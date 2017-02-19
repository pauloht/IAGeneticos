/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Selecao;

import Cruzamento.Cruzamento;
import Model.Caminho;
import Model.Populacao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FREE
 */
public class Selecao {
    private int quantiaGeradoPorSelecao;
    private TipoSelecao tipoSelecao;
    private GeracaoNovaEnum geracaoNova;

    public Selecao(int quantiaGeradaPorSelecao, TipoSelecao tipoSelecao,GeracaoNovaEnum novaGeracao) {
        this.quantiaGeradoPorSelecao = quantiaGeradaPorSelecao;
        this.tipoSelecao = tipoSelecao;
        this.geracaoNova = novaGeracao;
    }
    
    public void gerarNovaPopulacao(Populacao populacaoDeEntrada)
    {
        List< Caminho > novoCaminho = new ArrayList<>();
        for (int i=0;i<quantiaGeradoPorSelecao;i++)
        {
            Caminho caminhoSelecionado = tipoSelecao.selecionar(populacaoDeEntrada);
            novoCaminho.add(caminhoSelecionado);
        }
        populacaoDeEntrada.updatePop(novoCaminho);
    }
    
    public Caminho[] gerarNCaminhosPorSelecao(Populacao pop,int n)
    {
        return( geracaoNova.pegarNCaminhos(pop, n) );
    }
    
    public Caminho selecionar(Populacao pop)
    {
        return( tipoSelecao.selecionar(pop) );
    }

    public GeracaoNovaEnum getGeracaoNova() {
        return geracaoNova;
    }

    public int getQuantiaGeradoPorSelecao() {
        return quantiaGeradoPorSelecao;
    }
    
    
}
