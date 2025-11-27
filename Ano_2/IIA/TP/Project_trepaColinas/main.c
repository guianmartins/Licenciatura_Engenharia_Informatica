#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "algoritmo.h"
#include "utils.h"

#define DEFAULT_RUNS 100

int main(int argc, char *argv[]) {
    char nome_fich[100];
    int n_moedas, num_iter, k, runs, custo, best_custo;
    float *tipo_moedas;
    int *sol, *best;
    float mbf = 0.0;
    float valor_troco;

    if (argc == 3) {
        runs = atoi(argv[2]);
        strcpy(nome_fich, argv[1]);
    } else if (argc == 2) {
        runs = DEFAULT_RUNS;
        strcpy(nome_fich, argv[1]);
    } else {
        runs = DEFAULT_RUNS;
        printf("Nome do Ficheiro: ");
        gets(nome_fich);
    }
    if (runs <= 0)
        return 0;
    init_rand();
    // Preenche matriz de adjacencias
    tipo_moedas = init_dados(nome_fich, &n_moedas, &valor_troco, &num_iter);

    sol = malloc(sizeof(int) * n_moedas);
    best = malloc(sizeof(int) * n_moedas);
    if (sol == NULL || best == NULL) {
        printf("Erro na alocacao de memoria");
        exit(1);
    }
    for (k = 0; k < runs; k++) {
        // Gerar solucao inicial
        gera_sol_inicial(sol, tipo_moedas, valor_troco, n_moedas);
        escreve_sol(sol, n_moedas);
        // Trepa colinas
        custo = trepa_colinas(sol, tipo_moedas, n_moedas, num_iter, valor_troco);
        //custo = trepa_colinas_probabilistico(sol , tipo_moedas , n_moedas , n_moedas , valor_troco);
        //custo = recristalizacao_simulada(sol , tipo_moedas , n_moedas , n_moedas , valor_troco);
        // Escreve resultados da repeticao k
        printf("\nRepeticao %d:", k);
        escreve_sol(sol, n_moedas);
        printf("Custo final: %2d\n", custo);
        mbf += custo;
        if (k == 0 || best_custo > custo) {
            best_custo = custo;
            substitui(best, sol, n_moedas);
        }
    }
    // Escreve e resultados globais
    printf("\n\nMBF: %f\n", mbf / k);
    printf("\nMelhor solucao encontrada");
    escreve_sol(best, n_moedas);
    printf("Custo final: %2d\n", best_custo);
    free(tipo_moedas);
    free(sol);
    free(best);
    return 0;
}