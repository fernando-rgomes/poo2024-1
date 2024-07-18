package br.ufpb.fernando.artesanato;

public class Roupa extends ItemDeArtesanato{
    private String material;
    private String tipo;
    private String tamanho;

    public Roupa(String codigo,String nome, double preco, String material, String tipo, String tamanho) {
        super(codigo, nome, preco);
        this.material=material;
        this.tipo = tipo;
        this.tamanho = tamanho;
    }

    public Roupa() {
        this("","",0.0, "", ""," ");

    }
}
