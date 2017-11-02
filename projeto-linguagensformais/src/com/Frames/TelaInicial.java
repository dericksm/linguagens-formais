/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Frames;

import com.Listener.TelaInicialListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.SwingUtilities;
import static javax.swing.SwingUtilities.updateComponentTreeUI;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.text.PlainDocument;

public class TelaInicial extends javax.swing.JFrame {

    TelaInicialListener listener = new TelaInicialListener(this);

    String[] arrayNaoTerminais;
    String[] arrayTerminais;
    String[] arrayProducoes;
    String inicial;
    MaskFormatter mascara;
    MaskFormatter mascaraTerminais;
    String valoresMascara = "";
    HashMap<String, String> gramatica = new HashMap<String, String>();
    DefaultListModel modelo = new DefaultListModel();

    public TelaInicial() throws ParseException {
        initComponents();

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaInicial.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(TelaInicial.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(TelaInicial.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(TelaInicial.class.getName()).log(Level.SEVERE, null, ex);
        }
        SwingUtilities.updateComponentTreeUI(this);
        updateComponentTreeUI(this);

        campoNaoTerminais.setDocument(new PlainDocument() {
            @Override
            public void insertString(int offs, String str, AttributeSet a)
                    throws BadLocationException {
                //normalmente apenas uma letra é inserida por vez,
                //mas fazendo assim também previne caaso o usuário
                //cole algum texto
                for (int i = 0; i < str.length(); i++) {
                    if (Character.isLetter(str.charAt(i)) == false) {
                        return;
                    }
                }
                super.insertString(offs, str.toUpperCase() + ",", a);
            }
        });

        campoTerminais.setDocument(new PlainDocument() {
            @Override
            public void insertString(int offs, String str, AttributeSet a)
                    throws BadLocationException {
                //normalmente apenas uma letra é inserida por vez,
                //mas fazendo assim também previne caaso o usuário
                //cole algum texto
                for (int i = 0; i < str.length(); i++) {
                    if (Character.isLetter(str.charAt(i)) == false) {
                        return;
                    }
                }
                super.insertString(offs, str.toLowerCase() + ",", a);
            }
        });

        //sobrescreve as mascaras
        mascara = new MaskFormatter("U -> LU");
        this.campoProducoes.setFormatterFactory(null);
        this.campoProducoes.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(mascara));
        this.campoProducoes.setValue(null);

        mascaraTerminais = new MaskFormatter("U -> L");
        this.campoProducoes1.setFormatterFactory(null);
        this.campoProducoes1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(mascaraTerminais));
        this.campoProducoes1.setValue(null);

        listaProducoes.setModel(modelo);

        //desativa os botoes
        btnEnviarNaoTerminal.setEnabled(false);
        btnEnviarProd.setEnabled(false);
        btnEnviarProdVazia.setEnabled(false);
        btnEnviarTerminal.setEnabled(false);
        btnEnviarProdTer.setEnabled(false);

        btnAlterarInicial.setEnabled(false);
        btnAlterarNaoTerminal.setEnabled(false);
        btnAlterarTerminal.setEnabled(false);

        btnExcluirProd.setEnabled(false);
        btnExcluirProdVazia.setEnabled(false);
        btnExcluirProdTer.setEnabled(false);

        montarGramatica.setEnabled(false);

        campoNaoTerminais.setEditable(false);
        campoTerminais.setEditable(false);
        campoProducaoVazia.setEditable(false);
        campoProducoes.setEditable(false);
        campoProducoes1.setEditable(false);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void trataNaoTerminais() {

        if (campoNaoTerminais.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha o campo não terminais");

        } else {

            String naoTerminais = inicial + ",";

            naoTerminais += campoNaoTerminais.getText();

            arrayNaoTerminais = naoTerminais.split(",");
            for (int i = 1; i < arrayNaoTerminais.length; i++) {
                if (arrayNaoTerminais[i].equals(inicial)) {
                    JOptionPane.showMessageDialog(this, "O símbolo " + inicial + " é o termo inicial");
                    arrayNaoTerminais = null;
                    break;
                } else {
                    campoNaoTerminais.setEditable(false);
                    btnEnviarNaoTerminal.setEnabled(false);

                    //habilita os campos das producoes
                    btnEnviarProd.setEnabled(true);
                    btnEnviarProdVazia.setEnabled(true);
                    btnEnviarProdTer.setEnabled(true);
                    montarGramatica.setEnabled(true);
                    campoProducaoVazia.setEditable(true);
                    campoProducoes.setEditable(true);
                    campoProducoes1.setEditable(true);

                }

            }

        }

        caracteresMascara();
    }

