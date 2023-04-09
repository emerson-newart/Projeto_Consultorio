package br.com.consultorio.dao;

import br.com.consultorio.bean.Paciente;
import br.com.consultorio.conection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PacienteDao {
    
    private Connection con = null;
    
    public PacienteDao() {
        con = ConnectionFactory.getConnection();
    }
    
    public boolean save(Paciente paciente){
   
        String sql = "INSERT INTO paciente(nome, cpf) values(?,?)";
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, paciente.getNome());
            stmt.setString(2, paciente.getCpf());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro "+ex);
            return false;
        }finally{
            ConnectionFactory.closeConection(con, stmt);
        }    
    }
    
    public List<Paciente> listar(){
   
        String sql = "select * from paciente";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Paciente> lista = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Paciente paciente = new Paciente();
                paciente.setNome(rs.getString("nome"));
                paciente.setCpf(rs.getString("cpf"));
                lista.add(paciente);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao listar "+ex);
        }finally{
          ConnectionFactory.closeConection(con, stmt, rs);
        }
       return lista;
    }
    
    public boolean update(Paciente paciente){
   
        String sql = "update usuario set nome=?, cpf=? where id=?";
        PreparedStatement stmt = null;
  
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, paciente.getNome());
            stmt.setString(2, paciente.getCpf());
            stmt.setInt(3, paciente.getId());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro ao listar "+ex);
            return false;
        }finally{
          ConnectionFactory.closeConection(con, stmt);
        }
    }
    
    public boolean delete(Paciente paciente){
    
        String sql = "delete from usuario where id=?";
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);        
            stmt.setInt(1, paciente.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro ao deletar "+ex);
            return false;
        }finally{
          ConnectionFactory.closeConection(con, stmt);
        }
    }
    
}
