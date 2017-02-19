package Blender;

import Cruzamento.Cruzamento;
import Grafico.graficoDados;
import Model.Caminho;
import Model.Populacao;
import Mutacao.Mutacao;
import Selecao.Selecao;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author FREE
 */
public class Blender {
    private Selecao selecao;
    private Cruzamento cruzamento;
    private Mutacao mutacao;
    private graficoDados graficodados;
    
    int nPorSelecao;
    int nPorCruzamento;
    int nTotal;

    public Blender(Populacao pop,Selecao selecao, Cruzamento cruzamento, Mutacao mutacao ,int nPorSelecao, int nPorCruzamento, int nTotal) {
        this.selecao = selecao;
        this.cruzamento = cruzamento;
        this.nPorSelecao = nPorSelecao;
        this.nPorCruzamento = nPorCruzamento;
        this.nTotal = nTotal;
        this.mutacao = mutacao;
        this.graficodados = new graficoDados(pop);
        
        if ((nPorSelecao+nPorCruzamento!=nTotal))
        {
            throw new IllegalArgumentException("Incoreenrencia ao criar blender");
        }
    }
    
    public void proximaGeracao(Populacao pop)
    {
        selecao.gerarNovaPopulacao(pop);//gera nova Populacao seleciona elementos da populacao antiga
        Caminho pai,mae;
        
        pai = selecao.selecionar(pop);
        mae = selecao.selecionar(pop);
        Caminho[] nCruzamento = cruzamento.gerarNCaminhosPorMutacao(selecao, pop, nPorCruzamento);
        Caminho[] nSelecao = new Caminho[nPorSelecao];
        for (int i=0;i<nPorSelecao;i++)
        {
            nSelecao[i] = selecao.selecionar(pop);
        }
        List< Caminho > novaPop = new ArrayList<>();
        for (int i=0;i<nCruzamento.length;i++)
        {
            novaPop.add(nCruzamento[i]);
        }
        for (int i=0;i<nSelecao.length;i++)
        {
            novaPop.add(nSelecao[i]);
        }
        
        for (Caminho caminho : novaPop)
        {
            for (int i=0;i<caminho.getCaminho().length;i++)
            {
                mutacao.mutar(caminho, i);
            }
        }
        
        pop.updatePop(novaPop);
        pop.incGeracao();
        graficodados.addMaiorMenor(pop);
        
        //graficodados.printar();
    }

    public graficoDados getGraficodados() {
        return graficodados;
    }
    
    
}
