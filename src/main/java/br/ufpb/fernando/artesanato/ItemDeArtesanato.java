package br.ufpb.fernando.artesanato;

import java.util.Objects;

public class ItemDeArtesanato implements Comparable<ItemDeArtesanato>{
    private String codigo;
    private String nome;
    private double preco;

    public ItemDeArtesanato(String codigo, String nome, double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
    }

    public ItemDeArtesanato(){
        this("","",0.0);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemDeArtesanato that = (ItemDeArtesanato) o;
        return Objects.equals(codigo, that.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codigo);
    }

    public int CompareTo(ItemDeArtesanato o){
        //Opção 1
        //return this.nome.compareTo(o.getNome());
        //Opção 2
        if(this.preco < o.getPreco()){
            return -1;
        } else if(this.preco == o.getPreco()){
            return 0;
        }else{
            return 1;

        }
    }
}
