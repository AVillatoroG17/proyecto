import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    Connection connection;

    public Conexion() throws SQLException {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/clinica", "root", "");



        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error al conectar con la base de datos :( " + e.getMessage());
        }
    }


}

