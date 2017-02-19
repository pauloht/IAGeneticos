package Blender;

import Cruzamento.Cruzamento;
import Grafico.graficoDados;
import Model.Caminho;
import Model.Populacao;
import Mutacao.Mutacao;
import Selecao.GeracaoNovaEnum;
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
    
    int nTotal;

    public Blender(Populacao pop,Selecao selecao, Cruzamento cruzamento, Mutacao mutacao, int nTotal) {
        this.selecao = selecao;
        this.cruzamento = cruzamento;
        this.nTotal = nTotal;
        this.mutacao = mutacao;
        this.graficodados = new graficoDados(pop);
    }
    
    public void proximaGeracao(Populacao pop)
    {
        //System.out.println("BlenderInicioPop : " + pop.getPop().size());
        Caminho pai,mae;
        
        pai = selecao.selecionar(pop);
        mae = selecao.selecionar(pop);
        
        int nPorCruzamento;
        int nPorSelecao;
        
        if (selecao.getGeracaoNova()==GeracaoNovaEnum.TOTALMENTE_NOVA)
        {
            nPorCruzamento = nTotal;
            nPorSelecao = 0;
        }
        else if (selecao.getGeracaoNova()==GeracaoNovaEnum.ELISTISTA)
        {
            nPorSelecao = selecao.getQuantiaGeradoPorSelecao();
            nPorCruzamento = nTotal - nPorSelecao;
        }
        else
        {
            //System.out.println("ELSE TRIGGER");
            nPorSelecao = 0;
            nPorCruzamento = 0;
        }
        
        Caminho[] nCruzamento = cruzamento.gerarNCaminhosPorMutacao(selecao, pop, nPorCruzamento);
        Caminho[] nSelecao = selecao.gerarNCaminhosPorSelecao(pop, nPorSelecao);
        
        //System.out.println("nPorSelecao : " + nPorSelecao + ", realsize : " + nSelecao.length);
        //System.out.println("nPorCruzamento : " + nPorCruzamento + ", realsize : " + nCruzamento.length);
        /*
        Caminho[] nSelecao = new Caminho[nPorSelecao];
        for (int i=0;i<nPorSelecao;i++)
        {
            nSelecao[i] = selecao.selecionar(pop);
        }
        */
        List< Caminho > novaPop = new ArrayList<>();
        for (int i=0;i<nCruzamento.length;i++)
        {
            novaPop.add(nCruzamento[i]);
        }
        for (int i=0;i<nSelecao.length;i++)
        {
            novaPop.add(nSelecao[i]);
        }
        
        if (mutacao.getChanceMutacao()!=0.00)
        {
            mutacao.mutar(novaPop);
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
