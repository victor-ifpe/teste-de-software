package br.ifpe.jaboatao.ts.servicos;

import java.util.Date;
import java.util.List;

import br.ifpe.jaboatao.ts.entidades.Filme;
import br.ifpe.jaboatao.ts.entidades.Locacao;
import br.ifpe.jaboatao.ts.entidades.Usuario;
import br.ifpe.jaboatao.ts.utils.DataUtils;

public class LocacaoService {

	public Locacao alugarFilme(Usuario usuario, List<Filme> filmes) {
		Locacao locacao = new Locacao();
		locacao.setFilmes(filmes);
		locacao.setUsuario(usuario);
		locacao.setDataLocacao(new Date());

		double valorTotal = 0;
		double valorFilme = 0;
		for (int i = 0; i < filmes.size(); i++) {
			valorFilme = filmes.get(i).getValor();
			if (i == 3) {
				valorFilme = valorFilme * 0.75;
			}

			if (i == 4) {
				valorFilme = valorFilme * 0.50;
			}

			if (i == 5) {
				valorFilme = valorFilme * 0.25;
			}

			if (i == 6) {
				valorFilme = valorFilme * 0.0;
			}

			valorTotal += valorFilme;
		}
		locacao.setValorLocacao(valorTotal);

		// Entrega no dia seguinte
		Date dataEntrega = new Date();
		dataEntrega = DataUtils.incrementarQntDias(1, dataEntrega);
		locacao.setDataRetorno(dataEntrega);

		// Salvando a locacao...
		// O m�todo salvar() ser� implementado com o avan�ar do curso.

		return locacao;
	}

}