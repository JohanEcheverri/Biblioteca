package co.edu.uniquindio.poo;

public class Libro {

    private String codigo;
    private String isbn;
    private String autor;
    private String titulo;
    private String editorial;
    private String fechaPub;
    private int unidadesDis;
    private double precio;

    public Libro(String codigo, String isbn, String autor, String titulo, String editorial, String fechaPub,
            int unidadesDis, double precio) {
        this.codigo = codigo;
        this.isbn = isbn;
        this.autor = autor;
        this.titulo = titulo;
        this.editorial = editorial;
        this.fechaPub = fechaPub;
        this.unidadesDis = unidadesDis;
        this.precio = precio;

    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getFechaPub() {
        return fechaPub;
    }

    public void setFechaPub(String fechaPub) {
        this.fechaPub = fechaPub;
    }

    public int getUnidadesDis() {
        return unidadesDis;
    }

    public void setUnidadesDis(int unidadesDis) {
        this.unidadesDis = unidadesDis;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "[codigo=" + codigo + ", isbn=" + isbn + ", autor=" + autor + ", titulo=" + titulo + ", editorial="
                + editorial + ", fechaPub=" + fechaPub + ", unidadesDis=" + unidadesDis + ", precio=" + precio + "]";
    }

}
