import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class OpcionesPaciente {

    public void opcionePaciente(){
        System.out.println("¿ Que accion desea realizar ?");
        Scanner in = new Scanner(System.in);
        System.out.println("\n1. Agregar paciente");
        System.out.println("2. ver pacientes");
        int opcion = in.nextInt();

        if(opcion == 1 ){
            try{
                Conexion conexion = new Conexion();
                String sql = "INSERT INTO pacientes (nombre_paciente, apellido_paciente, DPI, sexo, tipo_de_sangre, edad, id_paciente, id_cita, id_medico, telefono) VALUES (?,?,?,?,?,?,?,?,?,?)";

            }

        }

    }

}

