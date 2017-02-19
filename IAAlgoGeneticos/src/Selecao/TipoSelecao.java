/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Selecao;

import Model.Caminho;
import Model.Populacao;

/**
 *
 * @author FREE
 */
public interface TipoSelecao {
    /**
     * Seleciona um caminho(crossomo) de uma populacao
     * @param populacao
     * @return 
     */
    public Caminho selecionar(Populacao populacao);
}
