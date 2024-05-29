import java.util.Scanner;
public class peticionUsuario {
    Scanner in = new Scanner(System.in);

    private String Doctor, Medico, Secretaria, Administrador;
    private int opcion;

    public void pedirUsuario(){

        System.out.println("Con que usuario desea ingresar: ");
        System.out.println("1. Doctor ");
        System.out.println("2. Medico ");
        System.out.println("3. Secretaria");
        System.out.println("4. Administrador");
        this.opcion = in.nextInt();

        switch (opcion){

            case 1:
                System.out.println("Bienvenido a la clinica Ingenieria total");
                System.out.println("Usted ha ingresado con el perfil Doctor");
                this.Doctor = in.nextLine();
                break;

            case 2:
                System.out.println("Bienvenido a la clinica Ingenieria total");
                System.out.println("Usted ha ingresado con el perfil Medico");
                this.Medico = in.nextLine();
                break;

            case 3:
                System.out.println("Bienvenido a la clinica Ingenieria total");
                System.out.println("Usted ha ingresado con el perfil Secretaria");
                this.Secretaria = in.nextLine();
                break;

            case 4:
                System.out.println("Bienvenido a la clinica Ingenieria total");
                System.out.println("Usted ha ingresado con el perfil Administrador");
                this.Administrador = in.nextLine();
                break;

        }

        //preparara para el main
    }

}
