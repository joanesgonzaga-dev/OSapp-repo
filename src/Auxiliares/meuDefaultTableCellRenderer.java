/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Auxiliares;

import java.awt.Color;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Joanes Gonzaga
 */
public class meuDefaultTableCellRenderer extends DefaultTableCellRenderer {
    
    public meuDefaultTableCellRenderer(){
        super();
        setHorizontalAlignment(RIGHT);
    }

    @Override
    protected void setValue(Object value) {
        
        super.setValue(value); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Fui carregado!");
    }
    
    

    @Override
    public void setBackground(Color c) {
        
        super.setBackground(c); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
