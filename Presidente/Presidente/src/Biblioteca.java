import java.util.Scanner;

public class Biblioteca {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        // Preparacion
        Libro libro1 = new Libro("Perdio", "Pepe", 1998);
        Libro libro2 = new Libro("Sentir", "Juan", 1928);
        Libro libro3 = new Libro("Noche", "Marcos", 1948);

        Socio socio1 = new Socio("Javi", 20, 1234);
        Socio socio2 = new Socio("Sofia", 30, 4321);

        Socio socio = null;

        // Iniciar sesion
        while (socio == null) {

            System.out.print("Introduce tu numero de socio: ");
            int numero = lectura();

            if (numero == 20) {
                socio = socio1;
            } else if (numero == 30) {
                socio = socio2;
            } else {
                System.out.println("Ese socio no existe, intentalo de nuevo.");
            }
        }

        // Comprobar contraseña
        int intentos = 3;
        boolean acceso = false;

        while (intentos > 0 && !acceso) {

            System.out.print("Contrasena: ");
            int pin = lectura();

            if (socio.comprobarContraseña(pin)) {
                acceso = true;
                System.out.println("Bienvenido/a, " + socio.getNombre());
            } else {
                intentos--;

                if (intentos > 0) {
                    System.out.println("Contrasena incorrecta. Te quedan " + intentos + " intentos.");
                }
            }
        }

        if (!acceso) {
            System.out.println("Acceso denegado.");
            return;
        }

        // Menu principal
        int opcion;

        do {

            System.out.println("\n--- MENU BIBLIOTECA ---");
            System.out.println("1. Ver todos los libros");
            System.out.println("2. Pedir un libro");
            System.out.println("3. Devolver un libro");
            System.out.println("4. Ver mis datos de socio");
            System.out.println("5. Salir");

            System.out.print("Elige una opcion: ");
            opcion = lectura();

            switch (opcion) {

                case 1:
                    mostrarTodos(libro1, libro2, libro3);
                    

                case 2:
                    mostrarTodos(libro1, libro2, libro3);

                    System.out.print("Que libro quieres? ");
                    int numPedir = pedirNumeroLibro();

                    Libro libroPedir = elegirLibro(
                        numPedir, libro1, libro2, libro3
                    );

                    socio.pedirLibro(libroPedir);
                    
                case 3:
                    mostrarTodos(libro1, libro2, libro3);

                    System.out.print("Que libro quieres devolver? ");
                    int numDevolver = pedirNumeroLibro();

                    Libro libroDevolver = elegirLibro(
                        numDevolver, libro1, libro2, libro3
                    );

                    socio.devolverLibro(libroDevolver);
                    

                case 4:
                    socio.mostrarDatos();
                   

                case 5:
                    System.out.println("Saliendo de la biblioteca...");
                    

                default:
                    System.out.println("Opcion no valida.");
            }

        } while (opcion != 5);

        // Al salir
        System.out.println("\nTe quedan " +
            socio.getLibrosPrestados() + " libros sin devolver.");

        // Buscar el libro mas prestado
        int maximo = libro1.getVecesPrestado();

        if (libro2.getVecesPrestado() > maximo) {
            maximo = libro2.getVecesPrestado();
        }

        if (libro3.getVecesPrestado() > maximo) {
            maximo = libro3.getVecesPrestado();
        }

        if (maximo == 0) {
            System.out.println("No se ha prestado ningun libro.");

        } else {

            System.out.println("Libro/s mas prestado/s:");

            if (libro1.getVecesPrestado() == maximo) {
                System.out.println(libro1.getTitulo());
            }

            if (libro2.getVecesPrestado() == maximo) {
                System.out.println(libro2.getTitulo());
            }

            if (libro3.getVecesPrestado() == maximo) {
                System.out.println(libro3.getTitulo());
            }

            System.out.println("Veces prestado: " + maximo);
        }

        System.out.println("Hasta pronto!");
        scan.close();
    }

    // Metodo de lectura
    public static int lectura() {

    int numero = 0;
    boolean correcto = false;

    while (!correcto) {

        try {

            numero = scan.nextInt();
            correcto = true;

        } catch (Exception ex) {

            System.out.println("Error: debes introducir un numero.");
            scan.nextLine();

        }
    }

        return numero;
    }
    // Mostrar todos los libros
    public static void mostrarTodos(Libro l1, Libro l2, Libro l3) {

        System.out.println("\n--- LIBROS DE LA BIBLIOTECA ---");

        System.out.println("1.");
        l1.mostrarInfo();

        System.out.println("\n2.");
        l2.mostrarInfo();

        System.out.println("\n3.");
        l3.mostrarInfo();
    }

    // Elegir libro
    public static Libro elegirLibro(int num, Libro l1, Libro l2, Libro l3) {

        if (num == 1) {
            return l1;
        } else if (num == 2) {
            return l2;
        } else {
            return l3;
        }
    }

    // Pedir numero de libro
    public static int pedirNumeroLibro() {

        int numero = 0;

        while (numero < 1 || numero > 3) {

            numero = lectura();

            if (numero < 1 || numero > 3) {
                System.out.println("Numero incorrecto. Introduce 1, 2 o 3:");
            }
        }

        return numero;
    }

    public static void devolver(Libro libro) {
    }


    public static void prestar(Libro libro) {
    }
}









