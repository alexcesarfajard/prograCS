package VistaGUI;

import Controlador.ControladorAutos;
import Controlador.ControladorClientes;
import Controlador.ControladorVenta;
import Controlador.ControladorVentas;
import Modelo.Autos;
import Modelo.Clientes;
import Modelo.ConsultaVenta;
import Modelo.Ventas;
import Modelo.ConsultasAutos;
import Modelo.ConsultasClientes;
import Modelo.ConsultasVentas;
import Modelo.Venta;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronny López Bravo y Alex Cesar Fajardo
 */

public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mitRegistoClientes = new javax.swing.JMenuItem();
        mitRegistroAutos = new javax.swing.JMenuItem();
        mitRegistroVentas = new javax.swing.JMenuItem();
        mitSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menú Principal");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 204));
        jLabel1.setText("Venta de Autos Usados Arley");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/carro.png"))); // NOI18N

        jMenu1.setText("Opciones");

        mitRegistoClientes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mitRegistoClientes.setText("Registro Clientes");
        mitRegistoClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitRegistoClientesActionPerformed(evt);
            }
        });
        jMenu1.add(mitRegistoClientes);

        mitRegistroAutos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mitRegistroAutos.setText("Registro Autos");
        mitRegistroAutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitRegistroAutosActionPerformed(evt);
            }
        });
        jMenu1.add(mitRegistroAutos);

        mitRegistroVentas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mitRegistroVentas.setText("Registro de Venta");
        mitRegistroVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitRegistroVentasActionPerformed(evt);
            }
        });
        jMenu1.add(mitRegistroVentas);

        mitSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mitSalir.setText("Salir");
        mitSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitSalirActionPerformed(evt);
            }
        });
        jMenu1.add(mitSalir);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Acerca de");

        jMenuItem1.setText("Acerca de");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(0, 36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mitSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitSalirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_mitSalirActionPerformed

    private void mitRegistoClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitRegistoClientesActionPerformed
        Clientes client = new Clientes();
        ConsultasClientes clientC = new ConsultasClientes();
        RegistroClientes frmClientes = new RegistroClientes();
        ControladorClientes ctrlclient = new ControladorClientes(client, clientC, frmClientes);
        ctrlclient.iniciar();
        frmClientes.setVisible(true);
    }//GEN-LAST:event_mitRegistoClientesActionPerformed

    private void mitRegistroAutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitRegistroAutosActionPerformed
        Autos au = new Autos();
        ConsultasAutos auConsulta = new ConsultasAutos();
        RegistroAutos frmAutos = new RegistroAutos();
        ControladorAutos ctrlAutos = new ControladorAutos(au, auConsulta, frmAutos);
        ctrlAutos.iniciar();
        frmAutos.setVisible(true);
    }//GEN-LAST:event_mitRegistroAutosActionPerformed

    private void mitRegistroVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitRegistroVentasActionPerformed
        /*
        Ventas venta = new Ventas();
        ConsultasVentas ventaC = new ConsultasVentas();
        RegistroVentas frmCaja = new RegistroVentas();
        ControladorVentas ctrlventas = new ControladorVentas(venta, ventaC, frmCaja);
        ctrlventas.iniciar();
        frmCaja.setVisible(true);*/
        
        Venta v = new Venta();
        ConsultaVenta conVenta = new ConsultaVenta();
        frmVenta frmCaja = new frmVenta();
        Clientes modCli = new Clientes();
        ConsultasClientes conCli = new ConsultasClientes();
        Autos modAut = new Autos();
        ConsultasAutos conAut = new ConsultasAutos();
        
        
        ControladorVenta ctrlVenta = new ControladorVenta(modCli, conCli, modAut, conAut, frmCaja, v, conVenta);
        
        ctrlVenta.iniciar();
        frmCaja.setVisible(true);
        frmCaja.setLocationRelativeTo(null);
        
    }//GEN-LAST:event_mitRegistroVentasActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Esta aplicación ha sido desarrollada por el grupo 3"
                + " de la clase Programación Cliente Servidor\n"
                + "Realizado por: \n-Alex Cesar Fajardo\n-Ronny Lopez Bravo\n-Axel Arley Andia", "Información", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem mitRegistoClientes;
    private javax.swing.JMenuItem mitRegistroAutos;
    private javax.swing.JMenuItem mitRegistroVentas;
    private javax.swing.JMenuItem mitSalir;
    // End of variables declaration//GEN-END:variables
}
