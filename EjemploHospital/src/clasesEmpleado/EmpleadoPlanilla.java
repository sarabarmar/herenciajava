package clasesEmpleado;

import javax.swing.JOptionPane;

public class EmpleadoPlanilla extends Empleado {
    private double salarioMensual;
    private double porcentajeHoraExtra;

    public double getSalarioMensual() { return salarioMensual; }
    public void setSalarioMensual(double salarioMensual) { this.salarioMensual = salarioMensual; }
    public double getPorcentajeHoraExtra() { return porcentajeHoraExtra; }
    public void setPorcentajeHoraExtra(double porcentajeHoraExtra) { this.porcentajeHoraExtra = porcentajeHoraExtra; }

    @Override
    public void registrarDatos() {
        super.registrarDatos();
        try {
            setCodigoDeEmpleado(JOptionPane.showInputDialog("Ingrese código de empleado (planilla):"));
            setCargo(JOptionPane.showInputDialog("Ingrese cargo:"));
            setArea(JOptionPane.showInputDialog("Ingrese área:"));
            String horas = JOptionPane.showInputDialog("Ingrese número horas extras (entero):");
            if (horas != null && !horas.isEmpty()) setNumeroDeHorasExtras(Integer.parseInt(horas));
            String s = JOptionPane.showInputDialog("Ingrese salario mensual (ej. 1200000):");
            if (s != null && !s.isEmpty()) setSalarioMensual(Double.parseDouble(s));
            String p = JOptionPane.showInputDialog("Ingrese porcentaje adicional por hora extra (ej. 0.25):");
            if (p != null && !p.isEmpty()) setPorcentajeHoraExtra(Double.parseDouble(p));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al registrar empleado de planilla.");
        }
    }

    @Override
    public void imprimirDatosPersona(String encabezado) {
        String datos = "EMPLEADO PLANILLA\n";
        datos += "Nombre: " + getNombre() + " " + getApellido() + "\n";
        datos += "DNI: " + getNumeroDeDNI() + "\n";
        datos += "Código: " + getCodigoDeEmpleado() + "\n";
        datos += "Cargo: " + getCargo() + "\n";
        datos += "Área: " + getArea() + "\n";
        datos += "Horas extras: " + getNumeroDeHorasExtras() + "\n";
        datos += "Salario mensual: " + getSalarioMensual() + "\n";
        datos += "Porcentaje hora extra: " + getPorcentajeHoraExtra() + "\n";
        datos += "-----------------------------";
        System.out.println(datos);
    }
}
