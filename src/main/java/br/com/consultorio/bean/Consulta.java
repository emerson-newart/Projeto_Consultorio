package br.com.consultorio.bean;

import java.util.Date;

public class Consulta {
    
    private Integer id;
    private Integer idMedico;
    private Integer idPaciente;
    private Date data;
    private Date hora;
    
    public Consulta(){
    
    }

    public Consulta(Integer idMedico, Integer idPaciente, Date data, Date hora) {
        this.idMedico = idMedico;
        this.idPaciente = idPaciente;
        this.data = data;
        this.hora = hora;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Integer idMedico) {
        this.idMedico = idMedico;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }
    
    
}
