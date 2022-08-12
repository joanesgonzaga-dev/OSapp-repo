/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Auxiliares;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author dti
 */
public class ControlarDigitacao extends PlainDocument {
     private String TipoValidacao;
     boolean  bUsarPonto=false;
     private int TamanhoCampo=0;
     
     public ControlarDigitacao(String cTipoValidacao)
     {
        super();
        setTipoValidacao(cTipoValidacao);
        
     }
     public ControlarDigitacao(String cTipoValidacao, boolean  UsarPonto, int TamanhoCampo){
        super();
        this.bUsarPonto = UsarPonto;
        this.TamanhoCampo = TamanhoCampo;
        setTipoValidacao(cTipoValidacao);
     }
     public ControlarDigitacao(String cTipoValidacao, boolean  UsarPonto)
     {
        super();
        this.bUsarPonto = UsarPonto;
        setTipoValidacao(cTipoValidacao);
        
     }
     public void replace(int offs, String str, AttributeSet a) throws BadLocationException   {
         super.insertString(offs, str.toUpperCase(), a);
     }
     @Override
     public void insertString(int offs, String str, AttributeSet a)   
          throws BadLocationException {   

          for (char c : str.toCharArray())   
          {
               
               if(TipoValidacao.equalsIgnoreCase("ALFANUMERICO") )
               {
                    if(c!=' ' && !Character.isDigit(c) && !Character.isLetter(c) &&  (bUsarPonto ? (c!='.') : true )  )
                    {
                        return;
                    }
                    
                    else{
                  
                    if(offs==0 && c== ' '){
                        return;
                    }
                    }
                    
               }else if(TipoValidacao.equalsIgnoreCase("NUMERICO") ){
                    if(!Character.isDigit(c))
                    {
                        return;
                    }               
               }
               if(TamanhoCampo>0){
                   if( str.length() + getLength() > TamanhoCampo){
                       return;
                   }                       
               }
          }   
         
          super.insertString(offs, str.toUpperCase(), a);
      }

    /**
     * @return the TipoValidacao
     */
    public String getTipoValidacao() {
        return TipoValidacao;
    }

    /**
     * @param TipoValidacao the TipoValidacao to set
     */
    public void setTipoValidacao(String TipoValidacao) {
        this.TipoValidacao = TipoValidacao;
    }
}


