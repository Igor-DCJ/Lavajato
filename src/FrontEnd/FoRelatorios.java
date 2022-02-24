/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrontEnd;


import BackEnd.ConexaoMySQL;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Igor
 */
public class FoRelatorios extends javax.swing.JDialog {
    
    
    private ConexaoMySQL c;
    private String[] CamposMostrar;
    private String[] CamposTabela;
    private String View;

    

    /**
     * Creates new form PaRelatorios
     */
    public FoRelatorios(String titulo, String[] Campos,String[] Campostabela, String view) {
        initComponents();
        
        this.setModal(true);
        this.c = new ConexaoMySQL();
        CamposMostrar=Campos;
        CamposTabela=Campostabela;
        
        View=view;
        this.setTitle(titulo);
        
        
    }
    
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
            //System.out.print(this.c.getResultSet().getObject("Nome"));
            
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
    
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        grdDados = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1238, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        
        this.setGrid();    
         this.setPreencherGrid();
         
         
    }//GEN-LAST:event_formWindowOpened

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable grdDados;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
