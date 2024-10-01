package co.edu.uniquindio.poo;

import java.util.Collection;
import java.util.LinkedList;

public class Bibliotecario extends Persona {

    private double salario;
    private int antiguedad;
    private Collection<Prestamo> prestamos;

    public Bibliotecario(String nombre, int cedula, int telefono, String correo, double salario, int antiguedad) {
        super(nombre, cedula, telefono, correo);
        this.salario = salario;
        this.antiguedad = antiguedad;
        prestamos = new LinkedList<>();
    }

    /**
     * Metodo para agregar un prestamo a la lista de prestamos de un bibliotecario
     * 
     * @param prestamo
     */
    public void agregarPrestamoBibliotecario(Prestamo prestamo) {
        prestamos.add(prestamo);
    }

    /**
     * Metodo para eliminar un prestamo de la lista de prestamos de un bibliotecario
     * 
     * @param codigo
     */
    public void eliminarPrestamoBibliotecario(String codigo) {
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getCodigo().equals(codigo)) {
                prestamos.remove(prestamo);
            }
        }
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public Collection<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(Collection<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    @Override
    public String toString() {
        return super.toString() + ", salario=" + salario + ", antiguedad=" + antiguedad + ", prestamos=" + prestamos
                + "]";
    }

}
