package br.com.consultorio.util;

import br.com.consultorio.bean.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModeloTabelaUsuario extends AbstractTableModel {
    
    private List<Usuario> dados; 
    private final int COL_ID = 0;
    private final int COL_NOME = 1;
    private final int COL_LOGIN = 2;
    private final int COL_SENHA = 3;
    
    
   public ModeloTabelaUsuario(){
     
   } 
   public ModeloTabelaUsuario(List<Usuario> lista){
     this.dados = lista;
   }
    
    @Override
    public String getColumnName(int column) {
        if(column == COL_ID){
          return "ID";
        }else if(column == COL_NOME){
          return "Nome";
        }else if(column == COL_LOGIN){
          return "Login";
        }else if(column == COL_SENHA){
          return "Senha";
        }       
        return "";
    }
    
    @Override
    public int getRowCount() {
        return this.dados.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Usuario u = this.dados.get(linha);
        
        if(coluna == COL_ID){
          return u.getId();
        }else if(coluna == COL_NOME){
          return u.getNome();
        }else if(coluna == COL_LOGIN){
          return u.getLogin();
        }else if(coluna == COL_SENHA){
          return u.getSenha();
        }       
        return "-";
    }

    @Override
    public void setValueAt(Object valor, int linha, int coluna) {
        Usuario u = this.dados.get(linha);
         if(coluna == COL_ID){
         u.setId((int) valor);
        }else if(coluna == COL_NOME){
          u.setNome((String) valor);
        }else if(coluna == COL_LOGIN){
           u.setLogin((String) valor);
        }else if(coluna == COL_SENHA){
          u.setSenha((String) valor);
        } 
         this.fireTableRowsUpdated(linha, linha);
    }
   
    public void limpaTabela(){
        int i = this.getRowCount()-1;
        while(i >= 0){
          this.removeRow(i);
          i--;
        }
    }
    
    public void addRow(Usuario u){
      this.dados.add(u);
      this.fireTableDataChanged();
    }
    
    public void removeRow(int linha){
      this.dados.remove(linha);
      this.fireTableRowsDeleted(linha, linha);
    }
    
}
