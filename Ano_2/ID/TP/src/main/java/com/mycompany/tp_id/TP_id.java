/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tp_id;

import static com.mycompany.tp_id.ModeloXML.adicionaPais;
import static com.mycompany.tp_id.ModeloXML.alteraCapital;
import static com.mycompany.tp_id.Wrappers.procura_dados_pais;
import java.io.IOException;
import net.sf.saxon.s9api.SaxonApiException;
import org.jdom2.Document;


public class TP_id {
    
    public static void main(String[] args) throws IOException, SaxonApiException{
        String nomePais = "Portugal";
        //pais p = procura_dados_pais(nomePais);
        // Exibir os dados do país
        //p.exibirInformacoes();
        
        //Document doc = XMLJDomFunctions.lerDocumentoXML("paises.xml"); 
        //Chama a função para adicionar o escritor ao XML 
        
        //doc = adicionaPais(p, doc); 
        //doc = alteraCapital(p.nome , "Roma" , doc);
        //doc = ModeloXML.removePais("Portugal", doc);  
        //grava o ficheiro XML em disco 
        //XMLJDomFunctions.escreverDocumentoParaFicheiro(doc, "paises.xml"); 
        
        ValidarXML.validarDocumentoDTD("paises.xml", "paises.dtd"); 
        ValidarXML.validarDocumentoXSD("paises.xml", "paises.xsd"); 
    }
}
