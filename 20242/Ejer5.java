import java.util.Scanner;

public class Ejer5 {
    int pesoscolombianos;
    double pesosaeuros;
    double pesosadolares;


    Scanner scanner = new Scanner(System.in);

    public void calcularConversion(){
        

        double euros = 0.00023;
        double dolares = 0.00025;

        System.out.println("Ingresar cuanto va pasar");
        pesoscolombianos=scanner.nextInt();
        pesosaeuros = pesoscolombianos * euros;
        pesosadolares = pesoscolombianos * dolares;
        System.out.println(pesoscolombianos +" Pesos colombianos a euros son: " + pesosaeuros);
        System.out.println(pesoscolombianos + " Pesos colombianos a dolares son: " + pesosadolares);
        }
    public static void main(String[] args){
        Ejer5 obEjer5 = new Ejer5();
        obEjer5.calcularConversion();
    }
}

