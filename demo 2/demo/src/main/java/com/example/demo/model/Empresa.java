package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Empresa {
	private UUID id;
	public String nome;
	public String morada;
	public int NumFuncionariosDesdeCriacao;
	public List<Pessoa> listaFuncionarios;     //NumFuncionários atual é dado pelo tamanho da lista de funcionários
	
	
	public Empresa(String nome, String morada) {
		this.nome = nome;
		this.morada = morada;
		NumFuncionariosDesdeCriacao = 0;
		id = UUID.randomUUID();
		listaFuncionarios = new ArrayList<>();
	}

	public UUID getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getMorada() {
		return morada;
	}
	
	public void setMorada(String morada) {
		this.morada = morada;
	}
	
	public int getNumFuncionariosAtual() {
		return listaFuncionarios.size();
	}
	
	public int getNumFuncionariosDesdeCriacao() {
		return NumFuncionariosDesdeCriacao;
	}
	
	public void setNumFuncionariosDesdeCriacao(int NumFuncionariosDesdeCriacao) {
		this.NumFuncionariosDesdeCriacao = NumFuncionariosDesdeCriacao;
	}

	public List<Pessoa> getListaFuncionarios() {
		return listaFuncionarios;
	}

	public void setListaFuncionarios(List<Pessoa> listaFuncionarios) {
		this.listaFuncionarios = listaFuncionarios;
	}
	
    public void addPessoa(Pessoa pessoa){
        NumFuncionariosDesdeCriacao++;
        listaFuncionarios.add(pessoa);
    }

    public void removePessoa(Pessoa pessoa){
        listaFuncionarios.remove(pessoa);
    }

}
