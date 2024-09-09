package proyecto.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private Connection cx;

    public void conectar() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            this.cx = DriverManager.getConnection("jdbc:mariadb://localhost:3306/dbcurso", "root", "");
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (ClassNotFoundException e) {
            System.err.println("Error: No se encontró el driver de MariaDB.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Error: No se pudo establecer la conexión con la base de datos.");
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        if (this.cx == null) {
            conectar();
            if (this.cx == null) {
                System.err.println("Error: No se pudo establecer la conexión a la base de datos.");
            }
        }
        return this.cx;
    }
}