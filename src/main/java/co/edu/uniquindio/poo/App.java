package co.edu.uniquindio.poo;

import javax.swing.JOptionPane;

public class App {

    public static Biblioteca miBiblioteca;

    public static void main(String[] args) {
        miBiblioteca = new Biblioteca("uni quindio", 0, 0);
        menuBiblioteca();
    }

    public static void menuBiblioteca() {
        imprimir("------------------------");
        imprimir("Biblioteca: " + miBiblioteca.getNombre());
        imprimir("1. Acceso a Bibliotecarios.");
        imprimir("2. Acceso a Estudiantes.");
        imprimir("3. Acceso a Prestamos.");
        imprimir("4. Acceso a Libros.");
        imprimir("5. Consultar ganancia.");
        imprimir("6. Salir.");
        imprimir("------------------------");
        int num = ingresarEntero("Seleccione una opcion:");
        switch (num) {
            case 1:
                operacionBibliotecarios();
                break;
            case 2:
                operacionEstudiantes();
                break;
            case 3:
                operacionPrestamos();
                break;
            case 4:
                operacionLibros();
                break;
            case 5:
                consultarGanancia();
            case 6:
                imprimir("Saliendo del Programa...");
                System.exit(0);
                break;
            default:
                imprimir("La opción ingresada es incorrecta.");
                menuBiblioteca();
                break;
        }
    }

    public static void operacionBibliotecarios() {
        imprimir("------------------------");
        imprimir("1. Crear Bibliotecario.");
        imprimir("2. Eliminar Bibliotecario.");
        imprimir("3. Mostrar Bibliotecario.");
        imprimir("4. N° Prestamos Bibliotecario.");
        imprimir("5. Salario Bibliotecario.");
        imprimir("6. Regresar.");
        imprimir("------------------------");

        int num = ingresarEntero("Seleccione una opción:");
        switch (num) {
            case 1:
                String nombre = JOptionPane.showInputDialog("Ingrese nombre del bibliotecario:");
                String correo = JOptionPane.showInputDialog("Ingrese correo del bibliotecario:");
                int cedula = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cedula del bibliotecario:"));
                int telefono = Integer.parseInt(JOptionPane.showInputDialog("Ingrese telefono del bibliotecario:"));
                double salario = Double.parseDouble(JOptionPane.showInputDialog("Ingrese salario del bibliotecario:"));
                int añosAnt = Integer
                        .parseInt(JOptionPane.showInputDialog("Ingrese años de antigüedad del bibliotecario:"));

                Bibliotecario bibliotecario = new Bibliotecario(nombre, cedula, telefono, correo, salario, añosAnt);
                miBiblioteca.crearBibliotecario(bibliotecario);
                operacionBibliotecarios();
                break;
            case 2:
                int cedula1 = Integer
                        .parseInt(JOptionPane.showInputDialog("Ingrese cedula del bibliotecario a eliminar:"));
                miBiblioteca.eliminarBibliotecario(cedula1);
                operacionBibliotecarios();
                break;
            case 3:
                int cedula2 = Integer
                        .parseInt(JOptionPane.showInputDialog("Ingrese cedula del bibliotecario a mostrar:"));
                miBiblioteca.mostrarBibliotecario(cedula2);
                operacionBibliotecarios();
                break;
            case 4:
                int cedula3 = Integer
                        .parseInt(JOptionPane.showInputDialog("Ingrese cedula del bibliotecario a consultar:"));
                miBiblioteca.prestamosBibliotecario(cedula3);
                operacionBibliotecarios();
                break;
            case 5:
                int cedula4 = Integer
                        .parseInt(JOptionPane.showInputDialog("Ingrese cedula del bibliotecario a pagar."));
                miBiblioteca.pagarBibliotecarios(cedula4);
                operacionBibliotecarios();
                break;
            case 6:
                menuBiblioteca();
                break;
            default:
                imprimir("Opción Incorrecta.");
                operacionBibliotecarios();
                break;
        }
    }

