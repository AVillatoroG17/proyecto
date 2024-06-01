import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OpcionesCita {

    public void opcionesCitasMedicas() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));
        panel.setBackground(Color.GRAY);

        JLabel label = new JLabel("Bienvenido al Sistema de Citas del Hopital INGENIERIA TOTAL");
        label.setForeground(Color.BLACK);
        panel.add(label);

        JButton addButton = new JButton("Agregar Cita");
        addButton.setForeground(Color.GREEN);

        JButton viewButton = new JButton("Ver Citas");
        viewButton.setForeground(Color.BLACK);

        JButton deleteButton = new JButton("Eliminar Cita");
        deleteButton.setForeground(Color.RED);

        JButton updateButton = new JButton("Actualizar datos de Cita");
        updateButton.setForeground(Color.BLUE);

        panel.add(addButton);
        panel.add(viewButton);
        panel.add(deleteButton);
        panel.add(updateButton);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarCita();
            }
        });

        viewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                verCitas();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eliminarCita();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actualizarCita();
            }
        });

        JOptionPane.showMessageDialog(null, panel, "Opciones de Citas Médicas", JOptionPane.PLAIN_MESSAGE);
    }

    private void agregarCita() {
        try {
            Conexion conexion = new Conexion();
            String sql = "INSERT INTO citas (id_cita, nombre_paciente, DPI, fecha_De_reservacion, motivo, nombre_doctor, id_medico, fecha_de_cita, id_paciente) VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = conexion.connection.prepareStatement(sql);

            Cita cita = new Cita();
            cita.setId_cita(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la cita")));
            cita.setNombre_paciente(JOptionPane.showInputDialog("Ingrese el nombre del paciente"));
            cita.setDPI(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el DPI del paciente")));
            cita.setFecha_de_reservacion(JOptionPane.showInputDialog("Ingrese la fecha en la cual el paciente realizó la cita"));
            cita.setMotivo(JOptionPane.showInputDialog("Ingrese el motivo de la cita"));
            cita.setNombre_doctor(JOptionPane.showInputDialog("Ingrese el nombre del doctor que atenderá al paciente"));
            cita.setId_medico(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del médico que atenderá al paciente")));
            cita.setFecha_de_cita(JOptionPane.showInputDialog("Ingrese la fecha de la cita"));
            cita.setId_paciente(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del paciente")));

            preparedStatement.setInt(1, cita.getId_cita());
            preparedStatement.setString(2, cita.getNombre_paciente());
            preparedStatement.setInt(3, cita.getDPI());
            preparedStatement.setString(4, cita.getFecha_de_reservacion());
            preparedStatement.setString(5, cita.getMotivo());
            preparedStatement.setString(6, cita.getNombre_doctor());
            preparedStatement.setInt(7, cita.getId_medico());
            preparedStatement.setString(8, cita.getFecha_de_cita());
            preparedStatement.setInt(9, cita.getId_paciente());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected == 1) {
                JOptionPane.showMessageDialog(null, "Datos insertados con éxito");
            }

            conexion.connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void verCitas() {
        try {
            Conexion conexion = new Conexion();
            Statement st = conexion.connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM citas");

            StringBuilder citas = new StringBuilder();
            while (rs.next()) {
                citas.append("ID: ").append(rs.getInt("id_cita")).append(", ")
                        .append("Nombre: ").append(rs.getString("nombre_paciente")).append(", ")
                        .append("DPI: ").append(rs.getInt("DPI")).append(", ")
                        .append("Fecha que pidio cita: ").append(rs.getString("fecha_de_reservacion")).append(", ")
                        .append("Motivo: ").append(rs.getString("motivo")).append(", ")
                        .append("Nombre del Doctor: ").append(rs.getString("nombre_doctor")).append(", ")
                        .append("ID del Médico: ").append(rs.getInt("id_medico")).append(", ")
                        .append("Fecha de Cita: ").append(rs.getString("fecha_de_cita")).append(", ")
                        .append("ID del Paciente: ").append(rs.getInt("id_paciente")).append("\n");
            }

            JTextArea textArea = new JTextArea(citas.toString());
            textArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(textArea);
            JOptionPane.showMessageDialog(null, scrollPane, "Lista de Citas", JOptionPane.INFORMATION_MESSAGE);

            conexion.connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void eliminarCita() {
        try {
            Conexion conexion = new Conexion();
            int id_cita = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la cita que desea eliminar"));

            String sql = "DELETE FROM citas WHERE id_cita = ?";
            PreparedStatement preparedStatement = conexion.connection.prepareStatement(sql);
            preparedStatement.setInt(1, id_cita);
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Cita eliminada correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ninguna cita con el ID proporcionado.");
            }

            conexion.connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void actualizarCita() {
        try {
            Conexion conexion = new Conexion();
            int id_cita = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la cita que desea actualizar"));
            String[] updateOptions = {"Cambiar nombre", "Cambiar fecha de cita", "Cambiar DPI"};
            int opcionActualizacion = JOptionPane.showOptionDialog(null, "Seleccione la opción de actualización", "Opciones de Actualización",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, updateOptions, updateOptions[0]);

            switch (opcionActualizacion) {
                case 0:
                    String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre");
                    actualizarCampo("nombre_paciente", nuevoNombre, id_cita);
                    break;
                case 1:
                    String nuevaFecha = JOptionPane.showInputDialog("Ingrese la nueva fecha de la cita");
                    actualizarCampo("fecha_de_cita", nuevaFecha, id_cita);
                    break;
                case 2:
                    String nuevoDPI = JOptionPane.showInputDialog("Ingrese el nuevo DPI");
                    actualizarCampo("DPI", nuevoDPI, id_cita);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida");
                    break;
            }
            conexion.connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private void actualizarCampo(String campo, String nuevoValor, int id_cita) throws SQLException {
        Conexion conexion = new Conexion();
        String sql = "UPDATE citas SET " + campo + " = ? WHERE id_cita = ?";
        PreparedStatement preparedStatement = conexion.connection.prepareStatement(sql);
        preparedStatement.setString(1, nuevoValor);
        preparedStatement.setInt(2, id_cita);
        int filasAfectadas = preparedStatement.executeUpdate();

        if (filasAfectadas > 0) {
            JOptionPane.showMessageDialog(null, campo + " de la cita actualizado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró ninguna cita con el ID proporcionado.");
        }
    }
}