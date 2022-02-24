/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrontEnd;

import BackEnd.PaMostrarDados;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Igor
 */
public class CaFuncionarios extends PaMostrarDados{
    
    public CaFuncionarios(){
        
        this.setTitle("Funcionários");//Setando o titulo da janela
        this.CamposMostrar =new String [] {"Código", "Nome", "CPF", "Usuário","Tipo de Conta"  };//Os nomes das colunas da tabela que vão aparecer
        this.CamposTabela =new String [] {"CodFuncionario", "Nome", "CPF","Usuario","IsAdministrador"};//Os nomes que estão no Banco referentes ao seu lugar na tabela EXATAMENTE IGUAIS
        this.View= "listarFuncionario";//Nome da view que vai pegar os dados
        this.Tabela= "funcionario";//Nome da tabela que vai pegar os dados
        this.CampoExclusao="Nome"; //Campo que identifica oqueSerá mostrado, Exp: tipo nome pode ser HP,Sony,Igor,Administrador
        
    }

    @Override
    protected void Entradas(int Codigo) {
        new CaCadastrarFuncionar(Codigo).setVisible(true);
        
    }
    

    
    
}
