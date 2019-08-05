package com.ci.questoesPrototype.service;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ci.questoesPrototype.dto.QuestaoDTO;
import com.ci.questoesPrototype.model.Questao;

@RunWith(value = SpringRunner.class)
@SpringBootTest
public class QuestaoServiceTest {

	@Autowired
	private QuestaoService questaoService;

	public void deveSalvarUmaQuestao() {
		QuestaoDTO questaoParaSalvar = new QuestaoDTO();
		questaoParaSalvar.setId(1);
		questaoParaSalvar.setPesquisa(1);
		questaoParaSalvar.setEnunciado("qual seu nome?");

		questaoService.save(questaoParaSalvar);
		Questao questaoSalva = questaoService.findById(1);

		Assert.assertEquals("qual seu nome?", questaoSalva.getEnunciado());
		Assert.assertEquals(1, questaoSalva.getPesquisa());
		Assert.assertNull(questaoSalva.getResposta());
	}

}
