/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gerador;

import Model.Caminho;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author FREE
 */
public class CaminhoGen {
    public static Caminho gerarRandomCaminho()
    {
       List< Integer > caminhos = new LinkedList<>();
       for (int i=1;i<281;i++)
       {
           caminhos.add(i);//adiciona de 1-280
       }
       
       int[] caminhoGerado = new int[280];
       Random decisao = new Random();
       for (int i=0;i<280;i++)
       {
           int indice = decisao.nextInt(caminhos.size());
           int novoInt = caminhos.get(indice);
           caminhos.remove(indice);
           caminhoGerado[i] = novoInt;
       }
       Caminho retorno = new Caminho(caminhoGerado);
       return( retorno );
    }
}
