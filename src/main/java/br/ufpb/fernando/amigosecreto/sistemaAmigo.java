package br.ufpb.fernando.amigosecreto;

import java.util.ArrayList;
import java.util.List;

public class sistemaAmigo{
    private List<Mensagem> mensagens;
    private List<Amigo> amigos;

    public void cadastraAmigo(String nomeAmigo, String emailAmigo ){
        //TODO
        Amigo novoAmigo = new Amigo(nomeAmigo, emailAmigo);
        amigos.add(novoAmigo);
    }

    public List<Amigo> getAmigos() {
        return amigos;
    }

    public Amigo pesquisaAmigo(String emailAmigo){
        for (Amigo a: amigos){
            if (a.getEmail().equals(emailAmigo)){
                return a;
            }
        }
        return null; // retorna nulo se o amigo com o email fornecido não existir
    }

    public void enviarMensagemParaTodos(String texto, String emailRemetente, boolean ehAnonima){
        Mensagem mensagemParaTodos = new Mensagem(texto, emailRemetente, ehAnonima) {
            @Override
            public String getTextoCompletoAExibir() {
                // Adiciona um prefixo para indicar que a mensagem é para todos
                return "Esta mensagem é para todos! " + getTexto();
            }
        };

        // Adiciona a mensagem à lista de mensagens
        mensagens.add(mensagemParaTodos);
    }

    public void enviarMensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario, boolean ehAnonima){
        Mensagem mensagemParaAlguem = new Mensagem(texto, emailRemetente, ehAnonima ) {
            @Override
            public String getTextoCompletoAExibir() {
                return "Esta mensagem é privada: " + getTexto();
            }
        };
        mensagens.add(mensagemParaAlguem);
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
    List<Mensagem> listaComTodasMensagens = new ArrayList<>();
    for(Mensagem m: this.mensagens){
        listaComTodasMensagens.add(m);
    }
    return listaComTodasMensagens;

    }

    public void configuraAmigoSecretoDe(String emailDaPessoa, String emailAmigoSorteado) throws amigoNaoExisteException{
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

    public String pesquisaAmigoSecretoDe(String emailDaPessoa) throws amigoNaoExisteException, amigoNaoSorteadoException{
        Amigo amigoEncontrado = null;
        for (Amigo a: this.amigos){
           if(a.getEmail().equals(emailDaPessoa)){
               amigoEncontrado = a;
               break;
           }

       }
        if (amigoEncontrado == null){
            throw new amigoNaoExisteException("Este amigo com email: "+ emailDaPessoa +" não existe.");

        }
        String amigoSecreto = amigoEncontrado.getEmailAmigoSorteado();
        if (amigoSecreto == null){

            throw new amigoNaoSorteadoException("Este amigo não foi sorteado para: "+ emailDaPessoa);
        }
        return amigoSecreto;


    }


 }

