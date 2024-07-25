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
        return ("Mensagem  para: " +emailDestinatario + "Texto: " + super.getTexto());
    } else{
        return ("Mensagem de: " +super.getEmailRemetente() + " para: " +emailDestinatario+ " Texto: " + super.getTexto());

    }

    }
}
