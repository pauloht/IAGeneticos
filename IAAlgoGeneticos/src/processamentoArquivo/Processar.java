/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processamentoArquivo;

import Model.Grafo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @author Paulo
 * 
 */
public class Processar {
    private static boolean fileSet = false;
    
    /**
     * Processa arquivo "a280.tsp" e transforma na estrutura de dados Model.Grafo
     * @param file arquivo "a280.tsp"
     * @param grafo estrutura passa por referencia que sera instanciada
     * @return 
     */
    public static Grafo processar(File file)
    {
        try{
        Grafo grafo = null;
        int contador = 0;
        FileReader fr = new FileReader( file );
        BufferedReader br = new BufferedReader(fr);
        int[] posx = new int[280];
        int[] posy = new int[280];
        while (true)
        {
            String lineIN = br.readLine();
            String line;
            if (lineIN.equals("EOF"))
            {
                System.out.println("ACHOU EOF");
                break;
            }
            if (lineIN==null)
            {
                break;
            }
            //System.out.println("line read : " + lineIN);
            if (contador < 3)
            {
                boolean shouldAbort = false;
                switch(contador)
                {
                    case 0 : 
                        if (!lineIN.equals("NAME : a280"))
                        {
                            shouldAbort = true;
                        }
                        break;
                    case 1 :
                        if (!lineIN.equals("COMMENT : drilling problem (Ludwig)"))
                        {
                            shouldAbort = true;
                        }
                        break;
                    case 2 :
                        if (!lineIN.equals("TYPE : TSP"))
                        {
                            shouldAbort = true;
                        }
                        break;
                }
                if (shouldAbort)
                {
                    System.out.println("FALHA EM " + contador);
                    return(null);
                }
            }
            line = processarString(lineIN);
            //System.out.println("Linha processada : " + line);
            if (contador > 5)
            {
                String[] separado = line.split(" ");
                int id = Integer.parseInt( separado[0] );//inutil?
                //System.out.println("separado[1] = " + separado[1]);
                int valorx = Integer.parseInt( separado[1] );
                int valory = Integer.parseInt( separado[2] );
                
                //System.out.println("id : " + id);
                posx[id-1] = valorx;
                //System.out.println("valorx : " + valorx);
                posy[id-1] = valory;
                //System.out.println("valory : " + valory);
                if ((id-1)==(contador-6))
                {
                    //System.out.println("TRUE ID-1==contador-6");
                }
            }
            contador++;
        }
        
        //System.out.println("INICIO");
        double[][] matriz = new double[280][280];
        for (int i=0;i<279;i++)
        {
            for (int j=0;j<280-i-1;j++)
            {
                //distancia eh a raiz do quadrado das diferencas
                double distancia = Math.sqrt( Math.pow( posx[i] - posx[i+1+j], 2) + Math.pow( posy[i] - posy[i+1+j], 2) );
                matriz[i][j] = distancia;
            }
        }
        //System.out.println("FIM");
        grafo = new Grafo(matriz);
        if (grafo == null)
        {
            System.out.println("lol?");
        }
        //grafo.imprimirDistancias();
        return(grafo);
        }
        catch(Exception e)
        {
            System.out.println("mensagem erro : " + e.getMessage());
            e.printStackTrace();
            return(null);
        }
    }
    
    private static String processarString(String entrada)
    {
        StringBuilder aux = new StringBuilder();
        boolean start = true;
        boolean espacobuffer = false;
        char c;
        for (int i=0;i<entrada.length();i++)
        {
            c = entrada.charAt(i);
            if (c!=' ')
            {
                start = false;
                espacobuffer = false;
                aux.append(c);
            }
            else
            {
                if (!start)
                {
                    if (!espacobuffer)
                    {
                        aux.append(c);
                        espacobuffer = true;
                    }
                }
            }
        }
        return(aux.toString());
    }
    
}
