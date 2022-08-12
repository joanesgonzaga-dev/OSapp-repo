/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Auxiliares;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author Joanes Gonzaga
 */
public class GerenciaJFrames {
    
    private StatusCadastro frameSatus;

    /**
     * @return the frameSatus
     */
    public StatusCadastro getFrameSatus() {
        return frameSatus;
    }

    /**
     * @param frameSatus the frameSatus to set
     */
    public void setFrameSatus(StatusCadastro frameSatus) {
        this.frameSatus = frameSatus;
    }
    
    public enum StatusCadastro{
        Inserindo,
        Navegando,
        Editando
    }
    
    public void posicionaFrame(JFrame frame){
        //Pode ser necessário definir para o método, parametros a serem passados como Largura (Width) e Altura (Height), caso os valores abaixo não se aplique a todas as resoluções
        Dimension tamanhoForm = new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width - 550, Toolkit.getDefaultToolkit().getScreenSize().height - 200);
        frame.setSize(tamanhoForm);
        frame.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - tamanhoForm.width)/2, ((Toolkit.getDefaultToolkit().getScreenSize().height - tamanhoForm.height)/2));
        
    }
    
    public static void posicionaJDialogs(JDialog dialogo){
         Dimension tamanhoForm = new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width - (Toolkit.getDefaultToolkit().getScreenSize().width - 650), Toolkit.getDefaultToolkit().getScreenSize().height - (Toolkit.getDefaultToolkit().getScreenSize().height - 520));
        dialogo.setSize(tamanhoForm);
        dialogo.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - tamanhoForm.width)/3, ((Toolkit.getDefaultToolkit().getScreenSize().height - tamanhoForm.height)/3));
        dialogo.setResizable(false);
        dialogo.setTitle(dialogo.getTitle());
    }
    
}
