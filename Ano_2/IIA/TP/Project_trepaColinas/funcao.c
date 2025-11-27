#include "funcao.h"
#include <math.h>
#include <stdio.h>

int calcula_fit(int *sol, float *values, float val, int v)
{
    int i, total_moedas = 0;
    float soma_valores = 0.0;

    for (i = 0; i < v; i++) {
        total_moedas += sol[i];
        soma_valores += sol[i] * values[i];
    }
    if (fabs(soma_valores - val) > 1e-6) {
        return fabs(soma_valores - val) * 100 + 1000;
    }
    return total_moedas;
}


void reparacao(int sol[], float *values, float val, int v) {
    float soma_valores = 0.0, diff;
    int i;
    // Calcula o valor atual da solução
    for (i = 0; i < v; i++) {
        soma_valores += sol[i] * values[i];
    }
    // Calcula a diferença entre o valor desejado e o valor atual
    diff = val - soma_valores;

    // Tenta corrigir a diferença ajustando as posições da solução
    for (i = 0; i < v; i++) {
        if (fabs(diff) < 1e-6) {
            break;  // Se a diferença for insignificante, interrompe
        }
        // Caso a diferença seja positiva, adiciona moedas (se possível)
        if (diff > 0) {
            int max_add = (int)(diff / values[i]); // Quantidade máxima de moedas a adicionar
            sol[i] += max_add;                    // Adiciona as moedas
            diff -= max_add * values[i];          // Atualiza a diferença
        }
            // Caso a diferença seja negativa, remove moedas (se possível)
        else if (diff < 0) {
            int max_remove = fmin(sol[i], (int)(-diff / values[i])); // Limita o número de moedas a remover
            sol[i] -= max_remove;                                   // Remove as moedas
            diff += max_remove * values[i];                         // Atualiza a diferença
        }
    }
}
