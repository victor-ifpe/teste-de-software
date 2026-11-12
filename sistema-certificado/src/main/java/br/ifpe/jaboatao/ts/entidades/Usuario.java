package br.ifpe.jaboatao.ts.entidades;

public class Usuario {

	private String nome;
	private Double presenca;
	private Double nota;


	public Usuario(String nome, Double presenca, Double nota) {
		this.nome = nome;
		this.presenca = presenca;
		this.nota = nota;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPresenca() {
		return presenca;
	}

	public void setPresenca(Double presenca) {
		this.presenca = presenca;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}
}