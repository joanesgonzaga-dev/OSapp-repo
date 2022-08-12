/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Configuracoes.DAO;
import Entidades.Atendimento;
import Entidades.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Joanes Gonzaga
 */
public class AtendimentoFacade {

    public int retornaChaveUnica(Atendimento atendimento) {
        int chave = 0;
        ResultSet rschave = null;

        String strSQLInsert = "INSERT INTO atendimento(dataentrada) VALUES(?)";
        Connection con = DAO.getConexao();
        try {
            PreparedStatement pstm = con.prepareStatement(strSQLInsert, Statement.RETURN_GENERATED_KEYS);
            java.sql.Date sqlData = new java.sql.Date(atendimento.getDataEntrada().getTime());
            pstm.setDate(1, sqlData);
            pstm.execute();
            
                rschave = pstm.getGeneratedKeys();
                if (rschave.next()) {
                    chave = rschave.getInt(1);  
                }

        } catch (SQLException ex) {
            Logger.getLogger(AtendimentoFacade.class.getName()).log(Level.SEVERE, null, ex);
        }

        return chave;
    }
    
    public int insereClienteNoAtendimento(Cliente cliente,Atendimento atendimento){
        int retorno = 0;
        Connection conCliente = DAO.getConexao();
        String strSQLClienteAtendimento = "UPDATE atendimento SET codcliente=?, nomecliente=? WHERE codigo=?";
        try {
            PreparedStatement pstmCliente = conCliente.prepareStatement(strSQLClienteAtendimento);
            pstmCliente.setInt(1, cliente.getCodigo());
            pstmCliente.setString(2, cliente.getNome());
            pstmCliente.setInt(3, atendimento.getCodigo());
            
            retorno = pstmCliente.executeUpdate();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            retorno = 0;
        }
        catch(NullPointerException ex){
            JOptionPane.showMessageDialog(null, ex);
            retorno = 0;
        }
        
        return retorno;
        
    }

}
