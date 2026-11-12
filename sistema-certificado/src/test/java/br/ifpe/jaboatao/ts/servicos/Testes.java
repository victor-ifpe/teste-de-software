package br.ifpe.jaboatao.ts.servicos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.ifpe.jaboatao.ts.entidades.Usuario;

public class Testes {

	@Test
	@DisplayName("Verifica se presença está dando maior ou igual a 75%")
	public void teste01() {

		// Cenario
		Usuario usuario = new Usuario("João", 75.0, 10.0);
		Integer presencaTotal = 100;
		Double resultado = (usuario.getPresenca() * presencaTotal) / 100;

		// Verificacao
		Assertions.assertTrue(resultado >= 75.0, "A presença foi maior ou igual a 75.0%");
	}

	@Test
	@DisplayName("Verifica se nota foi acima de 7")
	public void teste02() {

		// Cenario
		Usuario usuario = new Usuario("João", 75.0, 7.0);

		// Verificacao
		Assertions.assertTrue(usuario.getNota() >= 7.0, "A nota foi maior ou igual a 7");
	}

	@Test
	@DisplayName("Verifica se presença está acima de 75%")
	public void teste03() {

		// Cenario
		Usuario usuario = new Usuario("João", 80.0, 10.0);
		Integer presencaTotal = 100;
		Double resultado = (usuario.getPresenca() * presencaTotal) / 100;

		// Verificacao
		Assertions.assertTrue(resultado >= 75.0, "A presença foi maior ou igual a 75.0%");
	}

	@Test
	@DisplayName("Verifica se aluno possui mais presenças que o total de aulas")
	public void teste04() {

		// Cenario
		Usuario usuario = new Usuario("João", 50.0, 10.0);
		Integer presencaTotal = 40;
		Double resultado = usuario.getPresenca();

		// Verificacao
		Assertions.assertFalse(resultado <= presencaTotal, "O aluno não pode ter 50 presenças em 40 aulas");
	}

	@Test
	@DisplayName("Verifica se aluno possui presença muito baixa")
	public void teste05() {

		// Cenario
		Usuario usuario = new Usuario("João", 10.0, 8.0);
		Integer presencaTotal = 100;
		Double resultado = (usuario.getPresenca() * presencaTotal) / 100;

		// Verificacao
		Assertions.assertFalse(resultado >= 75.0, "O aluno não atingiu 75% de presença");
	}

	@Test
	@DisplayName("Verifica se aluno possui presença máxima de 100%")
	public void teste06() {

		// Cenario
		Usuario usuario = new Usuario("João", 100.0, 10.0);

		// Verificacao
		Assertions.assertTrue(usuario.getPresenca() <= 100.0, "A presença não pode ultrapassar 100%");
	}

	@Test
	@DisplayName("Verifica se aluno possui nota muito baixa")
	public void teste07() {

		// Cenario
		Usuario usuario = new Usuario("João", 80.0, 2.0);

		// Verificacao
		Assertions.assertFalse(usuario.getNota() >= 7.0, "O aluno não atingiu a nota mínima");
	}

	@Test
	@DisplayName("Verifica se aluno possui nota muito alta")
	public void teste08() {

		// Cenario
		Usuario usuario = new Usuario("João", 90.0, 1000.0);

		// Verificacao
		Assertions.assertTrue(usuario.getNota() >= 7.0, "A nota foi maior ou igual a 7");
	}

	@Test
	@DisplayName("Verifica se aluno possui presença igual a zero")
	public void teste09() {

		// Cenario
		Usuario usuario = new Usuario("João", 0.0, 8.0);
		Integer presencaTotal = 100;
		Double resultado = (usuario.getPresenca() * presencaTotal) / 100;

		// Verificacao
		Assertions.assertFalse(resultado >= 75.0, "O aluno não possui presença suficiente");
	}

}