package br.ufpb.fernando.amigosecreto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaAmigoMap {

    private List<Mensagem> mensagens;
    private Map<String, Amigo> amigos;

    public SistemaAmigoMap(){
        this.mensagens = new ArrayList<>();
        this.amigos = new HashMap<>();
    }

    public void cadastraAmigo(String nome, String email) throws AmigoJaExisteException {
        String emailFormatado = email.trim().toLowerCase();
        if (amigos.containsKey(emailFormatado)) {
            throw new AmigoJaExisteException("Amigo com email " + email + " já está cadastrado.");
        }
        Amigo novoAmigo = new Amigo(nome.trim(), emailFormatado);
        amigos.put(emailFormatado, novoAmigo);
    }

    public Amigo pesquisaAmigo(String emailAmigo) throws AmigoNaoExisteException{
        Amigo a = this.amigos.get(emailAmigo);
        if (a == null) {
            throw new AmigoNaoExisteException("Esse amigo não existe");
        } else {
            return a;
        }

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

    public List<Mensagem> pesquisaTodasAsMensagens() {
        List<Mensagem> listaComTodasMensagens = new ArrayList<>();
        for (Mensagem m : this.mensagens) {
            listaComTodasMensagens.add(m);
        }
        return listaComTodasMensagens;
    }

        public String pesquisaAmigoSecretoDe(String emailDaPessoa) throws AmigoNaoExisteException, AmigoNaoSorteadoException {
            Amigo amigo = amigos.get(emailDaPessoa);
            if (amigo == null) {
                throw new AmigoNaoExisteException("Amigo com email " + emailDaPessoa + " não existe.");
            }
            String emailAmigoSecreto = amigo.getEmailAmigoSorteado();
            if (emailAmigoSecreto == null) {
                throw new AmigoNaoSorteadoException("Amigo secreto ainda não configurado para " + emailDaPessoa);
            }
            return emailAmigoSecreto;
        }

        public void configuraAmigoSecretoDe(String emailDaPessoa, String emailAmigoSecreto) throws AmigoNaoExisteException{
           Amigo amigo = amigos.get(emailDaPessoa);
           if (amigo == null){
               throw new AmigoNaoExisteException("Amigo com email "+ emailDaPessoa + " não existe.");
           }

            if (!amigos.containsKey(emailDaPessoa)){
                throw new AmigoNaoExisteException("Amigo com email "+ emailDaPessoa + " não existe.");

        }
            amigo.setEmailAmigoSorteado(emailAmigoSecreto);
    }

}
