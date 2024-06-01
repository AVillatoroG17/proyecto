import java.util.Scanner;
public class aplicacion {
    public static void main(String[] args) {
        // Colores
        String negro = "\033[30m", rojo = "\033[31m", verde = "\033[32m", amarillo = "\033[33m", azul = "\033[34m", magenta = "\033[35m", celeste = "\033[36m", blanco = "\033[37m";
        String fRojo = "\033[41m", fVerde = "\033[42m", fAmarillo = "\033[43m", fAzul = "\033[44m", fMagenta = "\033[45m", fCeleste = "\033[46m", fGris = "\033[47m";
        String borrar = "\u001B[0m"; //borrar

        int opcion;
        Scanner in = new Scanner(System.in);

        System.out.println(fRojo + negro + " +++++++++++++++++++++++++++++++++++++++++++++++++ " + borrar);
        System.out.println(fRojo + negro + " *Bienvenido Indique la Opcion que desea realizar+ " + borrar);
        System.out.println(fRojo + negro + " +++++++++++++++++++++++++++++++++++++++++++++++++ " + borrar);
        System.out.println("");
        System.out.println(fAmarillo + negro + "1. Opciones Cita" + borrar);
        System.out.println("");
        System.out.println(fCeleste + negro + "2. Opciones Paciente" + borrar);
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

