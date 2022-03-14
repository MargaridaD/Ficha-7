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

import com.example.demo.model.Empresa;
import com.example.demo.service.ServiceEmpresa;

public class ControladorEmpresa {
	
private final ServiceEmpresa serviceEmpresa;
	
	@Autowired												//Esta anotacao permite que o Spring injete dependencias nesta classe
	public ControladorEmpresa(ServiceEmpresa serviceEmpresa){
		this.serviceEmpresa = serviceEmpresa;
	}
    
	@GetMapping("/getAllEmpresas")
	public List<Empresa> getAllEmpresas(){
		return serviceEmpresa.getAllEmpresas();
	}
	
	@GetMapping("/getEmpresaById/{id}")
	public Empresa getEmpresaById(@PathVariable String id){
		return serviceEmpresa.getEmpresaById(id);
	}
	
    @PostMapping("/addEmpresa")
    public  List<Empresa> addEmpresa(@RequestBody Empresa empresa){	//public tipoDeRetorno nomeFuncao(localDeInsercaoDados tipo nomeVariavel)
    	if(empresa.getNumFuncionariosAtual() >= 0 && empresa.getNumFuncionariosDesdeCriacao() >= 0 
    			&& empresa.getNome() != null && !empresa.getNome().isBlank()
    			&& empresa.getMorada() != null && !empresa.getMorada().isBlank()) {
    		List<Empresa> aux = serviceEmpresa.addEmpresa(empresa);
         	return aux;	
    	}else{
    		System.out.println("Dados mal inseridos.");
    		return Collections.EMPTY_LIST;
    	}
    }
    
    @PutMapping("/updateEmpresa")
    public  Empresa updateEmpresa(@RequestBody Empresa empresa){	
  		return serviceEmpresa.updateEmpresa(empresa);
    }
    
    @DeleteMapping("/deleteEmpresa/{id}")
    public List<Empresa> deleteEmpresa(@PathVariable String id){
    	return serviceEmpresa.deleteEmpresa(id);
    }

}
