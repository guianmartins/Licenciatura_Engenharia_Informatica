import numpy as np

from . import intelligence


class wsa(intelligence.sw):
    """
    Whale Swarm Algorithm
    (Versão Otimizada com Caching de Fitness)
    """

    def __init__(self, n, function, lb, ub, dimension, iteration, ro0=2,
                 eta=0.005):
        """
        :param n: number of agents
        :param function: test function
        :param lb: lower limits for plot axes
        :param ub: upper limits for plot axes
        :param dimension: space dimension
        :param iteration: the number of iterations
        :param ro0: intensity of ultrasound at the origin of source
    (default value is 2)
        :param eta: probability of message distortion at large distances
    (default value is 0.005)
        """

        super(wsa, self).__init__()

        self.__agents = np.random.uniform(lb, ub, (n, dimension))
        self._points(self.__agents)

        # --- MODIFICAÇÃO 1: Criar arrays para guardar os scores ---
        # self.__fitness_scores guarda o score de cada agente
        self.__fitness_scores = np.zeros(n)
        # self.__Gbest_fitness guarda o melhor score global encontrado
        self.__Gbest_fitness = float('inf')

        Gbest = self.__agents[0]  # Placeholder inicial

        # --- MODIFICAÇÃO 2: Avaliação Inicial (Custo: n treinos) ---
        # Calcula o fitness de toda a população inicial *uma vez*

        for i in range(n):
            self.__fitness_scores[i] = function(self.__agents[i])
            if self.__fitness_scores[i] < self.__Gbest_fitness:
                self.__Gbest_fitness = self.__fitness_scores[i]
                Gbest = self.__agents[i]

        self._set_Gbest(Gbest)  # Guarda o melhor Gbest inicial


        # --- Loop de Iteração ---
        for t in range(iteration):
            print(f"\n--- WSA: Iteração {t + 1}/{iteration} ---", flush=True)

            # Copia os agentes para calcular as novas posições
            # (Usar .copy() é importante para não modificar o original acidentalmente)
            new_agents = self.__agents.copy()

            for i in range(n):
                # --- MODIFICAÇÃO 3: `function` removida daqui ---
                # A função agora usa os scores guardados (self.__fitness_scores)
                y = self.__better_and_nearest_whale(i, n)

                if y:  # Se encontrou um "y" (agente melhor e mais próximo)
                    new_agents[i] += np.dot(
                        np.random.uniform(0, ro0 *
                                          np.exp(-eta * self.__whale_dist(i, y))),
                        self.__agents[y] - self.__agents[i])

            # Aplica os limites (lb, ub) às novas posições
            new_agents = np.clip(new_agents, lb, ub)

            # --- MODIFICAÇÃO 4: Avaliação da Nova Geração (Custo: n treinos por iteração) ---
            # Avalia o fitness *apenas* das novas posições
            new_fitness_scores = np.zeros(n)
            for i in range(n):
                new_fitness_scores[i] = function(new_agents[i])

            # Atualiza o estado da "swarm" com as novas posições e scores
            self.__agents = new_agents
            self.__fitness_scores = new_fitness_scores
            self._points(self.__agents)  # Para o histórico de pontos

            # --- MODIFICAÇÃO 5: Encontrar o novo Gbest (sem treinos) ---
            # Compara usando os scores já calculados
            current_best_idx = np.argmin(self.__fitness_scores)
            current_best_fitness = self.__fitness_scores[current_best_idx]

            if current_best_fitness < self.__Gbest_fitness:

                self.__Gbest_fitness = current_best_fitness
                Gbest = self.__agents[current_best_idx]
                self._set_Gbest(Gbest)  # Atualiza o Gbest na classe pai

        # Fim do construtor
        print(f"\n--- WSA: Otimização concluída. Score final: {self.__Gbest_fitness:.5f} ---", flush=True)

    def __whale_dist(self, i, j):
        # Esta função está correta, não mexe com fitness
        return np.linalg.norm(self.__agents[i] - self.__agents[j])

    def __better_and_nearest_whale(self, u, n):
        # --- MODIFICAÇÃO 6: Função de comparação usa scores guardados ---
        # Não chama mais a `function` (que treina modelos)

        temp = float("inf")
        v = None
        for i in range(n):
            # Compara scores do array, muito mais rápido!
            if self.__fitness_scores[i] < self.__fitness_scores[u]:
                dist_iu = self.__whale_dist(i, u)
                if dist_iu < temp:
                    v = i
                    temp = dist_iu
        return v

    # --- MODIFICAÇÃO 7: Adicionar "getter" para o score final ---
    def get_Gbest_fitness(self):
        """Retorna o melhor fitness (score) encontrado durante a otimização."""
        return self.__Gbest_fitness