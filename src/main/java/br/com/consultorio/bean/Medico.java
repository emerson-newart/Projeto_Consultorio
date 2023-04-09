package br.com.consultorio.bean;

public class Medico {
    
    private Integer id;
    private String nome;
    private String crm;
    
    public Medico(){
    
    }

    public Medico(String nome, String crm) {
        this.nome = nome;
        this.crm = crm;
    }

    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id){
      this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }
    
    
    
}
