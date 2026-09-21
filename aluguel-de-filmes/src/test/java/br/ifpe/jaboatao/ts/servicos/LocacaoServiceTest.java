package br.ifpe.jaboatao.ts.servicos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.ifpe.jaboatao.ts.entidades.Filme;
import br.ifpe.jaboatao.ts.entidades.Locacao;
import br.ifpe.jaboatao.ts.entidades.Usuario;

public class LocacaoServiceTest {

	LocacaoService service;

	@BeforeEach
	public void setup() {
		service = new LocacaoService();
	}

	@Test
	@DisplayName("Verifica valor da locação")
	public void teste01() {
		// Cenario
		Usuario usuario = new Usuario("João");
		List<Filme> filmes = Arrays.asList(new Filme("Filme 01", 2, 10.0));

		// Acao
		Locacao locacao = service.alugarFilme(usuario, filmes);

		// Verificacao
		Assertions.assertEquals(10.0, locacao.getValorLocacao());
	}

	@Test
	@DisplayName("Verifica estoque do filme")
	public void teste02() {
		// Cenario
		Usuario usuario = new Usuario("João");
		List<Filme> filmes = Arrays.asList(new Filme("Filme 01", 2, 10.0));

		// Acao
		Locacao locacao = service.alugarFilme(usuario, filmes);

		// Verificacao
		Assertions.assertEquals("Filme 01", locacao.getFilmes().get(0).getTitulo());
	}

	@Test
	public void verificarNomeUsuario() {
		// Cenario
		Usuario usuario = new Usuario("João");
		List<Filme> filmes = Arrays.asList(new Filme("Filme 01", 2, 10.0));

		// Acao
		Locacao locacao = service.alugarFilme(usuario, filmes);

		// Verificar o nome do usuário e no título do filme
		Assertions.assertEquals("João", locacao.getUsuario().getNome());
	}

	@Test
	public void verifiacarTituloFilme() {
		// Cenario
		Usuario usuario = new Usuario("João");
		List<Filme> filmes = Arrays.asList(new Filme("Filme 01", 2, 10.0));

		// Acao
		Locacao locacao = service.alugarFilme(usuario, filmes);

		Assertions.assertEquals("Filme 01", locacao.getFilmes().get(0).getTitulo());
	}

	@Test
	@DisplayName("Verifica o valor da locacao para 3 filmes")
	public void alugarVariosFilmes() {
		// Cenario
		Usuario usu = new Usuario("Usuario 01");
		List<Filme> filmes = Arrays.asList(
				new Filme("Filme 01", 5, 10.0),
				new Filme("Filme 02", 3, 12.0),
				new Filme("Filme 03", 2, 10.0));

		// Acao
		Locacao locacao = service.alugarFilme(usu, filmes);

		// Verificacao
		assertEquals(32.0, locacao.getValorLocacao());
	}

	@Test
	@DisplayName("Deve dar descono de 25% no quarto filme")
	public void teste06() {
		// cenario
		Usuario usu = new Usuario("Usuario 01");
		List<Filme> filmes = Arrays.asList(
				new Filme("Filme 01", 2, 40.0), // 40
				new Filme("Filme 02", 2, 40.0), // 40
				new Filme("Filme 03", 2, 40.0), // 40
				new Filme("Filme 04", 2, 40.0) // 30
		);

		// acao
		Locacao locacao = service.alugarFilme(usu, filmes);

		// verificao
		assertEquals(150.0, locacao.getValorLocacao());
	}

	@Test
	@DisplayName("Deve dar descono de 50% no quinto filme")
	public void teste07() {
		// cenario
		Usuario usu = new Usuario("Usuario 01");
		List<Filme> filmes = Arrays.asList(
				new Filme("Filme 01", 2, 40.0), // 40
				new Filme("Filme 02", 2, 40.0), // 40
				new Filme("Filme 03", 2, 40.0), // 40
				new Filme("Filme 04", 2, 40.0), // 30
				new Filme("Filme 05", 2, 40.0) // 20
		);

		// acao
		Locacao locacao = service.alugarFilme(usu, filmes);

		// verificao
		assertEquals(170.0, locacao.getValorLocacao());
	}

	@Test
	@DisplayName("Deve dar descono de 75% no sexto filme")
	public void teste08() {
		// cenario
		Usuario usu = new Usuario("Usuario 01");
		List<Filme> filmes = Arrays.asList(
			new Filme("Filme 01", 2, 40.0), // 40
			new Filme("Filme 02", 2, 40.0), // 40
			new Filme("Filme 03", 2, 40.0), // 40
			new Filme("Filme 04", 2, 40.0), //30
			new Filme("Filme 05", 2, 40.0), //20
			new Filme("Filme 06", 2, 40.0) //10
		);


		// acao
		Locacao locacao = service.alugarFilme(usu, filmes);

		// verificao
		assertEquals(180.0, locacao.getValorLocacao());
	}

	@Test
	@DisplayName("Deve dar descono de 100% no setimo filme")
	public void teste09() {
		// cenario
		Usuario usu = new Usuario("Usuario 01");
		List<Filme> filmes = Arrays.asList(
			new Filme("Filme 01", 2, 40.0), // 40
			new Filme("Filme 02", 2, 40.0), // 40
			new Filme("Filme 03", 2, 40.0), // 40
			new Filme("Filme 04", 2, 40.0), //30
			new Filme("Filme 05", 2, 40.0), //20
			new Filme("Filme 06", 2, 40.0), //10
			new Filme("Filme 07", 2, 40.0) //0
		);


		// acao
		Locacao locacao = service.alugarFilme(usu, filmes);

		// verificao
		assertEquals(180.0, locacao.getValorLocacao());
	}
}