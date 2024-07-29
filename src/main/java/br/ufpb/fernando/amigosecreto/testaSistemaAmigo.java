package br.ufpb.fernando.amigosecreto;

import javax.swing.*;

public class testaSistemaAmigo {
    public static void main(String[] args) {
        sistemaAmigo sistema= new sistemaAmigo();


        String nome = JOptionPane.showInputDialog(null, "Informe o nome do amigo: ");


        String email = JOptionPane.showInputDialog(null, "Informe o email do amigo: ");

        sistema.cadastraAmigo(nome, email);

        for (Amigo a: sistema.getAmigos()) {
            JOptionPane.showMessageDialog(null, nome + " " + email);
        }
    }
}
