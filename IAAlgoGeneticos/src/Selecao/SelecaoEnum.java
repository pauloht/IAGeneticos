/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Selecao;

/**
 *
 * @author FREE
 */
public enum SelecaoEnum {
    FITNESS,
    RANKING_FITNESS;
    
    public TipoSelecao getSelecao(int quantiaPorSelecao)
    {
        switch (this)
        {
            case FITNESS :
                return(new Fitness());
            case RANKING_FITNESS :
                return(new RankingFitness());
            default :
                return(null);
        }
    }
}
