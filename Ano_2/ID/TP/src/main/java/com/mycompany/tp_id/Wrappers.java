package com.mycompany.tp_id;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.sf.saxon.s9api.SaxonApiException;
import net.sf.saxon.s9api.XdmValue;


public class Wrappers {
    
    public static String procura_capital() throws IOException {
        Scanner in = new Scanner(new FileInputStream("dbcity.html"), "UTF-8");
        
        String er = "<a[^>]+>Capital<\\/a>\\s<span[^>]+>[^<]+<\\/span><\\/th><td><a[^>]+>([^<]+)<\\/a>";    
        Pattern p = Pattern.compile(er); 

        while (in.hasNextLine()) {
            String line = in.nextLine();
            Matcher m = p.matcher(line);

            if(m.find()) {
                
                return m.group(1); // Retorna apenas a capital 
            }
        }
     
        in.close();
        return null;
    }
    
    
    public static String procura_continente() throws FileNotFoundException {
        Scanner in = new Scanner(new FileInputStream("dbcity.html"), "UTF-8");
        String er = "Continente<\\/th><td><a [^>]+>([^<]+)<\\/a>";
        Pattern p = Pattern.compile(er);
        while (in.hasNextLine()) {
            String line = in.nextLine(); // Ler a linha corretamente
            Matcher m = p.matcher(line);
            if (m.find()) {
                return m.group(1);
                
            }
        }
        

        in.close();
        
        return null;
    }
    
    public static String procura_bandeira() throws IOException{

        Scanner in = new Scanner(new FileInputStream("wiki.html"), "UTF-8");
        String line;

        String er1 = "<div style=\"padding-bottom:3px;\"><span [^t]*typeof=\"mw:File\"><a[^?]+><img alt=\"[^\"]+\" src=\"([a-zA-Z\\/._%0-9-]+)\"";

        Pattern p1 = Pattern.compile(er1);

        while (in.hasNextLine()) {
            line = in.nextLine();
            Matcher m1 = p1.matcher(line);

            while (m1.find()) {
                in.close();
                return m1.group(1);
            }
        }
    
        return null;       
    }
    
    public static List<String> procura_linguas() throws FileNotFoundException {
       Scanner in = new Scanner(new FileInputStream("dbcity.html"), "UTF-8");
        List<String> data = new ArrayList<>();
        String er = "Língua oficial<\\/th><td>([^<]+(?:<br\\/>[^<]+)*)<\\/td>";
        Pattern p = Pattern.compile(er);
        String linguas = null;
        while (in.hasNextLine()) {
            String line = in.nextLine(); // Ler a linha corretamente
            Matcher m = p.matcher(line);
            if (m.find()) {
                linguas = m.group(1);
                
            }
        }
        
         if (linguas != null) {
            data = Arrays.asList(linguas.split("<br/>"));
        }

        in.close();
        
        return data;
    }
    
    
    public static String procura_area() throws FileNotFoundException {
        String replace;
        Scanner in = new Scanner(new FileInputStream("dbcity.html"), "UTF-8");
        String er = "Superfície<\\/a><\\/th><td>([0-9.]+) km²<\\/td>";
        Pattern p = Pattern.compile(er);
        String str = null;
        while (in.hasNextLine()) {
            String line = in.nextLine(); // Ler a linha corretamente
            Matcher m = p.matcher(line);
            if (m.find()) {
                str = m.group(1);

            }
        }   replace = str.replace(".","");
        
        
        return replace;
    }
    
    public static String procura_populacao() throws FileNotFoundException {
        Scanner in = new Scanner(new FileInputStream("dbcity.html"), "UTF-8");
        String er = "População<\\/a><\\/th><td>([0-9.]+) habitantes";
        Pattern p = Pattern.compile(er);
        String str = null;
        while (in.hasNextLine()) {
            String line = in.nextLine(); // Ler a linha corretamente
            Matcher m = p.matcher(line);
            if (m.find()) {
                str = m.group(1);
                
            }
        }      
        String replace = str.replace(".","");
        in.close();
        
        return replace;
    }
    
    public static String procura_densidade() throws IOException{
       
    
        Scanner in = new Scanner(new FileInputStream("wiki.html"), "UTF-8");
        String line, densidade;
        String er1 = "Densidade<\\/a>";
        String er2 = "<td[^>]+>([0-9,]+) hab.\\/km²";
        Pattern p1 = Pattern.compile(er1);
        Pattern p2 = Pattern.compile(er2);
        while (in.hasNextLine()) {
            line = in.nextLine();
            Matcher m1 = p1.matcher(line);

            while (m1.find()) {
                in.nextLine();
                line = in.nextLine();
                Matcher m2 = p2.matcher(line);
                if(m2.find()){
                    in.close();
                    densidade = m2.group(1);
                    densidade = densidade.replace(",", ".");
                    return densidade;
                }
            }
        }
        
        return null;
    }
    
    public static String procura_presidente() throws IOException{
       
    
        String line;

        List<String> TiposChefe = new ArrayList<>(Arrays.asList("Presidente", "Monarca", "Rei", "Imperador"));
        
        for (int i = 0 ; i < TiposChefe.size() ; i++){
        Scanner in = new Scanner(new FileInputStream("wiki.html"), "UTF-8");
            String er1 = TiposChefe.get(i) +"<\\/a>";
            String er2 = "<td[^>]+><a[^>]+>([^>]+)<\\/a>";
            Pattern p1 = Pattern.compile(er1);
            Pattern p2 = Pattern.compile(er2);

            while (in.hasNextLine()) {
                line = in.nextLine();
                Matcher m1 = p1.matcher(line);
                while (m1.find()) {
                    in.nextLine();
                    line = in.nextLine();
                    Matcher m2 = p2.matcher(line);
                    if(m2.find()){
                        in.close();
                        return m2.group(1);
                    }
                }
            }
        }
        
        
        return null;
    }

 
    
