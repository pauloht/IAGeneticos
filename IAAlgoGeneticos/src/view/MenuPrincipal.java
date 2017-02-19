/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Blender.Blender;
import Cruzamento.Cruzamento;
import Cruzamento.OrderCrossOver;
import Model.Grafo;
import Model.Populacao;
import Mutacao.Mutacao;
import Mutacao.MutacaoEnum;
import Selecao.GeracaoNovaEnum;
import Selecao.Selecao;
import Selecao.SelecaoEnum;
import java.util.Locale;
import javax.swing.JOptionPane;

/**
 *
 * @author FREE
 */
public class MenuPrincipal extends javax.swing.JFrame {
    private Grafo custo = null;
    private int nGeracoes = 0;
    private int nPopulacao = 10;
    private double taxaMutacao = 0.00;
    private double taxaCruzamento = 0.00;
    private boolean lock = false;
    private SelecaoEnum selecaoTipo = null;
    private GeracaoNovaEnum novaGeracao = null;
    private MutacaoEnum mutacaoTipo = null;
    private int nElitista = 0;
    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal(Grafo custo) {
        initComponents();
        this.custo = custo;
        forceValues();
        ViewGlobal.centralizarJanela(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgSelecaoTipo = new javax.swing.ButtonGroup();
        bgNovaGeracao = new javax.swing.ButtonGroup();
        bgMutacaoTipo = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        lbApenasPercentage = new javax.swing.JLabel();
        lbPercentage = new javax.swing.JLabel();
        btIniciar = new javax.swing.JButton();
        tfGeracoes = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfTamanhoPopulacao = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        brFitness = new javax.swing.JRadioButton();
        brRankingFitness = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        brTotalmenteNova = new javax.swing.JRadioButton();
        brElitista = new javax.swing.JRadioButton();
        tfNElitista = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        tfTaxaCruzamento = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        tfTaxaMutacao = new javax.swing.JTextField();
        brSwap = new javax.swing.JRadioButton();
        brFastSwap = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));

        lbApenasPercentage.setFont(new java.awt.Font("Lucida Console", 1, 24)); // NOI18N
        lbApenasPercentage.setText("%");

        lbPercentage.setFont(new java.awt.Font("Lucida Console", 1, 24)); // NOI18N
        lbPercentage.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbPercentage.setText("0");

