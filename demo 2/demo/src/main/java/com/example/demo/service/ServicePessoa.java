package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Empresa;
import com.example.demo.model.Pessoa;

@Service
public class ServicePessoa {
	
	
	List<Pessoa>pessoas = new ArrayList<>();
	
	public List<Pessoa> getAllPessoas(){
		System.out.println(pessoas);
		return pessoas;
	} 
	
	public Pessoa getPessoaById(String id){
		try {
			Integer id_aux = Integer.parseInt(id);
			for(Pessoa i : pessoas) {
				if(i.getId() == id_aux) {
					return i;
				}
			}
			System.out.println("Id inválido.");
			return null;	
		}catch (Exception e){
			System.out.println("Id inválido. Introduza um número inteiro entre 0 e " + pessoas.size());
			return null;
		}
	} 
	
	public List<Pessoa> addPessoa(Pessoa pessoa){
		System.out.println(pessoa);
									//FALTA CONFIRMAR SE ID DA EMPRESA EXISTE
			pessoas.add(pessoa);


			return pessoas;
	}
	
	public Pessoa updatePessoa(Pessoa pessoa){
		for(Pessoa i : pessoas) {
				if(i.getId() == pessoa.getId()) {
					if(pessoa.getNome() != null && !pessoa.getNome().isBlank()) {
						i.setNome(pessoa.getNome());
					}
					if(pessoa.getIdade()>=0) {
						i.setIdade(pessoa.getIdade());
					}
					if(pessoa.getEmail() != null && !pessoa.getEmail().isBlank()) {
						i.setEmail(pessoa.getEmail());
					}
				}
				return i;
		}
		System.out.println("Pessoa não existe.");
		return null;
	} 
	
	public List<Pessoa> deletePessoa(String id){
		try {
			Integer id_aux = Integer.parseInt(id);
			for(Pessoa i : pessoas) {
				if(i.getId() == id_aux) {
					pessoas.remove(i);
					return pessoas;
				}
			}
			System.out.println("Id inválido.");
			return null;	
		}catch (Exception e){
			System.out.println("Id inválido. Introduza um número inteiro entre 0 e " + pessoas.size());
			return null;
		}
	}
	
}
