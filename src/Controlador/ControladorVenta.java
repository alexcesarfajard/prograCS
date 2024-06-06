package Controlador;

import Modelo.Autos;
import Modelo.Clientes;
import Modelo.ConsultaVenta;
import Modelo.ConsultasAutos;
import Modelo.ConsultasClientes;
import Modelo.Venta;
import VistaGUI.RegistroClientes;
import VistaGUI.frmVenta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ronny López Bravo y Alex Cesar Fajardo, Axel Arley
 */
public class ControladorVenta implements ActionListener {

    private final Clientes modCli;
    private final ConsultasClientes conCli;
    private final Autos modAut;
    private final ConsultasAutos conAut;
    private final frmVenta frmVenta;
    private final Venta modelo;
    private final ConsultaVenta consulta;

    DefaultTableModel modelotabla = new DefaultTableModel();

    public ControladorVenta(Clientes modCli, ConsultasClientes conCli, Autos modAut,
            ConsultasAutos conAut, frmVenta frmVenta, Venta modelo, ConsultaVenta consulta) {
        this.modCli = modCli;
        this.conCli = conCli;
        this.modAut = modAut;
        this.conAut = conAut;
        this.frmVenta = frmVenta;
        this.modelo = modelo;
        this.consulta = consulta;
        this.frmVenta.btnbuscarcliente.addActionListener(this);
        this.frmVenta.btnBuscarAuto.addActionListener(this);
        this.frmVenta.btnFacturar.addActionListener(this);
        this.frmVenta.btnEditar.addActionListener(this);
        this.frmVenta.btnBuscar.addActionListener(this);
        this.frmVenta.btnEliminar.addActionListener(this);
        this.frmVenta.btnCargar.addActionListener(this);
        this.frmVenta.btnLimpiar.addActionListener(this);
    }

    public void iniciar() {
        frmVenta.setTitle("Ventas");
        frmVenta.setLocationRelativeTo(null);
        frmVenta.txtnombrecli.setEditable(false);
        frmVenta.txtmarca.setEditable(false);
        frmVenta.txtModelo.setEditable(false);
        frmVenta.txtPrecio.setEditable(false);
        frmVenta.txtApellidos.setEditable(false);
        cargardatos(frmVenta.tblVenta);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Botón de buscar cliente
        if (e.getSource() == frmVenta.btnbuscarcliente) {
            modCli.setId(Integer.parseInt(frmVenta.txtidcliente.getText()));
            if (conCli.buscar(modCli)) {
                frmVenta.txtidcliente.setText(String.valueOf(modCli.getId()));
                frmVenta.txtnombrecli.setText(String.valueOf(modCli.getNombre()));
                frmVenta.txtApellidos.setText(String.valueOf(modCli.getApellidos()));
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ningún cliente");
            }
        } // fin de boton buscar cliente

        //boton de buscar auto
        if (e.getSource() == frmVenta.btnBuscarAuto) {
            modAut.setPlaca(frmVenta.txtplaca.getText());
            if (conAut.buscar(modAut)) {
                frmVenta.txtplaca.setText(String.valueOf(modAut.getPlaca()));
                frmVenta.txtmarca.setText(String.valueOf(modAut.getMarca()));
                frmVenta.txtModelo.setText(String.valueOf(modAut.getModelo()));
                frmVenta.txtPrecio.setText(String.valueOf(modAut.getPrecio()));
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ningún auto");
            }
        } // fin de boton buscar auto

        //boton de facturar
        if (e.getSource() == frmVenta.btnFacturar) {
            modelo.setIdcliente(Integer.parseInt(frmVenta.txtidcliente.getText()));
            modelo.setPlaca(frmVenta.txtplaca.getText());
            modelo.setPrecio(Double.parseDouble(frmVenta.txtpreciofinal.getText()));
            modelo.setFecha(frmVenta.txtfecha.getText());
            if (consulta.registrarVenta(modelo)) {
                JOptionPane.showMessageDialog(null, "Venta guardada con éxito");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al facturar");
                limpiar();
            }
        } // fin de boton guardar

        //boton de editar venta
        if (e.getSource() == frmVenta.btnEditar) {
            modelo.setId(Integer.parseInt(frmVenta.txtidventa.getText()));
            modelo.setIdcliente(Integer.parseInt(frmVenta.txtidcliente.getText()));
            modelo.setPlaca(frmVenta.txtplaca.getText());
            modelo.setFecha(frmVenta.txtfecha.getText());
            modelo.setPrecio(Double.parseDouble(frmVenta.txtpreciofinal.getText()));
            if (consulta.modificarventa(modelo)) {
                JOptionPane.showMessageDialog(null, "Registro modificado con exito");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar",
                        "Error", JOptionPane.ERROR_MESSAGE);
                limpiar();
            }
        }//fin de editar venta

        //Botón de eliminar
        if (e.getSource() == frmVenta.btnEliminar) {
            modelo.setId(Integer.parseInt(frmVenta.txtidventa.getText()));
            if (consulta.eliminar(modelo)) {
                JOptionPane.showMessageDialog(null, "Registro eliminado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar registro");
                limpiar();
            }
            limpiartabla();
        } // fin de eliminar

        //Botón de buscar
        if (e.getSource() == frmVenta.btnBuscar) {
            modelo.setId(Integer.parseInt(frmVenta.txtidventa.getText()));
            if (consulta.buscar(modelo)) {
                frmVenta.txtidventa.setText(String.valueOf(modelo.getId()));
                frmVenta.txtidcliente.setText(String.valueOf(modelo.getIdcliente()));
                frmVenta.txtplaca.setText(modelo.getPlaca());
                frmVenta.txtfecha.setText(modelo.getFecha());
                frmVenta.txtpreciofinal.setText(String.valueOf(modelo.getPrecio()));
                frmVenta.txtidventa.setEditable(false);
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ningún registro");
                limpiar();
            }
        } // fin de buscar

        //boton limpiar
        if (e.getSource() == frmVenta.btnLimpiar) {
            limpiar();
        }

        //boton cargar datos
        if (e.getSource() == frmVenta.btnCargar) {
            cargardatos(frmVenta.tblVenta);
        }

    } // fin de action performed

    public void limpiar() {
        frmVenta.txtidcliente.setText(null);
        frmVenta.txtnombrecli.setText(null);
        frmVenta.txtApellidos.setText(null);
        frmVenta.txtplaca.setText(null);
        frmVenta.txtmarca.setText(null);
        frmVenta.txtModelo.setText(null);
        frmVenta.txtPrecio.setText(null);
        frmVenta.txtfecha.setText(null);
        frmVenta.txtidventa.setText(null);
        frmVenta.txtpreciofinal.setText(null);
        frmVenta.txtidventa.setEditable(true);
        limpiartabla();
    }

    public void cargardatos(JTable tabla) {
        modelotabla = (DefaultTableModel) tabla.getModel();
        List<Venta> lista = consulta.cargardatos();
        Object[] object = new Object[5];

        for (int i = 0; i < lista.size(); i++) {
            object[0] = lista.get(i).getId();
            object[1] = lista.get(i).getIdcliente();
            object[2] = lista.get(i).getPlaca();
            object[3] = lista.get(i).getFecha();
            object[4] = lista.get(i).getPrecio();
            modelotabla.addRow(object);
        }
        frmVenta.tblVenta.setModel(modelotabla);
    } // fin de cargar datos

    public void limpiartabla() {
        int rows = frmVenta.tblVenta.getRowCount();
        for (int i = 0; i <= rows; i++) {
            modelotabla.removeRow(i);
            i = i - 1;
        }
    }
}
