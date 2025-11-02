package clases;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import clasesEmpleado.EmpleadoEventual;
import clasesEmpleado.EmpleadoPlanilla;

public class ModeloDatos {

    private HashMap<String, Paciente> listaPacientes;
    private HashMap<String, EmpleadoEventual> listaEmpleadosEventuales;
    private HashMap<String, EmpleadoPlanilla> listaEmpleadosPlanilla;
    private HashMap<String, Medico> listaMedicos;
    private ArrayList<CitaMedica> listaCitasMedicas;

    public ModeloDatos() {
        listaPacientes = new HashMap<>();
        listaEmpleadosEventuales = new HashMap<>();
        listaEmpleadosPlanilla = new HashMap<>();
        listaMedicos = new HashMap<>();
        listaCitasMedicas = new ArrayList<>();
    }

    // Sobrecarga para cada tipo
    public void registrarPersona(Paciente miPaciente) {
        if (miPaciente == null || miPaciente.getNumeroDeDNI() == null) return;
        if (listaPacientes.containsKey(miPaciente.getNumeroDeDNI())) {
            JOptionPane.showMessageDialog(null, "Paciente ya registrado.");
            return;
        }
        listaPacientes.put(miPaciente.getNumeroDeDNI(), miPaciente);
    }

    public void registrarPersona(EmpleadoEventual empEventual) {
        if (empEventual == null || empEventual.getNumeroDeDNI() == null) return;
        if (listaEmpleadosEventuales.containsKey(empEventual.getNumeroDeDNI())) {
            JOptionPane.showMessageDialog(null, "Empleado eventual ya registrado.");
            return;
        }
        listaEmpleadosEventuales.put(empEventual.getNumeroDeDNI(), empEventual);
    }

    public void registrarPersona(EmpleadoPlanilla empPlanilla) {
        if (empPlanilla == null || empPlanilla.getNumeroDeDNI() == null) return;
        if (listaEmpleadosPlanilla.containsKey(empPlanilla.getNumeroDeDNI())) {
            JOptionPane.showMessageDialog(null, "Empleado (planilla) ya registrado.");
            return;
        }
    
        listaEmpleadosPlanilla.put(empPlanilla.getNumeroDeDNI(), empPlanilla);
    }

    public void registrarPersona(Medico miMedico) {
        if (miMedico == null || miMedico.getNumeroDeDNI() == null) return;
        if (listaMedicos.containsKey(miMedico.getNumeroDeDNI())) {
            JOptionPane.showMessageDialog(null, "Médico ya registrado.");
            return;
        }
        listaMedicos.put(miMedico.getNumeroDeDNI(), miMedico);

        listaEmpleadosPlanilla.put(miMedico.getNumeroDeDNI(), miMedico);
    }

    public void imprimirPacientes() {
        if (listaPacientes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay pacientes registrados");
            return;
        }
        for (Paciente p : listaPacientes.values()) {
            p.imprimirDatosPersona("");
        }
    }

    public void imprimirEmpleadosEventuales() {
        if (listaEmpleadosEventuales.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay empleados eventuales registrados");
            return;
        }
        for (EmpleadoEventual e : listaEmpleadosEventuales.values()) {
            e.imprimirDatosPersona("");
        }
    }

    public void imprimirEmpleadosPlanilla() {
        if (listaEmpleadosPlanilla.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay empleados de planilla registrados");
            return;
        }
        for (EmpleadoPlanilla emp : listaEmpleadosPlanilla.values()) {
            emp.imprimirDatosPersona("");
        }
    }

    public void imprimirMedicos() {
        if (listaMedicos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay médicos registrados");
            return;
        }
        for (Map.Entry<String, Medico> elemento : listaMedicos.entrySet()) {
            elemento.getValue().imprimirDatosPersona("");
        }
    }

    public void registrarCitaMedica() {
        String documentoPaciente = JOptionPane.showInputDialog("Ingrese el documento del paciente:");
        Paciente miPaciente = listaPacientes.get(documentoPaciente);

        if (miPaciente == null) {
            JOptionPane.showMessageDialog(null, "El paciente no está registrado");
            return;
        }

        String nombreMedico = JOptionPane.showInputDialog("Ingrese el nombre del médico:");
        Medico miMedico = null;

        for (Medico medico : listaMedicos.values()) {
            if (medico.getNombre().equalsIgnoreCase(nombreMedico)) {
                miMedico = medico;
                break;
            }
        }

        if (miMedico == null) {
            JOptionPane.showMessageDialog(null, "El médico no está registrado");
            return;
        }

        String servicio = JOptionPane.showInputDialog("Ingrese el servicio:");
        String fecha = JOptionPane.showInputDialog("Ingrese la fecha:");
        String hora = JOptionPane.showInputDialog("Ingrese la hora:");

        CitaMedica miCita = new CitaMedica(miPaciente, miMedico, servicio, fecha, hora);
        listaCitasMedicas.add(miCita);
        JOptionPane.showMessageDialog(null, "Cita médica registrada con éxito");
    }

    public void imprimirCitasMedicas() {
        if (listaCitasMedicas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay citas médicas registradas");
            return;
        }
        for (CitaMedica cita : listaCitasMedicas) {
            cita.imprimirCita();
        }
    }
}
