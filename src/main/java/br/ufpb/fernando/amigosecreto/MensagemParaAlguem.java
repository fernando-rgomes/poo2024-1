package br.ufpb.fernando.amigosecreto;

public class MensagemParaAlguem extends Mensagem{
    private String emailDestinatario;

    public MensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario, boolean anonima ){
        super(texto, emailRemetente, anonima);
        this.emailDestinatario = emailDestinatario;


    }
    public String getEmailDestinatario(){
        return emailDestinatario;
    }

    public void setEmailDestinatario(String emailDestinatario) {
        this.emailDestinatario = emailDestinatario;
    }

    public String getTextoCompletoAExibir(){
    if(ehAnonima()){
        return ("Mensagem  para: " +emailDestinatario + "Texto: " + super.getTexto());
    } else{
        return ("Mensagem de: " +super.getEmailRemetente() + " para: " +emailDestinatario+ " Texto: " + super.getTexto());

    }

    }
}
