/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Selecao;

import Model.Caminho;

/**
 *
 * @author FREE
 */
public class CaminhoWrapper implements Comparable{
    private Caminho caminho;
    private int fitness = 0;
    
    public CaminhoWrapper(Caminho caminho,int fitness)
    {
        this.caminho = caminho;
        this.fitness = fitness;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof CaminhoWrapper)
        {
            CaminhoWrapper outroCaminho = (CaminhoWrapper)o;
            return(outroCaminho.fitness - this.fitness);
        }
        return(0);
    }

    public int getFitness() {
        return fitness;
    }
    
    public Caminho getCaminho()
    {
        return(caminho);
    }
    
    protected void setFitness(int fitness)
    {
        this.fitness = fitness;
    }
}
