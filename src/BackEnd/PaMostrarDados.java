/*

Template para o Padrão de Exibição e Exclusão


this.setTitle("Funcionarios");                             //Setando o titulo da janela
this.CamposMostrar =new String [] {"Código", "Coluna1"};  //Os nomes das colunas da tabela que vão aparecer
this.CamposTabela =new String [] {"Cod", "Campo1"};      //Os nomes que estão no Banco referentes ao seu lugar na tabela EXATAMENTE IGUAIS
this.View= "funcionario";                               //Nome da view que vai pegar os dados
this.Tabela= "funcionario";                            //Nome da tabela que vai pegar os dados
this.CampoExclusao="Nome";                            //Campo que identifica oqueSerá mostrado, Exp: tipo nome pode ser HP,Sony,Igor,Administrador




 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Igor
 */
public abstract class PaMostrarDados extends javax.swing.JDialog {

    private ConexaoMySQL c;
    protected String[] CamposMostrar;
    protected String[] CamposTabela;
    protected String View;
    protected String Tabela;
    protected String CampoExclusao;

    
    
    public PaMostrarDados() {
        initComponents();
        this.setModal(true);
        this.c = new ConexaoMySQL();
   
    }
    
    protected abstract void Entradas(int Codigo); 
    
    
    
    
    private void setGrid() {
        
    grdDados.setModel(new javax.swing.table.DefaultTableModel(
    new Object [][] {    },
    CamposMostrar
    )); 
    
    grdDados.getColumnModel().getColumn(0).setMaxWidth(90);
    grdDados.getColumnModel().getColumn(0).setMinWidth(90);
            
}
    
    private void setPreencherGrid(){
        DefaultTableModel dtm = (DefaultTableModel) grdDados.getModel();
        
        //Limpando Tabela
        while(dtm.getRowCount()>0){
            dtm.removeRow(0);
        }
        
        //Preenchendo Tabela
        
        try{
            String SQL="Select *From "+View;
            this.c.setResultSet(SQL);
            this.c.getResultSet().next();
            
            do{
                Object[] Campos = new Object[CamposTabela.length];
                for(int i=0;i<CamposTabela.length;i++){
                    Campos[i]=this.c.getResultSet().getString(CamposTabela[i]);
                    
                }
                dtm.addRow(Campos);
                
            }while(this.c.getResultSet().next());
            
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(this, e);
        } 
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCadastrar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        grdDados = new javax.swing.JTable();
        btnFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        grdDados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "", "", "", ""
            }
        ));
        grdDados.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(grdDados);

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCadastrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrar)
                    .addComponent(btnEditar)
                    .addComponent(btnExcluir)
                    .addComponent(btnFechar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        
         this.setGrid();    
         this.setPreencherGrid();
         
         
    }//GEN-LAST:event_formWindowOpened

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
        if(grdDados.getRowCount()>0){           
            if(grdDados.getSelectedRowCount()>0){
                
                String Codigo = String.valueOf(grdDados.getValueAt(grdDados.getSelectedRow(), 0));
                String MostrarExclusao = "";                
                try{

                    String SQL="Select "+ CampoExclusao + " From " + this.View + " where " + this.CamposTabela[0] + " = " + Codigo + ";";
                    this.c.setResultSet(SQL);
                    this.c.getResultSet().next();
                    
                    MostrarExclusao= this.c.getResultSet().getString(CampoExclusao); //Serve para armazenar qual o campo que eu quero excluir
                    
                }
                
                catch(SQLException e){
                    JOptionPane.showMessageDialog(this, e);
                }
                
                if(JOptionPane.showConfirmDialog(this, "Deseja mesmo excluir o registro: '"+MostrarExclusao+"'?","Exclusão", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
                    
                    this.c.SQLExecute("Delete From " + this.Tabela + " where " + this.CamposTabela[0] + " = " + Codigo + ";");
                    JOptionPane.showMessageDialog(this, "Registro excluido com sucesso");
                    this.setPreencherGrid();
                }

            }
            else{
                JOptionPane.showMessageDialog(this, "Selecione um item");
            }

        }
        else{
            JOptionPane.showMessageDialog(this, "O cadastro não possui dados");
        }
        
        
        
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        // TODO add your handling code here:
        Entradas(0);
        this.setPreencherGrid();
        
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        
       if(grdDados.getRowCount()>0){           
            if(grdDados.getSelectedRowCount()>0){
                
                String Codigo = String.valueOf(grdDados.getValueAt(grdDados.getSelectedRow(), 0));
                
                Entradas(Integer.parseInt(Codigo));
                this.setPreencherGrid();
               

            }
            else{
                JOptionPane.showMessageDialog(this, "Selecione um item.");
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "O cadastro não possui dados.");
        }
        
                
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFechar;
    private javax.swing.JTable grdDados;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
