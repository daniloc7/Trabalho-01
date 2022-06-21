package com.example.demo.dtos;

import javax.validation.constraints.NotBlank;

import com.example.demo.models.Jogador;

public class PagamentoDto {
	
	@NotBlank
	private int ano;
	
	@NotBlank
	private int mes;
	
	@NotBlank
	private double valor;
	
	private Jogador jogadorModel;

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Jogador getJogadorModel() {
		return jogadorModel;
	}

	public void setJogadorModel(Jogador jogadorModel) {
		this.jogadorModel = jogadorModel;
	}
	
}
