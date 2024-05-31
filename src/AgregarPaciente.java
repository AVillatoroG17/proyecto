import java.util.Scanner;
public class AgregarPaciente {
    Scanner in = new Scanner(System.in);
    private String nombre, apellido,fecha_de_reserva, nombre_medico, apellido_medico,  motivo, fecha_de_cita;
    private int id_paciente, id_medico, DPI;

    public void agregarPaciente(){
        System.out.println("Ingrese el nombre del paciente");
        this.nombre = in.nextLine();
        System.out.println("Ingrese el apellido del paciente");
        this.apellido = in.nextLine();
        System.out.println("Ingrese el DPI del paciente");
        this.DPI = in.nextInt();
        System.out.println("Ingrese el id del paciente");
        this.id_paciente = in.nextInt();
        System.out.println("Ingrese la fecha de reserva");
        this.fecha_de_reserva = in.nextLine();
        System.out.println("Ingrese el nombre del medico que lo atendera");
        this.nombre_medico = in.nextLine();
        System.out.println("Ingrese el apellido del medico que lo atendera");
        this.apellido_medico = in.nextLine();
        System.out.println("Ingrese el id del medico que lo atendera");
        this.id_medico = in.nextInt();
        System.out.println("Ingrese el motivo por el cual reservo la cita");
        this.motivo = in.nextLine();
        System.out.println("Ingrese la fecha donde se le atendera");
        this.fecha_de_cita = in.nextLine();
    }

    //hello

}
