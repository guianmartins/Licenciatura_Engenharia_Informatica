/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp_id;

import java.util.List;

/**
 *
 * @author wolfe
 */
public class Paises {
    String nome;
    String capital;
    String continente;
    String linkBandeira;
    List<String> linguasOficiais;
    String area; // em km²
    String populacao;
    String densidade; // habitantes por km²
    String chefeDeEstado;
    List<String> religioes;
    List<String> cidadesImportantes;
    List<String> paisesFronteira;
    String casosCovid;

    public Paises(String nome, String capital, String continente, String linkBandeira, List<String> linguasOficiais, String area, String populacao, String densidade, String chefeDeEstado, List<String> religioes, List<String> cidadesImportantes, List<String> paisesFronteira, String casosCovid) {
        this.nome = nome;
        this.capital = capital;
        this.continente = continente;
        this.linkBandeira = linkBandeira;
        this.linguasOficiais = linguasOficiais;
        this.area = area;
        this.populacao = populacao;
        this.densidade = densidade;
        this.chefeDeEstado = chefeDeEstado;
        this.religioes = religioes;
        this.cidadesImportantes = cidadesImportantes;
        this.paisesFronteira = paisesFronteira;
        this.casosCovid = casosCovid;
    }

    public String getNome() {
        return nome;
    }

    public String getCapital() {
        return capital;
    }

    public String getContinente() {
        return continente;
    }

    public String getLinkBandeira() {
        return linkBandeira;
    }

    public List<String> getLinguasOficiais() {
        return linguasOficiais;
    }

    public String getArea() {
        return area;
    }

    public String getPopulacao() {
        return populacao;
    }

    public String getDensidade() {
        return densidade;
    }

    public String getChefeDeEstado() {
        return chefeDeEstado;
    }

    public List<String> getReligioes() {
        return religioes;
    }

    public List<String> getCidadesImportantes() {
        return cidadesImportantes;
    }

    public List<String> getPaisesFronteira() {
        return paisesFronteira;
    }

    public String getCasosCovid() {
        return casosCovid;
    }
}
