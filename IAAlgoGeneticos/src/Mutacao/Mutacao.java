/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mutacao;

import Model.Caminho;
import java.util.Random;

/**
 *
 * @author FREE
 */
public abstract class Mutacao {
    double chanceMutacao = 0.00;//entre 0-100
    public Mutacao(double chance)
    {
        chanceMutacao = chance;
    }
    
    public void mutar(Caminho pop,int cromossomoPosicao)
    {
        Random gem = new Random();
        double roll = gem.nextDouble();
        roll = roll*100;
        //double roll = gem.nextDouble()*100;
        //System.out.println("Rolou : " + roll);
        if (roll <= chanceMutacao)
        {
            
            //System.out.println("Prescissa de : " + chanceMutacao + " , rolou : " + roll);
            mutarTrue(pop,cromossomoPosicao);
        }
        else
        {
            //System.out.println("falhou mutacao");
        }
    }

    public double getChanceMutacao() {
        return chanceMutacao;
    }
    
    protected abstract void mutarTrue(Caminho pop,int cromossomoPosicao);
}
