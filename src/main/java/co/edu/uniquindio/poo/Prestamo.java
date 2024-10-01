package co.edu.uniquindio.poo;

import java.util.Collection;
import java.util.LinkedList;

public class Prestamo {

    private double total;
    private String fechaEnt;
    private String fechaPrest;
    private String codigo;
    private Estudiante estudiante;
    private Bibliotecario bibliotecario;
    private Collection<DetallePrestamo> detallePrestamos;

    public Prestamo(double total, String fechaEnt, String fechaPrest, String codigo, Estudiante estudiante,
            Bibliotecario bibliotecario) {
        this.total = total;
        this.fechaEnt = fechaEnt;
        this.fechaPrest = fechaPrest;
        this.codigo = codigo;
        this.estudiante = estudiante;
        this.bibliotecario = bibliotecario;
        detallePrestamos = new LinkedList<>();
    }

    
    /**
     * Metodo para eliminar un detalle prestamo
     * @param libro
     * @param cantidad
     * @param subTotal
     */
    public void eliminarDetallePrestamo(Libro libro, int cantidad, double subTotal) {
        for (DetallePrestamo detalle : detallePrestamos) {
            if (detalle.getLibro().equals(libro) && detalle.getCantidad() == cantidad
                    && detalle.getSubTotal() == subTotal) {
                detallePrestamos.remove(detalle);
            }
        }
    }

    /**
     * Metodo para añadir un detalle prestamo
     * @param detallePrestamo
     */
    public static void añadirDetallePrestamo(Prestamo prestamo, DetallePrestamo detallePrestamo) {
        prestamo.detallePrestamos.add(detallePrestamo);
    }
    

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getFechaEnt() {
        return fechaEnt;
    }

    public void setFechaEnt(String fechaEnt) {
        this.fechaEnt = fechaEnt;
    }

    public String getFechaPrest() {
        return fechaPrest;
    }

    public void setFechaPrest(String fechaPrest) {
        this.fechaPrest = fechaPrest;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Bibliotecario getBibliotecario() {
        return bibliotecario;
    }

    public void setBibliotecario(Bibliotecario bibliotecario) {
        this.bibliotecario = bibliotecario;
    }

    public Collection<DetallePrestamo> getDetallePrestamos() {
        return detallePrestamos;
    }

    public void setDetallePrestamos(Collection<DetallePrestamo> detallePrestamos) {
        this.detallePrestamos = detallePrestamos;
    }

    @Override
    public String toString() {
        return "[total=" + total + ", fecha entrega=" + fechaEnt + ", fecha prestamo=" + fechaPrest
                + ", codigo=" + codigo + ", estudiante(cedula)=" + estudiante.getCedula() + ", bibliotecario(cedula)="
                + bibliotecario.getCedula()
                + ", detalles prestamo=" + detallePrestamos + "]";
    }

}
