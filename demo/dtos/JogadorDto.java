package com.example.demo.dtos;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

//Aqui pode ser criado constraints personalizadas
public class JogadorDto {
	
	@NotBlank
	@Size(max = 60)
	private String nome;
	
	@NotBlank
	@Size(max = 60)
	private String email;
	
	private Date dataNasc;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}
	
}
