package br.ufpb.fernando.amigosecreto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SistemaAmigoMapTest {

    @Test
    public void testConfiguraAmigoSecretoDe(){
        SistemaAmigoMap sistema = new SistemaAmigoMap();
        try{
            sistema.cadastraAmigo("Ayla ", "ayla@teste.com");
            sistema.cadastraAmigo("Bruno", "bruno@teste.com");
        } catch(AmigoJaExisteException e){
            fail("Não deveria lançar AmigoJaExisteException aqui");
        }

        try{
            sistema.configuraAmigoSecretoDe("ayla@teste.com","bruno@teste.com" );
        } catch (AmigoNaoExisteException e){
            fail("Não deveria lançar AmigoNaoExisteException aqui");
        }

        try {
            String amigoSecreto = sistema.pesquisaAmigoSecretoDe("ayla@teste.com");
            assertEquals("bruno@teste.com", amigoSecreto);
        } catch (AmigoNaoExisteException | AmigoNaoSorteadoException e) {
            fail("Não deveria lançar exceção aqui");
        }
    }
}

