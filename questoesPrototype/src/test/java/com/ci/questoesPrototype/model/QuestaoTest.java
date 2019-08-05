package com.ci.questoesPrototype.model;

import org.junit.Assert;
import org.junit.Test;

public class QuestaoTest {
	
	@Test
	public void deveCriarUmaQuestao() {
		Questao questao = new Questao();
		questao.setId(1);
		questao.setPesquisa(1);
		questao.setEnunciado("qual seu nome?");
		questao.setResposta("lucas");
		
		Assert.assertEquals(1, (int) questao.getId());
		Assert.assertEquals(1, (int) questao.getPesquisa());
		Assert.assertEquals("qual seu nome?", questao.getEnunciado());
		Assert.assertEquals("lucas", questao.getResposta());
	}

}
