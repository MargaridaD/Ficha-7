package com.example.demo.service;



import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Empresa;



@Service
public class ServiceEmpresa {
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

	public List<Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}
	
	
	
}
