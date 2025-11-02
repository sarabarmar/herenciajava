package clases;

public class CitaMedica {
    private Paciente paciente;
    private Medico medico;
    private String servicio;
    private String fecha;
    private String hora;

    public CitaMedica(Paciente paciente, Medico medico, String servicio, String fecha, String hora) {
        this.paciente = paciente;
        this.medico = medico;
        this.servicio = servicio;
        this.fecha = fecha;
        this.hora = hora;
    }

    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }
    public Medico getMedico() { return medico; }
    public void setMedico(Medico medico) { this.medico = medico; }
    public String getServicio() { return servicio; }
    public void setServicio(String servicio) { this.servicio = servicio; }
    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }
    public String getHora() { return hora; }
    public void setHora(String hora) { this.hora = hora; }

    public void imprimirCita() {
        String datos = "CITA MÉDICA\n";
        datos += "Paciente: " + paciente.getNombre() + " " + paciente.getApellido() + "\n";
        datos += "Médico: " + medico.getNombre() + " " + medico.getApellido() + "\n";
        datos += "Servicio: " + servicio + "\n";
        datos += "Fecha: " + fecha + "\n";
        datos += "Hora: " + hora + "\n";
        datos += "Consultorio: " + medico.getNumeroDeConsultorio() + "\n";
        datos += "-----------------------------";
        System.out.println(datos);
    }
}
