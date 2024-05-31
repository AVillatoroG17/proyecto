import java.util.Scanner;

public class peticionUsuario {
    Scanner in = new Scanner(System.in);

    private int opcion;
    private int accion;

    public void pedirUsuario() {
        System.out.println("Con que usuario desea ingresar: ");
        System.out.println("1. Doctor ");
        System.out.println("2. Medico ");
        System.out.println("3. Secretaria");
        System.out.println("4. Administrador");
        this.opcion = in.nextInt();
        in.nextLine(); // consume the newline

        switch (opcion) {
            case 1:
                System.out.println("Bienvenido a la clinica Ingenieria total");
                System.out.println("Usted ha ingresado con el perfil Doctor");
                mostrarMenuDoctor();
                break;

            case 2:
                System.out.println("Bienvenido a la clinica Ingenieria total");
                System.out.println("Usted ha ingresado con el perfil Medico");
                mostrarMenuMedico();
                break;

            case 3:
                System.out.println("Bienvenido a la clinica Ingenieria total");
                System.out.println("Usted ha ingresado con el perfil Secretaria");
                mostrarMenuSecretaria();
                break;

            case 4:
                System.out.println("Bienvenido a la clinica Ingenieria total");
                System.out.println("Usted ha ingresado con el perfil Administrador");
                mostrarMenuAdministrador();
                break;

            default:
                System.out.println("Opcion no valida. Intente de nuevo.");
                pedirUsuario();
                break;
        }
    }

    private void mostrarMenuDoctor() {
            System.out.println("1. Añadir paciente");
            System.out.println("2. Eliminar paciente");
            System.out.println("3. Consultar paciente");
            System.out.println("4. Actualizar paciente");
            System.out.println("5. Consultar citas");
            System.out.println("6. Salir");
            accion = in.nextInt();
            in.nextLine();
            switch (accion) {
                case 1:
                    AgregarPaciente pacienteNuevo = new AgregarPaciente();

                    pacienteNuevo.agregarPaciente();
                    break;
                case 2:
// eliminar...
                    break;
                case 3:
// Consultar...
                    break;
                case 4:
// Actualizar...
                    break;
                case 5:
// Consultar cita...
                    break;
                case 6:
                    System.out.println("Saliendo del menu...");
                    break;
                default:
                    System.out.println("Opcion no valida. Intente de nuevo.");
                    break;
            }
    }

    private void mostrarMenuMedico() {
        do {
            System.out.println("1. Consultar paciente");
            System.out.println("2. Actualizar paciente");
            System.out.println("3. Consultar citas");
            System.out.println("4. Salir");
            accion = in.nextInt();
            in.nextLine();
            switch (accion) {
                case 1:
// Consultar...
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    System.out.println("Saliendo del menu...");
                    break;
                default:
                    System.out.println("Opcion no valida. Intente de nuevo.");
                    break;
            }
        } while (accion != 4);
    }

    private void mostrarMenuSecretaria() {
            System.out.println("1. Consultar paciente");
            System.out.println("2. Actualizar paciente");
            System.out.println("3. Crear citas");
            System.out.println("4. Eliminar citas");
            System.out.println("5. Consultar citas");
            System.out.println("6. Salir");
            accion = in.nextInt();
            in.nextLine();
            switch (accion) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:
                    System.out.println("Saliendo del menu...");
                    break;
                default:
                    System.out.println("Opcion no valida. Intente de nuevo.");
                    break;
            }
    }

    private void mostrarMenuAdministrador() {
        do {
            System.out.println("1. Añadir doctor");
            System.out.println("2. Añadir medico");
            System.out.println("3. Eliminar doctor");
            System.out.println("4. Eliminar medico");
            System.out.println("5. Añadir paciente");
            System.out.println("6. Eliminar paciente");
            System.out.println("7. Consultar paciente");
            System.out.println("8. Actualizar paciente");
            System.out.println("9. Consultar citas");
            System.out.println("10. Salir");
            accion = in.nextInt();
            in.nextLine();
            switch (accion) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:
                    ;
                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:

                    break;
                case 9:

                    break;
                case 10:
                    System.out.println("Saliendo del menu...");
                    break;
                default:
                    System.out.println("Opcion no valida. Intente de nuevo.");
                    break;
            }
        } while (accion != 10);
    }
}