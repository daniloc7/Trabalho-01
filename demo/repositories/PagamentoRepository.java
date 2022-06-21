package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Jogador;
import com.example.demo.models.Pagamento;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
	
	public List<Pagamento> findByMesContainingAndJogadorId(Integer mes, Long id);
	
	public boolean existsByAnoAndMesAndJogador(Integer ano, Integer mes, Jogador jogador);
	
	public List<Pagamento> findAll(Long id);
	
	public List<Pagamento> findByMesAndAnoBetWeenAndJogadorId(Integer mesI, Integer mesF, Integer anoI, Integer anoF, Long id);

}
