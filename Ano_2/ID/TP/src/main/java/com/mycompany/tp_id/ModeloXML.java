/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp_id;

import com.mycompany.tp_id.pais;
import java.util.List;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;


public class ModeloXML {
    public static Document adicionaPais (pais p, Document doc){
        Element raiz; 
        if (doc == null) { 
            raiz = new Element("Paises"); //cria <lista>...</lista> 
            doc = new Document(raiz); 
        } else { 
            raiz = doc.getRootElement(); 
        }
        
        Element pais = new Element("pais");
        Attribute a = new Attribute("nome", p.getNome()); 
        pais.setAttribute(a); 
        
        Element capital = new Element("capital");
        capital.addContent(p.getCapital());
        
        Element continente = new Element("continente");
        continente.addContent(p.getContinente());
        
        Element bandeira = new Element("bandeira");
        bandeira.addContent(p.getBandeira());
        
        Element linguas_oficiais = new Element("linguasOficiais");
        List<String> listalinguas = p.getLinguasOficiais();
        
        for (String lingua : listalinguas) {
            Element linguaElement = new Element("lingua").addContent(lingua);
            linguas_oficiais.addContent(linguaElement);
        }

        Element area = new Element("area");
        area.addContent(p.getArea());
        
        Element populacao = new Element("populacao");
        populacao.addContent(p.getPopulacao());
        
        Element densidade = new Element("densidade");
        densidade.addContent(p.getDensidade());
        
        Element chefe_estado = new Element("chefeEstado");
        chefe_estado.addContent(p.getChefeEstado());
        
        
        Element religioes = new Element("religioes");
        List<String> listaReligioes = p.getReligioes();
        
        for (String religiao : listaReligioes) {
            Element religiaoElement = new Element("religiao").addContent(religiao);
            religioes.addContent(religiaoElement);
        }
        
        Element cidades_importantes = new Element("cidadesImportantes");
        List<String> listaCidades = p.getCidadesImportantes();
        
        for (String cidade : listaCidades) {
            Element cidadeElement = new Element("cidade").addContent(cidade);
            cidades_importantes.addContent(cidadeElement);
        }
        
        Element paises_fronteira = new Element("paisesFronteira");
        List<String> listaPaises = p.getPaisesFronteira();
        
        for (String paisF : listaPaises) {
            Element paisElement = new Element("paisFronteira").addContent(paisF);
            paises_fronteira.addContent(paisElement);
        }
        
        Element casos_covid = new Element("casosCovid");
        casos_covid.addContent(p.getCasosCovid());
        
        pais.addContent(capital);
        pais.addContent(continente);
        pais.addContent(bandeira);
        pais.addContent(linguas_oficiais);
        pais.addContent(area);
        pais.addContent(populacao);
        pais.addContent(densidade);
        pais.addContent(religioes);
        pais.addContent(cidades_importantes);
        pais.addContent(paises_fronteira);
        pais.addContent(casos_covid);
       
        raiz.addContent(pais);
        
        return doc;
    }
    
    
    public static Document removePais (String nome, Document doc){
        Element raiz; 
        
        if (doc == null) { 
           System.err.println("Erro: O ficheiro não existe.");
           return doc; 
        } else { 
            raiz = doc.getRootElement(); 
        } 
        
        List todos = raiz.getChildren("pais"); 
        boolean found = false;
        for(int i=0; i<todos.size();i++){ 
            Element p = (Element)todos.get(i); 
            if (p.getAttributeValue("nome").contains(nome)) { 
                p.getParent().removeContent(p); 
                System.out.println("País removido com sucesso!"); 
                found = true; 
            } 
        }  
        if(!found){ 
            System.out.println("país: " + nome + " não foi encontrado"); 
            return null; 
        } 
        return doc;
    }
    
    
    public static Document alteraCapital(String nome, String novaCap,  Document doc){
        if (doc == null) { 
           System.err.println("Erro: O documento XML é nulo.");
           return null; 
        }
      
        Element raiz = doc.getRootElement();
        List todos = raiz.getChildren("pais");
        boolean found = false; 
        for(int i=0; i<todos.size();i++){ 
            Element p = (Element)todos.get(i); 
            if (p.getAttributeValue("nome").contains(nome)) {
                p.getChild("capital").setText(novaCap);
                found = true; 
            } 
        }  
        if(!found){ 
            System.out.println("País: " + nome + " não foi encontrado"); 
            return null; 
        } 
       
        
        return doc;
    }
    
    
    public static Document alteraPopulacao(String nome, String novaPop,  Document doc){
        if (doc == null) { 
           System.err.println("Erro: O documento XML é nulo.");
           return null; 
        }

        Element raiz = doc.getRootElement();
        List todos = raiz.getChildren("pais");
        boolean found = false; 
        for(int i=0; i<todos.size();i++){ 
            Element p = (Element)todos.get(i); 
            if (p.getAttributeValue("nome").contains(nome)) {
                p.getChild("populacao").setText(novaPop);
                found = true; 
            } 
        }  
        if(!found){ 
            System.out.println("País: " + nome + " não foi encontrado"); 
            return null; 
        } 
       
        
        return doc;
    }
    
