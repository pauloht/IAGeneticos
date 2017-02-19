/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mutacao;

import Model.Caminho;
import Model.Populacao;
import java.util.List;

/**
 *
 * @author FREE
 */
public abstract class Mutacao {
    protected double chanceMutacao = 0.00;//entre 0-100
    public Mutacao(double chance)
    {
        chanceMutacao = chance;
    }
    
    public void mutar(Populacao pop)
    {
        mutarTrue(pop);
    }
    
    public void mutar(List<Caminho> caminhos)
    {
        mutarTrue(caminhos);
    }

    public double getChanceMutacao() {
        return chanceMutacao;
    }
    
    protected abstract void mutarTrue(Populacao pop);
    protected abstract void mutarTrue(List< Caminho > caminhos);
}
