/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cruzamento;

import Model.Caminho;
import Model.Populacao;
import Selecao.Selecao;
import java.util.Random;

/**
 *
 * @author FREE
 */
public abstract class Cruzamento {
    double taxaCruzamento = 60.00;//entre 0-100;
    
    public Cruzamento(double taxaCruzamento)
    {
        this.taxaCruzamento = taxaCruzamento;
    }
    
    public Caminho[] cruzamento(Caminho pai,Caminho mae)
    {
        Random gen = new Random();
        double isCruzamento = 100*gen.nextDouble();
        Caminho[] retornoFalso = new Caminho[2];
        retornoFalso[0] = pai;
        retornoFalso[1] = mae;
        if (isCruzamento >=taxaCruzamento)
        {
            return(retornoFalso);
        }
        else
        {
            Caminho[] retornoVerdadeiro = cruzamentoComSucesso(pai, mae);
            return(retornoVerdadeiro);
        }
    }
    
    protected abstract Caminho[] cruzamentoComSucesso(Caminho pai,Caminho mae);
    
    public Caminho[] gerarNCaminhosPorMutacao(Selecao selecao,Populacao pop,int nIndividuos)
    {
        if (nIndividuos%2==1)
        {
            nIndividuos--;
        }
        Caminho[] retorno = new Caminho[nIndividuos];
        for (int i=0;i<nIndividuos;i=i+2)
        {
            Caminho pai = selecao.selecionar(pop);
            Caminho mae = selecao.selecionar(pop);
            
            Caminho[] filhos = cruzamento(pai, mae);
            Caminho filho1 = filhos[0];
            Caminho filho2 = filhos[1];
            
            retorno[i] = filho1;
            retorno[i+1] = filho2;
        }
        return(retorno);
    }
}
