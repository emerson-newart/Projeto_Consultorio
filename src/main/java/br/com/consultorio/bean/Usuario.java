package br.com.consultorio.bean;

public class Usuario {
    
    private Integer id;
    private String login;
    private String nome;
    private String senha;
    private String status;
    
    public Usuario(){}

    public Usuario(String login, String nome, String senha, String status) {
        this.login = login;
        this.nome = nome;
        this.senha = senha;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getLogin() {
        return login;
    }
    
    public void setLogin(String login){
      this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
