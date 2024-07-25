package br.ufpb.fernando.amigosecreto;

import java.util.List;

public class sistemaAmigo{
    private List<Mensagem> mensagens;
    private List<Amigo> amigos;

    public void cadastraAmigo(String nomeAmigo, String emailAmigo ){
        //TODO
    }

    public Amigo pesquisaAmigo(String emailAmigo){
        //TODO
        return null;
    }

    public void enviarMensagemParaTodos(String texto, String emailRemetente, boolean ehAnonima){
        //TODO
    }

    public void enviarMensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario, boolean ehAnonima){
        //TODO
    }

    public List<Mensagem> pesquisarMensagensAnonimas(){
    //TODO
        return List.of();
    }

    public List<Mensagem> pesquisarTodasAsMensagens(){
    //TODO
        return List.of();
    }

    public void configuraAmigoSecretoDe(String emailDaPessoa, String emailAmigoSorteado){
        //TODO
    }

    public String pesquisaAmigoSecretoDe(String emailDaPessoa){
    //TODO
        return emailDaPessoa;
    }




}
