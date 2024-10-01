package co.edu.uniquindio.poo;

import java.util.Collection;
import java.util.LinkedList;

public class Estudiante extends Persona {

    private int edad;
    private Collection<Prestamo> prestamos;

    public Estudiante(String nombre, int cedula, int telefono, String correo, int edad) {
        super(nombre, cedula, telefono, correo);
        this.edad = edad;
        prestamos = new LinkedList<>();
    }

    /**
     * Metodo para agregar un prestamo a la lista de prestamos de un estudiante
     * 
     * @param prestamo
     */
    public void agregarPrestamoEstudiante(Prestamo prestamo) {
        prestamos.add(prestamo);
    }

    /**
     * Metodo para eliminar un prestamo de la lista de prestamos de un estudiante
     * 
     * @param codigo
     */
    public void eliminarPrestamoEstudiante(String codigo) {
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getCodigo().equals(codigo)) {
                prestamos.remove(prestamo);

            }
        }
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Collection<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(Collection<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    @Override
    public String toString() {
        return super.toString() + ", edad=" + edad + ", prestamos=" + prestamos + "]";
    }

}
