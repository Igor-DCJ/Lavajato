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
public class CaCadastrarModelo extends javax.swing.JDialog {
    
    private ConexaoMySQL c;
    private int Cod;


    /**
     * Creates new form CaCadastrarModelo
     */
    public CaCadastrarModelo(int Codigo) {
        initComponents();
        this.c = new ConexaoMySQL();
        this.setModal(true);
        Cod= Codigo;
        this.setTitle("Cadastrando Modelo");
        
        
        //Definir ComboBox
        this.c.setComboBox(cbModalidade, "modalidade", "Nome");
        
          if(Codigo == 0){
            this.setTitle("Cadastrando Modelos");

        }
        else{
            this.setTitle("Editando Modelos");
            
            

            try{
                String SQL="select Md.Nome, M.Nome as Modalidade From modelo as Md inner join modalidade M on (Md.CodModalidade = M.CodModalidade) where CodModelo= "+Codigo;
                this.c.setResultSet(SQL);
                this.c.getResultSet().next();
                
                
                txtNome.setText(this.c.getResultSet().getString("Nome"));
                cbModalidade.setSelectedItem(this.c.getResultSet().getObject("Modalidade"));

            }
            catch(SQLException e){
                JOptionPane.showMessageDialog(this, e);
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

        txtNome = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        cbModalidade = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btnModalidades = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

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

        cbModalidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Modalidade :");

        btnModalidades.setText("Modalidades");
        btnModalidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModalidadesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtNome)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblNome)
                                    .addGap(195, 195, 195)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbModalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnModalidades))
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbModalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModalidades))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        // Toda essa sequencia de Strings seguido de Ifs ?? para verificar se os campos foram preenchidos

        String Nome=txtNome.getText();
        int TamanhoNome=Nome.length();

        if(TamanhoNome>=1){

            if(Cod==0){
                String Selecionado="Select codModalidade from modalidade where Nome ='"+ cbModalidade.getSelectedItem()+"'";
                
                String SQL="Insert into modelo(Nome,codModalidade)"+ " Values('" 
                + txtNome.getText() + "',("+Selecionado+"));";
                
                //System.out.print(SQL);
                this.c.SQLExecute(SQL);
                this.dispose();
                JOptionPane.showMessageDialog(this, "Cadastrado com sucesso");
            }
            else{
                 String Selecionado="Select codModalidade from modalidade where Nome ='"+ cbModalidade.getSelectedItem()+"'";
                
                String SQL= "Update modelo set Nome = '"+txtNome.getText()+"', CodModalidade=("+Selecionado+") where(Codmodelo= '"+Cod+"' )";
                
                //System.out.print(SQL);
                this.c.SQLExecute(SQL);
                this.dispose();
                JOptionPane.showMessageDialog(this, "Editado com sucesso");
            }

        }
        else{
            JOptionPane.showMessageDialog(this, "O Nome est?? muito pequeno.");
        }

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnModalidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModalidadesActionPerformed
        // TODO add your handling code here:
        
        new CaModalidade().setVisible(true);
        this.c.setComboBox(cbModalidade, "modalidade", "Nome");       

    }//GEN-LAST:event_btnModalidadesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnModalidades;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbModalidade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblNome;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
