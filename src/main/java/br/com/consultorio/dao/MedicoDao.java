package br.com.consultorio.dao;

import br.com.consultorio.bean.Medico;
import br.com.consultorio.conection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MedicoDao {
    
    private Connection con = null;
    
    public MedicoDao() {
        con = ConnectionFactory.getConnection();
    }
    
    public boolean save(Medico medico){
   
        String sql = "INSERT INTO medico(nome, crm) values(?,?)";
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, medico.getNome());
            stmt.setString(2, medico.getCrm());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro "+ex);
            return false;
        }finally{
            ConnectionFactory.closeConection(con, stmt);
        }    
    }
    
    public List<Medico> listar(){
   
        String sql = "select * from medico";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Medico> lista = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Medico medico = new Medico();
                medico.setNome(rs.getString("nome"));
                medico.setCrm(rs.getString("crm"));
                lista.add(medico);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao listar "+ex);
        }finally{
          ConnectionFactory.closeConection(con, stmt, rs);
        }
       return lista;
    }
    
    public boolean update(Medico medico){
   
        String sql = "update medico set nome=?, crm=? where id=?";
        PreparedStatement stmt = null;
  
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, medico.getNome());
            stmt.setString(2, medico.getCrm());
            stmt.setInt(3, medico.getId());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro ao listar "+ex);
            return false;
        }finally{
          ConnectionFactory.closeConection(con, stmt);
        }
    }
    
    public boolean delete(Medico medico){
    
        String sql = "delete from medico where id=?";
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);        
            stmt.setInt(1, medico.getId());
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
