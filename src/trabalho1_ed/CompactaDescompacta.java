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

        try {
            FileReader fileReader = new FileReader(arquivoEntrada);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter(arquivoSaida);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            //na palavra much ele não esta fazendo o .split
            // loop por cada linha do arquivo
            while (!(linha = bufferedReader.readLine()).equals("0")) {
                String[] palavra = linha.split(" ");
                for (int i = 0; i < palavra.length; i++) {

                    if (palavra[i].charAt(palavra[i].length() - 1) == '.' || palavra[i].charAt(palavra[i].length() - 1) == ',') {

                        String caractere = Character.toString(palavra[i].charAt(palavra[i].length() - 1));

                        if (caractere.equals(".")) {
                            String modificacao = palavra[i].replace(".", "#");
                            String[] palavraTemp = modificacao.split("#");
                            int verificador = lista.buscarElemento(palavraTemp[0]);

                            if (verificador == 0) {
                                lista.insereInicio(palavraTemp[0]);
                                bufferedWriter.write(palavraTemp[0]);
                                bufferedWriter.write(caractere + " ");
                            } else {
                                bufferedWriter.write(verificador);
                                lista.excluirParaMover(verificador);
                                lista.insereInicio(palavraTemp[0]);
                                bufferedWriter.write(caractere + " ");
                            }

                        } else {

                            String[] palavraTemp = palavra[i].split(caractere);
                            int verificador = lista.buscarElemento(palavraTemp[0]);

                            if (verificador == 0) {
                                lista.insereInicio(palavraTemp[0]);
                                bufferedWriter.write(palavraTemp[0]);

                            } else {
                                bufferedWriter.write(verificador);
                                lista.excluirParaMover(verificador);
                                lista.insereInicio(palavraTemp[0]);
                            }
                            bufferedWriter.write(caractere + " ");
                        }
                    } else {

                        int verificador = lista.buscarElemento(palavra[i]);

                        if (verificador == 0) {
                            lista.insereInicio(palavra[i]);
                            bufferedWriter.write(palavra[i] + " ");
                        } else {
                            bufferedWriter.write(verificador + " ");
                            lista.excluirParaMover(verificador);
                            lista.insereInicio(palavra[i]);
                        }

                    }

                }
                bufferedWriter.newLine();
            }

            // feche o arquivo
            bufferedReader.close();
            bufferedWriter.write("0");
            bufferedWriter.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo inexistente!");
        } catch (IOException ex) {
            System.out.println("Erro lendo o arquivo!");
        }

    }

    public static void descompactar(String arquivoSaida, String arquivoDescompactado) {
        String linha = null;
        ListaEncadeada lista = new ListaEncadeada();

        try {
            FileReader fileReader = new FileReader(arquivoSaida);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter(arquivoDescompactado);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            while (!(linha = bufferedReader.readLine()).equals("0")) {
                String[] palavra = linha.split(" ");
                for (int i = 0; i < palavra.length; i++) {
                    if (!digito(palavra[i])) {
                        if (palavra[i].charAt(palavra[i].length() - 1) == '.' || palavra[i].charAt(palavra[i].length() - 1) == ',') {
                            String caractere = Character.toString(palavra[i].charAt(palavra[i].length() - 1));

                            if (caractere.equals(".")) {
                                String modificacao = palavra[i].replace(".", "#");
                                String[] palavraTemp = modificacao.split("#");
                                int verificador = lista.buscarElemento(palavraTemp[0]);

                                if (verificador == 0) {
                                    lista.insereInicio(palavraTemp[0]);
                                    bufferedWriter.write(palavraTemp[0]);
                                    bufferedWriter.write(caractere + " ");
                                } /*else {
                                 bufferedWriter.write(verificador);
                                 lista.excluirParaMover(verificador);
                                 lista.insereInicio(palavraTemp[0]);
                                 bufferedWriter.write(caractere + " ");
                                 }*/

                            } else {
                                String[] palavraTemp = palavra[i].split(caractere);
                                int verificador = lista.buscarElemento(palavraTemp[0]);

                                if (verificador == 0) {
                                    lista.insereInicio(palavraTemp[0]);
                                    bufferedWriter.write(palavraTemp[0]);

                                }/* else {
                                 bufferedWriter.write(verificador);
                                 lista.excluirParaMover(verificador);
                                 lista.insereInicio(palavraTemp[0]);
                                 }*/

                                bufferedWriter.write(caractere + " ");
                            }

                        } else {
                            lista.insereInicio(palavra[i]);
                            bufferedWriter.write(palavra[i] + " ");
                            /*String temp = lista.buscarPalavra(Integer.parseInt(palavra[i]));
                             bufferedWriter.write(temp + " ");
                             lista.excluirParaMover(Integer.parseInt(palavra[i]));
                             lista.insereInicio(temp);*/
                        }
                    }else{
                        String temp = lista.buscarPalavra(Integer.parseInt(palavra[i]));
                        bufferedWriter.write(temp + " ");
                        lista.excluirParaMover(Integer.parseInt(palavra[i]));
                        lista.insereInicio(temp);
                    }
                }
                bufferedWriter.newLine();

                // feche o arquivo
            }
            bufferedReader.close();
            bufferedWriter.write("0");
            bufferedWriter.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo inexistente!");
        } catch (IOException ex) {
            System.out.println("Erro lendo o arquivo!");
        }
    }

    //metodo para verificar se a String passada é um número
    public static boolean digito(String palavra) {
        return palavra.matches("[0-9]*");
    }
}
