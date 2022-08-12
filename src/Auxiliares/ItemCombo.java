/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Auxiliares;

/**
 *
 * @author Joanes Gonzaga
 */
public class ItemCombo {
   
    private Object indice;
    private String descricao;
    

    /**
     * @return the indice
     */
    public Object getIndice() {
        return indice;
    }

    /**
     * @param indice the indice to set
     */
    public void setIndice(Object indice) {
        this.indice = indice;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public String toString(){
        
        return getDescricao();
    }
    
}
