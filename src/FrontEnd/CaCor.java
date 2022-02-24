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
public class CaCor extends PaMostrarDados{
    
    
    public CaCor() {
        
        this.setTitle("Cores");//Setando o titulo da janela
        this.CamposMostrar =new String [] {"Código", "Nome"};//Os nomes das colunas da tabela que vão aparecer
        this.CamposTabela =new String [] {"CodCor", "Nome"};//Os nomes que estão no Banco referentes ao seu lugar na tabela EXATAMENTE IGUAIS
        this.View= "cor";//Nome da tabela que vai pegar os dados
        this.Tabela= "cor";//Nome da tabela que vai pegar os dados
        this.CampoExclusao="Nome"; //Campo que identifica oqueSerá mostrado, Exp: tipo nome pode ser HP,Sony,Igor,Administrador
        
        
        
    }    
    
    
    
    @Override
    protected void Entradas(int Codigo) {
        new CaCadastrarCor(Codigo).setVisible(true);
    }
    
}
