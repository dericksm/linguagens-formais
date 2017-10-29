/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Listener;

import com.Frames.TelaInicial;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author CLIENTE
 */
public class TelaInicialListener implements ActionListener{

    private TelaInicial tela;

    public TelaInicialListener(TelaInicial tela) {
        this.tela = tela;
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if("naoTerminais".equals(e.getActionCommand())) {
            tela.trataNaoTerminais();
        } else if("terminais".equals(e.getActionCommand())) {
            tela.trataTerminais();
        } else if("inicial".equals(e.getActionCommand())) {
            tela.trataInicial();
        }
        
    }
    
}
