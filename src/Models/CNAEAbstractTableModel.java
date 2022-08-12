/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Models;

import Configuracoes.DAO;
import Entidades.CNAE;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Joanes Gonzaga
 */
public class CNAEAbstractTableModel extends AbstractTableModel {
    
    List minhaLista;
    
    public CNAEAbstractTableModel(List lista){
        
        minhaLista = new ArrayList();
        minhaLista.addAll(lista);
        
    }

    @Override
    public int getRowCount() {
        return minhaLista.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        CNAE cnae = (CNAE)minhaLista.get(rowIndex);
        if(columnIndex == 0){
            return cnae.getCnae();
        }
        else if(columnIndex == 1){
            return cnae.getCnaeDescricao();
        }
        else{
            return "";
        }
    }
    
    @Override
    public String getColumnName(int column){
        
        if(column == 0){
            return "Cód. CNAE";
        }
        else if(column == 1){
            return "Descrição";
        }
        else{
            return "";
        }
    }
    
    public void inserir(CNAE meuCNAE){
        minhaLista.add(meuCNAE);
        fireTableDataChanged();
    }
    
    public void limpar(){
        minhaLista.clear();
        fireTableDataChanged();
    }
    
    public int excluir(int rowIndex, int colIndex){
        int retorno = 0;
        Connection cn = DAO.getConexao();
        try {
            PreparedStatement pstm = cn.prepareStatement("DELETE FROM cnae WHERE codigo=" + getValueAt(rowIndex, colIndex));
            retorno = pstm.executeUpdate();
            if(retorno > 0){
                minhaLista.remove(rowIndex);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Deu merda! " + ex.getMessage());
            return retorno;
        }
        return retorno;
    }
    
}
