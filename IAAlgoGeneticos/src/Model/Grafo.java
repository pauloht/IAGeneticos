/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author FREE
 */
public class Grafo {
    private final int MAXVALOR = 280;
    
    private double[][] matriz;
    //Considerando 10 entradas
    //Linha 1 tera 9 entradas ou seja custo de 1-2(entrada 1) 1-3(entrada 2)....(1-10)entrada 9
    //Linha 9 tera 1 entrada 9-10
    //Para achar distancia entre X-Y pega linha matriz[min(X,Y)-1][|X - Y|-1]
    //Exemplo caminho 10-5 = matriz[min(10,5)-1][|10-5|-1] = matriz[4][4]
    //1[2,3,4,5,6,7,8,9,10]
    //2[3,4,5,6,7,8,9,10]
    //3[4,5,6,7,8,9,10]
    //4[5,6,7,8,9,10]
    //5[6,7,8,9,10]
    //6[7,8,9,10]
    //7[8,9,10]
    //8[9,10]
    //9[10]
    
    public Grafo(double[][] matriz)
    {
        this.matriz = matriz;
    }
    
    public double distancia(int id1,int id2)
    {
        if (id1<=0 || id2<=0 || id1>280 || id2>280 )
        {
            throw new IllegalArgumentException("FORA DO RANGE");
        }
        int idLinha = Math.min(id1, id2)-1;
        int idColuna = Math.abs(id1-id2)-1;
        return(matriz[idLinha][idColuna]);
    }
    
    public void calcularCustoCaminho(Caminho caminho)
    {
        Double custo = 0.00;
        int inicio = caminho.getCaminho()[0];
        for (int i=1;i<caminho.getCaminho().length;i++)
        {
            int fim = caminho.getCaminho()[i];
            custo = custo + this.distancia(inicio, fim);
            inicio = fim;
        }
        caminho.setCusto(custo);
    }
    
    public void imprimirDistancias()
    {
        for (int i=0;i<279;i++)
        {
            for (int j=0;j<279-i;j++)
            {
                System.out.println("Distancia(" + (i+1) + "->" + (i+2+j) + ")="+matriz[i][j]);;
            }
        }
    }
}
