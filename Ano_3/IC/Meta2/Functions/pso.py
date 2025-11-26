import numpy as np

# Assumindo que 'intelligence' está no mesmo diretório
from . import intelligence


class pso(intelligence.sw):
    """
    Particle Swarm Optimization
    """

    def __init__(self, n, function, lb, ub, dimension, iteration, w=0.5, c1=1,
                 c2=1):
        """
        :param n: number of agents
        :param function: test function
        :param lb: lower limits for plot axes
        :param ub: upper limits for plot azes
        :param dimension: space dimension
        :param iteration: the number of iterations
        :param w: balance between the range of research and consideration for
        suboptimal decisions found (default value is 0.5):
        w>1 the particle velocity increases, they fly apart and inspect
         the space more carefully;
        w<1 particle velocity decreases, convergence speed depends
        on parameters c1 and c2 ;
        :param c1: ratio between "cognitive" and "social" component
        (default value is 1)
        :param c2: ratio between "cognitive" and "social" component
        (default value is 1)
        """

        super(pso, self).__init__()

        self.__agents = np.random.uniform(lb, ub, (n, dimension))
        velocity = np.zeros((n, dimension))
        self._points(self.__agents)

        # --- ### CORREÇÃO 1: Calcular fitness inicial e guardar Gbest_fitness ### ---
        # Calcula a fitness (Val Loss) para todos os agentes iniciais
        all_fitness = np.array([function(x) for x in self.__agents])
        # Encontra o índice do melhor agente (menor Val Loss)
        best_agent_index = all_fitness.argmin()

        # Define o Pbest e Gbest inicial (os parâmetros)
        Pbest = self.__agents[best_agent_index]
        Gbest = Pbest

        # Guarda o valor de fitness (Val Loss) do melhor agente
        self.__Gbest_fitness = all_fitness[best_agent_index]
        # --- Fim da Correção 1 ---

        for t in range(iteration):

            r1 = np.random.random((n, dimension))
            r2 = np.random.random((n, dimension))
            velocity = w * velocity + c1 * r1 * (
                    Pbest - self.__agents) + c2 * r2 * (
                               Gbest - self.__agents)
            self.__agents += velocity
            self.__agents = np.clip(self.__agents, lb, ub)
            self._points(self.__agents)

            # --- ### CORREÇÃO 2: Otimizar e guardar Gbest_fitness no loop ### ---
            # 1. Calcula a fitness de todas as novas posições dos agentes
            current_fitness_list = np.array([function(x) for x in self.__agents])
            # 2. Encontra o índice do melhor da *iteração atual*
            current_best_index = current_fitness_list.argmin()

            # 3. Obtém os parâmetros (Pbest) e o valor (Pbest_fitness) desse melhor
            Pbest = self.__agents[current_best_index]
            Pbest_fitness = current_fitness_list[current_best_index]

            # 4. Compara o melhor desta iteração com o melhor *global*
            if Pbest_fitness < self.__Gbest_fitness:
                Gbest = Pbest  # Atualiza os melhores parâmetros
                self.__Gbest_fitness = Pbest_fitness  # ATUALIZA O MELHOR VALOR DE FITNESS
            # --- Fim da Correção 2 ---

        self._set_Gbest(Gbest)

    # Método para o main.py recuperar o valor sem treinar de novo
    # (Este método agora funciona porque self.__Gbest_fitness existe)
    def get_Gbest_fitness(self):
        return self.__Gbest_fitness