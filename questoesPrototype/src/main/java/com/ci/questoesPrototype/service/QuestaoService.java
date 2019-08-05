package com.ci.questoesPrototype.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ci.questoesPrototype.model.Questao;
import com.ci.questoesPrototype.repository.QuestaoRepository;
import com.ci.questoesPrototype.dto.QuestaoDTO;

@Service
public class QuestaoService {

	private QuestaoRepository questaoRepository;

	@Autowired
	public QuestaoService(QuestaoRepository questaoRepository) {
		this.questaoRepository = questaoRepository;
	}

	public void save(QuestaoDTO questaoDTO) {
		Integer id = questaoDTO.getId();
		String enunciado = questaoDTO.getEnunciado();
		int pesquisa = questaoDTO.getPesquisa();

		Questao questao = new Questao(id, enunciado, pesquisa);
		this.questaoRepository.saveAndFlush(questao);
	}

	public void delete(Integer id) {
		this.questaoRepository.deleteById(id);
	}
	
	public Questao findById(Integer id) {
		Optional<Questao> questao = questaoRepository.findById(id);
		if (questao.isPresent()) {
			return questao.get();
		}
		throw new ServiceException("Questao não encontrada");
	}


	private QuestaoDTO criarQuestaoDTO(Questao questao) {
		QuestaoDTO questaoDTO = new QuestaoDTO();
		questaoDTO.setId(questao.getId());
		questaoDTO.setEnunciado(questao.getEnunciado());
		questaoDTO.setResposta(questao.getResposta());
		questao.setPesquisa(questao.getPesquisa());
		return questaoDTO;
	}

	public QuestaoDTO responderQuestao(String resposta, Questao questao) {
		QuestaoDTO questaoDTO = new QuestaoDTO();
		questaoDTO.setId(questao.getId());
		questaoDTO.setEnunciado(questao.getEnunciado());
		questaoDTO.setResposta(resposta);
		questao.setPesquisa(questao.getPesquisa());
		return questaoDTO;
	}

	public List<QuestaoDTO> ResponderPorPesquisa(int pesquisa) {
		List<QuestaoDTO> questoesParaResponder = new ArrayList<QuestaoDTO>();
		List<Questao> questoes = questaoRepository.findByPesquisa(pesquisa);

		for (Questao questao : questoes) {
			QuestaoDTO questaoDTO = criarQuestaoDTO(questao);
			if (questao.getResposta().isEmpty()) {
				questoesParaResponder.add(questaoDTO);
			}
		}

		return questoesParaResponder;
	}

	public List<QuestaoDTO> findAllByPesquisa(int pesquisa) {
		List<QuestaoDTO> questaoParaRetorno = new ArrayList<QuestaoDTO>();
		List<Questao> questoes = questaoRepository.findByPesquisa(pesquisa);

		for (Questao questao : questoes) {
			QuestaoDTO questaoDTO = criarQuestaoDTO(questao);
			questaoParaRetorno.add(questaoDTO);
		}

		return questaoParaRetorno;
	}

}
