package br.ufpb.fernando.artesanato;

public class itemNaoExisteException extends Exception{
    itemNaoExisteException(String msg){
        super(msg);
    }
}
