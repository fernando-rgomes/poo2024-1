package br.ufpb.fernando.amigosecreto;

public class AmigoNaoExisteException extends Exception{
    AmigoNaoExisteException(String msg){
        super((msg));
    }
}
