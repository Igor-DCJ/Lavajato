package BackEnd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Henrique
 */

public class ConexaoMySQL {
    private Statement stmt; //executar consultas DML
    private ResultSet rs; //gerenciar consultas DQL
    private Connection c;         

    public ConexaoMySQL() {
        String Database = "psc_igordias";
        String user = "igordias";
        String password = "trab-85-wawp-";
        
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://psc-igordias.mysql.uhserver.com:3306/" + Database;
        
        //Abrir conexão
        try {            
            Class.forName(driver).newInstance();                               
            c = DriverManager.getConnection(url, user, password);            
            stmt = c.createStatement();              
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na conexão MySQL");            
            JOptionPane.showMessageDialog(null, e);
            JOptionPane.showMessageDialog(null, "A aplicação será finalizada...");
            System.exit(0); //Finalizar a aplicação
        }              
    }    
    
    public boolean SQLExecute(String SQL) {
        try {
            this.stmt.execute(SQL);
            return true;
        }
        catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }        
    }

    public boolean setResultSet(String Query) {
        try {
            this.rs = this.stmt.executeQuery(Query);
            return true;
        }
        catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }                
    }             
    
    public ResultSet getResultSet() {
        return rs;
    }
    
    public void setComboBox(JComboBox ComboBox,String Table, String Field){
        try{
            ComboBox.removeAllItems();
            String SQL ="SELECT DISTINCT "+Field+" FROM "+Table+" ORDER BY "+Field;
            this.setResultSet(SQL);
            if(this.rs.next()){
                do{
                    ComboBox.addItem(rs.getString(Field));
                    
                }while(rs.next());
                ComboBox.setSelectedIndex(-1);
            }
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    public String getCodigoFromComboBox(JComboBox ComboBox,String Table, String Field,String CodigoNome){
        String Codigo="null";
        if(ComboBox.getItemCount()>0 && ComboBox.getSelectedIndex() != -1){
            String SQL ="Select "+CodigoNome+" from "+Table+" Where "+Field+" like '"+ComboBox.getSelectedItem().toString()+"'";
            
            try{
                this.setResultSet(SQL);
                
                if(this.rs.first()){
                    Codigo=this.rs.getString(CodigoNome);
                }
            }
            catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
        } 
    }
    return Codigo;
          
    }
}