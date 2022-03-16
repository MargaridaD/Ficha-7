package com.example.demo.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Pessoa")
public class Pessoa {
	
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    
	private String nome;
	private int idade;
	private String email;
	
	@JsonIgnore			//Porque a pessoa tem o atributo empresa e a empresa tem o atributo pessoa o que daria um loop infinito
	private Empresa empresa; //Empresa a que a pessoa pertence

	
	/*public Pessoa(String nome, int idade, String email) {
		this.nome = nome;
		this.idade = idade;
		this.email = email;
		id = UUID.randomUUID();
	}*/


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
	
	public Long getId() {
		return id;
	}

	public Empresa getIdEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}


	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", idade=" + idade + ", email=" + email + "]";
	}
	
	
	
}

