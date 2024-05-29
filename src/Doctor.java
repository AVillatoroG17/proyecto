import java.util.Scanner;
public class Doctor {
    Scanner in = new Scanner(System.in);
    private String nombre, apellid0, especialidad, licencia_medica;
    private int id_medico, edad, telefono, DPI;

    public void crearDoctor(){
        System.out.println("Ingrese el nombre del doctor");
        this.nombre = in.nextLine();
        System.out.println("Ingrese el apellido del doctor");
        this.apellid0 = in.nextLine();
        System.out.println("Ingres el DPI del doctor");
        this.DPI = in.nextInt();
        System.out.println("Ingrese la especialidad");
        this.especialidad = in.nextLine();
        System.out.println("Ingrese la licencia medica");
        this.licencia_medica = in.nextLine();
        System.out.println("Ingrese el id del medico");
        this.id_medico = in.nextInt();
        System.out.println("Ingrese la edad del medico");
        this.edad = in.nextInt();
        System.out.println("Ingrese el numero del telefono del doctor");
        this.telefono = in.nextInt();
    }
}
