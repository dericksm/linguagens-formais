/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Model.Class;

/**
 *
 * @author comp9
 */
public class ModelTransicao {
    
    private String inicial;
    private String terminais;
    private String naoTerminais;
    private String producoes;

    public String getInicial() {
        return inicial;
    }

    public void setInicial(String inicial) {
        this.inicial = inicial;
    }

    public String getTerminais() {
        return terminais;
    }

    public void setTerminais(String terminais) {
        this.terminais = terminais;
    }

    public String getNaoTerminais() {
        return naoTerminais;
    }

    public void setNaoTerminais(String naoTerminais) {
        this.naoTerminais = naoTerminais;
    }

    public String getProducoes() {
        return producoes;
    }

    public void setProducoes(String producoes) {
        this.producoes = producoes;
    }

}
