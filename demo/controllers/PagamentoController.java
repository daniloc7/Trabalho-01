package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.PagamentoDto;
import com.example.demo.models.Jogador;
import com.example.demo.models.Pagamento;
import com.example.demo.repositories.PagamentoRepository;
import com.example.demo.services.JogadorService;
import com.example.demo.services.PagamentoService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/Pagamentos")
public class PagamentoController {
	
	@Autowired
	private PagamentoService pagamentoService;
	
	@Autowired
	private JogadorService jogadorService;
	
	@PostMapping()
	public ResponseEntity<Object> savePagamento(@RequestBody @Valid PagamentoDto pagamentoDto){
		
		Pagamento pagamento = new Pagamento();
		if(pagamentoService.existsByAnoAndMesAndJogador(pagamento.getAno(), pagamento.getMes(), pagamento.getJogadorModel())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Esse pagamento já foi realizado, cuidado pagar duplicado.");
		}
		BeanUtils.copyProperties(pagamentoDto, pagamento);
		return ResponseEntity.status(HttpStatus.CREATED).body(pagamentoService.save(pagamento));
	}
	
	@GetMapping()
	public ResponseEntity<List<Pagamento>> getAllPagamentos(Long jogadorId){
		return ResponseEntity.status(HttpStatus.OK).body(pagamentoService.findAll(jogadorId)); //Verificar
	}
	
	@GetMapping("/consultarEntreMeses")
	public ResponseEntity<List<Pagamento>> consultarPorMesAno(int mesInicio, int mesFim, int anoInicio, 
															  int anoFim, Long jogadorId){
		return ResponseEntity.status(HttpStatus.FOUND).body(
				pagamentoService.findByMesAndAnoBetWeenAndJogadorId(mesInicio, mesFim, anoInicio, anoFim, jogadorId));
		
	}
	
	@GetMapping("/consultarMes")
	public ResponseEntity<List<Pagamento>> consultarMes(Integer mes, Long jogadorId){
		return ResponseEntity.status(HttpStatus.FOUND).body(pagamentoService.findByMesContainingAndJogadorId(mes, jogadorId));
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deletePagamento(@PathVariable(value="id") Long id){
		Optional<Pagamento> pagamentoOptional = pagamentoService.findById(id);
		if(!pagamentoOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Jogador não encontrado!");
		}
		
		pagamentoService.delete(pagamentoOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Pagamento excluído!");
	}
	

}
