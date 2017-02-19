/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Blender.Blender;
import Model.Populacao;
import java.util.Locale;
import javax.swing.JLabel;

/**
 *
 * @author FREE
 */
public class MyThread implements Runnable{
    JLabel lb = null;
    Blender bd = null;
    int interacoes;
    Populacao pop;
    
    public void setLabel(JLabel lb,Populacao pop,Blender bd,int interacoes)
    {
        this.lb = lb;
        this.bd = bd;
        this.interacoes = interacoes;
        this.pop = pop;
    }
    
    @Override
    public void run() {

    }
    
    private void updateLabel(String text)
    {
        lb.setText(text);
    }
    
}
