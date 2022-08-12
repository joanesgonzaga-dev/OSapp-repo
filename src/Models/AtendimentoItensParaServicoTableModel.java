/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Entidades.Atendimento;
import Entidades.ItemParaServico;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Joanes Gonzaga
 */
public class AtendimentoItensParaServicoTableModel extends AbstractTableModel {

    List items;

    public AtendimentoItensParaServicoTableModel(List listaDeItens) {
        items = new ArrayList();
        items.addAll(listaDeItens);
    }

    @Override
    public int getRowCount() {
        return items.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        ItemParaServico item = (ItemParaServico) items.get(rowIndex);

        if (columnIndex == 0) {
            return rowIndex + 1;
        } else if (columnIndex == 1) {
            return item.getDescricao();
        } else if (columnIndex == 2) {
            return item.getFabricante();
        } else if (columnIndex == 3) {
            return item.getModelo();
        } else if (columnIndex == 4) {
            return item.getNumeroSerie();
        } else if (columnIndex == 5) {
            return item.getCampoLivre();
        } else if (columnIndex == 6) {
            return item.getAno1();
        } else {
            return "";
        }
    }

    public String getColumnName(int columnIndex) {

        if (columnIndex == 0) {
            return "Item";
        } else if (columnIndex == 1) {
            return "Descrição do Item";
        } else if (columnIndex == 2) {
            return "Marca/Fabricante";
        } else if (columnIndex == 3) {
            return "Modelo";
        } else if (columnIndex == 4) {
            return "Número de Série";
        } else if (columnIndex == 5) {
            return "Campo Livre";
        } else if (columnIndex == 6) {
            return "Ano";
        } else {
            return "";
        }
    }

    public void inserir(ItemParaServico itemInserido) {
        items.add(itemInserido);
        fireTableDataChanged();
    }

    public void remover(int rowIndex) {

        items.remove(rowIndex);
        fireTableDataChanged();
    }

    public void limparLista() {
        items.clear();
        fireTableDataChanged();
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return false;
        } else {
            return true;
        }
    }

    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        ItemParaServico item = (ItemParaServico) items.get(rowIndex);

        if (columnIndex == 1) {
            item.setDescricao(aValue.toString());

        } else if (columnIndex == 2) {
            

        } else if (columnIndex == 3) {

        } else if (columnIndex == 4) {

        } else if (columnIndex == 5) {

        } else if (columnIndex == 6) {

        } else {

        }

    }

}
