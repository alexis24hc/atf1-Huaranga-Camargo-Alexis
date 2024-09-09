package proyecto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//Clases importadas
import proyecto.db.Conexion;
import proyecto.model.Asignatura;

public class AsignaturaDao {

    private Connection cx;

    public AsignaturaDao() {
        Conexion conexion = new Conexion();
        this.cx = conexion.getConnection();
    }

    public List<Asignatura> buscarTodos() {
        List<Asignatura> asignaturas = new ArrayList<>();
        Statement st = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM asignaturas";
            st = cx.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Asignatura asig = new Asignatura();
                asig.setCodigo(rs.getString("codigo"));
                asig.setNombre(rs.getString("nombre"));
                asig.setHoras(rs.getInt("horas"));
                asig.setTipo(rs.getString("tipo"));
                asig.setCreditos(rs.getInt("creditos"));
                asignaturas.add(asig);
            }
        } catch (Exception e) {
            System.err.println("Error al consultar datos: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
            } catch (Exception e) {
                System.err.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
        return asignaturas;
    }

    public void insertar(Asignatura asignatura) {
        PreparedStatement ps = null;
        try {
            String sql = "INSERT INTO asignaturas (codigo, nombre, horas, tipo, creditos) VALUES (?, ?, ?, ?, ?)";
            ps = cx.prepareStatement(sql);
            ps.setString(1, asignatura.getCodigo());
            ps.setString(2, asignatura.getNombre());
            ps.setInt(3, asignatura.getHoras());
            ps.setString(4, asignatura.getTipo());
            ps.setInt(5, asignatura.getCreditos());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error al insertar datos: " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception e) {
                System.err.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
    }

    public void actualizar(Asignatura asignatura) {
        PreparedStatement ps = null;
        try {
            String sql = "UPDATE asignaturas SET nombre=?, horas=?, tipo=?, creditos=? WHERE codigo=?";
            ps = cx.prepareStatement(sql);
            ps.setString(1, asignatura.getNombre());
            ps.setInt(2, asignatura.getHoras());
            ps.setString(3, asignatura.getTipo());
            ps.setInt(4, asignatura.getCreditos());
            ps.setString(5, asignatura.getCodigo());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error al actualizar datos: " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception e) {
                System.err.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
    }

    public Asignatura buscarPorCodigo(String codigo) {
        Asignatura asig = new Asignatura();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM asignaturas WHERE codigo = ?";
            ps = cx.prepareStatement(sql);
            ps.setString(1, codigo);
            rs = ps.executeQuery();
            if (rs.next()) {
                asig.setCodigo(rs.getString("codigo"));
                asig.setNombre(rs.getString("nombre"));
                asig.setHoras(rs.getInt("horas"));
                asig.setTipo(rs.getString("tipo"));
                asig.setCreditos(rs.getInt("creditos"));
            }
        } catch (Exception e) {
            System.err.println("Error al buscar datos por código: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception e) {
                System.err.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
        return asig;
    }

    public void darBaja(String codigo) {
        PreparedStatement ps = null;
        try {
            String sql = "DELETE FROM asignaturas WHERE codigo=?";
            ps = cx.prepareStatement(sql);
            ps.setString(1, codigo);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error al eliminar datos: " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception e) {
                System.err.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
    }
}
