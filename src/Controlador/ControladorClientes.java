package Controlador;

import Excepciones.ExcepcionesPersonalizadas;
import Modelo.Clientes;
import Modelo.ConsultasClientes;
import VistaGUI.RegistroClientes;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
/**
 *
 * @author Ronny López Bravo y Alex Cesar Fajardo, Axel Arley
 */
public class ControladorClientes implements ActionListener {
    private final Clientes modelo;
    private final ConsultasClientes consultas;
    private final RegistroClientes vista;
    DefaultTableModel modelotabla;

    public ControladorClientes(Clientes modelo, ConsultasClientes consultas, RegistroClientes vista) {
        this.modelo = modelo;
        this.consultas = consultas;
        this.vista = vista;
        this.vista.btnAgregar.addActionListener(this);
        this.vista.btnEditar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.btnLimpiar.addActionListener(this);
        this.vista.btnBuscar.addActionListener(this);
        this.vista.btnCargar.addActionListener(this);
        this.modelotabla = (DefaultTableModel) vista.tblClientes.getModel();
    }

    public void iniciar() {
        vista.setTitle("Clientes");
        vista.setLocationRelativeTo(null);
        vista.txtidaux.setEditable(false);
        cargardatos();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == vista.btnAgregar || e.getSource() == vista.btnEditar) {
                validarDatosEntrada();
                cargarModeloDesdeVista();
                boolean exito = e.getSource() == vista.btnAgregar ? consultas.registrar(modelo) : consultas.modificar(modelo);
                String mensaje = e.getSource() == vista.btnAgregar ? "Registro Guardado" : "Registro modificado";
                JOptionPane.showMessageDialog(null, exito ? mensaje : "Error al guardar/modificar registro");
                limpiar();
                limpiartabla();
                cargardatos();
            }
            if (e.getSource() == vista.btnEliminar) {
                modelo.setId(Integer.parseInt(vista.txtID.getText()));
                if (consultas.eliminar(modelo)) {
                    JOptionPane.showMessageDialog(null, "Registro eliminado");
                    limpiar();
                    limpiartabla();
                    cargardatos();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al eliminar registro");
                }
            }
            if (e.getSource() == vista.btnBuscar) {
                modelo.setId(Integer.parseInt(vista.txtID.getText()));
                if (consultas.buscar(modelo)) {
                    vista.txtID.setText(String.valueOf(modelo.getId()));
                    vista.txtNombre.setText(modelo.getNombre());
                    vista.txtApellidos.setText(modelo.getApellidos());
                    vista.txtCorreo.setText(modelo.getCorreo());
                    vista.txtTelefono.setText(modelo.getTelefono());
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró ningún registro");
                    limpiar();
                }
            }
            if (e.getSource() == vista.btnLimpiar) {
                limpiar();
            }
        } catch (ExcepcionesPersonalizadas ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese datos válidos.");
        }
    }

    private void validarDatosEntrada() throws ExcepcionesPersonalizadas {
        if (!vista.txtID.getText().matches("\\d{9}")) {
            throw new ExcepcionesPersonalizadas("El ID debe contener exactamente 9 dígitos.");
        }
        if (!vista.txtNombre.getText().matches("[a-zA-Z ]+")) {
            throw new ExcepcionesPersonalizadas("El nombre debe contener solo letras.");
        }
        if (!vista.txtTelefono.getText().matches("\\d{8}")) {
            throw new ExcepcionesPersonalizadas("El número de teléfono debe contener 8 dígitos.");
        }
        if (!vista.txtCorreo.getText().contains("@")) {
            throw new ExcepcionesPersonalizadas("El correo debe contener '@'.");
        }
    }

    private void cargarModeloDesdeVista() {
        modelo.setId(Integer.parseInt(vista.txtID.getText()));
        modelo.setNombre(vista.txtNombre.getText());
        modelo.setApellidos(vista.txtApellidos.getText());
        modelo.setCorreo(vista.txtCorreo.getText());
        modelo.setTelefono(vista.txtTelefono.getText());
    }

    private void limpiar() {
        vista.txtID.setText("");
        vista.txtNombre.setText("");
        vista.txtApellidos.setText("");
        vista.txtCorreo.setText("");
        vista.txtTelefono.setText("");
    }

    private void cargardatos() {
        modelotabla.setRowCount(0); 
        List<Clientes> lista = consultas.cargardatos();
        for (Clientes cliente : lista) {
            Object[] row = new Object[]{cliente.getId(), cliente.getNombre(), cliente.getApellidos(),
                                        cliente.getCorreo(), cliente.getTelefono()};
            modelotabla.addRow(row);
        }
    }

    private void limpiartabla() {
        int rows = modelotabla.getRowCount();
        for (int i = rows - 1; i >= 0; i--) {
            modelotabla.removeRow(i);
        }
    }
}
