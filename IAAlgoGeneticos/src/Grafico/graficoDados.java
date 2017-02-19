/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafico;

import Model.Populacao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FREE
 */
public class graficoDados {
    private List< Double > menorLocal;
    private List< Double > maiorLocal;
    
    private double maiorGlobal;
    private double menorGlobal;
    
    private int distanciaPassos = 1;
    
    private int contadorInterno = 0;
    
    private boolean compactFlag = false;
    
    public graficoDados(double maiorLocal,double menorLocal)
    {
        this.menorLocal = new ArrayList<>();
        this.maiorLocal = new ArrayList<>();
        this.maiorGlobal = maiorLocal;
        this.menorGlobal = menorLocal;
        this.addMaiorLocal(maiorLocal);
        this.addMenorLocal(menorLocal);
    }
    
    public graficoDados(Populacao pop)
    {
        double maiorLocal = pop.getMaiorCustoLocal();
        double menorLocal = pop.getMenorCustoLocal();
        this.menorLocal = new ArrayList<>();
        this.maiorLocal = new ArrayList<>();
        this.maiorGlobal = maiorLocal;
        this.menorGlobal = menorLocal;
        this.addMaiorLocal(maiorLocal);
        this.addMenorLocal(menorLocal);
    }
    
    private void compactar()
    {
        List< Double > novaListaMaior = new ArrayList<>();
        List< Double > novaListaMenor = new ArrayList<>();
        novaListaMaior.add(maiorLocal.get(0));
        novaListaMenor.add(menorLocal.get(0));
        /*
        System.out.println("Lista antes : ");
        for (Double d : maiorLocal)
        {
            System.out.print(String.format("%.2f ; ",d));
        }
        System.out.println("");
        */
        for (int i=1;i<11;i++)
        {
            if (i%2==0)
            {
                novaListaMaior.add(this.maiorLocal.get(i));
                novaListaMenor.add(this.menorLocal.get(i));
            }
        }
        this.maiorLocal = novaListaMaior;
        this.menorLocal = novaListaMenor;
        distanciaPassos = distanciaPassos*2;
        
        compactFlag = false;
        /*
        System.out.println("Lista depois : ");
        for (Double d : maiorLocal)
        {
            System.out.print(String.format("%.2f ;",d));
        }
        System.out.println("");
        */
    }
    
    private boolean shouldCompact()
    {
        if (compactFlag)
        {
            return(true);
        }
        if (maiorLocal.size()>10)
        {
            compactFlag = true;
            return(false);
        }
        return(false);
    }
    
    public void addMaiorMenor(Populacao pop)
    {
        contadorInterno++;
        if ( (contadorInterno>=distanciaPassos&&!compactFlag) || (compactFlag&&contadorInterno>=distanciaPassos*2) )
        {
            if (!shouldCompact())
            {
                if (!compactFlag)
                {
                    //System.out.println("adicionando...");
                    contadorInterno = 0;
                    addMaiorLocal(pop.getMaiorCustoLocal());
                    addMenorLocal(pop.getMenorCustoLocal());
                }
            }
            else
            {
                //System.out.println("compactando...");
                compactar();
                contadorInterno = 0;
                addMaiorLocal(pop.getMaiorCustoLocal());
                addMenorLocal(pop.getMenorCustoLocal());
            }
        }
    }
    
    private void addMaiorLocal(double maiorLocal)
    {
        this.maiorLocal.add(maiorLocal);
        maiorGlobal = Math.max(maiorGlobal, maiorLocal);
    }
    
    private void addMenorLocal(double menorLocal)
    {
        this.menorLocal.add(menorLocal);
        menorGlobal = Math.min(menorGlobal, menorLocal);
    }

    public List<Double> getMenorLocal() {
        return menorLocal;
    }

    public List<Double> getMaiorLocal() {
        return maiorLocal;
    }

    public double getMaiorGlobal() {
        return maiorGlobal;
    }

    public double getMenorGlobal() {
        return menorGlobal;
    }

    public int getDistanciaPassos() {
        return distanciaPassos;
    }

    
    
    public void printar()
    {
        System.out.println("tam maior : " + this.maiorLocal.size() );
        System.out.println("tam menor : " + this.menorLocal.size() );
        System.out.println("distancia passos : " + this.distanciaPassos);
        System.out.println("Cont interno : " + this.distanciaPassos);    }
    
}
