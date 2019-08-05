package com.ci.questoesPrototype.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Questao")
public class Questao {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@NotNull
	@NotEmpty
	private String enunciado;
	
	private String resposta;
	
	@NotNull
	private int pesquisa;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	public int getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(int pesquisa) {
		this.pesquisa = pesquisa;
	}

	public Questao(Integer id, String enunciado, String resposta, int pesquisa) {
		this.id = id;
		this.enunciado = enunciado;
		this.resposta = resposta;
		this.pesquisa = pesquisa;
	}
	
	@SuppressWarnings("unused")
	public Questao() {
	}

	public Questao(Integer id, String enunciado, int pesquisa) {
		this.id = id;
		this.enunciado = enunciado;
		this.pesquisa = pesquisa;
	}
}
