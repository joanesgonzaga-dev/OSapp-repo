/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Auxiliares;

import java.awt.Component;
import org.jdesktop.beansbinding.Converter;


/**
 *
 * @author Fernando
 */
public class beansbind {
    public  static <T> void BindAuto(Component j, T t, String Campo, String Propriedade ){
        BindAuto(j, t, Campo, Propriedade,null);
    }
     public  static <T> void BindAuto(Component j, T t, String Campo, String Propriedade, Converter c){
         try {
                                 
             org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(
                    org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, 
                    t, org.jdesktop.beansbinding.ELProperty.create("${"+ Campo  +"}"), 
                    j, 
                    org.jdesktop.beansbinding.BeanProperty.create(Propriedade), 
                    Campo);
             
            if(c!=null){
                binding.setConverter(c);
            }
            binding.bind();
             
         } catch (Exception e) {
            // LogDinnamus.Log(e, true);
         }
        
    }
}
