/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp_id;

import java.util.List;

/**
 *
 * @author Daniel
 */
public class pais {
    String nome;
    String capital;
    String continente;
    String bandeira;
    List<String> linguasOficiais;
    String area;
    String populacao;
    String densidade;
    String chefeEstado;
    List<String> religioes;
    List<String> cidadesImportantes;
    List<String> paisesFronteira;
    String casosCovid;

    // Construtor

    public pais(String nome, String capital, String continente, String bandeira, List<String> linguasOficiais, String area, String populacao, String densidade, String chefeEstado, List<String> religioes, List<String> cidadesImportantes, List<String> paisesFronteira, String casosCovid) {
        this.nome = nome;
        this.capital = capital;
        this.continente = continente;
        this.bandeira = bandeira;
        this.linguasOficiais = linguasOficiais;
        this.area = area;
        this.populacao = populacao;
        this.densidade = densidade;
        this.chefeEstado = chefeEstado;
        this.religioes = religioes;
        this.cidadesImportantes = cidadesImportantes;
        this.paisesFronteira = paisesFronteira;
        this.casosCovid = casosCovid;
    }

    
    

    // Getters
    
    public String getNome(){
        return nome;
    }
    
    public String getCapital() {
        return capital;
    }

    public String getContinente() {
        return continente;
    }

    public String getBandeira() {
        return bandeira;
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

    public String getChefeEstado() {
        return chefeEstado;
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

    // Método para exibir informações
    public void exibirInformacoes() {
        System.out.println("Capital: " + capital);
        System.out.println("Continente: " + continente);
        System.out.println("Bandeira: " + bandeira);
        System.out.println("Línguas Oficiais: " + String.join(", ", linguasOficiais));
        System.out.println("Área: " + area + " km²");
        System.out.println("População: " + populacao);
        System.out.println("Densidade: " + densidade + " hab/km²");
        System.out.println("Chefe de Estado: " + chefeEstado);
        System.out.println("Religiões: " + String.join(", ", religioes));
        System.out.println("Cidades Importantes: " + String.join(", ", cidadesImportantes));
        System.out.println("Países Fronteira: " + String.join(", ", paisesFronteira));
        System.out.println("Casos Covid: " + casosCovid);
    }
}
