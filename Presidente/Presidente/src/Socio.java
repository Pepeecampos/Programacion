public class Socio {
    //Atributos
    private String nombre;
    private int constraseña;
    private int numeroSocio;
    private final int maxPrestamos=2;
    private int librosPrestado =0;
    //Constructor
    public Socio(String nombre,int numeroSocio,int constraseña){
        this.nombre=nombre;
        this.numeroSocio=numeroSocio;
        this.constraseña=constraseña;
        this.librosPrestado=0;
    }
    //Metodos
    public boolean comprobarContraseña(int pin){
         return this.constraseña==pin;
    }
    public boolean puedePedir(){
       return librosPrestado< maxPrestamos;
    }
    public void pedirLibro(Libro libro){

        if(!puedePedir()){
            System.out.println("El socio ha alcanzado el límite de préstamos.");

        }else if(!libro.isDisponible()){
            System.out.println("El libro ya está prestado");
        }else {
            Biblioteca.prestar(libro);
            if (!libro.isDisponible()){
                librosPrestado++;
                System.out.println("Prestamo realizado.");
            }
        
        }   
    }
    public void devolverLibro(Libro libro){
        if(librosPrestado>0 && !libro.isDisponible()){
            Biblioteca.devolver(libro);
            if (librosPrestado<0){
                librosPrestado=0;
            }
            System.out.println("Libro dvuelto correctamente.");

        }else{
            System.out.println("No se puede devolver este libro.");
        }
    } 

    // Muestra los datos del socio
    public void mostrarDatos() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Número de socio: " + numeroSocio);
        System.out.println("Libros prestados: " + librosPrestado);
    }

     // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroSocio() {
        return numeroSocio;
    }

    public void setNumeroSocio(int numeroSocio) {
        this.numeroSocio = numeroSocio;
    }

    public int getLibrosPrestados() {
        return librosPrestado;
    }

    public int getMaxPrestamos() {
        return maxPrestamos;
    }
   
}
