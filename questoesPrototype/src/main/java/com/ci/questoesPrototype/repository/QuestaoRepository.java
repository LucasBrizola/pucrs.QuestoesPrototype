package com.ci.questoesPrototype.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ci.questoesPrototype.model.Questao;



@Repository
public interface QuestaoRepository extends JpaRepository<Questao, Integer> {
	@Query("SELECT q FROM QUESTAO q WHERE q.pesquisa = :pesquisa")
	List<Questao> findByPesquisa(@Param("pesquisa") int pesquisa);	
	
}
