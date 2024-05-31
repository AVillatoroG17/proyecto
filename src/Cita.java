public class Cita {

    private String nombre_paciente, fecha_de_reservacion, motivo, nombre_doctor, fecha_de_cita;
    private int DPI, id_medico, id_cita;

    public String getNombre_paciente() {
        return nombre_paciente;
    }

    public void setNombre_paciente(String nombre_paciente) {
        this.nombre_paciente = nombre_paciente;
    }

    public int getDPI() {
        return DPI;
    }

    public void setDPI(int DPI) {
        this.DPI = DPI;
    }

    public String getFecha_de_reservacion() {
        return fecha_de_reservacion;
    }

    public void setFecha_de_reservacion(String fecha_de_reservacion) {
        this.fecha_de_reservacion = fecha_de_reservacion;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getNombre_doctor() {
        return nombre_doctor;
    }

    public void setNombre_doctor(String nombre_doctor) {
        this.nombre_doctor = nombre_doctor;
    }

    public int getId_medico() {
        return id_medico;
    }

    public void setId_medico(int id_medico) {
        this.id_medico = id_medico;
    }

    public String getFecha_de_cita() {
        return fecha_de_cita;
    }

    public void setFecha_de_cita(String fecha_de_cita) {
        this.fecha_de_cita = fecha_de_cita;
    }

    public int getId_cita() {
        return id_cita;
    }

    public void setId_cita(int id_cita) {
        this.id_cita = id_cita;

    }
}
