package Modelo;

/**
 *
 * @author Ronny López Bravo y Alex Cesar Fajardo, Axel Arley
 */
public class Clientes {

    private int id;
    private String nombre;
    private String apellidos;
    private String correo;
    private String telefono;
    private int idaux;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getIdaux() {
        return idaux;
    }

    public void setIdaux(int idaux) {
        this.idaux = idaux;
    }
}
