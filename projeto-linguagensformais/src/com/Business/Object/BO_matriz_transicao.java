/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Business.Object;

import com.Model.Class.ModelTransicao;

/**
 *
 * @author comp9
 */
public class BO_matriz_transicao extends ModelTransicao {
    
    ModelTransicao model = null;
    
    public BO_matriz_transicao(){
    }
    
    public BO_matriz_transicao(ModelTransicao model){
        this.model = model;
    }
}
