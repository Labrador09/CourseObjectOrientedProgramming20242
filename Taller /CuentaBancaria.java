
public class CuentaBancaria  {

    private String numeroCuenta;
    private double saldo;
    private String titular;

    public CuentaBancaria (String numeroCuenta,String titular, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.titular = titular;
    }
    public void depositar(double cantidad) {
        if (cantidad > 0){
          saldo += cantidad;
          System.out.println("tu nuevo saldo es "+ saldo);
        } else {
            System.out.println("La cantidad a deporsitar debe ser mayor a 0");
        }
      
    }
    public void retirar(double cantidad){
        if (cantidad > 0 && cantidad <= saldo){
            saldo -= cantidad;
            System.out.println("Retiraste: "+ cantidad + " Tu nuevo saldo es: "+ saldo);
        } else {
            System.out.println("Fondos insuficientes o invalido");
        }
    }
    
    public void estado(double cantidad){
        System.out.println("El estado de su cuenta es "+ saldo);
    }
       
    
    
}






   
