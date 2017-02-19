/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teste;

import java.util.Random;

/**
 *
 * @author FREE
 */
public class teste {
    public static void main(String args[])
    {
        Random gem = new Random();
        for (int i=0;i<10;i++)
        {
            double roll = gem.nextDouble()*100;
            System.out.println("roll : " + roll + "%");
        }
    }
}
