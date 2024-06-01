import javax.swing.*;
import java.awt.*;
public class aplicacion {
    public static void main(String[] args) {

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel label1 = new JLabel(" +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ ");
        label1.setOpaque(true);
        label1.setBackground(Color.RED);
        label1.setForeground(Color.BLACK);

        JLabel label2 = new JLabel(" *Bienvenido al sistema del Hospital Ingeniería Total, Indique la Opción que desea realizar* ");
        label2.setOpaque(true);
        label2.setBackground(Color.RED);
        label2.setForeground(Color.BLACK);

        JLabel label3 = new JLabel(" +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ ");
        label3.setOpaque(true);
        label3.setBackground(Color.RED);
        label3.setForeground(Color.BLACK);

        JLabel labelOpciones1 = new JLabel("1. Opciones Cita");
        labelOpciones1.setOpaque(true);
        labelOpciones1.setBackground(Color.YELLOW);
        labelOpciones1.setForeground(Color.BLACK);

        JLabel labelOpciones2 = new JLabel("2. Opciones Paciente");
        labelOpciones2.setOpaque(true);
        labelOpciones2.setBackground(Color.CYAN);
        labelOpciones2.setForeground(Color.BLACK);

        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Espacio entre las secciones
        panel.add(labelOpciones1);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Espacio entre las opciones
        panel.add(labelOpciones2);


        String opcionStr = JOptionPane.showInputDialog(null, panel, "Opciones", JOptionPane.PLAIN_MESSAGE);

        if (opcionStr != null) {
            try {
                int opcion = Integer.parseInt(opcionStr);
                switch (opcion) {
                    case 1:
                        OpcionesCita cita1 = new OpcionesCita();
                        cita1.opcionesCitasMedicas();
                        break;
                    case 2:
                        OpcionesPaciente paciente1 = new OpcionesPaciente();
                        paciente1.opcionePaciente();
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada no válida", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna opción", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

