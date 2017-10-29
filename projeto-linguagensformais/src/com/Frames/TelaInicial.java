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
import javax.swing.text.MaskFormatter;
import javax.swing.text.PlainDocument;


public class TelaInicial extends javax.swing.JFrame {

    TelaInicialListener listener = new TelaInicialListener(this);

    String[] arrayNaoTerminais;
    String[] arrayTerminais;
    String[] arrayProducoes;
    String inicial;
    DefaultListModel modelo = new DefaultListModel();
    

    public TelaInicial() {
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
        listaProducoes.setModel(modelo);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    
   
    public void trataNaoTerminais() {

        if (campoNaoTerminais.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha o campo não terminais");

        } else {
            arrayNaoTerminais = campoNaoTerminais.getText().split(",");
            for (String arrayValore : arrayNaoTerminais) {
                System.out.println(arrayValore);
            }
            campoNaoTerminais.setEditable(false);
            btnEnviarNaoTerminal.setEnabled(false);
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
        }

    }

    public void trataInicial() {
        if (campoInicial.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha o campo inicial");
        } else {
            inicial = campoInicial.getText();
            btnEnviarInicial.setEnabled(false);
            campoInicial.setEditable(false);
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
        
        boolean verificaProd = true;
        for (String terminais : arrayNaoTerminais) {
            if (campoProducoes.getText().charAt(0) == terminais.charAt(0)) {
                modelo.add(modelo.getSize(), campoProducoes.getText().toString());
                

                verificaProd = true;
                break;
            } else {
                verificaProd = false;
            }
        }
        if (verificaProd == false) {
            JOptionPane.showMessageDialog(this, "Produção Inválida, " + campoProducoes.getText().charAt(0) + " não é um simbolo não terminal");
        }

        campoProducoes.setText("");
        campoProducoes.requestFocus();
    }

    public void removeProducao() {
        int index = listaProducoes.getSelectedIndex();
        modelo.remove(index);
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
        btnEnviarProd1 = new javax.swing.JToggleButton();
        campoInicial = new javax.swing.JFormattedTextField();
        campoProducoes = new javax.swing.JFormattedTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaProducoes = new javax.swing.JList<>();

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

        jLabel7.setText("Informe as Produções:");

        btnEnviarProd1.setText("Montar Gramática Regular");

        try {
            campoInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("U")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoInicial.setPreferredSize(new java.awt.Dimension(14, 24));

        try {
            campoProducoes.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("U -> LU")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoProducoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoProducoesActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(listaProducoes);

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
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(campoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEnviarInicial)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAlterarInicial))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
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
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(1, 1, 1)
                                    .addComponent(campoProducoes, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnEnviarProd)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnExcluirProd))
                                .addComponent(jLabel1)
                                .addComponent(jLabel7)
                                .addComponent(btnEnviarProd1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEnviarProd)
                    .addComponent(btnExcluirProd)
                    .addComponent(campoProducoes, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEnviarProd1)
                .addContainerGap(286, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoProducoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoProducoesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoProducoesActionPerformed

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
                new TelaInicial().setVisible(true);
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
    private javax.swing.JToggleButton btnEnviarProd1;
    private javax.swing.JToggleButton btnEnviarTerminal;
    private javax.swing.JToggleButton btnExcluirProd;
    private javax.swing.JFormattedTextField campoInicial;
    private javax.swing.JTextField campoNaoTerminais;
    private javax.swing.JFormattedTextField campoProducoes;
    private javax.swing.JTextField campoTerminais;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listaProducoes;
    // End of variables declaration//GEN-END:variables
}
