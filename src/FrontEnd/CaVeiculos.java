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
public class CaVeiculos extends PaMostrarDados{

    public CaVeiculos() {
        
        this.setTitle("Veículos");//Setando o titulo da janela
        this.CamposMostrar =new String [] {"Placa", "Modelo","Cor", "Proprietario"};//Os nomes das colunas da tabela que vão aparecer
        this.CamposTabela =new String [] {"Placa", "CodModelo", "CodCor","CodProprietario"};//Os nomes que estão no Banco referentes ao seu lugar na tabela EXATAMENTE IGUAIS ao que está na view que vierem
        this.View= "veiculo";//Nome da view que vai pegar os dados
        this.Tabela= "veiculo";//Nome da tabela que vai pegar os dados
        this.CampoExclusao="Placa"; //Campo que identifica oqueSerá mostrado, Exp: tipo nome pode ser HP,Sony,Igor,Administrador
        
        
        
    }    
    
    
    
    @Override
    protected void Entradas(int Codigo) {
       // new CaCadastrarVeiculos(Codigo).setVisible(true);
    }
    
}