    public void caracteresMascara() {
        for (String naoTerminais : arrayNaoTerminais) {
            System.out.println(naoTerminais);
            if (naoTerminais.matches("[A-Z]") && naoTerminais != "null") {
                mascara.setValidCharacters(valoresMascara += naoTerminais);
                mascaraTerminais.setValidCharacters(valoresMascara += naoTerminais);
            }

        }

        for (String terminais : arrayTerminais) {
            System.out.println(terminais);
            if (terminais.matches("[a-z]") && terminais != "null") {
                mascara.setValidCharacters(valoresMascara += terminais);
                mascaraTerminais.setValidCharacters(valoresMascara += terminais);
            }

        }

    }

    public void trataTerminais() {

        if (campoTerminais.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha o campo terminais");

        } else {
            arrayTerminais = campoTerminais.getText().split(",");
            for (String arrayValore : arrayTerminais) {
                System.out.println(arrayValore);

            }
            campoTerminais.setEditable(false);
            btnEnviarTerminal.setEnabled(false);

            //habilita os botoes do proximo campo
            btnEnviarNaoTerminal.setEnabled(true);
            btnAlterarNaoTerminal.setEnabled(true);
            campoNaoTerminais.setEditable(true);
            btnExcluirProd.setEnabled(true);
            btnExcluirProdVazia.setEnabled(true);
        }

    }

    public void trataInicial() {
        if (campoInicial.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha o campo inicial");
        } else {
            inicial = campoInicial.getText();
            btnEnviarInicial.setEnabled(false);
            btnAlterarInicial.setEnabled(true);
            campoInicial.setEditable(false);

            //habilita os botoes do proximo campo
            btnEnviarTerminal.setEnabled(true);
            btnAlterarTerminal.setEnabled(true);
            campoTerminais.setEditable(true);
        }

    }

    public void alteraInicial() {
        campoInicial.setEditable(true);
        btnEnviarInicial.setEnabled(true);
        campoInicial.requestFocus();
    }

    public void alteraTerminal() {
        campoTerminais.setEditable(true);
        btnEnviarTerminal.setEnabled(true);
        campoTerminais.requestFocus();
    }

    public void alteraNaoTerminal() {
        campoNaoTerminais.setEditable(true);
        btnEnviarNaoTerminal.setEnabled(true);
        campoNaoTerminais.requestFocus();
    }

