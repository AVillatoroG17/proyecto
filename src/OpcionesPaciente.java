import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class OpcionesPaciente {

    public void opcionePaciente() {
        System.out.println("¿ Que accion desea realizar ?");
        Scanner in = new Scanner(System.in);
        System.out.println("\n1. Agregar paciente");
        System.out.println("2. ver pacientes");
        int opcion = in.nextInt();


        if (opcion == 1) {
            try {
                Conexion conexion = new Conexion();
                String sql = "INSERT INTO paciente (id_paciente, nombre_paciente, apellido_paciente, DPI, sexo, edad, tipo_de_sangre, telefono, id_cita, id_medico) VALUES (?,?,?,?,?,?,?,?,?,?)";

                PreparedStatement preparedStatement = conexion.connection.prepareStatement(sql);

                Paciente paciente = new Paciente();
                int id_paciente = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del paciente"));
                String nombre_paciente = JOptionPane.showInputDialog("Ingrese el nombre del paciente");
                String apellido_paciente = JOptionPane.showInputDialog("Ingrese el apellido del paciente");
                int DPI = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el DPI del paciente"));
                String sexo = JOptionPane.showInputDialog("Ingrese el sexo del paciente");
                int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del paciente"));
                String tipo_de_sangre = JOptionPane.showInputDialog("Ingrese el tipo de sangre del paciente");
                int telefono = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el teléfono del paciente"));
                int id_cita = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la cita del paciente"));
                int id_medico = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del médico que atenderá al paciente"));

                paciente.setId_paciente(id_paciente);
                paciente.setNombre_paciente(nombre_paciente);
                paciente.setApellido_paciente(apellido_paciente);
                paciente.setDPI(DPI);
                paciente.setSexo(sexo);
                paciente.setEdad(edad);
                paciente.setTipo_de_sangre(tipo_de_sangre);
                paciente.setTelefono(telefono);
                paciente.setId_cita(id_cita);
                paciente.setId_medico(id_medico);

                preparedStatement.setInt(1, paciente.getId_paciente());
                preparedStatement.setString(2, paciente.getNombre_paciente());
                preparedStatement.setString(3, paciente.getApellido_paciente());
                preparedStatement.setInt(4, paciente.getDPI());
                preparedStatement.setString(5, paciente.getSexo());
                preparedStatement.setInt(6, paciente.getEdad());
                preparedStatement.setString(7, paciente.getTipo_de_sangre());
                preparedStatement.setInt(8, paciente.getTelefono());
                preparedStatement.setInt(9, paciente.getId_cita());
                preparedStatement.setInt(10, paciente.getId_medico());

                int rowsAffected = preparedStatement.executeUpdate();
                System.out.println("Filas afectadas: " + rowsAffected);

                if (rowsAffected == 1)
                    JOptionPane.showMessageDialog(null, "Datos insertados con éxito");

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
                rs = st.executeQuery("SELECT * FROM paciente");
                while (rs.next()) {
                    System.out.println(rs.getInt("id_paciente") + " " +
                            rs.getString("nombre_paciente") + " " +
                            rs.getString("apellido_paciente") + " " +
                            rs.getInt("DPI") + " " +
                            rs.getString("sexo") + " " +
                            rs.getInt("edad") + " " +
                            rs.getString("tipo_de_sangre") + " " +
                            rs.getInt("telefono") + " " +
                            rs.getInt("id_cita") + " " +
                            rs.getInt("id_medico"));
                }

                conexion.connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if (opcion == 3) {
            try {
                Conexion conexion = new Conexion();
                int id_cita = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la cita que desea eliminar"));

                String sql = "DELETE FROM citas WHERE id_cita = ?";
                try (PreparedStatement preparedStatement = conexion.connection.prepareStatement(sql)) {
                    preparedStatement.setInt(1, id_cita);
                    int rowsAffected = preparedStatement.executeUpdate();
                    System.out.println("Filas afectadas: " + rowsAffected);
                }

                conexion.connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if (opcion == 4) {  // Update option
            try {
                Conexion conexion = new Conexion();
                int id_cita = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la cita que desea actualizar"));

                String nombre_paciente = JOptionPane.showInputDialog("Ingrese el nuevo nombre del paciente (deje en blanco para no cambiar)");
                String DPIString = JOptionPane.showInputDialog("Ingrese el nuevo DPI del paciente (deje en blanco para no cambiar)");
                String fecha_De_reservacion = JOptionPane.showInputDialog("Ingrese la nueva fecha de reservación (deje en blanco para no cambiar)");
                String motivo = JOptionPane.showInputDialog("Ingrese el nuevo motivo (deje en blanco para no cambiar)");
                String nombre_doctor = JOptionPane.showInputDialog("Ingrese el nuevo nombre del doctor (deje en blanco para no cambiar)");
                String id_medicoString = JOptionPane.showInputDialog("Ingrese el nuevo ID del médico (deje en blanco para no cambiar)");
                String fecha_de_cita = JOptionPane.showInputDialog("Ingrese la nueva fecha de la cita (deje en blanco para no cambiar)");

                StringBuilder sql = new StringBuilder("UPDATE citas SET ");
                boolean needsComma = false;

                if (!nombre_paciente.isEmpty()) {
                    sql.append("nombre_paciente = '").append(nombre_paciente).append("'");
                    needsComma = true;
                }
                if (!DPIString.isEmpty()) {
                    if (needsComma) sql.append(", ");
                    sql.append("DPI = ").append(DPIString);
                    needsComma = true;
                }
                if (!fecha_De_reservacion.isEmpty()) {
                    if (needsComma) sql.append(", ");
                    sql.append("fecha_De_reservacion = '").append(fecha_De_reservacion).append("'");
                    needsComma = true;
                }
                if (!motivo.isEmpty()) {
                    if (needsComma) sql.append(", ");
                    sql.append("motivo = '").append(motivo).append("'");
                    needsComma = true;
                }
                if (!nombre_doctor.isEmpty()) {
                    if (needsComma) sql.append(", ");
                    sql.append("nombre_doctor = '").append(nombre_doctor).append("'");
                    needsComma = true;
                }
                if (!id_medicoString.isEmpty()) {
                    if (needsComma) sql.append(", ");
                    sql.append("id_medico = ").append(id_medicoString);
                    needsComma = true;
                }
                if (!fecha_de_cita.isEmpty()) {
                    if (needsComma) sql.append(", ");
                    sql.append("fecha_de_cita = '").append(fecha_de_cita).append("'");
                }

                sql.append(" WHERE id_cita = ").append(id_cita);

                try (Statement st = conexion.connection.createStatement()) {
                    int rowsAffected = st.executeUpdate(sql.toString());
                    System.out.println("Filas afectadas: " + rowsAffected);
                }

                conexion.connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}



