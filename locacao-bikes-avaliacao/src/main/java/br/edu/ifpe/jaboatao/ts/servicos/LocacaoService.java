package br.edu.ifpe.jaboatao.ts.servicos;

import java.util.Date;
import java.util.List;

import br.edu.ifpe.jaboatao.ts.entidades.Bicicleta;
import br.edu.ifpe.jaboatao.ts.entidades.Cliente;
import br.edu.ifpe.jaboatao.ts.entidades.Locacao;
import br.edu.ifpe.jaboatao.ts.utils.ManipularDatas;

public class LocacaoService {

	public Locacao alugarBicicleta(Cliente cliente, List<Bicicleta> bicicletas) {

		for (Bicicleta bicicleta : bicicletas) {
			if (bicicleta.getValor() == null) {
				throw new IllegalArgumentException("Execeção: Bicicleta nula.");
			}
			if (bicicleta.getValor() < 500) {
				throw new IllegalArgumentException("Execeção: Verificar valor da bicicleta.");
			}

		}

		Locacao locacao = new Locacao();
		locacao.setBicicletas(bicicletas);
		locacao.setCliente(cliente);
		locacao.setDataLocacao(new Date());

		double valorTot = 0.0;

		for (Bicicleta bicicleta : bicicletas) {
			valorTot += bicicleta.getValor();
		}
		locacao.setValorLocacao(valorTot);

		if (bicicletas.size() == 4) {
			valorTot *= 0.90;
		} 

		if (bicicletas.size() >= 5) {
			valorTot *= 0.85;
		}

		if (locacao.getValorLocacao() >= 1999.0) {
			valorTot *= 0.80;
		} 
		
		locacao.setValorLocacao(valorTot);

		// Definir a entrega para 3 dias depois.
		Date dataEntrega = ManipularDatas.novaDataComDiferencaDeDias(3);
		locacao.setDataRetorno(dataEntrega);

		// Salvando a locacao...
		// O m�todo salvar() ser� implementado com o avan�ar do curso.

		return locacao;
	}
}