     public static List<String> procura_religioes() throws FileNotFoundException {
        List<String> data;
        Scanner in = new Scanner(new FileInputStream("dbcity.html"), "UTF-8");
        data = new ArrayList<>();
        String er = "Religião <span [^>]+>[^<]+<\\/span><\\/h2><div [^<]+><ol [^>]+>(.*?)<\\/ol><\\/div>";
        String er2 = "<li><strong>([^<]+)<\\/strong>";
        Pattern p = Pattern.compile(er);
        Pattern p2 = Pattern.compile(er2);
        String linguas = null;
        while (in.hasNextLine()) {
            String line = in.nextLine(); // Ler a linha corretamente
            Matcher m = p.matcher(line);
            if (m.find()) {
                m = p2.matcher(line);
                while(m.find()){
                    data.add(m.group(1));                
                }
            }
        }
        
        
        return data;
    
        
     }
     public static List<String> procura_cidadesImportantes() throws FileNotFoundException {
        List<String> data;
        Scanner in = new Scanner(new FileInputStream("dbcity.html"), "UTF-8");
        data = new ArrayList<>();
        String er = "Cidades importantes : ([^.]+)";
        Pattern p = Pattern.compile(er);
        String cidades_imp = null;
        String linguas = null;
        while (in.hasNextLine()) {
            String line = in.nextLine(); // Ler a linha corretamente
            Matcher m = p.matcher(line);
            if (m.find()) {
                cidades_imp = m.group(1);
            }
        }   if(cidades_imp != null){
            String replace = cidades_imp.replace(" e",",");
            data = Arrays.asList(replace.split(", "));
        }
        
        
        return data;
    }
     
     public static List<String> procura_fronteira() throws FileNotFoundException {
        Scanner in = new Scanner(new FileInputStream("dbcity.html"), "UTF-8");
        List<String> data = new ArrayList<>();
        String er = "Fronteira <span [^>]+>[^<]+<\\/span><\\/h2><div [^>]+><ol[^>]+>(.*?)<\\/div>";
        String er2 = "<a [^>]+><img [^>]+> ([^<]+)<\\/a>";
        Pattern p = Pattern.compile(er);
        Pattern p2 = Pattern.compile(er2);
        
        while (in.hasNextLine()) {
            String line = in.nextLine(); // Ler a linha corretamente
            Matcher m = p.matcher(line);
            if (m.find()) {
               m = p2.matcher(line);
               while(m.find()){
                   data.add(m.group(1));
               }
            }
        }
       
        in.close();
        
        return data;
    }
    
     
     public static String procura_covid() throws FileNotFoundException {
         String replace;
        Scanner in = new Scanner(new FileInputStream("dbcity.html"), "UTF-8");
        String er = "<h2 [^>]+>Covid-19 <span [^>]+>[^<]+<\\/span><\\/h2><div [^>]+><table><tr><th>Confirmado<\\/th><td>([0-9.]+)<\\/td><\\/tr>";
        Pattern p = Pattern.compile(er);
        String str = null;
        while (in.hasNextLine()) {
            String line = in.nextLine(); // Ler a linha corretamente
            Matcher m = p.matcher(line);
            if (m.find()) {
                str = m.group(1);

            }
        }   replace = str.replace(".","");
        
        
        return replace;
    }
     
    public static pais procura_dados_pais(String pais) throws IOException, SaxonApiException { 
        
        String xp = "//pais[@nome='" + pais + "']";
        XdmValue res = null;
        res = XPathFunctions.executaXpath(xp, "paises.xml");
        if (res == null || res.size() == 0) { //Escritor não existe
            //String file = "C:\\Users\\Daniel\\Desktop\\2_Ano\\2_semestre\\ID\\TP_id\\sources\\" + pais + "_dbcity.html";

            String link = "https://pt.wikipedia.org/wiki/";
            HttpRequestFunctions.httpRequest1(link, pais, "wiki.html");

            link = "https://pt.db-city.com/";
            HttpRequestFunctions.httpRequest1(link, pais, "dbcity.html");


            // Obter os dados chamando as funções
            String capital = procura_capital();
            String continente = procura_continente();
            String bandeira = procura_bandeira();
            List<String> linguas = procura_linguas();
            String area = procura_area();
            String populacao = procura_populacao();
            String densidade = procura_densidade();
            String chefeEstado = procura_presidente();
            List<String> religioes = procura_religioes();
            List<String> cidadesImportantes = procura_cidadesImportantes();
            List<String> paisesFronteira = procura_fronteira();
            String casosCovid = procura_covid();

            // Criar objeto pais com os dados recolhidos
            return new pais(
                pais,
                capital, 
                continente, 
                bandeira, 
                linguas, 
                area, 
                populacao, 
                densidade, 
                chefeEstado, 
                religioes, 
                cidadesImportantes, 
                paisesFronteira, 
                casosCovid
            );
        }
        else{
             return null;
        }
    }
}

