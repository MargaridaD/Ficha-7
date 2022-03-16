package com.example.demo.dto;

public class SimpleResponse {
	
	private boolean statusOk;
    private String message;
    
    //CONSTRUTOR
    public SimpleResponse() {					
        statusOk = false;
        message = "Ocorreu um erro";
    }
    
    //METODO
    public void setSucess(String message){
        statusOk = true;
        this.message = message;
    }
    
    //GETTERS E SETTERS
    public boolean isStatusOk() {
        return statusOk;
    }

    public void setStatusOk(boolean statusOk) {
        this.statusOk = statusOk;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
