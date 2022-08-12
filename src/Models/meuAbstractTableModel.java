/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Models;

import Entidades.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Joanes Gonzaga
 */
public class meuAbstractTableModel extends AbstractTableModel {
    
    List minhaLista;
    
    public meuAbstractTableModel(List lista){
        minhaLista = new ArrayList();
        minhaLista.addAll(lista);
        
    }

    @Override
    public int getRowCount() {
       return minhaLista.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }
    
    @Override
    public String getColumnName(int column){
        
        if(column == 0){
            return "Código";
        }
        else if(column == 1){
            return "CPF/CNPJ";
        }
        else if(column == 2){
            return "Nome";
        }
        else if (column == 3){
            return "Nome Fantasia";
        }
        
        else if (column == 4){
            return "ENDEREÇO";
        }
        else if(column == 5){
            return "Fone Principal";
        }
        else{
            return "";
        }
            
    }
    
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       Cliente cliente = (Cliente)minhaLista.get(rowIndex);
        
        if(columnIndex == 0){
            return cliente.getCodigo();
        }
        else if (columnIndex == 1){
            return cliente.getCpf();
        }
        else if(columnIndex == 2){
            return cliente.getNome();
        }
        else if(columnIndex == 3){
            return cliente.getNomeFantasia();
        }
        else if(columnIndex == 4){
            return cliente.getLogradouro();
        }
        else if(columnIndex == 5){
            return cliente.getFonePrincipal();
        }
        
        else{
            return "";
        }
        
    }
    
    
    
    public void inserir(Cliente c){
        minhaLista.add(c);
        fireTableDataChanged();
    }
    
    public void limpar(){
        minhaLista.clear();
        fireTableDataChanged();
    }
    
    
    
}
