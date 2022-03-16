package com.example.demo.controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.GetEmpresaResponse;
import com.example.demo.dto.SimpleResponse;
import com.example.demo.model.Empresa;
import com.example.demo.service.ServiceEmpresa;

@RestController
public class ControladorEmpresa {
	
	private final ServiceEmpresa serviceEmpresa;
	
	@Autowired												//Esta anotacao permite que o Spring injete dependencias nesta classe
	public ControladorEmpresa(ServiceEmpresa serviceEmpresa){
		this.serviceEmpresa = serviceEmpresa;
	}
    
	@GetMapping("/getAllEmpresas")
	public List<Empresa> getAllEmpresas(){
		return serviceEmpresa.getListaEmpresas();
	}
	
    @PostMapping("/addEmpresa")
    public  ResponseEntity<SimpleResponse> addEmpresa(@RequestBody Empresa empresa){	//public tipoDeRetorno nomeFuncao(localDeInsercaoDados tipo nomeVariavel)
            SimpleResponse sr = new SimpleResponse();
            if (serviceEmpresa.addEmpresa(empresa)){
                sr.setSucess("Sucesso ao inserir a empresa");			//alterar mensagem do simple response
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(sr);
            }

            return ResponseEntity
            		.status(HttpStatus.BAD_REQUEST)
            		.body(sr);
    }	
    
    @GetMapping("/getEmpresaById/{id}")
    public ResponseEntity<SimpleResponse> getEmpresaById(@PathVariable String id){
        GetEmpresaResponse ger = new GetEmpresaResponse();
        
        Optional<Empresa> empresaOptional = serviceEmpresa.getEmpresaById(id);

        if (empresaOptional.isEmpty()){
            ger.setMessage("Id errado");
            return ResponseEntity
            		.status(HttpStatus.NOT_FOUND)
            		.body(ger);
        }else{
            ger.setEmpresa(empresaOptional.get());
            ger.setSucess("Empresa Encontrada");
            return ResponseEntity
            		.status(HttpStatus.OK)
            		.body(ger);
        }
    }
    
    /*@GetMapping("/geEmpresa")
    public ResponseEntity<SimpleResponse> getEmpresa(@RequestBody Empresa empresa){
        GetEmpresaResponse ger = new GetEmpresaResponse();

        Optional<Empresa> empresaOptional = serviceEmpresa.getEmpresa(empresa);

        if (empresaOptional.isEmpty()){
            ger.setMessage("Empresa não encontrada");
            return ResponseEntity
            		.status(HttpStatus.NOT_FOUND)
            		.body(ger);
        }else{
            ger.setEmpresa(empresaOptional.get());
            ger.setSucess("Empresa Encontrada");
            return ResponseEntity
            		.status(HttpStatus.OK)
            		.body(ger);
        }
    }*/
    
    @DeleteMapping("/deleteEmpresa")
    public ResponseEntity<SimpleResponse> deleteEmpresa(@RequestBody Empresa empresa){
        SimpleResponse sr = new SimpleResponse();

        if (serviceEmpresa.deleteEmpresa(empresa)){
            sr.setSucess("Sucesso ao remover a empresa");
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(sr);
        }

        return ResponseEntity
        		.status(HttpStatus.NOT_FOUND)
        		.body(sr);
    }

    @PutMapping("/updateEmpresa")
    public ResponseEntity<SimpleResponse> updateEmpresa(@RequestBody Empresa empresa){
        SimpleResponse sr = new SimpleResponse();

        if (serviceEmpresa.updateEmpresa(empresa)){
            sr.setSucess("Sucesso ao atualizar a empresa");
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(sr);
        }

        return ResponseEntity
        		.status(HttpStatus.BAD_REQUEST)
        		.body(sr);
    }


       
}
