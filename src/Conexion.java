import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    Connection connection;

    public Conexion() throws SQLException {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinica", "root", "SOMOSPROSSIUUU");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error al conectar con la base de datos :( " + e.getMessage());
        }
    }


}