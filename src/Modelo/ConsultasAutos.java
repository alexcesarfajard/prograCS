package Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ronny López Bravo y Alex Cesar Fajardo Axel Arley
 */
public class ConsultasAutos extends Conexion {

    public boolean registrar(Autos auto)  {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO autos(placa, marca, modelo, año, kilometraje,transmision, precio) VALUES(?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, auto.getPlaca());
            ps.setString(2, auto.getMarca());
            ps.setString(3, auto.getModelo());
            ps.setInt(4, auto.getAño());
            ps.setDouble(5, auto.getKilometraje());
            ps.setString(6, auto.getTransmision());
            ps.setDouble(7, auto.getPrecio());
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
    } // fin del moto registrar

    public boolean modificar(Autos auto) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "UPDATE autos SET placa=?,marca=?, modelo=?, año=?, kilometraje=?,"
                + "transmision=?, precio=? WHERE placa=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, auto.getPlaca());
            ps.setString(2, auto.getMarca());
            ps.setString(3, auto.getModelo());
            ps.setInt(4, auto.getAño());
            ps.setDouble(5, auto.getKilometraje());
            ps.setString(6, auto.getTransmision());
            ps.setDouble(7, auto.getPrecio());
            ps.setString(8, auto.getPlacaAux());
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
    } // fin del metodo modificar

    public boolean eliminar(Autos auto) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "DELETE FROM autos WHERE placa=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, auto.getPlaca());
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
    } // fin del metodo eliminar

    public boolean buscar(Autos auto) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT * FROM autos WHERE placa=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, auto.getPlaca());
            rs = ps.executeQuery();

            if (rs.next()) {
                auto.setMarca(rs.getString("marca"));
                auto.setModelo(rs.getString("modelo"));
                auto.setAño(Integer.parseInt(rs.getString("año")));
                auto.setKilometraje(Double.parseDouble(rs.getString("kilometraje")));
                auto.setTransmision(rs.getString("transmision"));
                auto.setPrecio(Double.parseDouble(rs.getString("precio")));
                auto.setPlaca(rs.getString("placa"));
                auto.setPlacaAux(rs.getString("placa"));
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
    } // fin del metodo buscar 

    public List cargardatos() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        List<Autos> datos = new ArrayList<>();
        String sql = "SELECT * FROM autos";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Autos a = new Autos();
                a.setPlaca(rs.getString("placa"));
                a.setPlacaAux("placa");
                a.setMarca(rs.getString("marca"));
                a.setModelo(rs.getString("modelo"));
                a.setAño(rs.getInt("año"));
                a.setKilometraje(rs.getDouble("kilometraje"));
                a.setTransmision(rs.getString("transmision"));
                a.setPrecio(rs.getDouble("precio"));
                datos.add(a);
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

} // fin de la clase consulta autos
