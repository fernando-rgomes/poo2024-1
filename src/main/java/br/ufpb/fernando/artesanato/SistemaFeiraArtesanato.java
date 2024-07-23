package br.ufpb.fernando.artesanato;

import java.util.List;

/**
 * Sistema para Gerenciar intes de Artesanato
 */
public interface SistemaFeiraArtesanato {

    /**
     * Cadastra um novo item no sistema.
     * @param item O item a ser adicionado
     * @return true se o item for cadastrado, ou false caso ele já exista no sistema
     */
    public boolean cadastraItem(ItemDeArtesanato item);

    /**
     * Pesquisa todos os itens cujo o nome começa com o nome passado como parâmetro
     * @param nome O nome a pesquisar
     * @return uma lista contendo os itens cujo nome omeça com o parãmetro passado.
     */
    public List<ItemDeArtesanato> pesquisaItensPeloNome(String nome);

    /**
     * Pesquisa os itens cujo preço é menor ou igual ao valor passado
     * @param preco o valor dos itens a pequisar
     * @return a lista dos itens cujo preço é menor ou igual ao valor passado no paraâmetro
     */
    public List<ItemDeArtesanato> pesquisaItensAbaixoDoPreco(double preco);


    /**
     * pesquisa o item cujo é passado pelo parâmetro
     * @param codigo codigo do utem a peswuisar
     * @return
     * @throws itemNaoExisteException Se não existir nenhum item com o código passado.
     */
    public ItemDeArtesanato pesquisaItemPeloCodigo(String codigo) throws itemNaoExisteException;


}
