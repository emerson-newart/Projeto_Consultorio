package br.com.consultorio.bean;

import java.util.ArrayList;

public class Paciente {
    
    private Integer id;
    private String nome;
    private String cpf;
    
   // private List<Consulta> consulta = new ArrayList<>();
    
    public Paciente(){
    
    }
    
    public Paciente(String nome, String cpf){
      this.nome = nome;
      this.cpf = cpf;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    
    
}
