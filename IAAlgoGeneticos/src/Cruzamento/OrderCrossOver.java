/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cruzamento;

import Model.Caminho;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author FREE
 */
public class OrderCrossOver extends Cruzamento{

    public OrderCrossOver(double taxaCruzamento) {
        super(taxaCruzamento);
    }

    @Override
    protected Caminho[] cruzamentoComSucesso(Caminho pai, Caminho mae) {
        //System.out.println("inicio");
        int indice1,indice2;
        Random gen = new Random();
        indice1 = gen.nextInt(280);//valor entre inclusivo [0-279]
        indice2 = gen.nextInt(280);
        if (indice1==indice2)
        {
            if (indice1>0)
            {
                indice2--;
            }
        }
        
        int menorindice,maiorindice;
        maiorindice = Math.max(indice1, indice2);
        menorindice = Math.min(indice1, indice2);
        
        Caminho caminhoA;
        Caminho caminhoB;
        int[] caminhoPai = pai.getCaminho();
        int[] caminhoMae = mae.getCaminho();
        
        //A eh composto pelo fixo (menorindice,maiorindice) do pai e o resto da mae
        CaminhoWrapperOX caminhoAsaida = new CaminhoWrapperOX(maiorindice,menorindice);
        //B eh composto pelo fixo (menorindice,maiorindice) da mae e o resto do pai
        CaminhoWrapperOX caminhoBsaida = new CaminhoWrapperOX(maiorindice,menorindice);
        
        boolean[] jaExisteA = new boolean[280];
        boolean[] jaExisteB = new boolean[280];
        for (int i=0;i<280;i++)
        {
            jaExisteA[i] = false;
            jaExisteB[i] = false;
        }
        int testerA = 0;
        int testerB = 0;
        //copia entre [menorindice,maiorindice]
        for (int i=menorindice;i<=maiorindice;i++)
        {
            testerA++;
            caminhoAsaida.add(caminhoPai[i]);
            jaExisteA[caminhoPai[i]-1] = true;
            
            testerB++;
            caminhoBsaida.add(caminhoMae[i]);
            jaExisteB[caminhoMae[i]-1] = true;
        }
        //copia entre (maiorindice,279]
        for (int i=menorindice;i<280;i++)
        {
            if (!jaExisteA[caminhoMae[i]-1]){
                testerA++;
                caminhoAsaida.add(caminhoMae[i]);
                jaExisteA[caminhoMae[i]-1] = true;
            }
            if (!jaExisteB[caminhoPai[i]-1]){
                testerB++;
                caminhoBsaida.add(caminhoPai[i]);
                jaExisteB[caminhoPai[i]-1] = true;
            }
        }
        //copia entre [0,menorindice)
        for (int i=0;i<menorindice;i++)
        {
            if (!jaExisteA[caminhoMae[i]-1]){
                testerA++;
                caminhoAsaida.add(caminhoMae[i]);
                jaExisteA[caminhoMae[i]-1] = true;
            }
            if (!jaExisteB[caminhoPai[i]-1]){
                testerB++;
                caminhoBsaida.add(caminhoPai[i]);
                jaExisteB[caminhoPai[i]-1] = true;
            }
        }
        //System.out.println("testerA : " + testerA + ",testerB : " + testerB);
        //System.out.println("Menor indice : " + menorindice + "Maior indice : " + maiorindice);

        //System.out.println("pai : ");
        //pai.printCaminho();
        //System.out.println("mae : ");
        //mae.printCaminho();
        //System.out.println("filho 1 : ");
        //caminhoAsaida.getValidoCaminho().printCaminho();
        //caminhoBsaida.getValidoCaminho();
        //System.out.println("fim");
        if (testerA>280)
        {
            throw new IllegalArgumentException("tester A>280");
        }
        if (testerB>280)
        {
            throw new IllegalArgumentException("tester B>280");
        }
        Caminho retorno[] = new Caminho[2];
        retorno[0] = caminhoAsaida.getValidoCaminho();
        retorno[1] = caminhoBsaida.getValidoCaminho();
        return(retorno);
        //para A copia mae de maiorindice em diante
    }
    
}
