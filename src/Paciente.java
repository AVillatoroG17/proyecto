public class Paciente {

    private String nombre_paciente, apellido_paciente, sexo, tipo_de_sangre;
    private int DPI, id_paciente, telefono, edad, id_cita, id_medico;

    public String getNombre_paciente() {return nombre_paciente;}

    public void setNombre_paciente(String nombre_paciente) {
        this.nombre_paciente = nombre_paciente;
    }

    public String getApellido_paciente() {return apellido_paciente;}

    public void setApellido_paciente(String apellido_paciente) {
        this.apellido_paciente = apellido_paciente;
    }

    public int getDPI() {return DPI;}

    public void setDPI(int DPI) {
        this.DPI = DPI;
    }

    public int getEdad() {return edad;}

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getId_paciente() {return id_paciente;}

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public String getSexo() {return sexo;}

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTipo_de_sangre() {return tipo_de_sangre;}

    public void setTipo_de_sangre(String tipo_de_sangre) {
        this.tipo_de_sangre = tipo_de_sangre;
    }

    public int getTelefono() {return telefono;}

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getId_cita() {return id_cita;}

    public void setId_cita(int id_cita) {
        this.id_cita = id_cita;
    }

    public int getId_medico() {return id_medico;}

    public void setId_medico(int id_medico) {
        this.id_medico = id_medico;
    }
}
