/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Selecao;

import Model.Caminho;
import Model.Populacao;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author FREE
 */
public class RankingFitness implements TipoSelecao{
    private Populacao pop = null;
    private List< CaminhoWrapper > caminhosFitness;
    private int totalfitness = 0;
    private int geracao = 0;
    
    @Override
    public Caminho selecionar(Populacao populacao) {
        double maiorCusto = populacao.getMaiorCustoLocal();
        if (populacao!=pop || (populacao==pop&&populacao.getGeracao()!=geracao) )
        {
            pop = populacao;
            geracao = populacao.getGeracao();
            List< Caminho > caminho = populacao.getPop();
            caminhosFitness = new ArrayList<>();
            totalfitness = 0;
            for (Caminho c : caminho)
            {
                int fitnesslocal = new Double(c.getCusto()).intValue();
                //System.out.println("Caminho custo : " + c.getCusto());
                //System.out.println("fitness local : " + fitnesslocal);
                CaminhoWrapper wrapper = new CaminhoWrapper(c,fitnesslocal);
                caminhosFitness.add(wrapper);
            }
            Collections.sort(caminhosFitness);
            int contador = 1;
            for (CaminhoWrapper c : caminhosFitness)
            {
                c.setFitness(contador);
                totalfitness = totalfitness+contador;
                contador++;
            }
            //System.out.println("total fitness : " + totalfitness);
        }
        Random gen = new Random();
        int numeroRoleta = gen.nextInt(totalfitness)+1;
        CaminhoWrapper caminhoLocal=null;
        for (int i=0;i<caminhosFitness.size();i++)
        {
            caminhoLocal = caminhosFitness.get(i);
            numeroRoleta = numeroRoleta - caminhoLocal.getFitness();
            if (numeroRoleta<=0)
            {
                //double chanceDeSerSelecionado = (100.00*caminhoLocal.getFitness())/(totalfitness+0.00);
                //System.out.println("Chance de ser selecionado : " + String.format(Locale.US,"%.4f",chanceDeSerSelecionado));
                break;
            }
        }
        return( caminhoLocal.getCaminho() );
    }
    
}
