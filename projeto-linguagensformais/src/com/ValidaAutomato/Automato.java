/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ValidaAutomato;

import com.Automato.*;
import com.Frames.TelaInicial;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

public class Automato {

    ArrayList<String> finais = new ArrayList<>();
    static FiniteState z[] = new FiniteState[100];

    String testWord;
    String estadoInicial;
    private TelaInicial frame;

    public String getEstadoInicial() {
        return estadoInicial;
    }

    public void setEstadoInicial(String estadoInicial) {
        this.estadoInicial = estadoInicial;
    }

    public String getPalavra() {
        return testWord;
    }

    public void setPalavra(String palavra) {
        this.testWord = palavra;
    }

    public Automato(HashMap<String, String> mapa, String palavra, String inicial, TelaInicial tela) {

        mapa.entrySet().forEach((Map.Entry<String, String> entry) -> {
            String[] teste;
            teste = entry.getValue().replaceAll("[^a-zA-Z,]", "").split(",");

            for (String string : teste) {
                System.out.println(string);
                if (string.length() == 1) {
                    finais.add(entry.getKey());
                }

            }
        });
        this.frame = tela;
        setPalavra(palavra);
        setEstadoInicial(inicial);

        setStates(mapa);
    }

    public void setStates(HashMap<String, String> mapa) {
        int i = 0;
        for (Map.Entry<String, String> entry : mapa.entrySet()) {
            if (entry.getValue().length() > 1) {
                z[i] = new FiniteState(entry.getKey());
            }
            i++;
        }
        setTransitions(mapa);

    }

    public void setTransitions(HashMap<String, String> mapa) {

        mapa.entrySet().forEach((Map.Entry<String, String> entry) -> {
            int index = 0;
            for (FiniteState z2 : z) {
                if (z2 != null) {
                    if (z2.getName().equals(entry.getKey())) {
                        String[] array = entry.getValue().replaceAll("[^a-zA-Z,]", "").split(",");
                        for (String string : array) {
                            System.out.println(string);
                            System.out.println(string.length());
                            if (string.length() == 2) {
                                for (FiniteState z1 : z) {
                                    if (z1 != null) {
                                        if (z1.getName().equals(String.valueOf(string.charAt(1)))) {
                                            z2.addTransition(z1, string.charAt(0));

                                        }
                                    }
                                }
                            }
                            if (string.length() == 3) {
                                for (FiniteState z1 : z) {
                                    if (z1 != null) {
                                        if (z1.getName().equals(String.valueOf(string.charAt(1)))) {
                                            z2.addTransition(z1, string.replaceAll("[^a-z]", "").toCharArray());
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            index++;
        });

        setFinalState();
    }

    public void setFinalState() {

        finais.forEach((finalState) -> {
            for (FiniteState z1 : z) {
                if (z1 != null && z1.getName().equals(finalState)) {
                    z1.setFinal();

                }
            }
        });
        testaPalavra();

    }

    public void testaPalavra() {
        for (int i = 0; i < z.length; i++) {
            if (z[i] != null && z[i].getName().equals(estadoInicial)) {
                FiniteAutomaton automat = new FiniteAutomaton(z[i]);
                if ((automat.testWord(testWord).isValid())) {
                    JOptionPane.showMessageDialog(frame, "Palavra válida");
                } else {
                    JOptionPane.showMessageDialog(frame, "Palavra inválida");
                }

            }

        }
    }

}
