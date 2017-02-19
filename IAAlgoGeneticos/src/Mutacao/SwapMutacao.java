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
public class SwapMutacao extends Mutacao{

    public SwapMutacao(double chance) {
        super(chance);
    }

    @Override
    protected void mutarTrue(Caminho pop, int cromossomoPosicao) {
        Random gem = new Random();
        int indiceTrocado = 0;
        while (true)
        {
            indiceTrocado = gem.nextInt(pop.getCaminho().length);
            if (indiceTrocado!=cromossomoPosicao)
            {
                break;
            }
        }
        //System.out.println("Antes da mutacao com indices " + cromossomoPosicao + "," + indiceTrocado);
        //pop.printCaminho();
        int[] caminho = pop.getCaminho();
        int aux = caminho[cromossomoPosicao];
        caminho[cromossomoPosicao] = caminho[indiceTrocado];
        caminho[indiceTrocado] = aux;
        //System.out.println("Depois da mutacao");
        //pop.printCaminho();
    }
    
}
