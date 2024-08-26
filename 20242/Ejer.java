import java.util.Scanner;

public class Ejer {
    int salariobruto;
    int deducciones;
    int comision;
    int salarioneto;

    Scanner scanner = new Scanner (System.in);

    public void calcularSalarioneto(){
        System.out.println("Ingresar valores");
        salariobruto=scanner.nextInt();
        deducciones=scanner.nextInt();
        comision=scanner.nextInt();
        salarioneto=(salariobruto-deducciones)+comision;

        System.out.println("el salario neto es: "+salarioneto);
    }

}