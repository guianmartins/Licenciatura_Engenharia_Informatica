cmake_minimum_required(VERSION 3.27)
project(TP2_Project C)

set(CMAKE_C_STANDARD 99)

add_executable(TP2_Project main.c
        algoritmo.c
        funcao.c
        utils.c
        algoritmo.h
        funcao.h
        utils.h)
