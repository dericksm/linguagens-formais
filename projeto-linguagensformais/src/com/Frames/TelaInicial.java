/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Frames;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import static javax.swing.SwingUtilities.updateComponentTreeUI;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.MaskFormatter;
import javax.swing.text.PlainDocument;

/**
 *
 * @author comp9
 */
public class TelaInicial extends javax.swing.JFrame {

    /**
     * Creates new form TelaInicial
     */
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
                super.insertString(offs, str, a);
            }
        });

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
        campoProducoes = new javax.swing.JTextField();
        btnEnviarProd = new javax.swing.JToggleButton();
        btnExcluirProd = new javax.swing.JToggleButton();
        jLabel7 = new javax.swing.JLabel();
        btnEnviarProd1 = new javax.swing.JToggleButton();
        campoInicial = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Informe o Símbolo Inicial:");

        btnEnviarInicial.setText("Enviar");
        btnEnviarInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarInicialActionPerformed(evt);
            }
        });

        btnAlterarInicial.setText("Alterar");
        btnAlterarInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarInicialActionPerformed(evt);
            }
        });

        btnAlterarTerminal.setText("Alterar");
        btnAlterarTerminal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarTerminalActionPerformed(evt);
            }
        });

        jLabel3.setText("Informe os Terminais:");

        btnEnviarTerminal.setText("Enviar");
        btnEnviarTerminal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarTerminalActionPerformed(evt);
            }
        });

        btnEnviarNaoTerminal.setText("Enviar");
        btnEnviarNaoTerminal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarNaoTerminalActionPerformed(evt);
            }
        });

        btnAlterarNaoTerminal.setText("Alterar");
        btnAlterarNaoTerminal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarNaoTerminalActionPerformed(evt);
            }
        });

        jLabel4.setText("Informe os Não Terminais:");

        btnEnviarProd.setText("Enviar");
        btnEnviarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarProdActionPerformed(evt);
            }
        });

        btnExcluirProd.setText("Excluir");
        btnExcluirProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirProdActionPerformed(evt);
            }
        });

        jLabel7.setText("Informe as Produções:");

        btnEnviarProd1.setText("Montar Gramática Regular");
        btnEnviarProd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarProd1ActionPerformed(evt);
            }
        });

        try {
            campoInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("U")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addComponent(campoProducoes, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEnviarProd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluirProd))
                    .addComponent(jLabel7)
                    .addComponent(btnEnviarProd1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campoInicial)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(7, 7, 7)
                        .addComponent(btnEnviarInicial)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlterarInicial)))
                .addContainerGap(222, Short.MAX_VALUE))
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
                    .addComponent(campoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoTerminais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEnviarTerminal)
                    .addComponent(btnAlterarTerminal))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoNaoTerminais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEnviarNaoTerminal)
                    .addComponent(btnAlterarNaoTerminal))
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoProducoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEnviarProd)
                    .addComponent(btnExcluirProd))
                .addGap(115, 115, 115)
                .addComponent(btnEnviarProd1)
                .addContainerGap(349, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnviarInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarInicialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEnviarInicialActionPerformed

    private void btnAlterarInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarInicialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAlterarInicialActionPerformed

    private void btnAlterarTerminalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarTerminalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAlterarTerminalActionPerformed

    private void btnEnviarTerminalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarTerminalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEnviarTerminalActionPerformed

    private void btnEnviarNaoTerminalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarNaoTerminalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEnviarNaoTerminalActionPerformed

    private void btnAlterarNaoTerminalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarNaoTerminalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAlterarNaoTerminalActionPerformed

    private void btnEnviarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarProdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEnviarProdActionPerformed

    private void btnExcluirProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirProdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExcluirProdActionPerformed

    private void btnEnviarProd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarProd1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEnviarProd1ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JTextField campoProducoes;
    private javax.swing.JTextField campoTerminais;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}
