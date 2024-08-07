package br.ufpb.fernando.amigosecreto;

import javax.swing.*;
import java.util.List;

public class TestaSistemaAmigo {
    public static void main(String[] args) throws AmigoJaExisteException {
        SistemaAmigo sistema = new SistemaAmigo();
        boolean continuar = true;

        while (continuar) {
            String opcao = JOptionPane.showInputDialog(null, "Escolha uma opção: \n" +
                    "1. Cadastrar novo Amigo: \n" +
                    "2. Configurar Amigo Secreto: \n" +
                    "3. Enviar Mensagem Anônima: \n" +
                    "4. Enviar Mensagem Anônima para todos: \n" +
                    "5. Exibir Mensagens Anônimas: \n" +
                    "6. Pesquisar email: \n" +
                    "7. Sair");

            switch (opcao) {
                case "1":
                    String nome = JOptionPane.showInputDialog(null, "Qual o nome do amigo?");
                    String email = JOptionPane.showInputDialog(null, "Qual o email do amigo?");
                    sistema.cadastraAmigo(nome, email);
                    JOptionPane.showMessageDialog(null, "Amigo " + nome + " cadastrado com sucesso!");
                    break;

                case "2":
                    try {
                        String emailDaPessoa = JOptionPane.showInputDialog(null, "Informe o email da Pessoa:");
                        String emailAmigoSorteado = JOptionPane.showInputDialog(null, "Informe o Email do amigo Sorteado");
                        sistema.configuraAmigoSecretoDe(emailDaPessoa, emailAmigoSorteado);
                        JOptionPane.showMessageDialog(null, "Amigo secreto cadastrado!");
                    } catch (AmigoNaoExisteException e) {
                        JOptionPane.showMessageDialog(null, "Erro ao configurar amigos secretos: " + e.getMessage());
                    }
                    break;

                case "3":
                    String texto = JOptionPane.showInputDialog(null, "Digite o texto que você deseja enviar:");
                    String emailRemetente = JOptionPane.showInputDialog(null, "Informe seu email:");
                    String emailDestinatario = JOptionPane.showInputDialog(null, "Informe o email do destinatário:");
                    boolean ehAnonima = true;
                    sistema.enviarMensagemParaAlguem(texto, emailRemetente, emailDestinatario, ehAnonima);
                    JOptionPane.showMessageDialog(null, "Mensagem enviada com sucesso!");
                    for (Mensagem m: sistema.pesquisaMensagensAnonimas()){
                        JOptionPane.showMessageDialog(null, m.getTextoCompletoAExibir());
                    }
                    break;

                case "4":
                    String textoParaTodos = JOptionPane.showInputDialog(null, "Digite o texto que você deseja enviar:");
                    String emailRemetenteTodos = JOptionPane.showInputDialog(null, "Informe seu email:");
                    boolean anonimo = true;

                    sistema.enviarMensagemParaTodos(textoParaTodos, emailRemetenteTodos, anonimo);
                    JOptionPane.showMessageDialog(null, "Mensagem enviada com sucesso!");
                    for (Mensagem m: sistema.pesquisaMensagensAnonimas()){
                        JOptionPane.showMessageDialog(null, m.getTextoCompletoAExibir());
                    }
                    break;


                case "5":
                    List<Mensagem> mensagensAnonimasPesquisadas = sistema.pesquisaMensagensAnonimas();

                    // Inicializa uma string vazia para armazenar o texto das mensagens
                    String textoMensagens = "";

                    if (mensagensAnonimasPesquisadas == null || mensagensAnonimasPesquisadas.isEmpty()) {
                        textoMensagens = "Não há mensagens anônimas.";
                    } else {
                        // Adiciona o texto completo de cada mensagem anônima à string
                        for (Mensagem m : mensagensAnonimasPesquisadas) {
                            textoMensagens += m.getTextoCompletoAExibir() + "\n";
                        }
                    }

                    JOptionPane.showMessageDialog(null, textoMensagens);
                    break;

                case "6":
                    // Implementar funcionalidade para pesquisa de email, se necessário
                    try{
                        String emailDaPessoa = JOptionPane.showInputDialog(null, "Informe o e-mail da pessoa: ");
                        String emailAmigoSecreto = sistema.pesquisaAmigoSecretoDe(emailDaPessoa);
                        JOptionPane.showMessageDialog(null, "Ok "+ emailAmigoSecreto + " é seu amigo secreto");

                    } catch (AmigoNaoExisteException e){
                        JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
                    } catch (AmigoNaoSorteadoException e) {
                        JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
                    }
                    break;

                case "7":
                    continuar = false;
                    JOptionPane.showMessageDialog(null, "Saindo...");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida! Tente novamente.");
                    break;
                }

            }
        }
    }

