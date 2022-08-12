/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Auxiliares;

import org.jdesktop.beansbinding.Converter;

/**
 *
 * @author Joanes Gonzaga
 */
public class ConverterIntegerEmItemCombo extends Converter<Integer, ItemCombo>{

    @Override
    public ItemCombo convertForward(Integer value) {
        ItemCombo i = new ItemCombo();
        i.setDescricao("");
        i.setIndice(value);
        return i;
    }

    @Override
    public Integer convertReverse(ItemCombo value) {
        return Integer.valueOf(value.getIndice().toString());
    }
    
    
}
