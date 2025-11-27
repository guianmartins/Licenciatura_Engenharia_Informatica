#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include "algoritmo.h"
#include "funcao.h"
#include "utils.h"

#define PROB 0.05
#define TMAX 1
#define TMIN 0.05


void gera_vizinho(int a[], int b[], int n) {
    int i, pos, delta;

    // Copia a solução atual para o vizinho
    for (i = 0; i < n; i++) {
        b[i] = a[i];
    }

    // Gera um valor aleatório entre -1, 0 ou 1
    delta = random_l_h(-1, 1);

    // Garante que a alteração seja válida (não altera se delta == 0)
    if (delta != 0) {
        // Escolhe uma posição aleatória válida para alterar
        pos = random_l_h(0, n - 1);

        // Aplica a modificação somando o valor gerado à posição
        b[pos] += delta;

        // Opcional: Garante que a solução se mantém dentro de limites válidos (ex: >= 0)
        if (b[pos] < 0) {
            b[pos] = 0;  // Evita valores negativos
        }
    }


}

void gera_vizinho2(int sol[], int solViz[], int n) {
    int numAlteracoes = random_l_h(1,  2);  // Número de posições a alterar
    int pos, delta;

    // Copia a solução atual para o vizinho
    for (int i = 0; i < n; i++) {
        solViz[i] = sol[i];
    }

    // Faz alterações em várias posições
    for (int i = 0; i < numAlteracoes; i++) {
        pos = random_l_h(0, n - 1);  // Seleciona uma posição aleatória
        delta = random_l_h(-1, 1);       // Gera -1, 0 ou 1
        solViz[pos] += delta;

        // Garante que os valores não sejam negativos
        if (solViz[pos] < 0) {
            solViz[pos] = 0;
        }
    }
}


int trepa_colinas(int sol[], float *mat, int vert, int num_iter, float val)
{
    int *nova_sol, custo, custo_viz, i;

    nova_sol = malloc(sizeof(int)*vert);
    if(nova_sol == NULL)
    {
        printf("Erro na alocacao de memoria");
        exit(1);
    }
    // Avalia solucao inicial
    custo = calcula_fit(sol, mat, val,vert );
    for(i=0; i<num_iter; i++)
    {
        gera_vizinho2(sol, nova_sol, vert);
        reparacao(nova_sol, mat, val, vert);
        custo_viz = calcula_fit(nova_sol, mat, val, vert);
        if(custo_viz <= custo)
        {
            substitui(sol, nova_sol, vert);
            custo = custo_viz;
        }

    }
    free(nova_sol);
    return custo;
}


// Trepa colinas first-choice
// Parâmetros de entrada: Solucao, sol, Matriz de adjacencias, mat, Número de vértices, vert, Número de iterações, num_iter
// Parâmetros de saída: Custo da melhor solução encontrada
int trepa_colinas_probabilistico(int sol[], float *mat, int vert, int num_iter, float val)
{
    int *nova_sol, custo, custo_viz, i;

    // Aloca espaço em memória para guardar a nova solução
    nova_sol = malloc(sizeof(int)*vert);
    // Caso não consiga fazer a alocação, envia aviso e termina o programa
    if (nova_sol == NULL)
    {
        printf("Erro na alocacao de memoria");
        exit(1);
    }
    // Avalia solução inicial
    custo = calcula_fit(sol, mat, val, vert);
    for(i = 0; i < num_iter; i++)
    {
        // Gera solução vizinha
        gera_vizinho2(sol, nova_sol, vert);
        // Avalia solução vizinha
        custo_viz = calcula_fit(nova_sol, mat, val, vert);
        // Fica com a solução vizinha se o custo diminuir (problema de minimização) em relação à solução atual
        if (custo_viz <= custo)
        {
            substitui(sol, nova_sol, vert);
            custo = custo_viz;
        }
        else
        {
            // Fica com a solução vizinha, apesar de pior, se o valor aleatório gerado for abaixo da probabilidade definida
            if (rand_01() < PROB)
            {
                substitui(sol, nova_sol, vert);
                custo = custo_viz;
            }
        }
    }
    // Liberta a memória usada para guardar a nova solução
    free(nova_sol);
    // Devolve o custo da melhor solução encontrada
    return custo;
}

int recristalizacao_simulada(int sol[], float *mat, int vert, int num_iter, float val)
{
    int     *nova_sol, custo, custo_viz, i, best_custo, *best_sol;
    float   t = TMAX, decrementoT;

    // Calculo da decrementação de T para ir de TMAX a TMIN en num_iter
    decrementoT = (TMAX - TMIN) / num_iter;
    // Aloca espaço em memória para guardar a nova solução e a melhor solução
    nova_sol = malloc(sizeof(int)*vert);
    best_sol = malloc(sizeof(int)*vert);
    // Caso não consiga fazer a alocação, envia aviso e termina o programa
    if(nova_sol == NULL || best_sol == NULL)
    {
        printf("Erro na alocacao de memoria");
        exit(1);
    }
    // Avalia solucao inicial
    custo = calcula_fit(sol, mat, val , vert);
    // Guarda essa solução inicial como a melhor
    best_custo = custo;
    substitui(best_sol, sol, vert);
    for(i=0; i < num_iter; i++)
    {
        // Gera solução vizinha
        gera_vizinho2(sol, nova_sol, vert);
        // Avalia solução vizinha
        custo_viz = calcula_fit(nova_sol, mat, val , vert);
        // Se a solução vizinha for melhor que a solução atual, guarda-a como a melhor solução
        if(custo_viz <= best_custo)
        {
            best_custo = custo_viz;
            substitui(best_sol, nova_sol, vert);
        }
        // Fica com a solução vizinha se o custo não aumentar (problema de minimização) em relação à solução atual
        if(custo_viz <= custo)
        {
            substitui(sol, nova_sol, vert);
            custo = custo_viz;
        }
        else
        {
            // Fica com a solução vizinha, apesar de pior, se o valor aleatório gerado for abaixo da probabilidade que se vai ajustando
            if (rand_01() < exp((custo - custo_viz) / t))
            {
                substitui(sol, nova_sol, vert);
                custo = custo_viz;
            }
        }
        t = t - decrementoT;
    }
    // Retorna a melhor solução encontrada
    substitui(sol, best_sol, vert);
    // Liberta a memória usada para guardar a nova solução e a melhor solução
    free(nova_sol);
    free(best_sol);
    // Devolve o custo da melhor solução encontrada
    return best_custo;
}


