/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teste;

import Selecao.CaminhoWrapper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author FREE
 */
public class caminhowrapperteste {
    public static void main(String args[])
    {
        testComparable();
    }
    
    private static void testComparable()
    {
        Random gen = new Random();
        List< CaminhoWrapper > lista = new ArrayList<>();
        for (int i=0;i<10;i++)
        {
            CaminhoWrapper c = new CaminhoWrapper(null,gen.nextInt(1000));
            lista.add(c);
        }
        
        System.out.println("lista antes : " );
        for (CaminhoWrapper c : lista)
        {
            System.out.println(c.getFitness() + ",");
        }
        
        Collections.sort(lista);
        System.out.println("lista depois");
        for (CaminhoWrapper c : lista)
        {
            System.out.println(c.getFitness() + ",");
        }
    }
}
