import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    Connection connection;

    public Conexion() throws SQLException {
        try {
<<<<<<< HEAD
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinica", "root", "SOMOSPROSSIUUU");
=======
            connection = DriverManager.getConnection("", "ingresa el usuario //creo que es root", "//ingresa la contraseña que elegista al instalar el MySQL");
>>>>>>> 1fd53b1995c18006faca12bece30682607af5c54
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error al conectar con la base de datos :( " + e.getMessage());
        }
    }


}