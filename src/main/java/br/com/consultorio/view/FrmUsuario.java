package br.com.consultorio.view;

import br.com.consultorio.bean.Usuario;
import br.com.consultorio.dao.UsuarioDao;
import br.com.consultorio.util.ModeloTabelaUsuario;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class FrmUsuario extends javax.swing.JInternalFrame {
    int ultimaSelecao = 0;
    String acao = "inicio";
    Usuario usuario = new Usuario();
    UsuarioDao usuarioDao = new UsuarioDao();
    ModeloTabelaUsuario model;
    
    public FrmUsuario() {
        initComponents();
        model  = new ModeloTabelaUsuario(usuarioDao.listar());
        tabelaUsuario.setModel(model);
        
        selecionaLinhaTabela(0, 0);
        preencheCampos();
         
        desabilitaBotoes();
        liberaCampos(false);
    }
    
    public void atualizaJTable(){
      model.limpaTabela();
      for(Usuario u: usuarioDao.listar()){
        model.addRow(u);
      }
    }
    
    public void liberaCampos(boolean teste){
       for(int i=0; i < painelCampos.getComponentCount(); i++){
           Component c = painelCampos.getComponent(i);
           if(c instanceof JTextField){
             JTextField field = (JTextField) c;
               field.setEditable(teste);
           }
       }
    }
    
    public void limpaCampos(){
       for(int i=0; i < painelCampos.getComponentCount(); i++){
           Component c = painelCampos.getComponent(i);
           if(c instanceof JTextField){
             JTextField field = (JTextField) c;
               field.setText("");
           }
       }
    }
    
    public void desabilitaBotoes(){
      if(acao.equals("inicio")){
        btnEditar.setEnabled(true);
        btnExcluir.setEnabled(true);
        btnNovo.setEnabled(true);
        btnSalvar.setEnabled(false);
        btnCancelar.setEnabled(false);
      }else if(acao.equals("novo")){
        btnEditar.setEnabled(false);
        btnExcluir.setEnabled(false);
        btnNovo.setEnabled(false);
        btnSalvar.setEnabled(true);
        btnCancelar.setEnabled(true);
      }else if(acao.equals("editar")){
        btnEditar.setEnabled(false);
        btnExcluir.setEnabled(false);
        btnNovo.setEnabled(false);
        btnSalvar.setEnabled(true);
        btnCancelar.setEnabled(true); 
      }
                
    }
    
    public void preencheCampos(){
        // Carregando dados da JTable nos JtextField
        if(tabelaUsuario.getSelectedRow() != -1){
          txtNome.setText(tabelaUsuario.getValueAt(tabelaUsuario.getSelectedRow(), 1).toString());
          txtLogin.setText(tabelaUsuario.getValueAt(tabelaUsuario.getSelectedRow(), 2).toString());
          txtSenha.setText(tabelaUsuario.getValueAt(tabelaUsuario.getSelectedRow(), 3).toString());
          //txtId.setText(tabelaUsuario.getValueAt(tabelaUsuario.getSelectedRow(), 0).toString());
        }
    }
    
    public Usuario setarObjeto(Usuario u, String tipo){
      if(tipo.equals("novo")){
        u.setId(null);
      }else{ 
        u.setId(Integer.parseInt(tabelaUsuario.getValueAt(tabelaUsuario.getSelectedRow(), 0).toString()));
      }
        u.setNome(txtNome.getText());
        u.setLogin(txtLogin.getText());
        u.setSenha(txtSenha.getText());
      
      return u;
    }
    
    public void selecionaLinhaTabela(int ini, int fim){
        tabelaUsuario.setRowSelectionInterval(ini, fim);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        painelCampos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        txtSenha = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaUsuario = new javax.swing.JTable();
        txtPesquisa = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnRecarregarTabela = new javax.swing.JButton();
        cbxTipoPesquisa = new javax.swing.JComboBox<>();
        btnEditar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setClosable(true);

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\emers\\OneDrive\\Imagens\\icones_sistema\\Admin-icon.png")); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(31, 31, 31))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        painelCampos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Login");

        jLabel2.setText("Senha");

        jLabel4.setText("Nome");

        jLabel6.setText("Código Interno");

        javax.swing.GroupLayout painelCamposLayout = new javax.swing.GroupLayout(painelCampos);
        painelCampos.setLayout(painelCamposLayout);
        painelCamposLayout.setHorizontalGroup(
            painelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCamposLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(painelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtLogin)
                    .addComponent(txtSenha)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        painelCamposLayout.setVerticalGroup(
            painelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCamposLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(19, 19, 19))
        );

        tabelaUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabelaUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaUsuarioMouseClicked(evt);
            }
        });
        tabelaUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tabelaUsuarioKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaUsuario);

        btnPesquisar.setText("Pesquisar");

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 204));
        jLabel5.setText("CADASTRO DE USUÁRIO");

        btnNovo.setIcon(new javax.swing.ImageIcon("C:\\Users\\emers\\OneDrive\\Imagens\\icones_sistema\\New-file-icon.png")); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnSalvar.setIcon(new javax.swing.ImageIcon("C:\\Users\\emers\\OneDrive\\Imagens\\icones_sistema\\save.fw.png")); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon("C:\\Users\\emers\\OneDrive\\Imagens\\icones_sistema\\delete.fw.png")); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnRecarregarTabela.setText("Recaregar tabela");

        cbxTipoPesquisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nome", "Login" }));

        btnEditar.setIcon(new javax.swing.ImageIcon("C:\\Users\\emers\\OneDrive\\Imagens\\icones_sistema\\update.fw.png")); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon("C:\\Users\\emers\\OneDrive\\Imagens\\icones_sistema\\cancel.fw.png")); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(painelCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(23, 23, 23)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cbxTipoPesquisa, 0, 147, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnPesquisar))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnRecarregarTabela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(painelCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnSalvar)
                    .addComponent(btnExcluir)
                    .addComponent(btnEditar)
                    .addComponent(btnCancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar)
                    .addComponent(btnRecarregarTabela)
                    .addComponent(cbxTipoPesquisa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setBounds(0, 0, 847, 471);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        // Novo registro
        acao = "novo";
        desabilitaBotoes();
        liberaCampos(true);
        limpaCampos();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // Cancela tudo
         acao = "inicio";
         desabilitaBotoes();
         liberaCampos(false);
         preencheCampos();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // Excluindo linha selecionada da JTable
        
        if(tabelaUsuario.getSelectedRow() != -1){
            int resposta = JOptionPane.showConfirmDialog(null, "Confirma Exclusão?", "Exclusão", JOptionPane.YES_NO_OPTION);
            if(resposta == 0){
              JOptionPane.showMessageDialog(null,"Resposta "+resposta);
              model.removeRow(tabelaUsuario.getSelectedRow());
              acao = "inicio";
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void tabelaUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaUsuarioMouseClicked
      if(!acao.equals("editar")){
        preencheCampos();
      }
    }//GEN-LAST:event_tabelaUsuarioMouseClicked

    private void tabelaUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaUsuarioKeyReleased
      if(!acao.equals("editar")){
        preencheCampos();
      }
    }//GEN-LAST:event_tabelaUsuarioKeyReleased

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // Altera dados do banco
        acao = "editar";
        if(tabelaUsuario.getSelectedRow() != -1){
            liberaCampos(true);
            desabilitaBotoes();
            ultimaSelecao = tabelaUsuario.getSelectedRow();
        }else{
          JOptionPane.showMessageDialog(null, "Selecione um registro para alterar!");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        Usuario u = new Usuario();
        UsuarioDao dao = new UsuarioDao();
        
        if(acao.equals("editar")){
        
          if(dao.alterar(setarObjeto(u, "editar"))){
             acao = "inicio";
             liberaCampos(false);
             desabilitaBotoes();
             atualizaJTable();
             //tabelaUsuario.setColumnSelectionAllowed(true);
             selecionaLinhaTabela(ultimaSelecao, ultimaSelecao);
             JOptionPane.showMessageDialog(null, "Registro alterado com sucesso!");
          }else{
             JOptionPane.showMessageDialog(null, "Algo deu errado, não foi possível alterar.");
          }
        }else if(acao.equals("novo")){
        
          if(dao.salvar(setarObjeto(u, "novo"))){
             acao = "inicio";
             liberaCampos(false);
             desabilitaBotoes();
             atualizaJTable();
             selecionaLinhaTabela(ultimaSelecao, ultimaSelecao);
             JOptionPane.showMessageDialog(null, "Registro salvo com sucesso!");
          }else{
             JOptionPane.showMessageDialog(null, "Algo deu errado, não foi possível salvar.");
          }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnRecarregarTabela;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbxTipoPesquisa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel painelCampos;
    private javax.swing.JTable tabelaUsuario;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPesquisa;
    private javax.swing.JTextField txtSenha;
    // End of variables declaration//GEN-END:variables
}
