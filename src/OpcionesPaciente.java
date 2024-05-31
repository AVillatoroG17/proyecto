import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class OpcionesPaciente {

    public void opcionePaciente(){
        System.out.println("¿ Que accion desea realizar ?");
        Scanner in = new Scanner(System.in);
        System.out.println("\n1. Agragar Paciente");
        System.out.println("2. Ver Paciente");
        //  System.out.println("3. Eliminar Paciente");
        int opcion = in.nextInt();


    }

}

