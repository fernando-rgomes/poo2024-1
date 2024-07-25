package br.ufpb.fernando.amigosecreto;

public class mensagemParaTodos extends Mensagem{
    public mensagemParaTodos(String texto, String emailRemetente, boolean anonima){
      super(texto,emailRemetente,anonima);
    }

    public String getTextoCompletoAExibir(){
    if(ehAnonima()){
        return ("Mensagem para todos. Texto: " + getTexto());
    } else{
        return ("Mensagem de: " + getEmailRemetente()+ " para todos. Texto: " + getTexto());
    }
    }
}
