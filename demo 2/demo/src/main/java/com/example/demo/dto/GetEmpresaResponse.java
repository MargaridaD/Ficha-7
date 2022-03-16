package com.example.demo.dto;

import com.example.demo.model.Empresa;

public class GetEmpresaResponse extends SimpleResponse{
	//ATRIBUTOS
    private Empresa empresa;

	//GETTERS E SETTERS
    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
