package br.com.consultorio.conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {
    
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/dbconsultorio?useTimezone=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "newart0147";
    
    
    // Método para conexão com o banco mysql
    public static Connection getConnection(){
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException ex) {
           throw new RuntimeException("Erro ao se conectar ao banco", ex);
        }
    }
    
    public static void closeConection(Connection con){
      if(con != null){
          try {
              con.close();
          } catch (SQLException ex) {
              System.err.println("Erro: "+ex);
          }
      }
    }
    
    public static void closeConection(Connection con, PreparedStatement stmt){
      if(stmt != null){
          try {
              stmt.close();
          } catch (SQLException ex) {
              System.err.println("Erro: "+ex);
          }
      }
      closeConection(con);
    }

    public static void closeConection(Connection con, PreparedStatement stmt, ResultSet rs){
      if(rs != null){
          try {
              rs.close();
          } catch (SQLException ex) {
              System.err.println("Erro: "+ex);
          }
      }
        closeConection(con, stmt);
    }
}
