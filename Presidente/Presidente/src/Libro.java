public class Libro {
    //Atributos privados
    private String titulo;
    private String autor;
    private int anioPublicacion;
    private boolean disponible= true;
    private int vecesPrestado =0;
    public Object libro2;
    //Constructor
    public Libro(String titulo,String autor,int anioPublicacion){
        this.titulo=titulo;
        this.autor=autor;
        this.anioPublicacion=anioPublicacion;
        this.disponible=true;
        this.vecesPrestado=0;
    }
    //Metodos
    public void mostrarInfo(){
        System.out.println("Titulo: "+ titulo);
        System.out.println("Autor: "+autor);
        System.out.println("Año de la publicación"+ anioPublicacion);
        if (disponible) {
            System.out.println("Estado: Disponible.");
            
        }else{
           System.out.println("Estado: Prestado."); 
        }
    }
    //Getters y setters
    public String getTitulo(){
        return titulo;
    }
    public void setTitulo(String titulo){
        this.titulo=titulo;
    }

    
    public String getAutor(){
        return autor;
    }
    public void setAutor(String autor){
        this.autor=autor;
    }


    public int getAnioPublicacion(){
        return anioPublicacion;
    }
    public void setAnioPublicacion(int anioPublicacion){
        this.anioPublicacion=anioPublicacion;
    }


    public boolean isDisponible(){
        return disponible;
    }
    public void setisDisponible(boolean disponible){
        this.disponible= disponible;
    }


    public int getVecesPrestado(){
        return vecesPrestado;
    }
    public void setVecesPrestado(int vecesPrestado){
        this.vecesPrestado = vecesPrestado;
    }

}
