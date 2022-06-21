package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Jogador;
//import com.example.demo.models.Jogador;
import com.example.demo.models.Pagamento;
import com.example.demo.repositories.PagamentoRepository;

@Service
public class PagamentoService {	
	
	final PagamentoRepository pagamentoRepository;

	public PagamentoService(PagamentoRepository pagamentoRepository) {		
		this.pagamentoRepository = pagamentoRepository;
	}
	
	public Pagamento save(Pagamento pagamentoModel) {
		return pagamentoRepository.save(pagamentoModel);
	}
	
	public List<Pagamento> findByMesContainingAndJogadorId(Integer mes, Long id){
		return pagamentoRepository.findByMesContainingAndJogadorId(mes,id);
	}
	
	public List<Pagamento> findAll(Long id){
		return pagamentoRepository.findAll(id);
	}
	
	public boolean existsByAnoAndMesAndJogador(int ano, int mes, Jogador jogador) {
		return pagamentoRepository.existsByAnoAndMesAndJogador(ano, mes, jogador);
	}
	
	public List<Pagamento> findByMesAndAnoBetWeenAndJogadorId(Integer mesI, Integer mesF, Integer anoI, Integer anoF, Long id){
		return pagamentoRepository.findByMesAndAnoBetWeenAndJogadorId(mesI, mesF, anoI, anoF, id);
	}
	
	public Optional<Pagamento> findById(Long id) {
		return pagamentoRepository.findById(id);
	}
	
	@Transactional
	public void delete(Pagamento pagamento){
		pagamentoRepository.delete(pagamento);
	}
	
}
