package br.ufpb.fernando.amigosecreto;

import javax.swing.*;

public class TestaSistemaAmigoGUI {
    public static void main(String[] args) {

        SistemaAmigo Sistema = new SistemaAmigo();
        String nome = JOptionPane.showInputDialog(null, "Digite o nome do amigo: ");
        String email = JOptionPane.showInputDialog(null, "Digite o e-mail do amigo:");
        String texto = JOptionPane.showInputDialog(null, "Digite a mensagem que você quer enviar: ");
        boolean ehAnonimo = true;
        String emailAmigoSorteado = JOptionPane.showInputDialog(null, "Informe o Amigo Sorteado");
        Sistema.cadastraAmigo(nome, email);
        Sistema.enviarMensagemParaTodos(texto, email, ehAnonimo);
        JOptionPane.showMessageDialog(null, "A mensagem: " + texto + "  foi enviada para todos com sucesso!" + " \n anônima: " + ehAnonimo);
        try {
            Sistema.configuraAmigoSecretoDe(email, emailAmigoSorteado);
            JOptionPane.showMessageDialog(null, "O amigo sorteado de " + email + " é " + emailAmigoSorteado);
        } catch (amigoNaoExisteException e) {
            JOptionPane.showMessageDialog(null, "Este amigo não existe");
        }
    }
}


