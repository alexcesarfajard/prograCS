package Controlador;

import Modelo.Ventas;
import Modelo.ConsultasVentas;
import VistaGUI.RegistroVentas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronny López Bravo y Alex Cesar Fajardo, Axel Arley
 */
public class ControladorVentas implements ActionListener {

    private final Ventas modelo;
    private final ConsultasVentas consultas;
    private final RegistroVentas vista;

    public ControladorVentas(Ventas modelo, ConsultasVentas consultas, RegistroVentas vista) {
        this.modelo = modelo;
        this.consultas = consultas;
        this.vista = vista;
        this.vista.btnAgregar.addActionListener(this);
        this.vista.btnEditar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.btnLimpiar.addActionListener(this);
        this.vista.btnBuscar.addActionListener(this);
    }

    public void iniciar() {
        vista.setTitle("Ventas");
        vista.setLocationRelativeTo(null);
        vista.txtIDCliente.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Botón de guardar
        if (e.getSource() == vista.btnAgregar) {
            modelo.setId(Integer.parseInt(vista.txtIDCliente.getText()));
            modelo.setNombre(vista.txtNombreCliente.getText());
            modelo.setApellidos(vista.txtApellidosCliente.getText());
            modelo.setCorreo(vista.txtCorreoCliente.getText());
            modelo.setMarca(vista.txtMarcaAuto.getText());
            modelo.setModelo(vista.txtModeloAuto.getText());
            modelo.setAño(Integer.parseInt(vista.txtAñoAuto.getText()));
            modelo.setPrecio(Double.parseDouble(vista.txtPrecioAuto.getText()));
            modelo.setPlaca(vista.txtPlacaAuto.getText());
            if (consultas.registrar(modelo)) {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar registro");
                limpiar();
            }
        }
        //Botón de modificar
        if (e.getSource() == vista.btnEditar) {

            modelo.setId(Integer.parseInt(vista.txtIDCliente.getText()));
            modelo.setNombre(vista.txtNombreCliente.getText());
            modelo.setApellidos(vista.txtApellidosCliente.getText());
            modelo.setCorreo(vista.txtCorreoCliente.getText());
            modelo.setMarca(vista.txtMarcaAuto.getText());
            modelo.setModelo(vista.txtModeloAuto.getText());
            modelo.setAño(Integer.parseInt(vista.txtAñoAuto.getText()));
            modelo.setPrecio(Double.parseDouble(vista.txtPrecioAuto.getText()));
            modelo.setPlaca(vista.txtPlacaAuto.getText());
            if (consultas.modificar(modelo)) {
                JOptionPane.showMessageDialog(null, "Registro modificado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar");
                limpiar();
            }
        }
        //Botón de eliminar
        if (e.getSource() == vista.btnEliminar) {
            modelo.setId(Integer.parseInt(vista.txtIDCliente.getText()));
            if (consultas.eliminar(modelo)) {
                JOptionPane.showMessageDialog(null, "Registro eliminado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar");
                limpiar();
            }
        }

        //Botón de buscar
        if (e.getSource() == vista.btnBuscar) {
            modelo.setId(Integer.parseInt(vista.txtIDCliente.getText()));
            if (consultas.buscar(modelo)) {
                vista.txtIDCliente.setText(String.valueOf(modelo.getId()));
                vista.txtNombreCliente.setText(modelo.getNombre());
                vista.txtApellidosCliente.setText(modelo.getApellidos());
                vista.txtCorreoCliente.setText(modelo.getCorreo());
                vista.txtMarcaAuto.setText(modelo.getMarca());
                vista.txtModeloAuto.setText(modelo.getModelo());
                vista.txtAñoAuto.setText(String.valueOf(modelo.getAño()));
                vista.txtPrecioAuto.setText(String.valueOf(modelo.getPrecio()));
                vista.txtPlacaAuto.setText(modelo.getPlaca());
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ningún registro");
                limpiar();
            }
        }
        //boton limpiar
        if (e.getSource() == vista.btnLimpiar) {
            limpiar();
        }
    }

    public void limpiar() {
        
        vista.txtIDCliente.setText(null);
        vista.txtNombreCliente.setText(null);
        vista.txtApellidosCliente.setText(null);
        vista.txtCorreoCliente.setText(null);
        vista.txtMarcaAuto.setText(null);
        vista.txtModeloAuto.setText(null);
        vista.txtAñoAuto.setText(null);
        vista.txtPrecioAuto.setText(null);
        vista.txtPlacaAuto.setText(null);

    }

}
