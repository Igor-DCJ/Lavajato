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
public class CaProprietarios extends PaMostrarDados{

    public CaProprietarios() {
        this.setTitle("Proprietarios");//Setando o titulo da janela
        this.CamposMostrar =new String [] {"Código", "Nome", "CPF", "Endereço","Contato"  };//Os nomes das colunas da tabela que vão aparecer
        this.CamposTabela =new String [] {"CodProprietario", "Nome", "CPF","Endereco","Contatos"};//Os nomes que estão no Banco referentes ao seu lugar na tabela EXATAMENTE IGUAIS
        this.View= "proprietario";//Nome da tabela que vai pegar os dados
        this.Tabela= "proprietario";//Nome da tabela que vai pegar os dados
        this.CampoExclusao="Nome"; //Campo que identifica oqueSerá mostrado, Exp: tipo nome pode ser HP,Sony,Igor,Administrador
        
        
        
    }
    
    
    @Override
    protected void Entradas(int Codigo) {
        new CaCadastrarProprietario(Codigo).setVisible(true);
        
    }
    
    
}
