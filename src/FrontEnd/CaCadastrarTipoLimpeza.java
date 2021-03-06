/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrontEnd;

import BackEnd.ConexaoMySQL;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Igor
 */
public class CaCadastrarTipoLimpeza extends javax.swing.JDialog {
    
    private ConexaoMySQL c;
    private int Cod;
    /**
     * Creates new form CaCadastrarTipoLimpeza
     */
    public CaCadastrarTipoLimpeza(int Codigo) {
        initComponents();
        this.c = new ConexaoMySQL();
        this.setModal(true);
         Cod= Codigo;
         
         
         
         
         if(Codigo == 0){
            this.setTitle("Cadastrando Tipo de Limpeza");

        }
        else{
            this.setTitle("Editando Tipo de Limpeza");

            try{
                String SQL="select * From tipolimpeza where CodTipoLimpeza = "+Codigo;
                this.c.setResultSet(SQL);
                this.c.getResultSet().next();

                txtNome.setText(this.c.getResultSet().getString("Nome"));
                txtPreco.setText(this.c.getResultSet().getString("Preco"));


            }
            catch(SQLException e){
                JOptionPane.showMessageDialog(this,  e);
            }
        }
    }
    
    public boolean IsFloat(JTextField TextField, String Campo){
        try {
            Float f=Float.parseFloat(TextField.getText());
            return true;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(
                    null,
                    "O valor do campo '" + Campo + "' não é válido. \n Informe um valor real.",
                    "Erro de Entrada" , JOptionPane.ERROR_MESSAGE);
            TextField.requestFocus();
            TextField.setText("");
            return false;
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

        lblCPF = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtPreco = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblCPF.setText("Preco :");

        lblNome.setText("Nome :");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPreco, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                    .addComponent(txtNome)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNome)
                            .addComponent(lblCPF))
                        .addGap(195, 195, 195)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCPF)
                .addGap(3, 3, 3)
                .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        if(IsFloat(txtPreco, "Preco" )){

            // Toda essa sequencia de Strings seguido de Ifs é para verificar se os campos foram preenchidos

            String Preco=txtPreco.getText();
            int TamanhoPreco=Preco.length();
            String Nome=txtNome.getText();
            int TamanhoNome=Nome.length();
      

                    if(TamanhoNome>=1){
                        if(TamanhoPreco>=1){

                            if(Cod==0){
                                String SQL="Insert into tipolimpeza(Nome, preco)"
                                + " Values('" + txtNome.getText() + "','" +txtPreco.getText() + "');";
                                //System.out.print(SQL);
                                this.c.SQLExecute(SQL);
                                this.dispose();
                                JOptionPane.showMessageDialog(this, "Cadastrado com sucesso");
                            }
                            else{
                                String SQL= "Update tipolimpeza set Nome = '"+txtNome.getText()+"',Preco = '"+txtPreco.getText()+"' where( CodTipoLimpeza = '"+Cod+"' )";
                                //System.out.print(SQL);
                                this.c.SQLExecute(SQL);
                                this.dispose();
                                JOptionPane.showMessageDialog(this, "Editado com sucesso");
                            }

                        }
                        else{
                            JOptionPane.showMessageDialog(this, "Informe um valor válido para Preço");
                            txtPreco.setText("");
                            txtPreco.requestFocus();
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(this, "O Nome está muito pequeno.");
                    }
                    txtNome.setText("");
                    txtNome.requestFocus();
                }
               

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblNome;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPreco;
    // End of variables declaration//GEN-END:variables
}