    public static void operacionEstudiantes() {
        imprimir("------------------------");
        imprimir("1. Crear Estudiante.");
        imprimir("2. Eliminar Estudiante.");
        imprimir("3. Mostrar Estudiante.");
        imprimir("4. Estudiante con mas prestamos.");
        imprimir("5. Regresar.");
        imprimir("------------------------");

        int num = ingresarEntero("Seleccione una opción:");
        switch (num) {
            case 1:
                String nombre = JOptionPane.showInputDialog("Ingrese nombre del estudiante:");
                int cedula = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cedula del estudiante:"));
                int telefono = Integer.parseInt(JOptionPane.showInputDialog("Ingrese telefono del estudiante:"));
                String correo = JOptionPane.showInputDialog("Ingrese correo del estudiante:");
                int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese edad del estudiante:"));

                Estudiante estudiante = new Estudiante(nombre, cedula, telefono, correo, edad);
                miBiblioteca.crearEstudiante(estudiante);
                operacionEstudiantes();
                break;
            case 2:
                int cedula1 = Integer
                        .parseInt(JOptionPane.showInputDialog("Ingrese cedula del estudiante a eliminar:"));
                miBiblioteca.eliminarEstudiante(cedula1);
                operacionEstudiantes();
                break;
            case 3:
                int cedula2 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cedula del estudiante a mostrar:"));
                miBiblioteca.mostrarEstudiante(cedula2);
                operacionEstudiantes();
                break;
            case 4:
                imprimir("El estudiante con mas prestamos es:" + miBiblioteca.estudianteConMasPrestamos());
                operacionEstudiantes();
                break;
            case 5:
                menuBiblioteca();
                break;
            default:
                imprimir("Opción Incorrecta.");
                operacionEstudiantes();
                break;
        }
    }

    public static void operacionPrestamos() {
        imprimir("------------------------");
        imprimir("1. Crear Prestamo.");
        imprimir("2. Eliminar Prestamo.");
        imprimir("3. Mostrar Prestamo.");
        imprimir("4. Añadir Libro Prestamo.");
        imprimir("5. Entregar Prestamo.");
        imprimir("6. Regresar.");
        imprimir("------------------------");

        int num = ingresarEntero("Seleccione una opción:");
        switch (num) {
            case 1:
                String fechaPrest = JOptionPane.showInputDialog("Ingrese fecha del prestamo (yyyy-MM-dd):");
                String fechaEnt = JOptionPane.showInputDialog("Ingrese fecha de entrega (yyyy-MM-dd):");
                String codigo = JOptionPane.showInputDialog("Ingrese codigo del prestamo:");
                double total = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el total del prestamo:"));

                int cedulaEstudiante = Integer.parseInt(
                        JOptionPane.showInputDialog("Ingrese cedula del estudiante que realiza el prestamo:"));
                Estudiante estudiante = miBiblioteca.buscarEstudiante(cedulaEstudiante);
                int cedulaBibliotecario = Integer.parseInt(
                        JOptionPane.showInputDialog("Ingrese cedula del bibliotecario que realiza el prestamo:"));
                Bibliotecario bibliotecario = miBiblioteca.buscarBibliotecario(cedulaBibliotecario);

                // Detalles prestamo//
                imprimir("Ingrese Detalles Prestamo:");
                String isbn = JOptionPane.showInputDialog("Ingrese isbn del libro prestado:");
                Libro libro = miBiblioteca.buscarLibro(isbn);
                int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad de copias del libro:"));

                double subTotal = DetallePrestamo.calcularSubTotal(cantidad, libro);
                DetallePrestamo detallePrestamo = new DetallePrestamo(cantidad, libro);
                detallePrestamo.setSubTotal(subTotal);

                Prestamo prestamo = new Prestamo(total, fechaEnt, fechaPrest, codigo, estudiante, bibliotecario);

                Prestamo.añadirDetallePrestamo(prestamo, detallePrestamo);
                miBiblioteca.crearPrestamo(prestamo, detallePrestamo);
                operacionPrestamos();
                break;
            case 2:
                String codigo1 = JOptionPane.showInputDialog("Ingrese codigo del prestamo a eliminar:");
                miBiblioteca.eliminarPrestamo(codigo1);
                operacionPrestamos();
                break;
            case 3:
                String codigo2 = JOptionPane.showInputDialog("Ingrese codigo del prestamo a mostrar:");
                miBiblioteca.mostrarPrestamo(codigo2);
                operacionPrestamos();
                break;
            case 4:
                String codigo3 = JOptionPane.showInputDialog("Ingrese codigo del prestamo a modificar:");
                String isbn2 = JOptionPane.showInputDialog("Ingrese isbn del libro a añadir:");
                miBiblioteca.añadirLibroAPrestamo(codigo3, isbn2);
                operacionPrestamos();
                break;
            case 5:
                String codigo4 = JOptionPane.showInputDialog("Ingrese codigo del prestamo a entregar:");
                miBiblioteca.entregarPrestamo(codigo4);
                operacionPrestamos();
                break;
            case 6:
                menuBiblioteca();
                break;
            default:
                imprimir("Opción Incorrecta.");
                operacionPrestamos();
                break;
        }
    }

