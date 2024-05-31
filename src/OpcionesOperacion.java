import java.util.Scanner;
public class OpcionesOperacion {
    Scanner in = new Scanner(System.in);
    int opcion;

    public void opcionesOperacion(){

        System.out.println("Indique la operacion que desea realizar");
        System.out.println("1. Agregar Cita");
        System.out.println("1. Agregar Paciente");
        opcion = in.nextInt();

        switch (opcion){
            case 1:
                OpcionesCita cita1 = new OpcionesCita();
                cita1.opcionesCitasMedicas();
                break;

            case 2:
                OpcionesPaciente paciente1 = new OpcionesPaciente();
                paciente1.opcionePaciente();
                break;
        }

    }

}
