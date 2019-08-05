package com.ci.questoesPrototype.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class QuestaoDTO {

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

}
