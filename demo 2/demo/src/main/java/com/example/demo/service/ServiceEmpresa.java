package com.example.demo.service;



import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Empresa;
import com.example.demo.model.Pessoa;



@Service
public class ServiceEmpresa {

	List<Pessoa>pessoas = new ArrayList<>();
	List<Empresa>empresas = new ArrayList<>();
	
	public List<Empresa> getAllEmpresas(){
		System.out.println(empresas);
		return empresas;
	} 
	
	public Empresa getEmpresaById(String id){
		try {
			Integer id_aux = Integer.parseInt(id);
			for(Empresa i : empresas) {
				if(i.getId() == id_aux) {
					return i;
				}
			}
			System.out.println("Id inválido.");
			return null;	
		}catch (Exception e){
			System.out.println("Id inválido. Introduza um número inteiro entre 0 e " + empresas.size());
			return null;
		}
	} 
	
	public List<Empresa> addEmpresa(Empresa empresa){
		System.out.println(empresa);
			empresas.add(empresa);
			return empresas;
	}
	
	public Empresa updateEmpresa(Empresa empresa){
		for(Empresa i : empresas) {
				if(i.getId() == empresa.getId()) {
					if(empresa.getNome() != null && !empresa.getNome().isBlank()) {
						i.setNome(empresa.getNome());
					}
					if(empresa.getMorada() != null && !empresa.getMorada().isBlank()) {
						i.setMorada(empresa.getMorada());
					}
					/*if(empresa.getNumFuncionariosAtual()>=0) {
						i.setNumFuncionariosAtual(empresa.getNumFuncionariosAtual());;
					}
					if(empresa.getNumFuncionariosDesdeCriacao()>=0) {
						i.setNumFuncionariosDesdeCriacao(empresa.getNumFuncionariosDesdeCriacao());;
					}*/
				}
				return i;
		}
		System.out.println("Empresa não existe.");
		return null;
	} 
	
	public List<Empresa> deleteEmpresa(String id){
		try {
			Integer id_aux = Integer.parseInt(id);
			for(Empresa i : empresas) {
				if(i.getId() == id_aux) {
					empresas.remove(i);
					for(Pessoa j:pessoas) {
						if(j.getIdEmpresa() == id_aux) {
							pessoas.remove(j);
						}
					}
					return empresas;
				}
			}
			System.out.println("Id inválido.");
			return null;	
		}catch (Exception e){
			System.out.println("Id inválido. Introduza um número inteiro entre 0 e " + empresas.size());
			return null;
		}
	}
	

	
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
		for(Empresa i:empresas) {
			if(pessoa.getIdEmpresa()==i.getId()) {
				i.getListaFuncionarios().add(pessoa);
				pessoas.add(pessoa);
				i.setNumFuncionariosAtual(i.getNumFuncionariosAtual()+1);
				i.setNumFuncionariosDesdeCriacao(i.getNumFuncionariosDesdeCriacao()+1);
				return pessoas;
			}
		}
		
		System.out.println("Empresa não existe");
		return null;
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
					
			/*	for(Empresa j: empresas) {
					if(j.get)
				}
					
				j.setNumFuncionariosAtual(j.getNumFuncionariosAtual()-1);
					j.setNumFuncionariosDesdeCriacao(j.getNumFuncionariosDesdeCriacao()-1); */
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
	

	public List<Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}
	
	
	
}
