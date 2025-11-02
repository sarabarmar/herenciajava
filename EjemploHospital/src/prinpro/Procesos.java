package prinpro;

import javax.swing.JOptionPane;
import clases.ModeloDatos;
import clases.Paciente;
import clases.Medico;
import clases.CitaMedica;
import clasesEmpleado.EmpleadoEventual;
import clasesEmpleado.EmpleadoPlanilla;

public class Procesos {

    private ModeloDatos miModeloDatos;

    public Procesos() {
        miModeloDatos = new ModeloDatos();
        presentarMenuOpciones();
    }

    private void presentarMenuOpciones() {
        String menu = "MENU PRINCIPAL\n";
        menu += "1. Registrar Paciente\n";
        menu += "2. Registrar Empleado\n";
        menu += "3. Registrar Medico\n";
        menu += "4. Registrar Cita Medica\n";
        menu += "5. Imprimir Información\n";
        menu += "6. Salir\n";

        int opcion = 0;
        do {
            try {
                String entrada = JOptionPane.showInputDialog(menu);
                if (entrada == null) { opcion = 6; break; }
                opcion = Integer.parseInt(entrada);
                evaluarOpcion(opcion);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Debe ingresar una opción válida");
            }
        } while (opcion != 6);
    }

    private void evaluarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                registrarPaciente();
                break;
            case 2:
                registrarEmpleado();
                break;
            case 3:
                registrarMedico();
                break;
            case 4:
                registrarCitaMedica();
                break;
            case 5:
                imprimirInformacion();
                break;
            case 6:
                JOptionPane.showMessageDialog(null, "Hasta pronto!");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción no válida");
                break;
        }
    }

    private void registrarPaciente() {
        Paciente miPaciente = new Paciente();
        miPaciente.registrarDatos();
        miModeloDatos.registrarPersona(miPaciente);
    }

    private void registrarEmpleado() {
        String menu = "TIPO DE EMPLEADO\n";
        menu += "1. Empleado Eventual\n";
        menu += "2. Empleado de Planilla\n";
        try {
            String entrada = JOptionPane.showInputDialog(menu);
            if (entrada == null) return;
            int tipo = Integer.parseInt(entrada);

            if (tipo == 1) {
                EmpleadoEventual empEventual = new EmpleadoEventual();
                empEventual.registrarDatos();
                miModeloDatos.registrarPersona(empEventual);
            } else if (tipo == 2) {
                EmpleadoPlanilla empPlanilla = new EmpleadoPlanilla();
                empPlanilla.registrarDatos();

                miModeloDatos.registrarPersona(empPlanilla);
            } else {
                JOptionPane.showMessageDialog(null, "Tipo no válido");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en selección de tipo de empleado.");
        }
    }

    private void registrarMedico() {
        Medico miMedico = new Medico();
        miMedico.registrarDatos();
        miModeloDatos.registrarPersona(miMedico);
    }

    private void registrarCitaMedica() {
        miModeloDatos.registrarCitaMedica();
    }

    private void imprimirInformacion() {
        String menu = "IMPRIMIR INFORMACIÓN\n";
        menu += "1. Pacientes\n";
        menu += "2. Empleados Eventuales\n";
        menu += "3. Empleados de Planilla\n";
        menu += "4. Médicos\n";
        menu += "5. Citas Médicas\n";
        try {
            String entrada = JOptionPane.showInputDialog(menu);
            if (entrada == null) return;
            int opcion = Integer.parseInt(entrada);

            switch (opcion) {
                case 1:
                    miModeloDatos.imprimirPacientes();
                    break;
                case 2:
                    miModeloDatos.imprimirEmpleadosEventuales();
                    break;
                case 3:
                    miModeloDatos.imprimirEmpleadosPlanilla();
                    break;
                case 4:
                    miModeloDatos.imprimirMedicos();
                    break;
                case 5:
                    miModeloDatos.imprimirCitasMedicas();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al seleccionar opción de impresión.");
        }
    }
}
