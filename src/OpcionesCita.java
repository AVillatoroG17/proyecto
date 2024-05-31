import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class OpcionesCita {

    public void opcionesCitasMedicas() {
        System.out.println("¿Qué acción desea realizar?");
        Scanner in = new Scanner(System.in);
        System.out.println("\n1. Agregar cita");
        System.out.println("2. Ver citas");
        System.out.println("3. Borrar una cita");
        System.out.println("4. Actualizar una cita");
        int opcion = in.nextInt();

        if (opcion == 1) {
            try {
                Conexion conexion = new Conexion();
                String sql = "INSERT INTO citas (id_cita, nombre_paciente, DPI, fecha_De_reservacion, motivo, nombre_doctor, id_medico, fecha_de_cita) VALUES (?,?,?,?,?,?,?,?)";

                try (PreparedStatement preparedStatement = conexion.connection.prepareStatement(sql)) {

                    Cita cita = new Cita();
                    int id_cita = Integer.parseInt(JOptionPane.showInputDialog("Este campo se completa automaticamente"));
                    String nombre_paciente = JOptionPane.showInputDialog("Ingrese el nombre del paciente");
                    int DPI = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el DPI del paciente"));
                    String fecha_De_reservacion = JOptionPane.showInputDialog("Ingrese la fecha en la cual el paciente relizo la cita");
                    String motivo = JOptionPane.showInputDialog("Ingrese el motivo por el cual el paciente realizo la cita");
                    String nombre_doctor = JOptionPane.showInputDialog("Ingrese el nombre del doctor que atendera al paciente");
                    int id_medico = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del medico que atendera al paciente"));
                    String fecha_de_cita = JOptionPane.showInputDialog("Ingrese la fecha en la cual el paciente vendra a la clinica");
                    int id_paciente = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del paciente"));

                    cita.setId_cita(id_cita);
                    cita.setNombre_paciente(nombre_paciente);
                    cita.setDPI(DPI);
                    cita.setFecha_de_reservacion(fecha_De_reservacion);
                    cita.setMotivo(motivo);
                    cita.setNombre_doctor(nombre_doctor);
                    cita.setId_medico(id_medico);
                    cita.setFecha_de_cita(fecha_de_cita);
                    cita.setId_paciente(id_paciente);

                    preparedStatement.setInt(1, cita.getId_cita());
                    preparedStatement.setString(2, cita.getNombre_paciente());
                    preparedStatement.setInt(3, cita.getDPI());
                    preparedStatement.setString(4, cita.getFecha_de_reservacion());
                    preparedStatement.setString(5, motivo);
                    preparedStatement.setString(6, nombre_doctor);
                    preparedStatement.setInt(7, id_medico);
                    preparedStatement.setString(8, fecha_de_cita);
                    preparedStatement.setInt(9, id_paciente);
                    int rowsAffected = preparedStatement.executeUpdate();
                    System.out.println("Filas afectadas: " + rowsAffected);
                }

                conexion.connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (opcion == 2) {
            try {
                Conexion conexion = new Conexion();
                Statement st;
                ResultSet rs;

                st = conexion.connection.createStatement();
                rs = st.executeQuery("SELECT * FROM citas");
                while (rs.next()) {
                    System.out.println(rs.getInt("id_cita") + " " + rs.getString("Nombre_paciente") + " " + rs.getInt("DPI") + " " + rs.getString("Fecha_de_reservacion") + " " + rs.getString("motivo") + " " + rs.getString("nombre_doctor") + " " + rs.getInt("id_medico") + " " + rs.getString("fecha_de_cita")+ rs.getInt("id_paciente"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (opcion == 3) {
            try {
                Conexion conexion = new Conexion();
                int id_cita = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la cita que desea eliminar"));
                String sql = "DELETE FROM citas WHERE id_cita = ?";
                try (PreparedStatement preparedStatement = conexion.connection.prepareStatement(sql)) {
                    preparedStatement.setInt(1, id_cita);
                    int rowsAffected = preparedStatement.executeUpdate();
                    if (rowsAffected > 0) {
                        System.out.println("La cita ha sido eliminada satisfactoriamente");
                    } else {
                        System.out.println("No se ha podido encontrar una cita correspondiente al id ingresado :(");
                    }
                }
                conexion.connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (opcion == 4) {
            try {
                Conexion conexion = new Conexion();
                int id_cita = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la cita que desea actualizar"));
                String nuevaFechaCita = JOptionPane.showInputDialog("Ingrese la nueva fecha para la cita");

                String sql = "UPDATE citas SET fecha_de_cita = ? WHERE id_cita = ?";
                try (PreparedStatement preparedStatement = conexion.connection.prepareStatement(sql)) {
                    preparedStatement.setString(1, nuevaFechaCita);
                    preparedStatement.setInt(2, id_cita);
                    int filasAfectadas = preparedStatement.executeUpdate();

                    if (filasAfectadas > 0) {
                        System.out.println("Fecha de cita actualizada correctamente.");
                    } else {
                        System.out.println("No se encontró ninguna cita que corresponda al id ingresado");
                    }
                }

                conexion.connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}




