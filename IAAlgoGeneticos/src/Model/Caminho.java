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
public class Caminho implements Comparable{
    private int[] caminho;
    
    private Double custo = null;

    public Caminho(int[] caminho)
    {
        this.caminho = caminho;
    }
    
    public void setCusto(Double custo) {
        this.custo = custo;
    }

    public Double getCusto() {
        return custo;
    }
    
    

    public int[] getCaminho() {
        return caminho;
    }
    
    public void printCaminho()
    {
        for (int i=0;i<caminho.length-1;i++)
        {
            System.out.print(caminho[i] + "->");
        }
        System.out.println(caminho[caminho.length-1]);
    }
    
    public boolean validarCaminho()
    {
        int[] contador = new int[280];
        for (int i=0;i<contador.length;i++)
        {
            contador[i] = 0;
        }
        for (int i=0;i<caminho.length;i++)
        {
            contador[caminho[i]-1]++;
        }
        boolean isValido = true;
        for (int i=0;i<contador.length;i++)
        {
            if (contador[i]!=1)
            {
                isValido = false;
                break;
            }
        }
        return(isValido);
    }    

    @Override
    public int compareTo(Object o) {
        if (o instanceof Caminho)
        {
            Caminho outroCaminho = (Caminho)o;
            if (outroCaminho.custo!=null && this.custo!=null)
            {
                return( new Double(custo-outroCaminho.custo).intValue() );
            }
        }
        return(0);
    }
}
