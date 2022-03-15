package com.example.demo.service;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.Empresa;
import com.example.demo.model.Pessoa;



@Service
public class ServiceEmpresa {

	private List<Pessoa>pessoas;
	private List<Empresa>empresas;
	
	public ServiceEmpresa() {
		List<Pessoa>pessoas = new ArrayList<>();
		List<Empresa>empresas = new ArrayList<>();
	}
	
    public List<Empresa> getListaEmpresas(){
        return empresas;
    }
	
	public boolean addEmpresa(Empresa empresa){
		if(empresa.getId() != null  
    			|| empresa.getNome() == null || !empresa.getNome().isBlank()
    			|| empresa.getMorada() == null || !empresa.getMorada().isBlank()) {
			return false;
		}
		
		empresas.add(empresa);
		return true;
	}
	
    public boolean deleteEmpresa(Empresa emp){
        Optional<Empresa> empOptional = getEmpresa(emp);

        if (empOptional.isEmpty()){
            return false;
        }

        Empresa empresaToDelete = empOptional.get();

        for (Pessoa i: empresaToDelete.getListaFuncionarios()){
            pessoas.remove(i);
        }

        empresas.remove(empresaToDelete);

        return true;
    }

    public boolean updateEmpresa(Empresa emp){
        Optional<Empresa> empOptional = getEmpresa(emp);
        if (empOptional.isEmpty()){
            return false;
        }

        Empresa empresaToUpdate = empOptional.get();

        if (emp.getNome()!= null && !emp.getNome().isBlank()){
            empresaToUpdate.setNome(emp.getNome());
        }

        if (emp.getMorada()!= null && !emp.getMorada().isBlank()){
            empresaToUpdate.setMorada(emp.getMorada());
        }

        return true;
    }

    public Optional<Empresa> getEmpresa(Empresa emp){
        if (emp.getId()!= null) {
            for (Empresa i : empresas) {
                if (i.getId().equals(emp.getId())) {
                    return Optional.of(i);
                }
            }
        }

        return Optional.empty();
    }

	
	
	
	
}
