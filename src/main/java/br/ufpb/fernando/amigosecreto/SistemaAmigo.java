package br.ufpb.fernando.amigosecreto;

import java.util.ArrayList;
import java.util.List;

public class SistemaAmigo{
    private List<Mensagem> mensagens;
    private List<Amigo> amigos;

    public SistemaAmigo(){
        this.amigos = new ArrayList<>();
        this.mensagens = new ArrayList<>();

    }


    public void cadastraAmigo(String nomeAmigo, String emailAmigo ) throws AmigoJaExisteException {
        //TODO
        for (Amigo a : amigos) {
            if (a.getEmail().equals(emailAmigo)) {
                throw new AmigoJaExisteException("Amigo com email " + emailAmigo + " já existe.");
            }
        }
        Amigo novoAmigo = new Amigo(nomeAmigo, emailAmigo);
        amigos.add(novoAmigo);
    }

    public List<Amigo> getAmigos() {
        return amigos;
    }

    public Amigo pesquisaAmigo(String emailAmigo) throws AmigoNaoExisteException{
        for (Amigo a: amigos){
            if (a.getEmail().equals(emailAmigo)){
                return a;
            }
        }
        throw new AmigoNaoExisteException("Esse amigo não existe");
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
        MensagemParaAlguem mensagemParaAlguem = new MensagemParaAlguem(texto, emailRemetente,emailDestinatario, ehAnonima) {
            @Override
            public String getTextoCompletoAExibir() {
                return "";
            }
        };
        this.mensagens.add(mensagemParaAlguem);
    }

    public List<Mensagem> pesquisaMensagensAnonimas(){
    List<Mensagem> mensagensAnonimas = new ArrayList<>();
    for(Mensagem mensagem : this.mensagens){
        if (mensagem.getAnonima()){
            mensagensAnonimas.add(mensagem);
        }
    }
        return mensagensAnonimas;
    }

    public List<Mensagem> pesquisaTodasAsMensagens(){
    List<Mensagem> listaComTodasMensagens = new ArrayList<>();
    for(Mensagem m: this.mensagens){
        listaComTodasMensagens.add(m);
    }
    return listaComTodasMensagens;

    }

    public void configuraAmigoSecretoDe(String emailDaPessoa, String emailAmigoSorteado) throws AmigoNaoExisteException{
        Amigo amigo = null;
        for(Amigo a: this.amigos ){
            if (a.getEmail().equals(emailDaPessoa)) {
                amigo = a;
                amigo.setEmailAmigoSorteado(emailAmigoSorteado);
                break;
            }
            }
            if (amigo == null ){
                throw new AmigoNaoExisteException("Esse amigo não existe");
            }
        }

    public String pesquisaAmigoSecretoDe(String emailDaPessoa) throws AmigoNaoExisteException, AmigoNaoSorteadoException{
        Amigo amigoEncontrado = null;
        for (Amigo a: this.amigos){
           if(a.getEmail().equals(emailDaPessoa)){
               amigoEncontrado = a;
               break;
           }

       }
        if (amigoEncontrado == null){
            throw new AmigoNaoExisteException("Este amigo com email: "+ emailDaPessoa +" não existe.");

        }

        String amigoSecreto = amigoEncontrado.getEmailAmigoSorteado();
        if (amigoSecreto == null){
            throw new AmigoNaoSorteadoException("Este amigo não foi sorteado para: "+ emailDaPessoa);
        }
        return amigoSecreto;
    }


 }