    public void trataProducoes() {

        for (int j = 0; j < modelo.getSize(); j++) {
            if (modelo.getElementAt(j).equals(campoProducoes.getText())) {
                JOptionPane.showMessageDialog(this, "Producao já existe");
                return;
            }

        }
        try {
            modelo.add(modelo.getSize(), campoProducoes.getText().toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Produção Inválida");
        }

        campoProducoes.requestFocus();

    }

    public void trataProducaoTerminal() {

        for (int j = 0; j < modelo.getSize(); j++) {
            if (modelo.getElementAt(j).equals(campoProducoes1.getText())) {
                JOptionPane.showMessageDialog(this, "Producao já existe");
                return;
            }

        }
        try {
            modelo.add(modelo.getSize(), campoProducoes1.getText().toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Produção Inválida");
        }

        campoProducoes1.requestFocus();

    }

    public void trataProducaoVazia() {

        for (int j = 0; j < modelo.getSize(); j++) {
            if (modelo.getElementAt(j).equals(campoProducaoVazia.getText())) {
                JOptionPane.showMessageDialog(this, "Producao já existe");
                return;
            }

        }
        try {
            modelo.add(modelo.getSize(), campoProducaoVazia.getText().toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Produção Inválida");
        }

        campoProducaoVazia.requestFocus();

    }

    public void removeProducao() {
        int index = listaProducoes.getSelectedIndex();
        modelo.remove(index);
    }

    public void montaGramatica() {

        if (listaProducoes.getModel().getSize() == 0) {
            JOptionPane.showMessageDialog(this, "Lista vazia");
            return;

        }
        
        String producoes = listaProducoes.getModel().toString();
        String[] arrayStringsProducoes = producoes.split(",");
        for (int i = 0; i < arrayStringsProducoes.length; i++) {
            arrayStringsProducoes[i] = arrayStringsProducoes[i].replace("^[, []]", "");
            System.out.println(arrayStringsProducoes[i]);
        }
        juntaProducoes(arrayStringsProducoes);
    }

    private void juntaProducoes(String[] arrayStringsProducoes) {
        String[] arrayComparar = arrayStringsProducoes;
        String[] arrayFinal = new String[arrayStringsProducoes.length];

        int index = 0;
        for (String a1 : arrayNaoTerminais) {
            
            arrayFinal[index] = a1 + " ->";

            for (String a2 : arrayComparar) {
                if (a1.charAt(0) == a2.charAt(1)) {
                    arrayFinal[index] += " |" + a2.substring(5, a2.length());

                }
            }
            index++;
            
        }
        for (String string : arrayFinal) {
            System.out.println(string);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnEnviarInicial = new javax.swing.JToggleButton();
        btnAlterarInicial = new javax.swing.JToggleButton();
        btnAlterarTerminal = new javax.swing.JToggleButton();
        jLabel3 = new javax.swing.JLabel();
        campoTerminais = new javax.swing.JTextField();
        btnEnviarTerminal = new javax.swing.JToggleButton();
        campoNaoTerminais = new javax.swing.JTextField();
        btnEnviarNaoTerminal = new javax.swing.JToggleButton();
        btnAlterarNaoTerminal = new javax.swing.JToggleButton();
        jLabel4 = new javax.swing.JLabel();
        btnEnviarProd = new javax.swing.JToggleButton();
        btnExcluirProd = new javax.swing.JToggleButton();
        jLabel7 = new javax.swing.JLabel();
        montarGramatica = new javax.swing.JToggleButton();
        campoInicial = new javax.swing.JFormattedTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaProducoes = new javax.swing.JList<>();
        btnEnviarProdVazia = new javax.swing.JToggleButton();
        campoProducaoVazia = new javax.swing.JFormattedTextField();
        btnExcluirProdVazia = new javax.swing.JToggleButton();
        jLabel8 = new javax.swing.JLabel();
        campoProducoes = new javax.swing.JFormattedTextField();
        btnEnviarProdTer = new javax.swing.JToggleButton();
        campoProducoes1 = new javax.swing.JFormattedTextField();
        btnExcluirProdTer = new javax.swing.JToggleButton();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Informe o Símbolo Inicial:");

        btnEnviarInicial.addActionListener(listener);
        btnEnviarInicial.setActionCommand("inicial");
        btnEnviarInicial.setText("Enviar");

        btnAlterarInicial.addActionListener(listener);
        btnAlterarInicial.setActionCommand("alterarInicial");
        btnAlterarInicial.setText("Alterar");

        btnAlterarTerminal.addActionListener(listener);
        btnAlterarTerminal.setActionCommand("alterarTerminal");
        btnAlterarTerminal.setText("Alterar");

        jLabel3.setText("Informe os Terminais:");

        btnEnviarTerminal.addActionListener(listener);
        btnEnviarTerminal.setActionCommand("terminais");
        btnEnviarTerminal.setText("Enviar");

        btnEnviarNaoTerminal.addActionListener(listener);
        btnEnviarNaoTerminal.setActionCommand("naoTerminais");
        btnEnviarNaoTerminal.setText("Enviar");

        btnAlterarNaoTerminal.addActionListener(listener);
        btnAlterarNaoTerminal.setActionCommand("alterarNaoTerminal");
        btnAlterarNaoTerminal.setText("Alterar");

        jLabel4.setText("Informe os Não Terminais:");

        btnEnviarProd.addActionListener(listener);
        btnEnviarProd.setActionCommand("producoes");
        btnEnviarProd.setText("Enviar");

        btnExcluirProd.addActionListener(listener);
        btnExcluirProd.setActionCommand("remover");
        btnExcluirProd.setText("Excluir");

        jLabel7.setText("Produção com terminal/não terminal:");

        montarGramatica.addActionListener(listener);
        montarGramatica.setActionCommand("montarGramatica");
        montarGramatica.setText("Montar Gramática Regular");

        try {
            campoInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("U")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoInicial.setPreferredSize(new java.awt.Dimension(14, 24));

        jScrollPane2.setViewportView(listaProducoes);

        btnEnviarProdVazia.addActionListener(listener);
        btnEnviarProdVazia.setActionCommand("producaoVazia");
        btnEnviarProdVazia.setText("Enviar");

        try {
            campoProducaoVazia.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("U -> &")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        btnExcluirProdVazia.addActionListener(listener);
        btnExcluirProdVazia.setActionCommand("remover");
        btnExcluirProdVazia.setText("Excluir");

        jLabel8.setText("Produção com vazio:");

        btnEnviarProdTer.addActionListener(listener);
        btnEnviarProdTer.setActionCommand("producoesTerminais");
        btnEnviarProdTer.setText("Enviar");

        btnExcluirProd.addActionListener(listener);
        btnExcluirProd.setActionCommand("remover");
        btnExcluirProdTer.setText("Excluir");

        jLabel9.setText("Produção com um Terminal:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(montarGramatica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(campoProducaoVazia, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnEnviarProdVazia)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnExcluirProdVazia))
                                .addComponent(jLabel8))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(campoProducoes1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEnviarProdTer)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnExcluirProdTer))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(campoProducoes, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEnviarProd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnExcluirProd, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(campoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEnviarInicial)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAlterarInicial))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(campoTerminais, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEnviarTerminal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAlterarTerminal))
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(campoNaoTerminais, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEnviarNaoTerminal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAlterarNaoTerminal))
                            .addComponent(jLabel4)
                            .addComponent(jLabel1)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9))
                        .addGap(0, 201, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEnviarInicial)
                    .addComponent(btnAlterarInicial)
                    .addComponent(campoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoTerminais, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEnviarTerminal)
                    .addComponent(btnAlterarTerminal))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoNaoTerminais, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEnviarNaoTerminal)
                    .addComponent(btnAlterarNaoTerminal))
                .addGap(14, 14, 14)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEnviarProd)
                    .addComponent(btnExcluirProd)
                    .addComponent(campoProducoes, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEnviarProdTer)
                    .addComponent(btnExcluirProdTer)
                    .addComponent(campoProducoes1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnEnviarProdVazia)
                        .addComponent(btnExcluirProdVazia))
                    .addComponent(campoProducaoVazia, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(montarGramatica)
                .addContainerGap(153, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(TelaInicial.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TelaInicial().setVisible(true);
                } catch (ParseException ex) {
                    Logger.getLogger(TelaInicial.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnAlterarInicial;
    private javax.swing.JToggleButton btnAlterarNaoTerminal;
    private javax.swing.JToggleButton btnAlterarTerminal;
    private javax.swing.JToggleButton btnEnviarInicial;
    private javax.swing.JToggleButton btnEnviarNaoTerminal;
    private javax.swing.JToggleButton btnEnviarProd;
    private javax.swing.JToggleButton btnEnviarProdTer;
    private javax.swing.JToggleButton btnEnviarProdVazia;
    private javax.swing.JToggleButton btnEnviarTerminal;
    private javax.swing.JToggleButton btnExcluirProd;
    private javax.swing.JToggleButton btnExcluirProdTer;
    private javax.swing.JToggleButton btnExcluirProdVazia;
    private javax.swing.JFormattedTextField campoInicial;
    private javax.swing.JTextField campoNaoTerminais;
    private javax.swing.JFormattedTextField campoProducaoVazia;
    private javax.swing.JFormattedTextField campoProducoes;
    private javax.swing.JFormattedTextField campoProducoes1;
    private javax.swing.JTextField campoTerminais;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listaProducoes;
    private javax.swing.JToggleButton montarGramatica;
    // End of variables declaration//GEN-END:variables

}
