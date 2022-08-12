/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Facade;

import Configuracoes.DAO;
import Entidades.ItemParaServico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joanes Gonzaga
 */
public class ItemParaServicoFacade {
    
   
    
    public static int inserirItemNoAtendimento(ItemParaServico itemInserido, int chaveUnicaAtendimento,int itemNagrade){
         int retornoInsert = 0;
        ItemParaServico item = itemInserido;
        Connection con = DAO.getConexao();
        String strSQLInsertItem = "INSERT INTO itensparaservico(codigo,item,nomeitem,qt,tamanho,cor,fabricante) VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement pstm = con.prepareStatement(strSQLInsertItem);
            pstm.setInt(1, chaveUnicaAtendimento);
            pstm.setInt(2,itemNagrade);
            //pstm.setInt(3, item.getIdUnico());
            pstm.setString(3,item.getDescricao());
            pstm.setInt(4, 0);
            pstm.setString(5, null);
            pstm.setString(6, null);
            pstm.setString(7, item.getFabricante());
            
            retornoInsert =  pstm.executeUpdate();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ItemParaServicoFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retornoInsert;
        
    }
}
