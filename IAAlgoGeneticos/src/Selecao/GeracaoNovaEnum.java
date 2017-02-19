/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Selecao;

import Model.Caminho;
import Model.Populacao;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author FREE
 */
public enum GeracaoNovaEnum {
    TOTALMENTE_NOVA,
    ELISTISTA;
    
    protected Caminho[] pegarNCaminhos(Populacao pop,int n)
    {
        if (this == TOTALMENTE_NOVA)
        {
            return( new Caminho[0] );
        }
        else if (this == ELISTISTA)
        {
            Caminho[] retorno = new Caminho[n];
            
            double maiorCusto = pop.getMaiorCustoLocal();
            List< Caminho > caminho = pop.getPop();
            /*
            System.out.println("N elite : " + n);
            System.out.println("entrada : ");
            for (Caminho c : caminho)
            {
                System.out.print(Double.toString(c.getCusto())+" :: ");
            }
            */
            List< CaminhoWrapper > caminhosFitness = new ArrayList<>();
            int totalfitness = 0;
            for (Caminho c : caminho)
            {
                int fitnesslocal = c.getCusto().intValue();
                CaminhoWrapper wrapper = new CaminhoWrapper(c,fitnesslocal);
                caminhosFitness.add(wrapper);
            }
            Collections.sort(caminhosFitness);
            int contador = 1;
            for (CaminhoWrapper c : caminhosFitness)
            {
                c.setFitness(contador);
                totalfitness = totalfitness+contador;
                contador++;
            }
                //System.out.println("total fitness : " + totalfitness);
            int maiorIndice = caminhosFitness.size()-1;
            int contadorLocal = 0;
            for (int i=maiorIndice;i>(maiorIndice-n);i--)
            {
                //System.out.println("Maior indice : " + maiorIndice + "i="+i);
                retorno[contadorLocal] = caminhosFitness.get(i).getCaminho();
                contadorLocal++;
            }
            /*
            System.out.println("\nsaida : ");
            for (Caminho c : retorno)
            {
                System.out.print(Double.toString(c.getCusto())+" :: ");
            }
            */
            return(retorno);
        }
        return(null);
    }
}
