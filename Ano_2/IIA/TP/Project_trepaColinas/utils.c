#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "utils.h"

// Leitura do ficheiro de input
// Parâmetros de entrada: Nome do ficheiro, nome, Número de vértices, n, Número de iterações, iter
// Parâmetros de saída: Matriz de adjacências, p
float* init_dados(char *nome, int *n , float *val, int *iter)
{
    FILE    *f;
    int     *p, *q;
    float   *values;
    int     i;

    f = fopen(nome, "r");
    if (!f)
    {
        printf("Erro no acesso ao ficheiro dos dados\n");
        exit(1);
    }

    // Lê o número de vértices e o valor inicial
    fscanf(f, "%d %f", n, val);

    // Lê o número de iterações (fixo como 100 neste caso)
    *iter = 10000;

    // Aloca espaço em memória para a matriz de adjacências
    p = malloc(sizeof(int) * (*n));
    if (!p)
    {
        printf("Erro na alocação de memória para matriz\n");
        exit(1);
    }

    // Aloca espaço em memória para os valores reais
    values = malloc(sizeof(float) * (*n));
    if (!values)
    {
        printf("Erro na alocação de memória para valores\n");
        free(p);
        exit(1);
    }

    // Preenche os valores reais
    for (i = 0; i < *n; i++) {
        fscanf(f, "%f", &values[i]);
    }

    // Fecha o arquivo
    fclose(f);

    // Retorna os valores reais
    return values;
}


// Gera a solução inicial
// Parâmetros de entrada: Solução, sol, Número de vertices, v

void gera_sol_inicial(int *sol, float *values, float val, int v) {
    float valor_restante = val;

    // Inicializa o vetor solução com zeros
    for (int i = v; i >= 0; i--) {
        sol[i] = 0;
    }

    // Para cada moeda, gera um número aleatório entre 0 e o máximo possível
    for (int i = v; i >= 0; i--){
        if (valor_restante <= 0) break; // Se não há mais valor para distribuir, para o loop
        int max_moedas = valor_restante / values[i]; // Máximo possível de moedas deste tipo
        sol[i] = random_l_h(max_moedas/2, max_moedas);         // Gera um valor aleatório entre 0 e max_moedas
        valor_restante -= sol[i] * values[i];       // Atualiza o valor restante
    }
}


// Escreve solução no ecrã
// Parâmetros de entrada: Solução, sol, Número de vertices, vert
void escreve_sol(int *sol, int vert)
{
    int i;

    printf("\nSolucao (quantidade por indice): \n");
    for (i = 0; i < vert; i++) {
        printf("Indice %2d: %d\n", i, sol[i]);
    }
    printf("\n");
}

// copia vector b para a (tamanho n)
// Parâmetros de entrada: Solução que será substituída, a, Solução que irá substituir, b, Número de vertices, n
void substitui(int a[], int b[], int n)
{
    int i;
    for (i = 0; i < n; i++)
        a[i] = b[i];
}

// Inicializa o gerador de números aleatórios
void init_rand()
{
	srand((unsigned)time(NULL));
}

// Gera um valor inteiro aleatório entre min e max
// Parâmetros de entrada: Valor inferior do intervalo, min, Valor superior do intervalo, max
// Parâmetros de saída: Valor aleatório entre min e max
int random_l_h(int min, int max)
{
	return min + rand() % (max - min + 1);
}

// Gera um valor inteiro aleatório entre 0 e 1
// Parâmetros de saída: Valor aleatório entre 0 e 1
float rand_01()
{
	return ((float)rand()) / RAND_MAX;
}
