/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excepciones;
import java.io.Serializable;
/**
 *
 * @author arley
 */
public class ExcepcionesPersonalizadas extends Exception {
public ExcepcionesPersonalizadas(String mensaje) {
        super(mensaje);
    }
public class MiExcepcionPersonalizada extends Exception implements Serializable {
    private int codigoError;
    private String detallesAdicionales;

    public MiExcepcionPersonalizada(String mensaje, int codigoError, String detallesAdicionales) {
        super(mensaje);
        this.codigoError = codigoError;
        this.detallesAdicionales = detallesAdicionales;
    }

    public int getCodigoError() {
        return codigoError;
    }

    public String getDetallesAdicionales() {
        return detallesAdicionales;
    }

    @Override
    public String toString() {
        return "MiExcepcionPersonalizada: " + getMessage() + ", Código de error: " + codigoError + ", Detalles adicionales: " + detallesAdicionales;
    }
}
}

