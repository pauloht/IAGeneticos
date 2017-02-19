/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author FREE
 */
public class Populacao {
    private List< Caminho > pop;
    private int geracao = 1;
    private Grafo custos;
    
    private double maiorCustoGlobal = 0.00;//maior custo de todas as geracoes
    
    private double menorCustoGlobal = 0.00;//menor custo de todas as geracoes
    
    private double maiorCustoLocal = 0.00;//maior custo da geracao atual
    
    private double menorCustoLocal = 0.00;//menor custo da geracao atual
    
    public Populacao(int tamanhoInicial,Grafo custo)
    {
        this.custos = custo;
        pop = new ArrayList<>();
        for (int i=0;i<tamanhoInicial;i++)
        {
            //System.out.println("Gerado novo caminho...");
            Caminho novoCaminho = Gerador.CaminhoGen.gerarRandomCaminho();
            custos.calcularCustoCaminho(novoCaminho);
            
            if (i==0)
            {
                maiorCustoLocal = novoCaminho.getCusto();
                menorCustoLocal = novoCaminho.getCusto();
            }
            else
            {
                maiorCustoLocal = Math.max(maiorCustoLocal, novoCaminho.getCusto());
                menorCustoLocal = Math.min(maiorCustoLocal, novoCaminho.getCusto());
            }
            
            pop.add(novoCaminho);
        }
        maiorCustoGlobal = maiorCustoLocal;
        menorCustoGlobal = menorCustoLocal;
        Collections.sort(pop);
    }
    
    private void recalcularCustos()
    {
        for (int i=0;i<pop.size();i++)
        {
            Caminho caminhoCorrente = pop.get(i);
            custos.calcularCustoCaminho(caminhoCorrente);
            if (i==0)
            {
                maiorCustoLocal = caminhoCorrente.getCusto();
                menorCustoLocal = caminhoCorrente.getCusto();
            }
            else
            {
                maiorCustoLocal = Math.max(maiorCustoLocal, caminhoCorrente.getCusto());
                menorCustoLocal = Math.min(menorCustoLocal, caminhoCorrente.getCusto());
            }
            //System.out.println("MaiorCustoLocal : " + maiorCustoLocal);
            //System.out.println("MenorCustoLocal : " + menorCustoLocal);
        }
        maiorCustoGlobal = Math.max(maiorCustoGlobal,maiorCustoLocal);
        menorCustoGlobal = Math.min(menorCustoGlobal,menorCustoLocal);
        Collections.sort(pop);
    }

    public int getGeracao() {
        return geracao;
    }
    
    public void incGeracao()
    {
        this.geracao = this.geracao + 1;
    }

    public double getMaiorCustoGlobal() {
        return maiorCustoGlobal;
    }

    public double getMenorCustoGlobal() {
        return menorCustoGlobal;
    }

    public double getMaiorCustoLocal() {
        return maiorCustoLocal;
    }

    public double getMenorCustoLocal() {
        return menorCustoLocal;
    }

    public void updatePop(List<Caminho> pop) {
        this.pop = pop;
        recalcularCustos();
    }

    public List<Caminho> getPop() {
        return pop;
    }
    
    public void printarInformacoes()
    {
        System.out.println("Geracao : " + geracao);
        System.out.println("Pop size : " + pop.size());
        System.out.println("Maior custo global : " + maiorCustoGlobal);
        System.out.println("Menor custo global : " + menorCustoGlobal);
        System.out.println("Maior custo local  : " + maiorCustoLocal);
        System.out.println("Menor custo local : " + menorCustoLocal);
        
        /*
        System.out.println("Custos : ");
        System.out.print("[");
        for (int i=0;i<pop.size()-1;i++)
        {
            System.out.print(String.format(Locale.US,"%3.2f",pop.get(i).getCusto() ) + ",");
        }
        System.out.println(String.format(Locale.US,"%3.2f",pop.get(pop.size()-1).getCusto() ) + "]");
        */
    }
}
