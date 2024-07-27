package br.ufpb.fernando.amigosecreto;

import java.util.ArrayList;
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
    List<Mensagem> mensagensAnonimas = new ArrayList<>();
    for(Mensagem mensagem : this.mensagens){
        if (mensagem.getAnonima()){
            mensagensAnonimas.add(mensagem);
        }
    }
        return mensagensAnonimas;
    }

    public List<Mensagem> pesquisarTodasAsMensagens(){
    //TODO
        return List.of();
    }

    public void configuraAmigoSecretoDe(String emailDaPessoa, String emailAmigoSorteado) throws amigoNaoExisteException{
        //TODO
        int cont = 0;
        for(Amigo a: this.amigos ){
            if (a.equals(emailDaPessoa)) {
                a.setEmailAmigoSorteado(emailAmigoSorteado);
                cont ++;
            }
            }
            if (cont == 0){
                throw new amigoNaoExisteException("Esse amigo não existe");
            }
        }

    public String pesquisaAmigoSecretoDe(String emailDaPessoa){
        return "";
    }

 }

