/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Configuracoes;

import java.io.IOException;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Joanes Gonzaga
 */
public class LerArquivoXML_BD {
   
    DocumentBuilderFactory dbf;
    DocumentBuilder db;
    Document documento;
    
    
     public String[] leArquivoXML(){
        
        String servidor = "";
        String banco = "";
        String porta = "";
        String usuario = "";
        String senha = "";
        
        
        dbf = DocumentBuilderFactory.newInstance();
        try{
        db = dbf.newDocumentBuilder();
            try{
            documento = db.parse("Configuracoes\\AcessoBD.xml");
            
            //Captura (Se localiza) na TAG superior (De abertura)
            Element elemento = documento.getDocumentElement();
            
            //Captura o item 0 do node Servidor para capturar o valor na TAG Servidor
            NodeList nodeListServidor = elemento.getElementsByTagName("Servidor");
            Element elementServidor = (Element)nodeListServidor.item(0);
            //Captura o valor de texto dentro da TAG Servidor
            servidor = elementServidor.getTextContent();
            
            NodeList nodeListBD = elemento.getElementsByTagName("Banco");
            Element elementoBanco = (Element)nodeListBD.item(0);
            banco = elementoBanco.getTextContent();
            
            NodeList nodeListPorta = elemento.getElementsByTagName("Porta");
            Element elementoPorta = (Element)nodeListPorta.item(0);
            porta = elementoPorta.getTextContent();
            
            NodeList nodeListUsuario = elemento.getElementsByTagName("User");
            Element elementoUsuario = (Element)nodeListUsuario.item(0);
            usuario = elementoUsuario.getTextContent();
            
            NodeList nodeListSenha = elemento.getElementsByTagName("Password");
            Element elementoSenha = (Element)nodeListSenha.item(0);
            senha = elementoSenha.getTextContent();
            
           // JOptionPane.showMessageDialog(this, servidor + ", " + banco + ", " + usuario + ", " + senha);
            
            }
            catch(IOException ex){
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            catch(SAXException ex){
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
        catch(ParserConfigurationException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
       String[] parametros = {servidor,banco,porta,usuario,senha};
        return parametros;
    }
    
}
