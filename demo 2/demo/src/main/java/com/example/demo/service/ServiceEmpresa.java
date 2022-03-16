package com.example.demo.service;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.model.Empresa;
import com.example.demo.model.Pessoa;
import com.example.demo.repository.pessoaRepository;



@Service
public class ServiceEmpresa {

   /* private final pessoaRepository pessoaRepo;

    @Autowired
    public ServiceEmpresa(pessoaRepository pessoaRepo) {
        this.pessoaRepo = pessoaRepo;
    }*/
    
	private List<Pessoa>pessoas;
	private List<Empresa>empresas;
	
	public ServiceEmpresa() {
		pessoas = new ArrayList<>();
		empresas =new ArrayList<>();
	}
	
    public List<Empresa> getListaEmpresas(){
        return empresas;
    }
	
	public boolean addEmpresa(Empresa empresa){
		if(empresa.getNome() == null || empresa.getNome().isBlank()
    			|| empresa.getMorada() == null || empresa.getMorada().isBlank()) {
			return false;
		}
		
		empresas.add(empresa);
		return true;
	}
	
    public Optional<Empresa> getEmpresaById(String id){
        if (id != null) {
        	try {
        		UUID uuid = UUID.fromString(id);  		//Converte String em UUID
        		for (Empresa e : empresas) {
        			if (e.getId().equals(uuid)) {		//PORQUE NÃO COMPARAMOS A EMPRESA?
        				return Optional.of(e);
        			}
        		}
        	}catch (Exception e) {
                return Optional.empty();
        	}
        }
        return Optional.empty();
    }
	
    public Optional<Empresa> getEmpresa(Empresa empresa){
        if (empresa.getId()!= null) {
            for (Empresa e : empresas) {
                if (e.getId().equals(empresa.getId())) {		//PORQUE NÃO COMPARAMOS A EMPRESA?
                    return Optional.of(e);
                }
            }
        }
        return Optional.empty();
    }
    
    public boolean deleteEmpresa(Empresa empresa){
        Optional<Empresa> empOptional = getEmpresa(empresa);

        if (empOptional.isEmpty()){
            return false;
        }

        Empresa empresaToDelete = empOptional.get();

        for (Pessoa p: empresaToDelete.getListaFuncionarios()){
            pessoas.remove(p);
        }

        empresas.remove(empresaToDelete);

        return true;
    }

    public boolean updateEmpresa(Empresa empresa){
        Optional<Empresa> empOptional = getEmpresa(empresa);
        if (empOptional.isEmpty()){
            return false;
        }

        Empresa empresaToUpdate = empOptional.get();

        if (empresa.getNome()!= null && !empresa.getNome().isBlank()){
            empresaToUpdate.setNome(empresa.getNome());
        }

        if (empresa.getMorada()!= null && !empresa.getMorada().isBlank()){
            empresaToUpdate.setMorada(empresa.getMorada());
        }

        return true;
    }



	
	
	
	
}
