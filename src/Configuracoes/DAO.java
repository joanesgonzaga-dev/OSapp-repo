/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Configuracoes;

import java.sql.Connection;

/**
 *
 * @author Joanes Gonzaga
 */
public class DAO {

    private static Conexao conexao = null;

    /**
     * @return the conexao
     */
    
    public static Connection getConexao() {
        if(conexao == null){
           conexao = new Conexao();
           conexao.conectar(new LerArquivoXML_BD().leArquivoXML());
           
        }
        
        return conexao.con;
    }

}