    public static void operacionLibros() {
        imprimir("------------------------");
        imprimir("1. Crear Libro.");
        imprimir("2. Eliminar Libro.");
        imprimir("3. Mostrar Libro.");
        imprimir("4. N° prestamos Libro.");
        imprimir("5. Sobreescribir libro.");
        imprimir("6. Regresar.");
        imprimir("------------------------");

        int num = ingresarEntero("Seleccione una opción:");
        switch (num) {
            case 1:
                String codigo = JOptionPane.showInputDialog("Ingrese codigo del libro:");
                String isbn = JOptionPane.showInputDialog("Ingrese isbn del libro:");
                String autor = JOptionPane.showInputDialog("Ingrese autor del libro:");
                String titulo = JOptionPane.showInputDialog("Ingrese titulo del libro:");
                String editorial = JOptionPane.showInputDialog("Ingrese editorial del libro:");
                String fechaPub = JOptionPane.showInputDialog("Ingrese fecha de publicacion del libro:");
                int unidadesDis = Integer
                        .parseInt(JOptionPane.showInputDialog("Ingrese unidades disponibles del libro:"));
                int precio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese precio del libro:"));

                Libro libro = new Libro(codigo, isbn, autor, titulo, editorial, fechaPub, unidadesDis, precio);
                miBiblioteca.crearLibro(libro);
                operacionLibros();
                break;
            case 2:
                String isbn1 = JOptionPane.showInputDialog("Ingrese isbn del libro a eliminar:");
                miBiblioteca.eliminarLibro(isbn1);
                operacionLibros();
                break;
            case 3:
                String codigo1 = JOptionPane.showInputDialog("Ingrese codigo del libro a mostrar:");
                miBiblioteca.mostrarLibro(codigo1);
                operacionLibros();
                break;
            case 4:
                String titulo1 = JOptionPane.showInputDialog("Ingrese titulo del libro a consultar:");
                miBiblioteca.cantidadDePrestamosLibro(titulo1);
                operacionLibros();
                break;
            case 5:
                String isbn3 = JOptionPane.showInputDialog("Ingrese isbn del libro a sobreescribir");
                miBiblioteca.sobreescribirLibro(isbn3);
                operacionLibros();
                break;
            case 6:
                menuBiblioteca();
                break;
            default:
                imprimir("Opción Incorrecta.");
                operacionLibros();
                break;
        }
    }

    public static void consultarGanancia() {
        double ganancia;
        ganancia = miBiblioteca.calcularGanancia();
        App.imprimir("La biblioteca ha recaudado un total de: " + ganancia + " Dollars");
        imprimir("------------------------");
        imprimir("1. Regresar.");
        imprimir("------------------------");
        int num = ingresarEntero("Seleccione una opción:");
        switch (num) {
            case 1:
                menuBiblioteca();
                break;
            default:
                imprimir("Opción Incorrecta.");
                operacionLibros();
                break;
        }
    }

    /**
     * Metodo para ingresar un numero entero, cualquier dato invalido
     * 
     * @param texto
     * @return num
     */
    public static int ingresarEntero(String mensaje) {
        boolean repetir = true;
        int num = 0;
        while (repetir) {
            try {
                String input = JOptionPane.showInputDialog(mensaje);
                num = Integer.parseInt(input);
                repetir = false;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El dato ingresado es invalido.");
            }
        }
        return num;
    }

    public static void imprimir(String texto) {
        System.out.println(texto);
    }

}
