/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mutacao;

import Model.Caminho;
import Model.Populacao;
import java.util.List;
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
    protected void mutarTrue(Populacao pop) {
        List< Caminho > caminhos = pop.getPop();
        mutarTrue(caminhos);
    }

    @Override
    protected void mutarTrue(List<Caminho> caminhos) {
        for (Caminho c : caminhos)
        {
            for (int i=0;i<c.getCaminho().length;i++)
            {
                Random gen = new Random();
                double teraMutacao = 100*gen.nextDouble();
                if (teraMutacao<=chanceMutacao)
                {
                    int indiceTrocado = 0;
                    while (true)
                    {
                        indiceTrocado = gen.nextInt(c.getCaminho().length);
                        if (indiceTrocado!=i)
                        {
                            break;
                        }
                    }
                    //System.out.println("Antes da mutacao com indices " + cromossomoPosicao + "," + indiceTrocado);
                    //pop.printCaminho();
                    int[] caminho = c.getCaminho();
                    int aux = caminho[i];
                    caminho[i] = caminho[indiceTrocado];
                    caminho[indiceTrocado] = aux;
                }
                //System.out.println("Depois da mutacao");
                //pop.printCaminho();
                
            }
        }
    }
    
}