    public static Document alteraArea(String nome, String novaArea,  Document doc){
        if (doc == null) { 
           System.err.println("Erro: O documento XML é nulo.");
           return null; 
        }

        Element raiz = doc.getRootElement();
        List todos = raiz.getChildren("pais");
        boolean found = false; 
        for(int i=0; i<todos.size();i++){ 
            Element p = (Element)todos.get(i); 
            if (p.getAttributeValue("nome").contains(nome)) {
                p.getChild("area").setText(novaArea);
                found = true; 
            } 
        }  
        if(!found){ 
            System.out.println("País: " + nome + " não foi encontrado"); 
            return null; 
        }   
        return doc;
    }
    
    
    public static Document alteraContinente(String nome, String novoCont,  Document doc){
        if (doc == null) { 
           System.err.println("Erro: O documento XML é nulo.");
           return null; 
        }

        Element raiz = doc.getRootElement();
        List todos = raiz.getChildren("pais");
        boolean found = false; 
        for(int i=0; i<todos.size();i++){ 
            Element p = (Element)todos.get(i); 
            if (p.getAttributeValue("nome").contains(nome)) {
                p.getChild("continente").setText(novoCont);
                found = true; 
            } 
        }  
        if(!found){ 
            System.out.println("País: " + nome + " não foi encontrado"); 
            return null; 
        } 
       
        
        return doc;
    }
    
    public static Document alteraDensidade(String nome, String novaDens,  Document doc){
        if (doc == null) { 
           System.err.println("Erro: O documento XML é nulo.");
           return null; 
        }

        Element raiz = doc.getRootElement();
        List todos = raiz.getChildren("pais");
        boolean found = false; 
        for(int i=0; i<todos.size();i++){ 
            Element p = (Element)todos.get(i); 
            if (p.getAttributeValue("nome").contains(nome)) {
                p.getChild("densidade").setText(novaDens);
                found = true; 
            } 
        }  
        if(!found){ 
            System.out.println("País: " + nome + " não foi encontrado"); 
            return null; 
        } 
       
        
        return doc;
    }
    
    public static Document alteraCovid(String nome, String novoCov,  Document doc){
        if (doc == null) { 
           System.err.println("Erro: O documento XML é nulo.");
           return null; 
        }

        Element raiz = doc.getRootElement();
        List todos = raiz.getChildren("pais");
        boolean found = false; 
        for(int i=0; i<todos.size();i++){ 
            Element p = (Element)todos.get(i); 
            if (p.getAttributeValue("nome").contains(nome)) {
                p.getChild("casosCovid").setText(novoCov);
                found = true; 
            } 
        }  
        if(!found){ 
            System.out.println("País: " + nome + " não foi encontrado"); 
            return null; 
        } 
       
        
        return doc;
    }
    
}
