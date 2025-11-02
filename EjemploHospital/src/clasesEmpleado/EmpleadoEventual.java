package clasesEmpleado;

import javax.swing.JOptionPane;

public class EmpleadoEventual extends Empleado {
    private double honorariosPorHora;
    private String fechaFinContrato;

    public double getHonorariosPorHora() { return honorariosPorHora; }
    public void setHonorariosPorHora(double honorariosPorHora) { this.honorariosPorHora = honorariosPorHora; }
    public String getFechaFinContrato() { return fechaFinContrato; }
    public void setFechaFinContrato(String fechaFinContrato) { this.fechaFinContrato = fechaFinContrato; }

    @Override
    public void registrarDatos() {
        super.registrarDatos();
        try {
            setCodigoDeEmpleado(JOptionPane.showInputDialog("Ingrese código de empleado eventual:"));
            setCargo(JOptionPane.showInputDialog("Ingrese cargo:"));
            setArea(JOptionPane.showInputDialog("Ingrese área:"));
            String horas = JOptionPane.showInputDialog("Ingrese número horas extras (entero):");
            if (horas != null && !horas.isEmpty()) setNumeroDeHorasExtras(Integer.parseInt(horas));
            String h = JOptionPane.showInputDialog("Ingrese honorarios por hora (ej. 12.5):");
            if (h != null && !h.isEmpty()) setHonorariosPorHora(Double.parseDouble(h));
            setFechaFinContrato(JOptionPane.showInputDialog("Fecha fin de contrato:"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al registrar empleado eventual.");
        }
    }

    @Override
    public void imprimirDatosPersona(String encabezado) {
        String datos = "EMPLEADO EVENTUAL\n";
        datos += "Nombre: " + getNombre() + " " + getApellido() + "\n";
        datos += "DNI: " + getNumeroDeDNI() + "\n";
        datos += "Código: " + getCodigoDeEmpleado() + "\n";
        datos += "Cargo: " + getCargo() + "\n";
        datos += "Área: " + getArea() + "\n";
        datos += "Horas extras: " + getNumeroDeHorasExtras() + "\n";
        datos += "Honorarios/hora: " + getHonorariosPorHora() + "\n";
        datos += "Fin contrato: " + getFechaFinContrato() + "\n";
        datos += "-----------------------------";
        System.out.println(datos);
    }
}
