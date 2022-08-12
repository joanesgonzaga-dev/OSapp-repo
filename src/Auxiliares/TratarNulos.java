/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Auxiliares;

/**
 *
 * @author dti
 * @param <T>
 */
public class TratarNulos<T> {

    
    public T Tratar(T Valor, T ValorPadrao)
    {
        T Retorno=null;

        if(Valor==null)        
            Retorno = ValorPadrao;        
        else        
            Retorno=Valor;
        
       return Retorno;
    }
}
