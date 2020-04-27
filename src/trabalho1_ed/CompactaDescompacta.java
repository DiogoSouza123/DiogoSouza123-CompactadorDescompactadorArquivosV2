/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1_ed;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author DiogoSouza
 */
public class CompactaDescompacta {

    public static void compartar(String arquivoEntrada, String arquivoSaida) {
        String linha = null;
        ListaEncadeada lista = new ListaEncadeada();
        //int tamanhoPalavra; //variavel para permitir acesso ao ultimo caractere da palavra
        try {
            FileReader fileReader = new FileReader(arquivoEntrada);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter(arquivoSaida);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            
            // loop por cada linha do arquivo
            while (!(linha = bufferedReader.readLine()).equals("0")) {
                String [] palavra = linha.split(" ");
                
            }

            // feche o arquivo
            bufferedReader.close();
            bufferedWriter.close();
            
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo inexistente!");
        } catch (IOException ex) {
            System.out.println("Erro lendo o arquivo!");
        }

    }
    
    

    public static void descompactar(String nomeDoArquivo) {

    }
}
