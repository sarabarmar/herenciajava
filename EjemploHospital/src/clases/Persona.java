package clases;

import javax.swing.JOptionPane;

public class Persona {
    private String numeroDeDNI;
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private String direccion;
    private String ciudadProcedencia;

    public String getNumeroDeDNI() { return numeroDeDNI; }
    public void setNumeroDeDNI(String numeroDeDNI) { this.numeroDeDNI = numeroDeDNI; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public String getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(String fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public String getCiudadProcedencia() { return ciudadProcedencia; }
    public void setCiudadProcedencia(String ciudadProcedencia) { this.ciudadProcedencia = ciudadProcedencia; }


    public void registrarDatos() {
        try {
            setNumeroDeDNI(JOptionPane.showInputDialog("Ingrese número de DNI:"));
            setNombre(JOptionPane.showInputDialog("Ingrese nombre:"));
            setApellido(JOptionPane.showInputDialog("Ingrese apellido:"));
            setFechaNacimiento(JOptionPane.showInputDialog("Ingrese fecha de nacimiento:"));
            setDireccion(JOptionPane.showInputDialog("Ingrese dirección:"));
            setCiudadProcedencia(JOptionPane.showInputDialog("Ingrese ciudad de procedencia:"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al ingresar datos de persona.");
        }
    }


    public void imprimirDatosPersona(String encabezado) {
        String datos = encabezado + "\n";
        datos += "Nombre: " + getNombre() + " " + getApellido() + "\n";
        datos += "DNI: " + getNumeroDeDNI() + "\n";
        datos += "Fecha Nac.: " + getFechaNacimiento() + "\n";
        datos += "Dirección: " + getDireccion() + "\n";
        datos += "Ciudad: " + getCiudadProcedencia() + "\n";
        System.out.println(datos);
    }
}

