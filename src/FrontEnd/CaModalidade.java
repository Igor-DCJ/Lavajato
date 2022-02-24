/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrontEnd;

import BackEnd.PaMostrarDados;

/**
 *
 * @author Igor
 */
public class CaModalidade extends PaMostrarDados{

 public CaModalidade() {
        
        this.setTitle("Modalidades");//Setando o titulo da janela
        this.CamposMostrar =new String [] {"Código", "Nome"};//Os nomes das colunas da tabela que vão aparecer
        this.CamposTabela =new String [] {"CodModalidade", "Nome"};//Os nomes que estão no Banco referentes ao seu lugar na tabela EXATAMENTE IGUAIS
        this.View= "modalidade";//Nome da tabela que vai pegar os dados
        this.Tabela= "modalidade";//Nome da tabela que vai pegar os dados
        this.CampoExclusao="Nome"; //Campo que identifica oqueSerá mostrado, Exp: tipo nome pode ser HP,Sony,Igor,Administrador
        
        
        
    }    
    
    
    
    @Override
    protected void Entradas(int Codigo) {
        new CaCadastrarModalidade(Codigo).setVisible(true);
    }    
    
}
