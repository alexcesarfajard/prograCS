package Modelo;

/**
 *
 * @author Ronny López Bravo y Alex Cesar Fajardo, Axel Arley
 */
public class Autos {

    private String marca;
    private String modelo;
    private int año;
    private double kilometraje;
    private String transmision;
    private double precio;
    private String placa;
    private String placaAux;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public double getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(double kilometraje) {
        this.kilometraje = kilometraje;
    }

    public String getTransmision() {
        return transmision;
    }

    public void setTransmision(String transmision) {
        this.transmision = transmision;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getPlacaAux() {
        return placaAux;
    }

    public void setPlacaAux(String placaAux) {
        this.placaAux = placaAux;
    }
}
