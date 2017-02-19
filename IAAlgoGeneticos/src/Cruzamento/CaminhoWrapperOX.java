/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cruzamento;

import Model.Caminho;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FREE
 */
public class CaminhoWrapperOX {
    private List< Integer > caminho;
    private int menorindice = -1;
    private int maiorindice = -1;
    public CaminhoWrapperOX(int maiorindice,int menorindice)
    {
        caminho = new ArrayList<>();
        this.maiorindice = maiorindice;
        this.menorindice = menorindice;
    }
    
    public void add(int valor)
    {
        caminho.add(valor);
    }
    
    public Caminho getValidoCaminho()
    {
        if (caminho.size()>280)
        {
            throw new IllegalArgumentException("Tamanho caminho > 280");
        }
        //System.out.println("CaminhoWrapper size: " + this.caminho.size());
        int[] rawCaminho = new int[280];
        int j = 0;
        for (int i=menorindice;i<280;i++)
        {
            rawCaminho[i] = caminho.get(j);
            j++;
        }
        int k = 0;
        for (int i=j;i<280;i++)
        {
            rawCaminho[k] = caminho.get(j);
            k++;
            j++;
        }
        //System.out.println("tamanho j : " + j);
        Caminho retorno = new Caminho(rawCaminho);
        if (retorno.validarCaminho())
        {
            //System.out.println("Valido!");
        }
        else
        {
            //System.out.println("Invalido!");
        }
        return(retorno);
    }
}
