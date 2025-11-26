import numpy as np


def ackley_function(x):

    a = 20
    b = 0.2
    c = 2 * np.pi

    x = np.array(x)

    dimensao = len(x)

    if dimensao == 0:
        return 0.0

    sum1 = np.sum(x ** 2)
    sum2 = np.sum(np.cos(c * x))

    termo1 = -a * np.exp(-b * np.sqrt(sum1 / dimensao))
    termo2 = -np.exp(sum2 / dimensao)

    return termo1 + termo2 + a + np.exp(1)