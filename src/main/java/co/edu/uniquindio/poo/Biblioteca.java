package co.edu.uniquindio.poo;

import javax.swing.JOptionPane;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Biblioteca {

    private String nombre;
    private Collection<Estudiante> estudiantes;
    private Collection<Bibliotecario> bibliotecarios;
    private Collection<Prestamo> prestamos;
    private Collection<Libro> libros;
    private double ganancia;
    private int cantidadLibros;

    public Biblioteca(String nombre, double ganancia, int cantidadLibros) {
        this.nombre = nombre;
        this.ganancia = ganancia;
        this.cantidadLibros = cantidadLibros;
        estudiantes = new LinkedList<>();
        bibliotecarios = new LinkedList<>();
        prestamos = new LinkedList<>();
        libros = new LinkedList<>();
    }

    // BIBLIOTECARIOS//

    /**
     * Metodo para crear bibliotecarios
     * 
     * @param bibliotecario
     */
    public void crearBibliotecario(Bibliotecario bibliotecario) {
        if (!verificarBibliotecario(bibliotecario.getCedula())) {
            bibliotecarios.add(bibliotecario);
            App.imprimir(bibliotecario.toString());
            App.imprimir("El bibliotecario se ha creado exitosamente.");
        } else {
            App.imprimir("El bibliotecario ya existe.");
        }
    }

    /**
     * Metodo para verificar si un bibliotecario ya existe
     * 
     * @param cedula
     * @return
     */
    public boolean verificarBibliotecario(int cedula) {
        boolean repetido = false;
        for (Bibliotecario bibliotecario : bibliotecarios) {
            if (bibliotecario.getCedula() == cedula) {
                repetido = true;
            }
        }
        return repetido;
    }

    /**
     * Metodo para eliminar bibliotecarios
     * 
     * @param cedula
     */
    public void eliminarBibliotecario(int cedula) {
        int centinela = 0;
        for (Bibliotecario bibliotecario : bibliotecarios) {
            if (bibliotecario.getCedula() == cedula) {
                bibliotecarios.remove(bibliotecario);
                App.imprimir("El bibliotecario se ha eliminado exitosamente.");
                centinela = 1;
                break;
            }
        }
        if (centinela == 0) {
            App.imprimir("El bibliotecario NO existe.");
        }
    }

    /**
     * Metodo para buscar y mostrar un bibliotecario
     * 
     * @param cedula
     */
    public void mostrarBibliotecario(int cedula) {
        int centinela = 0;
        for (Bibliotecario bibliotecario : bibliotecarios) {
            if (bibliotecario.getCedula() == cedula) {
                App.imprimir(bibliotecario.toString());
                centinela = 1;
                break;
            }
        }
        if (centinela == 0) {
            App.imprimir("El bibliotecario NO existe.");
        }
    }

    /**
     * Metodo para mostrar la cantidad de prestamos que ha realizado un
     * bibliotecario
     * 
     * @param cedula
     */
    public void prestamosBibliotecario(int cedula) {
        int numeroPrestamos = 0;
        for (Bibliotecario bibliotecario : bibliotecarios) {
            if (bibliotecario.getCedula() == cedula) {
                numeroPrestamos = bibliotecario.getPrestamos().size();
                App.imprimir(
                        "El bibliotecario " + bibliotecario.getNombre() + " Tiene " + numeroPrestamos + " prestamos.");
                break;
            }
        }

    }

    /**
     * Metodo para calcular y mostrar el salario de los bibliotecarios
     * 
     * @param cedula
     */
    public void pagarBibliotecarios(int cedula) {
        double total = 0;
        Bibliotecario bibliotecarioAPagar;
        double pagoBibliotecario = 0;
        if (bibliotecarios != null) {
            for (Bibliotecario bibliotecario : bibliotecarios) {
                if (bibliotecario.getCedula() == cedula) {
                    bibliotecarioAPagar = bibliotecario;
                    for (Prestamo prestamo : prestamos) {
                        if (prestamo.getBibliotecario().equals(bibliotecario)) {
                            double pagoPorPrestamo = prestamo.getTotal() * 0.20;
                            pagoBibliotecario += pagoPorPrestamo;
                        }
                    }
                    int antiguedad = bibliotecarioAPagar.getAntiguedad();
                    double bonificacion = pagoBibliotecario * (0.02 * antiguedad);
                    total += pagoBibliotecario + bonificacion;
                    App.imprimir("El salario total del bibliotecario " + bibliotecarioAPagar + " es de: " + total
                            + " Dollars.");
                    break;
                }
                break;
            }
        } else {
            App.imprimir("El bibliotecario NO existe.");
        }
        if (prestamos == null) {
            App.imprimir("El prestamo NO existe.");
        }
    }

    // ESTUDIANTES//

    /**
     * Metodo para crear estudiantes
     * 
     * @param estudiante
     */
    public void crearEstudiante(Estudiante estudiante) {
        if (!verificarEstudiante(estudiante.getCedula())) {
            estudiantes.add(estudiante);
            App.imprimir(estudiante.toString());
            App.imprimir("El estudiante se ha creado exitosamente.");
        } else {
            App.imprimir("El estudiante ya existe.");
        }
    }

    /**
     * Metodo para verificar si un estudiante ya existe
     * 
     * @param cedula
     * @return
     */
    public boolean verificarEstudiante(int cedula) {
        boolean repetido = false;
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getCedula() == cedula) {
                repetido = true;
            }
        }
        return repetido;
    }

    /**
     * Metodo para eliminar estudiantes
     * 
     * @param cedula
     */
    public void eliminarEstudiante(int cedula) {
        int centinela = 0;
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getCedula() == cedula) {
                estudiantes.remove(estudiante);
                App.imprimir("El estudiante se ha eliminado exitosamente.");
                centinela = 1;
                break;
            }
        }
        if (centinela == 0) {
            App.imprimir("El estudiante NO existe.");
        }
    }

    /**
     * Metodo para buscar y mostrar un estudiante
     * 
     * @param cedula
     */
    public void mostrarEstudiante(int cedula) {
        int centinela = 0;
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getCedula() == cedula) {
                App.imprimir(estudiante.toString());
                centinela = 1;
                break;
            }
        }
        if (centinela == 0) {
            App.imprimir("El estudiante NO existe.");
        }
    }

    /**
     * Metodo para buscar y mostrar los datos del estudiante con mas prestamos
     * 
     * @return
     */
    public Estudiante estudianteConMasPrestamos() {
        Estudiante estudianteConMasPrestamos = null;
        int masPrestamos = 0;
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getPrestamos().size() > masPrestamos) {
                masPrestamos = estudiante.getPrestamos().size();
                estudianteConMasPrestamos = estudiante;
            }
        }
        return estudianteConMasPrestamos;
    }

    // PRESTAMOS//

    /**
     * Metodo para crear prestamos
     * 
     * @param prestamo
     */
    public void crearPrestamo(Prestamo prestamo, DetallePrestamo detallePrestamo) {
        Bibliotecario bibliotecario = prestamo.getBibliotecario();
        Estudiante estudiante = prestamo.getEstudiante();

        if (bibliotecario != null) {
            if (!verificarPrestamo(prestamo.getCodigo())) {

                estudiante.agregarPrestamoEstudiante(prestamo);
                bibliotecario.agregarPrestamoBibliotecario(prestamo);
                prestamos.add(prestamo);

                double total = detallePrestamo.getSubTotal() + prestamo.getTotal();
                prestamo.setTotal(total);

                App.imprimir(prestamo.toString());
                App.imprimir("El préstamo se ha creado exitosamente.");
            } else {
                App.imprimir("El préstamo ya existe");
            }
        } else {
            App.imprimir("El bibliotecario NO existe.");
        }
        if (estudiante == null) {
            App.imprimir("El estudiante NO existe.");
        }
    }

    /**
     * Metodo para verificar si un prestamo ya existe
     * 
     * @param codigo
     * @return
     */
    public boolean verificarPrestamo(String codigo) {
        boolean repetido = false;
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getCodigo().equals(codigo)) {
                repetido = true;
            }
        }
        return repetido;
    }

    /**
     * Metodo para eliminar prestamos
     * 
     * @param codigo
     */
    public void eliminarPrestamo(String codigo) {
        int centinela = 0;
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getCodigo().equals(codigo)) {
                prestamos.remove(prestamo);
                App.imprimir("El prestamo se ha eliminado exitosamente.");
                centinela = 1;
                break;
            }
        }
        if (centinela == 0) {
            App.imprimir("El prestamo NO existe.");
        }
    }

    /**
     * Metodo para buscar y mostrar un prestamo
     * 
     * @param codigo
     */
    public void mostrarPrestamo(String codigo) {
        int centinela = 0;
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getCodigo().equals(codigo)) {
                App.imprimir(prestamo.toString());
                centinela = 1;
                break;
            }
        }
        if (centinela == 0) {
            App.imprimir("El prestamo NO existe.");
        }
    }

    /**
     * Metodo para buscar y retornar un estudiante
     * 
     * @param cedula
     * @return
     */
    public Estudiante buscarEstudiante(int cedula) {
        int centinela = 0;
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getCedula() == cedula) {
                centinela = 1;
                return estudiante;
            }
        }
        if (centinela == 0) {
            App.imprimir("El estudiante NO existe.");
        }
        return null;
    }

    /**
     * Metodo para buscar y retornar un bibliotecario
     * 
     * @param cedula
     * @return
     */
    public Bibliotecario buscarBibliotecario(int cedula) {
        int centinela = 0;
        for (Bibliotecario bibliotecario : bibliotecarios) {
            if (bibliotecario.getCedula() == cedula) {
                centinela = 1;
                return bibliotecario;
            }
        }
        if (centinela == 0) {
            App.imprimir("El bibliotecario NO existe.");
        }
        return null;
    }

    /**
     * Metodo para buscar y retornar un libro
     * 
     * @param isbn
     * @return
     */
    public Libro buscarLibro(String isbn) {
        int centinela = 0;
        for (Libro libro : libros) {
            if (libro.getIsbn().equals(isbn)) {
                centinela = 1;
                return libro;
            }
        }
        if (centinela == 0) {
            App.imprimir("El libro NO existe.");
        }
        return null;
    }

    /**
     * Metodo para adicionar libros a un prestamo y disminuir la cantidad de
     * unidades del libro
     * 
     * @param codigo
     * @param isbn
     */
    public void añadirLibroAPrestamo(String codigo, String isbn) {
        Prestamo prestamoAModificar = null;
        Libro libroAñadir = null;
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getCodigo().equals(codigo)) {
                prestamoAModificar = prestamo;
                break;
            }
        }
        for (Libro libro : libros) {
            if (libro.getIsbn().equals(isbn)) {
                libroAñadir = libro;
                break;
            }
        }
        if (prestamoAModificar != null) {
            if (libroAñadir.getUnidadesDis() > 0) {
                DetallePrestamo nuevoDetalle = new DetallePrestamo(1, libroAñadir);
                prestamoAModificar.getDetallePrestamos().add(nuevoDetalle);
                libroAñadir.setUnidadesDis(libroAñadir.getUnidadesDis() - 1);
                App.imprimir("El libro se ha añadido exitosamente");
            } else {
                App.imprimir("No hay unidades disponibles");
            }
        } else {
            App.imprimir("El prestamo NO extiste");
        }
        if (libroAñadir == null) {
            App.imprimir("El libro NO existe.");
        }
    }

    /**
     * Metodo para entregar prestamos
     * 
     * @param codigo
     */
    public void entregarPrestamo(String codigo) {
        Prestamo prestamoAEntregar = null;
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getCodigo().equals(codigo)) {
                prestamoAEntregar = prestamo;
                break;
            }
        }
        if (prestamoAEntregar != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate fechaPrestamo = LocalDate.parse(prestamoAEntregar.getFechaPrest(), formatter);
            LocalDate fechaEntrega = LocalDate.now();

            long diasPrestamo = ChronoUnit.DAYS.between(fechaPrestamo, fechaEntrega);
            double totalPrestamo = diasPrestamo * 10; // Costo por día

            for (DetallePrestamo detalle : prestamoAEntregar.getDetallePrestamos()) {
                Libro libro = detalle.getLibro();
                libro.setUnidadesDis(libro.getUnidadesDis() + 1);
            }
            App.imprimir("El total del prestamo es: " + totalPrestamo + " Dollars");
        } else {
            App.imprimir("El prestamo NO existe.");
        }
    }

    // LIBROS//

    /**
     * Metodo para crear libros
     * 
     * @param libro
     */
    public void crearLibro(Libro libro) {
        if (!verificarLibro(libro.getIsbn())) {
            libros.add(libro);
            App.imprimir(libro.toString());
            App.imprimir("El libro se ha creado exitosamente.");
        } else {
            App.imprimir("El libro ya existe.");
        }
    }

    /**
     * Metodo para verificar si un libro ya existe
     * 
     * @param isbn
     * @return
     */
    public boolean verificarLibro(String isbn) {
        boolean repetido = false;
        for (Libro libro : libros) {
            if (libro.getIsbn().equals(isbn)) {
                repetido = true;
            }
        }
        return repetido;
    }

    /**
     * Metodo para eliminar libros
     * 
     * @param isbn
     */
    public void eliminarLibro(String isbn) {
        int centinela = 0;
        for (Libro libro : libros) {
            if (libro.getIsbn().equals(isbn)) {
                libros.remove(libro);
                centinela = 1;
                App.imprimir("El libro se ha eliminado exitosamente.");
                break;
            }
        }
        if (centinela == 0) {
            App.imprimir("El libro NO existe.");
        }
    }

    /**
     * Metodo para buscar y mostrar un libro
     * 
     * @param isbn
     */
    public void mostrarLibro(String codigo) {
        int centinela = 0;
        for (Libro libro : libros) {
            if (libro.getCodigo().equals(codigo)) {
                App.imprimir(libro.toString());
                centinela = 1;
                break;
            }
        }
        if (centinela == 0) {
            App.imprimir("El libro NO existe.");
        }
    }

    /**
     * Metodo para determinar la cantidad de prestamos en los que esta incluido un
     * libro dado su nombre
     * 
     * @param titulo
     * @return
     */
    public int cantidadDePrestamosLibro(String titulo) {
        if (titulo == null) {
            App.imprimir("Por favor añadir titulo");
        }
        int numeroPrestamos = 0;
        for (Prestamo prestamo : prestamos) {
            for (DetallePrestamo detalle : prestamo.getDetallePrestamos()) {
                Libro libro = detalle.getLibro();
                if (libro != null && libro.getTitulo() != null && libro.getTitulo().equals(titulo)) {
                    numeroPrestamos += 1;
                }
            }
            if (numeroPrestamos == 0) {
                App.imprimir("No se encontraron prestamos para ese libro");
            }
        }
        return numeroPrestamos;
    }

    /**
     * Metodo para sobreescribir un libro
     * 
     * @param isbn
     */
    public void sobreescribirLibro(String isbn) {
        for (Libro libro : libros) {
            if (libro.getIsbn().equals(isbn)) {
                App.imprimir(libro.toString());
                String codigo = JOptionPane.showInputDialog("Ingrese codigo del libro");
                String isbn1 = JOptionPane.showInputDialog("Ingrese isbn del libro");
                String autor = JOptionPane.showInputDialog("Ingrese autor del libro");
                String titulo = JOptionPane.showInputDialog("Ingrese titulo del libro");
                String editorial = JOptionPane.showInputDialog("Ingrese editorial del libro");
                String fechaPub = JOptionPane.showInputDialog("Ingrese fecha de publicacion del libro");
                int unidadesDis = Integer
                        .parseInt(JOptionPane.showInputDialog("Ingrese unidades disponibles del libro"));

                libro.setCodigo(codigo);
                libro.setIsbn(isbn1);
                libro.setAutor(autor);
                libro.setTitulo(titulo);
                libro.setEditorial(editorial);
                libro.setFechaPub(fechaPub);
                libro.setUnidadesDis(unidadesDis);
                App.imprimir("Los nuevos datos son: " + libro.toString());
            }
        }
    }

    // GANANCIA//

    /**
     * Metodo para calcular la ganancia de la biblioteca
     * 
     * @return
     */
    public double calcularGanancia() {
        double ganancia = 0;
        for (Prestamo prestamo : prestamos) {
            ganancia += prestamo.getTotal();
        }
        return ganancia;
    }

    /**
     * Metodo para ingresar una cadena
     * 
     * @param texto
     * @return cadena
     */
    @SuppressWarnings("resource")
    public static String ingresarCadena(String texto) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(texto);
        String cadena = scanner.nextLine();
        return cadena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Collection<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(Collection<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public Collection<Bibliotecario> getBibliotecarios() {
        return bibliotecarios;
    }

    public void setBibliotecarios(Collection<Bibliotecario> bibliotecarios) {
        this.bibliotecarios = bibliotecarios;
    }

    public Collection<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(Collection<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    public Collection<Libro> getLibros() {
        return libros;
    }

    public void setLibros(Collection<Libro> libros) {
        this.libros = libros;
    }

    public double getGanancia() {
        return ganancia;
    }

    public void setGanancia(double ganancia) {
        this.ganancia = ganancia;
    }

    public int getCantidadLibros() {
        return cantidadLibros;
    }

    public void setCantidadLibros(int cantidadLibros) {
        this.cantidadLibros = cantidadLibros;
    }

    @Override
    public String toString() {
        return "Biblioteca [nombre=" + nombre + ", estudiantes=" + estudiantes + ", bibliotecarios=" + bibliotecarios
                + ", prestamos=" + prestamos + ", libros=" + libros + ", ganancia=" + ganancia + ", cantidadLibros="
                + cantidadLibros + "]";
    }
}
