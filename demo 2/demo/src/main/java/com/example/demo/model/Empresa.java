package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
	private static int counter = 0;
	private int id;
	public String nome;
	public String morada;
	public int NumFuncionariosAtual;
	public int NumFuncionariosDesdeCriacao;
	public List<Pessoa> listaFuncionarios;
	
	
	public Empresa(String nome, String morada, int numFuncionariosAtual, int numFuncionariosDesdeCriacao) {
		this.nome = nome;
		this.morada = morada;
		NumFuncionariosAtual = numFuncionariosAtual;
		NumFuncionariosDesdeCriacao = numFuncionariosDesdeCriacao;
		id = counter;
		counter++;
		listaFuncionarios = new ArrayList<>();
	}

	public int getId() {
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
		return NumFuncionariosAtual;
	}
	public void setNumFuncionariosAtual(int numFuncionariosAtual) {
		NumFuncionariosAtual = numFuncionariosAtual;
	}
	public int getNumFuncionariosDesdeCriacao() {
		return NumFuncionariosDesdeCriacao;
	}
	public void setNumFuncionariosDesdeCriacao(int numFuncionariosDesdeCriacao) {
		NumFuncionariosDesdeCriacao = numFuncionariosDesdeCriacao;
	}
	
	

}
