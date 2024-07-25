package br.ufpb.fernando.amigosecreto;

public class mensagemParaAlguem extends Mensagem{
    private String emailDestinatario;

    public mensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario, boolean anonima ){
        super(texto, emailRemetente, anonima);

    }
    public String getEmailDestinatario(){
        return emailDestinatario;
    }

    public void setEmailDestinatario(String emailDestinatario) {
        this.emailDestinatario = emailDestinatario;
    }

    public String getTextoCompletoAExibir(){
    if(ehAnonima()){
        return ("Mensagem  para: " +emailDestinatario + "Texto: " + getTexto());
    } else{
        return ("Mensagem de: " +getEmailRemetente() + " para: " +emailDestinatario+ " Texto: " + getTexto());

    }

    }
}
