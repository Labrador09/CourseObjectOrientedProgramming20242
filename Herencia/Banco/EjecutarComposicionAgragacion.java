package Herencia.Banco;

public class EjecutarComposicionAgragacion {
    public static void main(String[] args) {
        
        Cliente objCliente1 = new Cliente(1111544743,"Anuel", "Chango");
        Cuenta objCuenta1 = new Cuenta("8388198","Ahorro", 100000.0 );
        Banco objBanco1 = new Banco("99090099", "Banco UCC", objCuenta1);
        Cliente objCliente2 = new Cliente(1111123323,"Ozuna", "Chnchulo");
        Cuenta objCuenta2 = new Cuenta("9898779","Ahorro", 100000.0 );
        Banco objBanco2 = new Banco("99787675", "Banco UCC", objCuenta2);

        System.out.println(objCuenta1.consignarMsg(objCuenta2.getNroCuenta(), 1000.0));
        System.out.println(objCuenta1.transferirMsg(objCuenta2, 10000));
        System.out.println(objCuenta1);
    }

}
