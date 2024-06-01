import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class OpcionesPaciente {
    // Colores
    String negro = "\033[30m", rojo = "\033[31m", verde = "\033[32m", amarillo = "\033[33m", azul = "\033[34m", magenta = "\033[35m", celeste = "\033[36m", blanco = "\033[37m";
    String fRojo = "\033[41m", fVerde = "\033[42m", fAmarillo = "\033[43m", fAzul = "\033[44m", fMagenta = "\033[45m", fCeleste = "\033[46m", fGris = "\033[47m";
    String borrar = "\u001B[0m"; //borrar

    public void opcionePaciente() {
        System.out.println(fGris + negro + " ***************************************************************** " + borrar);
        System.out.println(fGris + negro + " *  Bienvenido a al Sistema de Citas de Clinica INGENIERIA TOTAL * " + borrar);
        System.out.println(fGris + negro + " *++++++++++++++++++++++++++++++++++++++++++********************** " + borrar);
        System.out.println("");
        System.out.println(fMagenta + negro + " ¿ Que accion desea realizar ?  " + borrar);
        Scanner in = new Scanner(System.in);
        System.out.println("");
        System.out.println(fVerde + negro + " 1. Agregar paciente  " + borrar);
        System.out.println(fAmarillo + negro + " 2. ver pacientes  " + borrar);
        System.out.println(fRojo + negro + "3. Eliminar a un paciente" + borrar);
        System.out.println(fAzul + negro + "4. Actualizar datos de un paciente" + borrar);
        System.out.println("");

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
                System.out.println(fVerde + negro + "Filas afectadas: " + rowsAffected + borrar);

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
        } else if (opcion == 3) {
            try {
                Conexion conexion = new Conexion();
                int id_paciente = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del paciente que desea eliminar"));

                String sql = "DELETE FROM paciente WHERE id_paciente = ?";
                try (PreparedStatement preparedStatement = conexion.connection.prepareStatement(sql)) {
                    preparedStatement.setInt(1, id_paciente);
                    int filasAfectadas = preparedStatement.executeUpdate();

                    if (filasAfectadas > 0) {
                        System.out.println(fRojo + negro + "Paciente eliminado correctamente." + borrar);
                    } else {
                        System.out.println(fRojo + negro + "No se encontró ningún paciente con el ID proporcionado." + borrar);
                    }
                }

                conexion.connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (opcion == 4) {
            try {
                Conexion conexion = new Conexion();
                int id_paciente = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del paciente que desea actualizar"));
                int opcionActualizacion = Integer.parseInt(JOptionPane.showInputDialog("Seleccione la opción de actualización:\n1. Cambiar nombre\n2. Cambiar DPI\n3. Cambiar teléfono"));

                switch (opcionActualizacion) {
                    case 1:
                        String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre para el paciente");
                        String sqlNombre = "UPDATE paciente SET nombre_paciente = ? WHERE id_paciente = ?";
                        try (PreparedStatement preparedStatement = conexion.connection.prepareStatement(sqlNombre)) {
                            preparedStatement.setString(1, nuevoNombre);
                            preparedStatement.setInt(2, id_paciente);
                            int filasAfectadas = preparedStatement.executeUpdate();

                            if (filasAfectadas > 0) {
                                System.out.println("Nombre del paciente actualizado correctamente.");
                            } else {
                                System.out.println("No se encontró ningún paciente con el ID proporcionado.");
                            }
                        }
                        break;

                    case 2:
                        String nuevoDPI = JOptionPane.showInputDialog("Ingrese el nuevo DPI para el paciente");
                        String sqlDPI = "UPDATE paciente SET dpi = ? WHERE id_paciente = ?";
                        try (PreparedStatement preparedStatement = conexion.connection.prepareStatement(sqlDPI)) {
                            preparedStatement.setString(1, nuevoDPI);
                            preparedStatement.setInt(2, id_paciente);
                            int filasAfectadas = preparedStatement.executeUpdate();

                            if (filasAfectadas > 0) {
                                System.out.println("DPI del paciente actualizado correctamente.");
                            } else {
                                System.out.println("No se encontró ningún paciente con el ID proporcionado.");
                            }
                        }
                        break;

                    case 3:
                        String nuevoTelefono = JOptionPane.showInputDialog("Ingrese el nuevo teléfono para el paciente");
                        String sqlTelefono = "UPDATE paciente SET telefono = ? WHERE id_paciente = ?";
                        try (PreparedStatement preparedStatement = conexion.connection.prepareStatement(sqlTelefono)) {
                            preparedStatement.setString(1, nuevoTelefono);
                            preparedStatement.setInt(2, id_paciente);
                            int filasAfectadas = preparedStatement.executeUpdate();

                            if (filasAfectadas > 0) {
                                System.out.println("Teléfono del paciente actualizado correctamente.");
                            } else {
                                System.out.println("No se encontró ningún paciente con el ID proporcionado.");
                            }
                        }
                        break;

                    default:
                        System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                        break;
                }

                conexion.connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    }


