/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrontEnd;

import BackEnd.ConexaoMySQL;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author Igor
 */
public class CaCadastrarVeiculos extends javax.swing.JDialog {
        
    private ConexaoMySQL c;
    private String Cod;

    /**
     * Creates new form CaCadastrarVeiculos
     */
    public CaCadastrarVeiculos(String Codigo) {
        initComponents();
                this.c = new ConexaoMySQL();
        this.setModal(true);
         Cod= Codigo;
         
        this.c.setComboBox(cbCor, "cor", "Nome");
        this.c.setComboBox(cbModelo, "modelo", "Nome");
        this.c.setComboBox(cbProprietario, "proprietario", "Nome");
        
        
         
         
         if(Codigo == "0"){
            this.setTitle("Cadastrando Veículo");

        }
        else{
            this.setTitle("Editando Veículo");

            try{
                String SQL="SELECT * FROM vw_listarVeiculo where placa='"+Codigo+"'";
                this.c.setResultSet(SQL);
                this.c.getResultSet().next();

                cbProprietario.setSelectedItem(this.c.getResultSet().getObject("Proprietario"));
                cbCor.setSelectedItem(this.c.getResultSet().getObject("Cor"));
                cbModelo.setSelectedItem(this.c.getResultSet().getObject("Modelo"));
                txtPlaca.setText(this.c.getResultSet().getString("placa"));

            }
            catch(SQLException e){
                JOptionPane.showMessageDialog(this, "Teste "+e);
            }
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

        jLabel1 = new javax.swing.JLabel();
        cbProprietario = new javax.swing.JComboBox<>();
        lblCor = new javax.swing.JLabel();
        cbCor = new javax.swing.JComboBox<>();
        lblModelo = new javax.swing.JLabel();
        cbModelo = new javax.swing.JComboBox<>();
        btnCaModelo = new javax.swing.JButton();
        btnCaCor = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JToggleButton();
        jLabel2 = new javax.swing.JLabel();
        txtPlaca = new javax.swing.JTextField();
        btnCaProprietario = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Proprietario :");

        cbProprietario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblCor.setText("Cor :");

        cbCor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblModelo.setText("Modelo :");

        cbModelo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnCaModelo.setText("Cadastro");
        btnCaModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCaModeloActionPerformed(evt);
            }
        });

        btnCaCor.setText("Cadastro");
        btnCaCor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCaCorActionPerformed(evt);
            }
        });

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

        jLabel2.setText("Placa: ");

        btnCaProprietario.setText("Cadastro");
        btnCaProprietario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCaProprietarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(lblModelo)
                    .addComponent(lblCor)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPlaca))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cbModelo, javax.swing.GroupLayout.Alignment.LEADING, 0, 111, Short.MAX_VALUE)
                            .addComponent(cbCor, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbProprietario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCaModelo, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(btnCaCor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCaProprietario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbProprietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCaProprietario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCaCor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblModelo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCaModelo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
         String Nome=txtPlaca.getText();
        int TamanhoPlaca=Nome.length();
        
        if(TamanhoPlaca>=6){
        
            if(Cod=="0"){
            String SelecionarProprietario="Select codProprietario from proprietario where Nome ='"+ cbProprietario.getSelectedItem()+"'";
            String SelecionarCor="Select codCor from cor where Nome ='"+ cbCor.getSelectedItem()+"'";
            String SelecionarModelo="Select codModelo from modelo where Nome ='"+ cbModelo.getSelectedItem()+"'";

            String SQL="Insert into veiculo(placa,CodModelo,CodCor,CodProprietario)"
                    + " values ('"+txtPlaca.getText()+"',( "+ SelecionarModelo+" ),( "+ SelecionarCor+" ),( "+ SelecionarProprietario+" ));";

            //System.out.print(SQL);
            this.c.SQLExecute(SQL);
            this.dispose();
            JOptionPane.showMessageDialog(this, "Cadastrado com sucesso");
            }
            else{
            String SelecionarProprietario="Select codProprietario from proprietario where Nome ='"+ cbProprietario.getSelectedItem()+"'";
            String SelecionarCor="Select codCor from cor where Nome ='"+ cbCor.getSelectedItem()+"'";
            String SelecionarModelo="Select codModelo from modelo where Nome ='"+ cbModelo.getSelectedItem()+"'";
            
            String SQL="Update veiculo set Placa = '"+txtPlaca.getText()+"', CodModelo=("+SelecionarModelo+"),"
                    + " CodCor=("+SelecionarCor+"), CodProprietario=("+SelecionarProprietario+") where(placa= '"+Cod+"' )";
            
            
            //System.out.print(SQL);
            this.c.SQLExecute(SQL);
            this.dispose();
            JOptionPane.showMessageDialog(this, "Editado com sucesso");            
            }





        
        }
        else{
            JOptionPane.showMessageDialog(cbCor, "O tamanho da Placa está muito pequeno, favor digitar um valor válido!");
            txtPlaca.setText("");
            txtPlaca.requestFocus();
        }
        
        
        
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnCaCorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCaCorActionPerformed
        // TODO add your handling code here:
        
        //Chamar Cadastro de Cor
        new CaCor().setVisible(true);
        this.c.setComboBox(cbCor, "cor", "Nome");
        
        
    }//GEN-LAST:event_btnCaCorActionPerformed

    private void btnCaModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCaModeloActionPerformed
        // TODO add your handling code here:
        
        new CaModelo().setVisible(true);
        this.c.setComboBox(cbModelo, "modelo", "Nome");

        
    }//GEN-LAST:event_btnCaModeloActionPerformed

    private void btnCaProprietarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCaProprietarioActionPerformed
        // TODO add your handling code here:
        new CaProprietarios().setVisible(true);
        this.c.setComboBox(cbProprietario, "proprietario", "Nome");
       
        
    }//GEN-LAST:event_btnCaProprietarioActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCaCor;
    private javax.swing.JButton btnCaModelo;
    private javax.swing.JButton btnCaProprietario;
    private javax.swing.JToggleButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbCor;
    private javax.swing.JComboBox<String> cbModelo;
    private javax.swing.JComboBox<String> cbProprietario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblCor;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JTextField txtPlaca;
    // End of variables declaration//GEN-END:variables
}
