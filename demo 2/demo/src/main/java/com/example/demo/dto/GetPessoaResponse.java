package com.example.demo.dto;

import com.example.demo.model.Pessoa;

public class GetPessoaResponse extends SimpleResponse{
	//ATRIBUTOS
	private Pessoa pessoa;
	

	//GETTERS E SETTERS
	public Pessoa getPessoa() {
		 return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		 this.pessoa = pessoa;
	}
}
