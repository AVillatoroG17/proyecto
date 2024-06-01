import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OpcionesPaciente {

    public void opcionePaciente() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1));
        panel.setBackground(Color.GRAY);

        JLabel label = new JLabel("Bienvenido al Sistema de Pacientes del Hostital INGENIERIA TOTAL");
        label.setForeground(Color.BLACK);
        panel.add(label);

        JButton addButton = new JButton("Agregar paciente");
        addButton.setForeground(Color.GREEN);

        JButton viewButton = new JButton("Ver pacientes");
        viewButton.setForeground(Color.YELLOW);

        JButton deleteButton = new JButton("Eliminar paciente");
        deleteButton.setForeground(Color.RED);

        JButton updateButton = new JButton("Actualizar datos paciente");
        updateButton.setForeground(Color.BLUE);

        panel.add(addButton);
        panel.add(viewButton);
        panel.add(deleteButton);
        panel.add(updateButton);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarPaciente();
            }
        });

        viewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                verPacientes();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eliminarPaciente();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actualizarPaciente();
            }
        });

        JOptionPane.showMessageDialog(null, panel, "Opciones de Paciente", JOptionPane.PLAIN_MESSAGE);
    }

    private void agregarPaciente() {
        try {
            Conexion conexion = new Conexion();
            String sql = "INSERT INTO paciente (id_paciente, nombre_paciente, apellido_paciente, DPI, sexo, edad, tipo_de_sangre, telefono, id_cita, id_medico) VALUES (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = conexion.connection.prepareStatement(sql);

            Paciente paciente = new Paciente();
            paciente.setId_paciente(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del paciente")));
            paciente.setNombre_paciente(JOptionPane.showInputDialog("Ingrese el nombre del paciente"));
            paciente.setApellido_paciente(JOptionPane.showInputDialog("Ingrese el apellido del paciente"));
            paciente.setDPI(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el DPI del paciente")));
            paciente.setSexo(JOptionPane.showInputDialog("Ingrese el sexo del paciente"));
            paciente.setEdad(Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del paciente")));
            paciente.setTipo_de_sangre(JOptionPane.showInputDialog("Ingrese el tipo de sangre del paciente"));
            paciente.setTelefono(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el teléfono del paciente")));
            paciente.setId_cita(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la cita del paciente")));
            paciente.setId_medico(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del médico que atenderá al paciente")));

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
            if (rowsAffected == 1) {
                JOptionPane.showMessageDialog(null, "Datos insertados con éxito");
            }

            conexion.connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void verPacientes() {
        try {
            Conexion conexion = new Conexion();
            Statement st = conexion.connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM paciente");

            StringBuilder pacientes = new StringBuilder();
            while (rs.next()) {
                pacientes.append("ID: ").append(rs.getInt("id_paciente")).append(", ")
                        .append("Nombre: ").append(rs.getString("nombre_paciente")).append(", ")
                        .append("Apellido: ").append(rs.getString("apellido_paciente")).append(", ")
                        .append("DPI: ").append(rs.getInt("DPI")).append(", ")
                        .append("Sexo: ").append(rs.getString("sexo")).append(", ")
                        .append("Edad: ").append(rs.getInt("edad")).append(", ")
                        .append("Tipo de Sangre: ").append(rs.getString("tipo_de_sangre")).append(", ")
                        .append("Teléfono: ").append(rs.getInt("telefono")).append(", ")
                        .append("ID Cita: ").append(rs.getInt("id_cita")).append(", ")
                        .append("ID Médico: ").append(rs.getInt("id_medico")).append("\n");
            }

            JTextArea textArea = new JTextArea(pacientes.toString());
            textArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(textArea);
            JOptionPane.showMessageDialog(null, scrollPane, "Lista de Pacientes", JOptionPane.INFORMATION_MESSAGE);

            conexion.connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void eliminarPaciente() {
        try {
            Conexion conexion = new Conexion();
            int id_paciente = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del paciente que desea eliminar"));


            String sqlDeleteCitas = "DELETE FROM citas WHERE id_paciente = ?";
            PreparedStatement preparedStatementCitas = conexion.connection.prepareStatement(sqlDeleteCitas);
            preparedStatementCitas.setInt(1, id_paciente);
            int filasAfectadasCitas = preparedStatementCitas.executeUpdate();


            String sqlDeletePaciente = "DELETE FROM paciente WHERE id_paciente = ?";
            PreparedStatement preparedStatementPaciente = conexion.connection.prepareStatement(sqlDeletePaciente);
            preparedStatementPaciente.setInt(1, id_paciente);
            int filasAfectadasPaciente = preparedStatementPaciente.executeUpdate();

            if (filasAfectadasPaciente > 0) {
                JOptionPane.showMessageDialog(null, "Paciente eliminado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ningún paciente con el ID proporcionado.");
            }

            conexion.connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void actualizarPaciente() {
        try {
            Conexion conexion = new Conexion();
            int id_paciente = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del paciente que desea actualizar"));
            String[] updateOptions = {"Cambiar nombre", "Cambiar DPI", "Cambiar teléfono"};
            int opcionActualizacion = JOptionPane.showOptionDialog(null, "Seleccione la opción de actualización", "Opciones de Actualización",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, updateOptions, updateOptions[0]);

            if (opcionActualizacion == 0) { // Cambiar nombre
                String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre para el paciente");
                String sqlNombre = "UPDATE paciente SET nombre_paciente = ? WHERE id_paciente = ?";
                PreparedStatement preparedStatement = conexion.connection.prepareStatement(sqlNombre);
                preparedStatement.setString(1, nuevoNombre);
                preparedStatement.setInt(2, id_paciente);
                int filasAfectadas = preparedStatement.executeUpdate();

                if (filasAfectadas > 0) {
                    JOptionPane.showMessageDialog(null, "Nombre del paciente actualizado correctamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró ningún paciente con el ID proporcionado.");
                }
            } else if (opcionActualizacion == 1) { // Cambiar DPI
                int nuevoDPI = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo DPI para el paciente"));
                String sqlDPI = "UPDATE paciente SET DPI = ? WHERE id_paciente = ?";
                PreparedStatement preparedStatement = conexion.connection.prepareStatement(sqlDPI);
                preparedStatement.setInt(1, nuevoDPI);
                preparedStatement.setInt(2, id_paciente);
                int filasAfectadas = preparedStatement.executeUpdate();

                if (filasAfectadas > 0) {
                    JOptionPane.showMessageDialog(null, "DPI del paciente actualizado correctamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró ningún paciente con el ID proporcionado.");
                }
            } else if (opcionActualizacion == 2) { // Cambiar teléfono
                int nuevoTelefono = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo teléfono para el paciente"));
                String sqlTelefono = "UPDATE paciente SET telefono = ? WHERE id_paciente = ?";
                PreparedStatement preparedStatement = conexion.connection.prepareStatement(sqlTelefono);
                preparedStatement.setInt(1, nuevoTelefono);
                preparedStatement.setInt(2, id_paciente);
                int filasAfectadas = preparedStatement.executeUpdate();

                if (filasAfectadas > 0) {
                    JOptionPane.showMessageDialog(null, "Teléfono del paciente actualizado correctamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró ningún paciente con el ID proporcionado.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Opción inválida");
            }
            conexion.connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

