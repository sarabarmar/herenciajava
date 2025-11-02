package clases;

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Paciente extends Persona {
    private String numeroHistoriaClinica;
    private String sexo;
    private String grupoSanguineo;
    private ArrayList<String> alergias;

    public Paciente() {
        alergias = new ArrayList<>();
    }

    public String getNumeroHistoriaClinica() { return numeroHistoriaClinica; }
    public void setNumeroHistoriaClinica(String numeroHistoriaClinica) { this.numeroHistoriaClinica = numeroHistoriaClinica; }
    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }
    public String getGrupoSanguineo() { return grupoSanguineo; }
    public void setGrupoSanguineo(String grupoSanguineo) { this.grupoSanguineo = grupoSanguineo; }
    public ArrayList<String> getAlergias() { return alergias; }

    @Override
    public void registrarDatos() {
        super.registrarDatos();
        try {
            setNumeroHistoriaClinica(JOptionPane.showInputDialog("Ingrese número de historia clínica:"));
            setSexo(JOptionPane.showInputDialog("Ingrese sexo:"));
            setGrupoSanguineo(JOptionPane.showInputDialog("Ingrese grupo sanguíneo:"));
            String continuar;
            do {
                continuar = JOptionPane.showInputDialog("¿Agregar alergia? (s/n)");
                if (continuar != null && continuar.equalsIgnoreCase("s")) {
                    String med = JOptionPane.showInputDialog("Nombre medicamento alérgeno:");
                    if (med != null && !med.trim().isEmpty()) alergias.add(med.trim());
                }
            } while (continuar != null && continuar.equalsIgnoreCase("s"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al registrar paciente.");
        }
    }

    @Override
    public void imprimirDatosPersona(String encabezado) {
        String datos = "PACIENTE\n";
        datos += "Nombre: " + getNombre() + " " + getApellido() + "\n";
        datos += "DNI: " + getNumeroDeDNI() + "\n";
        datos += "Historia clínica: " + getNumeroHistoriaClinica() + "\n";
        datos += "Sexo: " + getSexo() + "\n";
        datos += "Grupo sanguíneo: " + getGrupoSanguineo() + "\n";
        if (!alergias.isEmpty()) {
            datos += "Alergias: " + String.join(", ", alergias) + "\n";
        } else {
            datos += "Alergias: Ninguna\n";
        }
        datos += "-----------------------------";
        System.out.println(datos);
    }
}
