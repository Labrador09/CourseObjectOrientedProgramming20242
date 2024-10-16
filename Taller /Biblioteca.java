public class Biblioteca {


    private String titulo;
    private String autor;
    private String isbn;
    private int numpag;
    private boolean disponible;

    public Biblioteca (String titulo, String autor, String isbn, int numpag, boolean disponible) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.numpag = numpag;
        this.disponible = true;

    }
    public void prestar() {
        if (disponible) {
            disponible = false;
            System.out.println("El libro '" + titulo + "' ha sido prestado.");
        } else {
            System.out.println("El libro '" + titulo + "' no está disponible para préstamo.");
        }
        }
        public void devolver() {
            if (disponible) {
                disponible = true;
                System.out.println("El libro '" + titulo + "' ha sido devuelto.");
            } else {
                System.out.println("El libro '" + titulo + "' ya estaba disponible.");
        }
        }
        public boolean estadoDisponible() {
            return disponible;
        }
        public void mostrarInformacion() {
            System.out.println("El titulo es"+ titulo);
            System.out.println("Autor: "+ autor);
            System.out.println("ISBN: " +isbn);
            System.out.println("Numero de paginas: "+numpag);
            System.out.println("Estado: "+ disponible);

        }  

    }





    

