import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class OpcionesCita {


    public void opcionesCitasMedicas(){
        System.out.println("¿ Que accion desea realizar ?");
        Scanner in = new Scanner(System.in);
        System.out.println("\n1. Agragar cita");
        System.out.println("2. Ver citas");
      //  System.out.println("3. Eliminar cita");
        int opcion = in.nextInt();

        if(opcion == 1) {
            try {
                Conexion conexion = new Conexion();
                String sql = "INSERT INTO cita (nombre_paciente, DPI, fecha_De_reservacion, motivo, nombre_doctor, id_medico, fecha_de_cita) VALUES (?,?,?,?,?,?,?)";

                PreparedStatement preparedStatement = conexion.connection.prepareStatement(sql);

                Cita cita = new Cita();
                String nombre_paciente = JOptionPane.showInputDialog("Ingrese el nombre del paciente");
                int DPI = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el DPI del paciente"));
                String fecha_De_reservacion = JOptionPane.showInputDialog("Ingrese la fecha en la cual el paciente relizo la cita");
                String motivo = JOptionPane.showInputDialog("Ingrese el motivo por el cual el paciente realizo la cita");
                String nombre_doctor = JOptionPane.showInputDialog("Ingrese el nombre del doctor que atendera al paciente");
                int id_medico = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del medico que atendera al paciente"));
                String fecha_de_cita = JOptionPane.showInputDialog("Ingrese la fecha en la cual el paciente vendra a la clinica");

                cita.setNombre_paciente(nombre_paciente);
                cita.setDPI(DPI);
                cita.setFecha_de_reservacion(fecha_De_reservacion);
                cita.setMotivo(motivo);
                cita.setNombre_doctor(nombre_doctor);
                cita.setId_medico(id_medico);
                cita.setFecha_de_cita(fecha_de_cita);

                preparedStatement.setString(1, cita.getNombre_paciente());
                preparedStatement.setInt(2, cita.getDPI());
                preparedStatement.setString(3, cita.getFecha_de_reservacion());
                preparedStatement.setString(4, motivo);
                preparedStatement.setString(5, nombre_doctor);
                preparedStatement.setInt(6, id_medico);
                preparedStatement.setString(7, fecha_de_cita);

                int rowsAffected = preparedStatement.executeUpdate();
                System.out.println("rows" + rowsAffected);

                if (rowsAffected == 1)
                    JOptionPane.showConfirmDialog(null, "Datos insertados con exito");

                conexion.connection.close();
            } catch (Exception e) {
            }
        }

            else if (opcion == 2){
                try {
                    Conexion conexion = new Conexion();
                    Statement st;
                    ResultSet rs;

                    st = conexion.connection.createStatement();
                    rs = st.executeQuery("Select * from cita");
                    while (rs.next()) {
                         System.out.println(rs.getString("Nombre_paciente") + rs.getInt("DPI") + rs.getString("Fecha_de_reservacion")+ rs.getString("motivo")+ rs.getString("nombre_doctor") +rs.getInt("id_medico")+ rs.getString("fecha_de_cita"));
                    }

                }catch (Exception e){

                }

            }

        }

    }

