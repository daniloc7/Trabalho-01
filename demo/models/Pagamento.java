package com.example.demo.models;

//import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//import org.hibernate.type.descriptor.sql.SmallIntTypeDescriptor;
//import org.hibernate.type.descriptor.sql.TinyIntTypeDescriptor;


@Entity
@Table(name = "Pagamento")
public class Pagamento {
	
	@Id
	private long cod_pagamento;
	
	@Column(name="ano", nullable = false)
	private int ano;
	
	@Column(name="mes", nullable = false)
	private int mes;
	
	@Column(name="valor", nullable = false)
	private double valor;
	
	@ManyToOne
	@JoinColumn(name="ID_JOGADOR")
	private Jogador jogadorModel;

	public long getCod_pagamento() {
		return cod_pagamento;
	}

	public void setCod_pagamento(long cod_pagamento) {
		this.cod_pagamento = cod_pagamento;
	}

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
