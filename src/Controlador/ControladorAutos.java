package Controlador;

import Excepciones.ExcepcionesPersonalizadas;
import Modelo.Autos;
import Modelo.ConsultasAutos;
import VistaGUI.RegistroAutos;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 *
 * @author Ronny López Bravo y Alex Cesar Fajardo, Axel Arley
 */

public class ControladorAutos implements ActionListener {
    private final Autos modelo;
    private final ConsultasAutos consultas;
    private final RegistroAutos vista;
    DefaultTableModel modelotabla;

    public ControladorAutos(Autos modelo, ConsultasAutos consultas, RegistroAutos vista) {
        this.modelo = modelo;
        this.consultas = consultas;
        this.vista = vista;
        this.vista.btnAgregar.addActionListener(this);
        this.vista.btnEditar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.btnLimpiar.addActionListener(this);
        this.vista.btnBuscar.addActionListener(this);
        this.vista.btnCargar.addActionListener(this);
        this.modelotabla = (DefaultTableModel) vista.tblAutos.getModel();
    }

    public void iniciar() {
        vista.setTitle("Autos");
        vista.setLocationRelativeTo(null);
        vista.txtPlacaAux.setEditable(false);
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
                modelo.setPlaca(vista.txtPlaca.getText());
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
                modelo.setPlaca(vista.txtPlaca.getText());
                if (consultas.buscar(modelo)) {
                    vista.txtMarca.setText(modelo.getMarca());
                    vista.txtModelo.setText(modelo.getModelo());
                    vista.txtAño.setText(String.valueOf(modelo.getAño()));
                    vista.txtKilometraje.setText(String.valueOf(modelo.getKilometraje()));
                    vista.txtTransmision.setText(modelo.getTransmision());
                    vista.txtPrecio.setText(String.valueOf(modelo.getPrecio()));
                    vista.txtPlaca.setText(modelo.getPlaca());
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
            JOptionPane.showMessageDialog(null, "Por favor ingrese un número válido.");
        }
    }

    private void validarDatosEntrada() throws ExcepcionesPersonalizadas {
        if (!vista.txtAño.getText().matches("\\d+")) {
            throw new ExcepcionesPersonalizadas("El año debe ser numérico.");
        }
        if (!vista.txtKilometraje.getText().matches("\\d+(\\.\\d+)?")) {
            throw new ExcepcionesPersonalizadas("El kilometraje debe ser un número.");
        }
        if (!vista.txtPrecio.getText().matches("\\d+(\\.\\d+)?")) {
            throw new ExcepcionesPersonalizadas("El precio debe ser un número.");
        }
    }

    private void cargarModeloDesdeVista() {
        modelo.setMarca(vista.txtMarca.getText());
        modelo.setModelo(vista.txtModelo.getText());
        modelo.setAño(Integer.parseInt(vista.txtAño.getText()));
        modelo.setKilometraje(Double.parseDouble(vista.txtKilometraje.getText()));
        modelo.setTransmision(vista.txtTransmision.getText());
        modelo.setPrecio(Double.parseDouble(vista.txtPrecio.getText()));
        modelo.setPlaca(vista.txtPlaca.getText());
    }

    private void limpiar() {
        vista.txtMarca.setText("");
        vista.txtModelo.setText("");
        vista.txtAño.setText("");
        vista.txtKilometraje.setText("");
        vista.txtTransmision.setText("");
        vista.txtPrecio.setText("");
        vista.txtPlaca.setText("");
        vista.txtPlacaAux.setText("");
    }

    private void cargardatos() {
        modelotabla.setRowCount(0); 
        List<Autos> lista = consultas.cargardatos();
        for (Autos auto : lista) {
            Object[] row = new Object[]{auto.getMarca(), auto.getModelo(), auto.getAño(),
                                        auto.getKilometraje(), auto.getTransmision(), auto.getPrecio(), auto.getPlaca()};
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