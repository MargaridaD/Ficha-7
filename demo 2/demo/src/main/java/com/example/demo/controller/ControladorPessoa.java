package com.example.demo.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Pessoa;
import com.example.demo.service.ServiceEmpresa;

@RestController
public class ControladorPessoa {
	
	private final ServiceEmpresa serviceEmpresa;
	
	@Autowired												//Esta anotacao permite que o Spring injete dependencias nesta classe
	public ControladorPessoa(ServiceEmpresa serviceEmpresa){
		this.serviceEmpresa = serviceEmpresa;
	}
    
	@GetMapping("/getAllPessoas")
	public List<Pessoa> getAllPessoas(){
		return serviceEmpresa.getAllPessoas();
	}
	
	@GetMapping("/getPessoaById/{id}")
	public Pessoa getPessoaById(@PathVariable String id){
		return serviceEmpresa.getPessoaById(id);
	}
	
    @PostMapping("/addPessoa")
    public  List<Pessoa> addPessoa(@RequestBody Pessoa pessoa){	//public tipoDeRetorno nomeFuncao(localDeInsercaoDados tipo nomeVariavel)
    	if(pessoa.getIdade() >= 0 
    			&& pessoa.getNome() != null && !pessoa.getNome().isBlank()
    			&& pessoa.getEmail() != null && !pessoa.getEmail().isBlank()) {
    		List<Pessoa> aux = serviceEmpresa.addPessoa(pessoa);
         	return aux;	
    	}else{
    		System.out.println("Dados mal inseridos.");
    		return Collections.EMPTY_LIST;
    	}
    }
    
    @PutMapping("/updatePessoa")
    public  Pessoa updatePessoa(@RequestBody Pessoa pessoa){	
  		return serviceEmpresa.updatePessoa(pessoa);
    }
    
    @DeleteMapping("/deletePessoa/{id}")
    public List<Pessoa> deletePessoa(@PathVariable String id){
    	return serviceEmpresa.deletePessoa(id);
    }
    
}
