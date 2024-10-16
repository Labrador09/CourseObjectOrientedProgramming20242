public class Ejercicio2 {
    public static void main(String[] args) {
        // Crear varios objetos Libro
    Biblioteca objlibro1 = new Biblioteca ("Cien años de Soledad", "Gabriel García Márquez", "9783161484100", 471, true);
    Biblioteca objlibro2 = new Biblioteca ("Antes de diciembre", "Joana Marcús", "9789566026877", 486, true);
    
    objlibro2.prestar();
    objlibro2.mostrarInformacion();
    objlibro2.prestar();
}
}
