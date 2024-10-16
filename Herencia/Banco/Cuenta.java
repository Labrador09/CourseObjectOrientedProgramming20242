package Herencia.Banco;

public class Cuenta {

    private String nroCuenta;
    private String tipoCuenta;
    private double saldo;
    
    public Cuenta(String nroCuenta, String tipoCuenta, double saldo) {
        this.nroCuenta = nroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.saldo = saldo;
    }

    public String getNroCuenta() {
        return nroCuenta;
    }

    public void setNroCuenta(String nroCuenta) {
        this.nroCuenta = nroCuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Cuenta [nroCuenta=" + nroCuenta + ", tipoCuenta=" + tipoCuenta + ", saldo=" + saldo + "]";
    }
    
    public boolean consignar(double monto){
        boolean flag = false;
        
        if (nroCuenta.equals("9898779")){
            saldo += monto;
            flag = true;
        }
        return flag;
    }
    public String consignarMsg(String nroCuenta, double monto){
        String msg = " ";

        if (nroCuenta.equals("9898779")){
            saldo += monto;
            msg = "Trasaccion Exitosa... saldo actual = "+ saldo;
        } else{
            msg = "Error de transaccion";
        }
           
        return msg;
    }
    public boolean transferir(Cuenta cuenta, double monto) {
        if (monto > 0 && saldo >= monto) {
            this.saldo -= monto;  // Debitar el monto de la cuenta origen
            cuenta.consignar(monto);  // Consignar el monto en la cuenta destino
            return true;
        }
        return false;
    }
    public String transferirMsg(Cuenta cuenta, double monto) {
        if (monto > 0 && saldo >= monto) {
            this.saldo -= monto;
            cuenta.consignar(monto);
            return "Transferencia exitosa. Su nuevo saldo es: " + saldo;
        } else if (monto <= 0) {
            return "Monto inválido para transferir.";
        } else {
            return "Saldo insuficiente para la transferencia.";
        }
    }
}
