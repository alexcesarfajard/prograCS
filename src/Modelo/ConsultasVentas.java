package Modelo;

import java.sql.*;

/**
 *
 * @author Ronny López Bravo y Alex Cesar Fajardo Axel Arley
 */
public class ConsultasVentas extends Conexion {

    public boolean registrar(Ventas venta) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO ventas(id, nombre, apellidos, correo, marca, modelo, año, precio, placa) VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);

            ps.setInt(1, venta.getId());
            ps.setString(2, venta.getNombre());
            ps.setString(3, venta.getApellidos());
            ps.setString(4, venta.getCorreo());
            ps.setString(5, venta.getMarca());
            ps.setString(6, venta.getModelo());
            ps.setInt(7, venta.getAño());
            ps.setDouble(8, venta.getPrecio());
            ps.setString(9, venta.getPlaca());
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
    }

    public boolean modificar(Ventas venta) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "UPDATE ventas SET nombre=?, ,apellidos=?, correo=?, marca=?, modelo=?, año=?, precio=?, placa=? WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, venta.getId());
            ps.setString(2, venta.getNombre());
            ps.setString(3, venta.getApellidos());
            ps.setString(4, venta.getCorreo());
            ps.setString(5, venta.getMarca());
            ps.setString(6, venta.getModelo());
            ps.setInt(7, venta.getAño());
            ps.setDouble(8, venta.getPrecio());
            ps.setString(9, venta.getPlaca());
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
    }

    public boolean eliminar(Ventas venta) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "DELETE FROM ventas WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, venta.getId());
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
    }

    public boolean buscar(Ventas venta) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT * FROM ventas WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, venta.getId());
            rs = ps.executeQuery();

            if (rs.next()) {
                venta.setId(Integer.parseInt(rs.getString("id")));
                venta.setNombre(rs.getString("nombre"));
                venta.setApellidos(rs.getString("apellidos"));
                venta.setCorreo(rs.getString("correo"));
                venta.setMarca(rs.getString("marca"));
                venta.setModelo(rs.getString("modelo"));
                venta.setAño(Integer.parseInt(rs.getString("año")));
                venta.setPrecio(Double.parseDouble(rs.getString("precio")));
                venta.setPlaca(rs.getString("placa"));
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
    }

}
