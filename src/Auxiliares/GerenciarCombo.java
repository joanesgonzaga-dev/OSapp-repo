/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Auxiliares;

import java.sql.ResultSet;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author Joanes Gonzaga
 */
public class GerenciarCombo {
    
    
    public static boolean preencherCombo(ResultSet rs, String indice, String descricao, JComboBox cb){
        try {
            DefaultComboBoxModel<ItemCombo> model = new DefaultComboBoxModel<ItemCombo>();
            while(rs.next()){
                ItemCombo item = new ItemCombo();
                item.setIndice(rs.getObject(indice));
                item.setDescricao(rs.getString(descricao));
                
                model.addElement(item);
            }
            
            cb.setModel(model);
            
        } catch (Exception e) {
            return false;
        }
        
        return true;
    }
    
    public static void setarOpcaocombo(JComboBox combo, Object meuObj){
        ComboBoxModel meuCombo = combo.getModel();
        
        for (int i = 0; i < meuCombo.getSize(); i++) {
            
            ItemCombo item = (ItemCombo)meuCombo.getElementAt(i);
            
                
                if(item.getDescricao().trim().equals(meuObj.toString().trim())){
                    combo.setSelectedIndex(i);
                }
            
        }
        
        
    }
    
    public static void setarOpcaocomboIndice(JComboBox combo, Object meuObj){
        ComboBoxModel meuCombo = combo.getModel();
        
        for (int i = 0; i < meuCombo.getSize(); i++) {
            
            ItemCombo item = (ItemCombo)meuCombo.getElementAt(i);
            
                
                if(item.getIndice().equals(meuObj.toString().trim())){
                    combo.setSelectedIndex(i);
                }
            
        }
        
        
    }
}
