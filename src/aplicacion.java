import java.util.Scanner;
public class aplicacion {
    public static void main(String[] args) {
        int opcion;
        Scanner in = new Scanner(System.in);

        System.out.println("Indique la Opcion que desea realizar");
        System.out.println("1. Opciones Cita");
        System.out.println("2. Opciones Paciente");
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

