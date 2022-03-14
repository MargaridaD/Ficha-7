package com.example.demo.model;

public class Pessoa {
	private static int counter = 0;
	private int id;
	private String nome;
	private int idade;
	private String email;
	private int idEmpresa; //id da empresa a que a pessoa pertence

	public Pessoa(String nome, int idade, String email, int idEmpresa) {
		this.nome = nome;
		this.idade = idade;
		this.email = email;
		this.idEmpresa = idEmpresa;
		id = counter;
		counter++;
	}



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getId() {
		return id;
	}

	public int getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	
}

