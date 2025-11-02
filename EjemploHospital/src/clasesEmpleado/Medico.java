package clases;

import javax.swing.JOptionPane;
import clasesEmpleado.EmpleadoPlanilla;

public class Medico extends EmpleadoPlanilla {
    private String especialidad;
    private int numeroDeConsultorio;

    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }
    public int getNumeroDeConsultorio() { return numeroDeConsultorio; }
    public void setNumeroDeConsultorio(int numeroDeConsultorio) { this.numeroDeConsultorio = numeroDeConsultorio; }

    @Override
    public void registrarDatos() {
        super.registrarDatos();
        try {
            setEspecialidad(JOptionPane.showInputDialog("Ingrese especialidad:"));
            String n = JOptionPane.showInputDialog("Ingrese número de consultorio (entero):");
            if (n != null && !n.isEmpty()) setNumeroDeConsultorio(Integer.parseInt(n));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al registrar médico.");
        }
    }

    @Override
    public void imprimirDatosPersona(String encabezado) {
        String datos = "MÉDICO\n";
        datos += "Nombre: " + getNombre() + " " + getApellido() + "\n";
        datos += "DNI: " + getNumeroDeDNI() + "\n";
        datos += "Especialidad: " + getEspecialidad() + "\n";
        datos += "Consultorio: " + getNumeroDeConsultorio() + "\n";
        datos += "-----------------------------";
        System.out.println(datos);
    }
}
