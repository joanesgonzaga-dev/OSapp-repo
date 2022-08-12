/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Auxiliares;

import com.toedter.calendar.*;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;
import javax.swing.text.Element;
import javax.swing.text.PlainDocument;
import javax.swing.text.Position;
import javax.swing.text.Segment;

/**
 *
 * @author Joanes Gonzaga
 */
public class ManipulaComponentes {
    
    //O array foi criado aqui, pois como o método montaListTXT é chamado de forma recursiva, o mesmo recriava o array a cada iteração
    static ArrayList<JTextField> arrayTXT = new ArrayList<JTextField>();;

    public static void limpaCampos(Component[] meusComponentes) {
        for (Component comp : meusComponentes) {
            if (comp instanceof JTextField) {
                ((JTextField) comp).setText("");
            }
            //if(comp instanceof JComboBox) {
                //ItemCombo item = new ItemCombo();
            // ((JComboBox) comp).setSelectedIndex(-1);
         //  }
            //if(comp instanceof ButtonGroup)
            //{  
            //    ((ButtonGroup)comp).setSelected(false); //setSelected(false);
            //}
            if (comp instanceof JCheckBox){
                ((JCheckBox)comp).setSelected(false);
            }

            if (comp instanceof JTextArea) {
                ((JTextArea) comp).setText(null);
            }
            if (comp instanceof JDateChooser){
                Date dataAtual = new Date();
                ((JDateChooser)comp).setDate(dataAtual);
            }
            if (comp instanceof Container) {
                limpaCampos(((Container) comp).getComponents());
            }
        }

    }
    
    public   static void bloqueiaBarraDeEspaco(ArrayList<JTextField> campos){ 
       
        controleTXT(campos);
    }
    
    public static void liberaDocument(ArrayList<JTextField> camposDeTexto){
        
        for(final JTextField campo : camposDeTexto){
            
            if(campo instanceof com.toedter.calendar.JTextFieldDateEditor){
                continue;
            }
            
            else if(campo instanceof javax.swing.JFormattedTextField){
                continue;
            }
            
            else {
                campo.setDocument(new PlainDocument());
            }
        }   
        
    }
    
    private static void controleTXT(ArrayList<JTextField> camposDeTexto){
        
        for(final JTextField campo : camposDeTexto){
            
            if(campo instanceof com.toedter.calendar.JTextFieldDateEditor){
                continue;
            }
            
            else if(campo instanceof javax.swing.JFormattedTextField){
                continue;
            }
            
            else {
            
            campo.setDocument(new ControlarDigitacao("ALFANUMERICO", true, 0));
            }
        }       
    }
    
    private static ArrayList<JTextField> montaListTXT(Component[] componentes){

        for(Component componente : componentes){
            if (componente instanceof JTextField) {
                arrayTXT.add((JTextField)componente);
            }           
            if (componente instanceof Container) {
                montaListTXT(((Container) componente).getComponents());
            }
        }
        
        return arrayTXT;
    }

    public static void habilitaDesabilitaCampos(Component[] componentes, boolean status) {

        for (Component comp : componentes) {
            if (comp instanceof JTextField) {
                ((JTextField) comp).setEnabled(status);
            }
            if (comp instanceof JComboBox) {
                ((JComboBox) comp).setEnabled(status);
            }
            //if(comp instanceof ButtonGroup)
            //{  
            //    ((ButtonGroup)comp).setSelected(false); //setSelected(false);
            //}

            if (comp instanceof JTextArea) {
                ((JTextArea) comp).setEnabled(status);
            }
            if (comp instanceof Container) {
                habilitaDesabilitaCampos(((Container) comp).getComponents(), status);
            }
        }
    }

    public void validarCPF(){
        Pattern padrao;
    }
    
    public static boolean validarCamposObrigatorios(ArrayList<JTextField> camposAvaliados){
        boolean retorno = true;
        
        for (JTextField campo : camposAvaliados) {
                
                //JTextField campoTexto = (JTextField)campo;
                if( campo.getText().equals("") ){
                    retorno = false;
                }
        }       
        return retorno;
        
    }
    
    public static ArrayList<JTextField> retornaNomeCampoObrigatorioVazio(ArrayList<JTextField> camposAvaliados){
        
        ArrayList<JTextField> camposObrigatorios = new ArrayList<>();
        for (JTextField campo : camposAvaliados) {
                if( campo.getText().trim().equals("".trim()) ){
                    camposObrigatorios.add(campo);
                }
        }       
        
        return camposObrigatorios;
    }
    
    
    public static boolean validEmail(String email) {
    //System.out.println("Metodo de validacao de email");
    Pattern p = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]{2,7}$"); 
    Matcher m = p.matcher(email); 
    if (m.find()){
      //System.out.println("O email "+email+" e valido");
      return true;
    }
    else{
     //System.out.println("O E-mail "+email+" é inválido");
      return false;
    }  
 }
    public static void gerenciaBotoes(ArrayList<JButton> botoes, statusCadastro status) {

        for (JButton botao : botoes) {
            if (status == statusCadastro.Adicionando) {
                if (botao.getText().equals("Adicionar")) {
                    botao.setText("Gravar");
                    botao.setEnabled(true);
                } else if (botao.getText().equals("Editar")) {
                    botao.setText("Cancelar");
                    botao.setEnabled(true);
                } else if(botao.getText().equals("Buscar")){
                    botao.setEnabled(true);
                }
                else if(botao.getText().equals("Excluir")){
                    botao.setEnabled(false);
                }
                else if(botao.getText().equals("Sair")){
                    botao.setEnabled(false);
                }
            }
            else if(status == statusCadastro.Navegando){
                if(botao.getText().equals("Gravar")){
                    botao.setText("Adicionar");
                    botao.setEnabled(true);
                }
                else if(botao.getText().equals("Cancelar")){
                    botao.setText("Editar");
                    botao.setEnabled(true);
                }
                else{
                    botao.setEnabled(true);
                }
            }
            else if (status == statusCadastro.Editando){
                if(botao.getText().equals("Adicionar")){
                    botao.setText("Gravar");
                    botao.setEnabled(true);
                }
                else if(botao.getText().equals("Editar")){
                    botao.setText("Cancelar");
                    botao.setEnabled(true);
                }
                else if(botao.getText().equals("Buscar")){
                    botao.setEnabled(true);
                }
                else if(botao.getText().equals("Excluir")){
                    botao.setEnabled(false);
                }
                else if(botao.getText().equals("Sair")){
                    botao.setEnabled(false);
                }
            }
        }

    }

    public enum statusCadastro {

        Navegando,
        Adicionando,
        Editando
    }

}
