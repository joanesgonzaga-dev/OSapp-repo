/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Configuracoes;

import Formularios.frmMenuPrincipal;
//import dinnamus_os.frmLogin;
import javax.swing.JOptionPane;

/**
 *
 * @author Joanes Gonzaga
 */
public class Inicializacao {
    
    
    
    public static boolean iniciarApp(){
        boolean retorno = true;
        
        /*
        if(LogApp.Iniciar() == true){
            LogApp.Info("DinnamuS OS foi Iniciado Corretamente");
            if(DAO.getConexao() != null){
                    retorno = true;
            }
            
        }*/
        return retorno;
    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        /*
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        */
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              if(Inicializacao.iniciarApp()){
                  frmMenuPrincipal menu = new frmMenuPrincipal();
                  menu.setVisible(true);
              }
              else{
                  JOptionPane.showMessageDialog(null, "Não Foi Possível Iniciar a Aplicação" );
                  System.exit(0);
              }
            }
        });
    }
}
