/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Configuracoes;
import java.sql.*;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author Joanes Gonzaga
 */
public class Conexao {
  
    public Connection con = null;
    String servidor;
    String banco;
    String porta;
    String usuario;
    String senha;
    
    public Connection conectar(String parametros[]){
        
        
        this.servidor = parametros[0];
        this.banco = parametros[1];
        this.porta = parametros[2];
        this.usuario = parametros[3];
        this.senha = parametros[4];
        
        
        try{    
        Class.forName("net.sourceforge.jtds.jdbc.Driver");
        String strConexao = "jdbc:jtds:sqlserver://" + this.servidor + ":" + this.porta + ";databaseName=" + this.banco + ";user="+this.usuario+";password="+this.senha;
        
            try{
                con = DriverManager.getConnection(strConexao);               
                }
            catch(SQLException ex){
                
                JOptionPane.showConfirmDialog(null, ex.getMessage());
                // LogApp.Log(ex, true);
            }
        }
        
        catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        
        return con; 
    }
    
    public void desconecta(Connection con){
        
        this.con = con;
        
        try{
        this.con.close();
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Ocorreu um arro ao tentar fechar a conexão!: " + '\n' + ex.getMessage());
        }
    }
}
