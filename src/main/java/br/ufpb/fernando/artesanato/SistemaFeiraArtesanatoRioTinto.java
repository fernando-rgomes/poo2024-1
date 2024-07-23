package br.ufpb.fernando.artesanato;


import java.util.*;

public class SistemaFeiraArtesanatoRioTinto implements SistemaFeiraArtesanato{

        private Map<String,ItemDeArtesanato> itemDeArtesanato;

        public SistemaFeiraArtesanatoRioTinto(){
            this.itemDeArtesanato = new HashMap<>();
        }

        @Override
        public boolean cadastraItem(ItemDeArtesanato item) {
            if (this.itemDeArtesanato.containsKey(item.getCodigo())) {
                return false;
            } else {
                this.itemDeArtesanato.put(item.getCodigo(), item);
                return true;
            }
        }

        @Override
        public List<ItemDeArtesanato> pesquisaItensPeloNome(String nome) {
            //TODO
            List<ItemDeArtesanato> itenspeloNome = new LinkedList<>();
            for(ItemDeArtesanato item: this.itemDeArtesanato.values()){
                if(item.getNome().startsWith(nome)){
                    itenspeloNome.add(item);
                }
            }
            return itenspeloNome;
        }

        @Override
        public List<ItemDeArtesanato> pesquisaItensAbaixoDoPreco(double preco) {
            //TODO
            List<ItemDeArtesanato> itensPorPreco = new LinkedList<>();
            for(ItemDeArtesanato item: this.itemDeArtesanato.values())
                if (item.getPreco()<= preco) {
                    itensPorPreco.add(item);
                }

            return itensPorPreco;
        }

        @Override
        public ItemDeArtesanato pesquisaItemPeloCodigo(String codigo) throws itemNaoExisteException {
            //TODO

            ItemDeArtesanato item = this.itemDeArtesanato.get(codigo);
            if(item == null){
                throw new itemNaoExisteException("Não existe item com o código: " +codigo);
            }else{
                return item;
            }

        }
    }
