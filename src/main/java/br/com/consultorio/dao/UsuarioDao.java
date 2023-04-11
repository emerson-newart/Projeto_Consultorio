package br.com.consultorio.dao;

import br.com.consultorio.bean.Usuario;
import br.com.consultorio.conection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDao {
    private Connection con = null;
    
    public UsuarioDao() {
        con = ConnectionFactory.getConnection();
    }
    
    public List<Usuario> listar(){
     
        String sql = "Select * From adm_usuario where status=1";
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Usuario> listaUsuario = new ArrayList<>();
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()){
              Usuario usuario = new Usuario();
              usuario.setId(rs.getInt("id"));
              usuario.setNome(rs.getString("nome"));
              usuario.setLogin(rs.getString("login"));
              usuario.setSenha(rs.getString("senha"));
              listaUsuario.add(usuario);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao listar os registros "+ex);
        }finally{
          ConnectionFactory.closeConection(con, stmt, rs);
        }
        
        return listaUsuario;
    }
    
     public boolean alterar(Usuario usuario){
     
        String sql = "UPDATE adm_usuario SET nome=?, login=?, senha=? WHERE id=?";
        PreparedStatement stmt = null;
  
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getLogin());
            stmt.setString(3, usuario.getSenha());
            stmt.setInt(4, usuario.getId());
            
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro ao alterar "+ex);
            return false;
        }finally{
          ConnectionFactory.closeConection(con, stmt);
        }
        
       
    }
     
    public boolean salvar(Usuario usuario){
     
        String sql = "INSERT INTO adm_usuario (nome, login, senha, status) VALUES (?,?,?,?);";
        PreparedStatement stmt = null;
  
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getLogin());
            stmt.setString(3, usuario.getSenha());
            stmt.setInt(4, 1);
       
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro ao salvar "+ex);
            return false;
        }finally{
          ConnectionFactory.closeConection(con, stmt);
        }
        
       
    } 
}
