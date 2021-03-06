/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Grafico.graficoDados;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Locale;

/**
 *
 * @author FREE
 */
public class GraficoJPanel extends javax.swing.JPanel {

    /**
     * Creates new form GraficoFrame2
     */
    private graficoDados dados = null;
    
    public GraficoJPanel(graficoDados dados)
    {
        this.dados = dados;
    }
    
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        Color colorbuffer;
        int pontos = dados.getMaiorLocal().size();
        
        double alturamax = dados.getMaiorGlobal();
        double somay = alturamax/10.00;
        
        int passos =  dados.getDistanciaPassos();
        
        g.drawLine(10, 10, 10, 590);
        g.drawLine(10, 590, 790, 590);
        int fatorx = 76;
        int iniciox = 10;
        
        int fatory = 58;
        int inicioy = 590;
        //escala horizontal
        for (int i=0;i<10;i++)
        {
            int width = g.getFontMetrics().stringWidth(Integer.toString((i+1)*passos));
            g.drawLine((i+1)*fatorx+iniciox, 595, (i+1)*fatorx+iniciox, 585);
            g.drawString(Integer.toString((i+1)*passos), (i+1)*fatorx+iniciox - new Double(width/2.00).intValue(), 580);
        }
        
        double stringvertical = 0.00;
        //escala vertical
        for (int i=0;i<10;i++)
        {
            stringvertical = stringvertical + somay;
            int height = g.getFontMetrics().getHeight();
            g.drawLine(5, inicioy-( (i+1)*fatory ), 15, inicioy-( (i+1)*fatory ));
            g.drawString(String.format(Locale.US,"%.2f",stringvertical), 20 , inicioy-( (i+1)*fatory ) + new Double(height/2.00).intValue());
        }
        
        //linha de i-1->i
        colorbuffer = g.getColor();
        g.setColor(Color.RED);
        for (int i=1;i<pontos;i++)
        {
            int cordx1 = (i-1)*fatorx+iniciox;
            int cordy1 = coordenadaEquivalenteEmY(alturamax, dados.getMaiorLocal().get(i-1));
            
            int cordx2 = (i)*fatorx+iniciox;
            int cordy2 = coordenadaEquivalenteEmY(alturamax, dados.getMaiorLocal().get(i));
            
            g.drawLine(cordx1,cordy1+(600-inicioy),cordx2,cordy2+(600-inicioy));
        }
        g.setColor(colorbuffer);
        
        colorbuffer = g.getColor();
        g.setColor(Color.GREEN);
        for (int i=1;i<pontos;i++)
        {
            int cordx1 = (i-1)*fatorx+iniciox;
            int cordy1 = coordenadaEquivalenteEmY(alturamax, dados.getMenorLocal().get(i-1));
            
            int cordx2 = (i)*fatorx+iniciox;
            int cordy2 = coordenadaEquivalenteEmY(alturamax, dados.getMenorLocal().get(i));
            
            g.drawLine(cordx1,cordy1+(600-inicioy),cordx2,cordy2+(600-inicioy));
        }
        g.setColor(colorbuffer);
    }
    
    private int coordenadaEquivalenteEmY(double maxY,double Y)
    {
        double percentage = 1.00 - (Y/maxY);
        return( new Double(percentage*580).intValue() );
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
