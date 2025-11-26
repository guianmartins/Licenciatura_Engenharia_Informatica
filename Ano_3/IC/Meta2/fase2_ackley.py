import numpy as np
from Functions import ackley  # Importa o módulo ackley.py (do seu pacote local 'Functions')
# CORREÇÃO: Importar as CLASSES de dentro dos MÓDULOS
from Functions.wsa import wsa
from Functions.pso import pso


# --- Configurações Globais ---
# n_agentes e n_iteracoes serão definidos nos testes
n_execucoes = 10  # Número de vezes para executar e tirar a média

# Atribui a função (sem parênteses) à variável
funcao_benchmark = ackley.ackley_function

print("Iniciando Benchmark (Parte A e B)...")

# --- Loop pelas Dimensões ---
for dimensao in [2, 3]:
    print(f"\n{'-' * 50}")
    print(f"INICIANDO TESTES PARA DIMENSÃO {dimensao} (Ackley D{dimensao})")
    print(f"{'-' * 50}")

    # Limites de pesquisa para Ackley
    lb = [-32] * dimensao
    ub = [32] * dimensao

    # === PARTE A: COMPARAÇÃO DIRETA (WSA vs. PSO) ===
    # Usamos valores "standard" para a comparação
    n_agentes_comp = 30
    n_iteracoes_comp = 50
    print(f"\n[D{dimensao}] PARTE A: Comparação WSA vs. PSO")
    print(f"Executando {n_execucoes} vezes com {n_agentes_comp} agentes e {n_iteracoes_comp} iterações.")

    resultados_wsa = []
    resultados_pso = []

    for i in range(n_execucoes):
        # Executar WSA (Agora 'wsa' é a classe e pode ser chamada)
        wsa_opt = wsa(n=n_agentes_comp, function=funcao_benchmark, lb=lb, ub=ub, dimension=dimensao,
                      iteration=n_iteracoes_comp)

        # Obter a melhor POSIÇÃO e APLICAR a função
        best_pos_wsa = wsa_opt.get_Gbest()
        resultados_wsa.append(funcao_benchmark(best_pos_wsa))

        # Executar PSO (Agora 'pso' é a classe e pode ser chamada)
        pso_opt = pso(n=n_agentes_comp, function=funcao_benchmark, lb=lb, ub=ub, dimension=dimensao,
                      iteration=n_iteracoes_comp)

        # Obter a melhor POSIÇÃO e APLICAR a função
        best_pos_pso = pso_opt.get_Gbest()
        resultados_pso.append(funcao_benchmark(best_pos_pso))

        # print(f"  D{dimensao} - Comparação Execução {i + 1}/{n_execucoes} concluída.")

    print(f"\nResultados da Comparação (D{dimensao}):")
    print(f"  WSA - Média: {np.mean(resultados_wsa):.6f} | Min: {np.min(resultados_wsa):.6f}")
    print(f"  PSO - Média: {np.mean(resultados_pso):.6f} | Min: {np.min(resultados_pso):.6f}")

    # === PARTE B: ANÁLISE DE SENSIBILIDADE (Apenas WSA) ===
    print(f"\n[D{dimensao}] PARTE B: Análise de Sensibilidade do WSA")

    # --- B.1: Sensibilidade ao Nº de Agentes (n) ---
    print(f"\n  B.1: Sensibilidade ao Nº de Agentes (Iterações fixas = 50)")
    iteracoes_fixas = 50
    agentes_teste = [10, 30, 50, 100]
    resultados_agentes = {}

    for n_ag in agentes_teste:
        fitness_runs = []
        for i in range(n_execucoes):
            wsa_opt = wsa(n=n_ag, function=funcao_benchmark, lb=lb, ub=ub, dimension=dimensao,
                          iteration=iteracoes_fixas)

            # Obter a melhor POSIÇÃO e APLICAR a função
            best_pos_wsa = wsa_opt.get_Gbest()
            fitness_runs.append(funcao_benchmark(best_pos_wsa))

        resultados_agentes[n_ag] = np.mean(fitness_runs)
        print(f"    n = {n_ag:<4}: Fitness Médio = {resultados_agentes[n_ag]:.6f}")

    # --- B.2: Sensibilidade ao Nº de Iterações (iteration) ---
    print(f"\n  B.2: Sensibilidade ao Nº de Iterações (Agentes fixos = 30)")
    agentes_fixos = 30
    iteracoes_teste = [20, 50, 100, 200]
    resultados_iteracoes = {}

    for n_iter in iteracoes_teste:
        fitness_runs = []
        for i in range(n_execucoes):
            wsa_opt = wsa(n=agentes_fixos, function=funcao_benchmark, lb=lb, ub=ub, dimension=dimensao,iteration=n_iter)
            # Obter a melhor POSIÇÃO e APLICAR a função
            best_pos_wsa = wsa_opt.get_Gbest()
            fitness_runs.append(funcao_benchmark(best_pos_wsa))

        resultados_iteracoes[n_iter] = np.mean(fitness_runs)
        print(f"    iter = {n_iter:<4}: Fitness Médio = {resultados_iteracoes[n_iter]:.6f}")

print(f"\n{'-' * 50}")
print("Benchmark concluído.")