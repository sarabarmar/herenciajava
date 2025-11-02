package clasesEmpleado;

import clases.Persona;

public class Empleado extends Persona {
    private String codigoDeEmpleado;
    private int numeroDeHorasExtras;
    private String fechaDeIngreso;
    private String area;
    private String cargo;

    public String getCodigoDeEmpleado() { return codigoDeEmpleado; }
    public void setCodigoDeEmpleado(String codigoDeEmpleado) { this.codigoDeEmpleado = codigoDeEmpleado; }
    public int getNumeroDeHorasExtras() { return numeroDeHorasExtras; }
    public void setNumeroDeHorasExtras(int numeroDeHorasExtras) { this.numeroDeHorasExtras = numeroDeHorasExtras; }
    public String getFechaDeIngreso() { return fechaDeIngreso; }
    public void setFechaDeIngreso(String fechaDeIngreso) { this.fechaDeIngreso = fechaDeIngreso; }
    public String getArea() { return area; }
    public void setArea(String area) { this.area = area; }
    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    @Override
    public void registrarDatos() {
        super.registrarDatos();

    }

    @Override
    public void imprimirDatosPersona(String encabezado) {
        String datos = "EMPLEADO\n";
        datos += "Nombre: " + getNombre() + " " + getApellido() + "\n";
        datos += "DNI: " + getNumeroDeDNI() + "\n";
        datos += "Código empleado: " + getCodigoDeEmpleado() + "\n";
        datos += "Cargo: " + getCargo() + "\n";
        datos += "Área: " + getArea() + "\n";
        datos += "-----------------------------";
        System.out.println(datos);
    }
}
