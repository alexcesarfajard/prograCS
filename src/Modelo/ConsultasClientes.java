package Modelo;

//import java.awt.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ronny López Bravo y Alex Cesar Fajardo Axel Arley
 */
public class ConsultasClientes extends Conexion {

    public boolean registrar(Clientes cliente) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO clientes(id, nombre, apellidos, correo, telefono) VALUES(?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, cliente.getId());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getApellidos());
            ps.setString(4, cliente.getCorreo());
            ps.setString(5, cliente.getTelefono());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    } // fin de metodo registrar

    public boolean modificar(Clientes cliente) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "UPDATE clientes SET id=?, nombre=?, apellidos=?, correo=?, telefono=? WHERE id=?";

        try {
            /*
            System.out.println("Cliente\nid: " + cliente.getId() + "\nNombre: " + cliente.getNombre() 
                    + "\nApellido: " + cliente.getApellidos() + "\nCorreo: " + cliente.getCorreo()
                    + "\nTelefono: " + cliente.getTelefono() + "\nidaux: " + cliente.getIdaux() + "\n");*/

            ps = con.prepareStatement(sql);
            ps.setInt(1, cliente.getId());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getApellidos());
            ps.setString(4, cliente.getCorreo());
            ps.setString(5, cliente.getTelefono());
            ps.setInt(6, cliente.getIdaux());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    } // fin de metodo modificar

    public boolean eliminar(Clientes cliente) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "DELETE FROM clientes WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, cliente.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    } // fin de metodo eliminar

    public boolean buscar(Clientes cliente) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT * FROM clientes WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, cliente.getId());
            rs = ps.executeQuery();

            if (rs.next()) {
                cliente.setId(Integer.parseInt(rs.getString("id")));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellidos(rs.getString("apellidos"));
                cliente.setCorreo(rs.getString("correo"));
                cliente.setTelefono(rs.getString("telefono"));
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    } // fin de metodo buscar cliente

    public List cargardatos() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        List<Clientes> datos = new ArrayList<>();
        String sql = "SELECT * FROM clientes";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Clientes cli = new Clientes();
                cli.setId(rs.getInt("id"));
                cli.setNombre(rs.getString("nombre"));
                cli.setApellidos(rs.getString("apellidos"));
                cli.setCorreo(rs.getString("correo"));
                cli.setTelefono(rs.getString("telefono"));
                datos.add(cli);
            }
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return datos;
    } // fin de metodo cargar datos

} // fin de la clase consulta clientes
