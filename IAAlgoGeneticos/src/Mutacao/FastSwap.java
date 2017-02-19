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
public class FastSwap extends Mutacao{

    public FastSwap(double chance) {
        super(chance);
    }

    @Override
    protected void mutarTrue(Populacao pop) {
        List< Caminho > caminhos = pop.getPop();
        mutarTrue(caminhos);
    }

    @Override
    protected void mutarTrue(List<Caminho> caminhos) {
        Random gen = new Random();
        if (caminhos!=null&&caminhos.size()>0)
        {
            //todos os caminhos tem tamanho N
            //existe C caminhos
            //logo existe N*C cromossomos
            int numeroCaminhos = caminhos.size();
            int tamanhoCaminho = caminhos.get(1).getCaminho().length;
            int cromossomos = numeroCaminhos*tamanhoCaminho;
            //Se existem P cromossomos e a chance de mudar é X(X entre 0-1) entao existira P*X mudancas
            int mudancas = new Double( cromossomos*(chanceMutacao/100) ).intValue();
            //Muda PX vezes cromossomos de cadeia aleatorios
            for (int i=0;i<mudancas;i++)
            {
                int sorteioCaminho = gen.nextInt(numeroCaminhos);
                int sorteioPosicaoNoCaminho1 = gen.nextInt(tamanhoCaminho);
                int sorteioPosicaoNoCaminho2 = gen.nextInt(tamanhoCaminho);
                Caminho c = caminhos.get(sorteioCaminho);
                int[] caminho = c.getCaminho();
                int aux = caminho[sorteioPosicaoNoCaminho1];
                caminho[sorteioPosicaoNoCaminho1] = caminho[sorteioPosicaoNoCaminho2];
                caminho[sorteioPosicaoNoCaminho2] = aux;
            }
            
            
        }
    }
    
}