        btIniciar.setText("Iniciar");
        btIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIniciarActionPerformed(evt);
            }
        });

        tfGeracoes.setText("0");
        tfGeracoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfGeracoesActionPerformed(evt);
            }
        });

        jLabel1.setText("Geracoes");

        jLabel3.setText("TamanhoPopulacao");

        tfTamanhoPopulacao.setText("0");
        tfTamanhoPopulacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTamanhoPopulacaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(lbPercentage, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(lbApenasPercentage)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(28, 28, 28)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfGeracoes, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                            .addComponent(tfTamanhoPopulacao))
                        .addGap(181, 181, 181))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPercentage, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbApenasPercentage))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfGeracoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfTamanhoPopulacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addComponent(btIniciar)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Iniciar!", jPanel1);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));

        jLabel2.setText("Metodo de selecao :");

        bgSelecaoTipo.add(brFitness);
        brFitness.setText("Fitness");
        brFitness.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brFitnessActionPerformed(evt);
            }
        });

        bgSelecaoTipo.add(brRankingFitness);
        brRankingFitness.setText("Ranking da fitness");
        brRankingFitness.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brRankingFitnessActionPerformed(evt);
            }
        });

        jLabel4.setText("Gerar nova populacao :");

        bgNovaGeracao.add(brTotalmenteNova);
        brTotalmenteNova.setText("Totalmente nova");
        brTotalmenteNova.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brTotalmenteNovaActionPerformed(evt);
            }
        });

        bgNovaGeracao.add(brElitista);
        brElitista.setText("Elitista(mantem n melhores)");
        brElitista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brElitistaActionPerformed(evt);
            }
        });

        tfNElitista.setText("0");
        tfNElitista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNElitistaActionPerformed(evt);
            }
        });

        jLabel7.setText("funciona");

        jLabel8.setText("Sera autobalanceado ver manual");

        jLabel9.setText("N elementos pela elitista");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(brTotalmenteNova, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(brRankingFitness)
                                .addComponent(brFitness))
                            .addGap(45, 45, 45)
                            .addComponent(jLabel7)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tfNElitista, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(brElitista, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(brFitness)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(brRankingFitness))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel7)))
                .addGap(38, 38, 38)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(brTotalmenteNova)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(brElitista)
                .addGap(3, 3, 3)
                .addComponent(jLabel9)
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNElitista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Selecao", jPanel2);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));

        tfTaxaCruzamento.setText("60.00");
        tfTaxaCruzamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTaxaCruzamentoActionPerformed(evt);
            }
        });

        jLabel5.setText("Taxa de cruzamento :");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(tfTaxaCruzamento, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfTaxaCruzamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(233, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Crussamento", jPanel3);

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));
        jPanel4.setToolTipText("");

        jLabel6.setText("Taxa mutacao :");

        tfTaxaMutacao.setText("0.00");
        tfTaxaMutacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTaxaMutacaoActionPerformed(evt);
            }
        });

        bgMutacaoTipo.add(brSwap);
        brSwap.setText("Swap");
        brSwap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brSwapActionPerformed(evt);
            }
        });

        bgMutacaoTipo.add(brFastSwap);
        brFastSwap.setText("FastSwap");
        brFastSwap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brFastSwapActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(brFastSwap)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfTaxaMutacao, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(brSwap))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tfTaxaMutacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(brFastSwap)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(brSwap)
                .addContainerGap(167, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Mutacao", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIniciarActionPerformed
        // TODO add your handling code here:
        if (!lock)
        {
            lock = true;
            try{
                lockValues();
                long tBegin = System.nanoTime();
                forceValues();
                lbPercentage.setText("0");
                lbPercentage.paintImmediately(lbPercentage.getVisibleRect());

                Populacao test = new Populacao(nPopulacao, custo);//populacao inicial
                //test.printarInformacoes();
                Cruzamento cruzamento = new OrderCrossOver(taxaCruzamento);//cruzamento OX com 100% de chance de cruzamento
                Selecao selecao = new Selecao(nElitista, selecaoTipo.getSelecao(),novaGeracao);//usa roleta e fitness
                Mutacao mutacao = mutacaoTipo.getMutacaoInstancia(taxaMutacao);

                Blender prox = new Blender(test,selecao,cruzamento,mutacao,nPopulacao);
                double valorAgora;
                double mudancaNecessaria = 1.00;
                double percentage;
                int total = nGeracoes;
                for (int i=0;i<total;i++)
                {
                    valorAgora = Double.parseDouble( lbPercentage.getText() );
                    percentage = 100*(i+1+0.00)/(total+0.00);
                    //System.out.println("percentage : " + percentage);
                    //System.out.println("valoragora : " + valorAgora);
                    //System.out.println("percenta-valoragora : " + (percentage - valorAgora));
                    if ((percentage - valorAgora) >= mudancaNecessaria)
                    {
                        //System.out.println("TRUEEEEEEEEEEEEEEEEEEEEEE");
                        lbPercentage.setText(String.format(Locale.US,"%.2f",percentage));
                        lbPercentage.paintImmediately(lbPercentage.getVisibleRect());
                    }
                    prox.proximaGeracao(test);
                }
                //test.printarInformacoes();
                /*
                JFrame frame = new JFrame();
                JPanel panel = new GraficoJPanel(prox.getGraficodados());
                panel.setPreferredSize(new Dimension(800,600));
                panel.setBackground(Color.GRAY);
                frame.add(panel);
                frame.pack();
                ViewGlobal.centralizarJanela(frame);
                frame.setVisible(true);
                */
                long tEnd = System.nanoTime();
                long elapsed = tEnd-tBegin;
                GraficoFrame frame = new GraficoFrame(prox.getGraficodados(),elapsed);
                lbPercentage.setText("100");
                unlockValues();
                lock = false;
            }
            catch(Exception e)
            {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Opa algo estranho aconteceu, teremos que cancelar =(, tente de novo!");
                unlockValues();
                lock = false;
            }
        }
        //Caminho filho1 = filhos[0];
        //Caminho filho2 = filhos[1];
    }//GEN-LAST:event_btIniciarActionPerformed

    private void forceValues()
    {
        forceGeracoes();
        forcePopulacao();
        forceCruzamento();
        forceMutacao();
        forceSelecaoEnum();
        forceGeracaoNovaEnum();
        forceNElitista();
        forceMutacaoEnum();
    }
    
    private void forceGeracoes()
    {
        try{
            int n = Integer.parseInt(tfGeracoes.getText());
            nGeracoes = n;
        }
        catch(NumberFormatException e)
        {
            tfGeracoes.setText( Integer.toString(nGeracoes ) );
        }
    }
    
    private void forcePopulacao()
    {
        try{
            int n = Integer.parseInt(tfTamanhoPopulacao.getText());
            if (n%2==1)
            {
                n=n-1;
            }
            if (n<0)
            {
                tfTamanhoPopulacao.setText( Integer.toString(nPopulacao ) );
            }
            else
            {
                if (n<nElitista)
                {
                    nElitista = n;
                    tfNElitista.setText( Integer.toString(nElitista ) );
                }
                nPopulacao = n;
            }
            tfTamanhoPopulacao.setText( Integer.toString(nPopulacao ) );
        }
        catch(NumberFormatException e)
        {
            tfTamanhoPopulacao.setText( Integer.toString(nPopulacao ) );
        }
    }
    
    private void forceMutacao()
    {
        try{
            double n = Double.parseDouble( tfTaxaMutacao.getText() );
            taxaMutacao = n;
        }
        catch(NumberFormatException e)
        {
            tfTaxaMutacao.setText( Double.toString(taxaMutacao ) );
        }
    }
    
    private void forceCruzamento()
    {
        try{
            double n = Double.parseDouble( tfTaxaCruzamento.getText() );
            taxaCruzamento = n;
        }
        catch(NumberFormatException e)
        {
            tfTaxaCruzamento.setText( Double.toString(taxaCruzamento ) );
        }
    }
    
    private void forceSelecaoEnum()
    {
        try{
            if (brFitness.isSelected())
            {
                selecaoTipo = SelecaoEnum.FITNESS;
            }
            else if (brRankingFitness.isSelected())
            {
                selecaoTipo = SelecaoEnum.RANKING_FITNESS;
            }
            else
            {
                brFitness.setSelected(true);
                forceSelecaoEnumRecover();
            }
        }
        catch(Exception e)
        {
            brFitness.setSelected(true);
            forceSelecaoEnumRecover();
        }
    }
    
    private void forceSelecaoEnumRecover()
    {
        try{
            if (brFitness.isSelected())
            {
                selecaoTipo = SelecaoEnum.FITNESS;
            }
            else if (brRankingFitness.isSelected())
            {
                selecaoTipo = SelecaoEnum.RANKING_FITNESS;
            }
        }
        catch(Exception e)
        {
            brFitness.setSelected(true);
        }
    }
    
    private void forceGeracaoNovaEnum()
    {
        try{
            if (brTotalmenteNova.isSelected())
            {
                novaGeracao = GeracaoNovaEnum.TOTALMENTE_NOVA;
            }
            else if (brElitista.isSelected())
            {
                novaGeracao = GeracaoNovaEnum.ELISTISTA;
            }
            else
            {
                brElitista.setSelected(true);
                forceGeracaoNovaEnumRecover();
            }
        }
        catch(Exception e)
        {
            brElitista.setSelected(true);
            forceGeracaoNovaEnumRecover();
        }
    }
    
    private void forceGeracaoNovaEnumRecover()
    {
        try{
            if (brTotalmenteNova.isSelected())
            {
                novaGeracao = GeracaoNovaEnum.TOTALMENTE_NOVA;
            }
            else if (brElitista.isSelected())
            {
                novaGeracao = GeracaoNovaEnum.ELISTISTA;
            }
            else
            {
                brElitista.setSelected(true);
            }
        }
        catch(Exception e)
        {
            brElitista.setSelected(true);
        }
    }
    
    private void forceMutacaoEnum()
    {
        try{
            if (brSwap.isSelected())
            {
                mutacaoTipo = MutacaoEnum.SWAP;
            }
            else if (brFastSwap.isSelected())
            {
                mutacaoTipo = MutacaoEnum.FASTSWAP;
            }
            else
            {
                brFastSwap.setSelected(true);
                forceMutacaoEnumRecover();
            }
        }
        catch(Exception e)
        {
            brTotalmenteNova.setSelected(true);
            forceMutacaoEnumRecover();
        }
    }
    
    private void forceMutacaoEnumRecover()
    {
        try{
            if (brSwap.isSelected())
            {
                mutacaoTipo = MutacaoEnum.SWAP;
            }
            else if (brFastSwap.isSelected())
            {
                mutacaoTipo = MutacaoEnum.FASTSWAP;
            }
            else
            {
                brSwap.setSelected(true);
            }
        }
        catch(Exception e)
        {
            brTotalmenteNova.setSelected(true);
        }
    }
    
    private void forceNElitista()
    {
        try{
            int n = Integer.parseInt(tfNElitista.getText());
            if (n > nPopulacao)
            {
                tfNElitista.setText( Integer.toString(nElitista ) );
            }
            else
            {
                if ((nPopulacao-n)%2==1)
                {
                    nElitista = (n-1);
                }
                else
                {
                    nElitista = n;
                }
                tfNElitista.setText( Integer.toString(nElitista));
            }
        }
        catch(NumberFormatException e)
        {
            tfNElitista.setText( Integer.toString(nElitista ) );
        }
    }
    
    private void alterValues(boolean valor)
    {
        btIniciar.setEnabled(valor);
        tfGeracoes.setEditable(valor);
        tfTamanhoPopulacao.setEditable(valor);
        tfTaxaMutacao.setEditable(valor);
        tfTaxaCruzamento.setEditable(valor); 
    }
    
    private void lockValues()
    {
        alterValues(false);
    }
    
    private void unlockValues()
    {
        alterValues(true);
    }
    
    private void tfGeracoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfGeracoesActionPerformed
        // TODO add your handling code here:
        forceGeracoes();
    }//GEN-LAST:event_tfGeracoesActionPerformed

    private void tfTamanhoPopulacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTamanhoPopulacaoActionPerformed
        // TODO add your handling code here:
        forcePopulacao();
    }//GEN-LAST:event_tfTamanhoPopulacaoActionPerformed

    private void brElitistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brElitistaActionPerformed
        // TODO add your handling code here:
        forceGeracaoNovaEnum();
    }//GEN-LAST:event_brElitistaActionPerformed

    private void tfTaxaMutacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTaxaMutacaoActionPerformed
        // TODO add your handling code here:
        forceMutacao();
    }//GEN-LAST:event_tfTaxaMutacaoActionPerformed

    private void tfTaxaCruzamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTaxaCruzamentoActionPerformed
        // TODO add your handling code here:
        forceCruzamento();
    }//GEN-LAST:event_tfTaxaCruzamentoActionPerformed

    private void brFitnessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brFitnessActionPerformed
        // TODO add your handling code here:
        forceSelecaoEnum();
    }//GEN-LAST:event_brFitnessActionPerformed

    private void brRankingFitnessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brRankingFitnessActionPerformed
        // TODO add your handling code here:
        forceSelecaoEnum();
    }//GEN-LAST:event_brRankingFitnessActionPerformed

    private void tfNElitistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNElitistaActionPerformed
        // TODO add your handling code here:
        forceNElitista();
    }//GEN-LAST:event_tfNElitistaActionPerformed

    private void brTotalmenteNovaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brTotalmenteNovaActionPerformed
        // TODO add your handling code here:
        forceGeracaoNovaEnum();
    }//GEN-LAST:event_brTotalmenteNovaActionPerformed

    private void brFastSwapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brFastSwapActionPerformed
        // TODO add your handling code here:
        forceMutacaoEnum();;
    }//GEN-LAST:event_brFastSwapActionPerformed

    private void brSwapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brSwapActionPerformed
        // TODO add your handling code here:
        forceMutacaoEnum();
    }//GEN-LAST:event_brSwapActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgMutacaoTipo;
    private javax.swing.ButtonGroup bgNovaGeracao;
    private javax.swing.ButtonGroup bgSelecaoTipo;
    private javax.swing.JRadioButton brElitista;
    private javax.swing.JRadioButton brFastSwap;
    private javax.swing.JRadioButton brFitness;
    private javax.swing.JRadioButton brRankingFitness;
    private javax.swing.JRadioButton brSwap;
    private javax.swing.JRadioButton brTotalmenteNova;
    private javax.swing.JButton btIniciar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbApenasPercentage;
    private javax.swing.JLabel lbPercentage;
    private javax.swing.JTextField tfGeracoes;
    private javax.swing.JTextField tfNElitista;
    private javax.swing.JTextField tfTamanhoPopulacao;
    private javax.swing.JTextField tfTaxaCruzamento;
    private javax.swing.JTextField tfTaxaMutacao;
    // End of variables declaration//GEN-END:variables
}
