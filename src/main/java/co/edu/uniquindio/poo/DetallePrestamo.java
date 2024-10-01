package co.edu.uniquindio.poo;

public class DetallePrestamo {

    private int cantidad;
    private double subTotal;
    private Libro libro;

    public DetallePrestamo(int cantidad, Libro libro) {
        this.cantidad = cantidad;
        this.libro = libro;
        this.subTotal = calcularSubTotal(cantidad, libro);
    }

    /**
     * Metodo para calcular el subTotal de un libro
     * 
     * @return
     */
    public static double calcularSubTotal(int cantidad, Libro libro) {
        double subTotal = cantidad * libro.getPrecio();
        return subTotal;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    @Override
    public String toString() {
        return "[cantidad=" + cantidad + ", subTotal=" + subTotal + ", libro=" + libro + "]";
    }

}
