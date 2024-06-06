package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ronny López Bravo y Alex Cesar Fajardo Axel Arley
 */
public class ConsultaVenta extends Conexion {

    public boolean registrarVenta(Venta v) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO venta(idcliente, placa, fecha, precio) VALUES(?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, v.getIdcliente());
            ps.setString(2, v.getPlaca());
            ps.setString(3, v.getFecha());
            ps.setDouble(4, v.getPrecio());
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
    } // fin de registrar venta

    public boolean modificarventa(Venta v) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "UPDATE venta SET idcliente=?, placa=?, fecha=?, precio=? WHERE id=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, v.getIdcliente());
            ps.setString(2, v.getPlaca());
            ps.setString(3, v.getFecha());
            ps.setDouble(4, v.getPrecio());
            ps.setInt(5, v.getId());
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
    } // fin de modificar venta

    public boolean eliminar(Venta v) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "DELETE FROM venta WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, v.getId());
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

    public boolean buscar(Venta v) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT * FROM venta WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, v.getId());
            rs = ps.executeQuery();

            if (rs.next()) {
                v.setId(Integer.parseInt(rs.getString("id")));
                v.setIdcliente(Integer.parseInt(rs.getString("idcliente")));
                v.setPlaca(rs.getString("placa"));
                v.setFecha(rs.getString("fecha"));
                v.setPrecio(Double.parseDouble(rs.getString("precio")));
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
    } // fin de metodo buscar venta

    public List cargardatos() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        List<Venta> datos = new ArrayList<>();
        String sql = "SELECT * FROM venta";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Venta v = new Venta();
                v.setId(Integer.parseInt(rs.getString("id")));
                v.setIdcliente(Integer.parseInt(rs.getString("idcliente")));
                v.setPlaca(rs.getString("placa"));
                v.setFecha(rs.getString("fecha"));
                v.setPrecio(Double.parseDouble(rs.getString("precio")));
                datos.add(v);
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
} // fin de la clase consulta venta
