/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mutacao;

/**
 *
 * @author FREE
 */
public enum MutacaoEnum {
    SWAP,
    FASTSWAP;
    
    public Mutacao getMutacaoInstancia(double mutacaochance){
        switch (this)
        {
            case SWAP :
                return(new SwapMutacao(mutacaochance));
            case FASTSWAP :
                return(new FastSwap(mutacaochance));
            default :
                return(null);
        }
    }
}
