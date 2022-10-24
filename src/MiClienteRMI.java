import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
/*
 * Clase encargada de levantar la interfaz grafica para
 * la interaccion con el usuario mandar a llamar metodos al servidor
 * 
 * Del mismo modo aqui se levanta el servidor que recibira datos
 */

public class MiClienteRMI extends java.rmi.server.UnicastRemoteObject implements
MiInterfazRecibir{

    static Matrix ma;
    static Matrix mb;

    protected MiClienteRMI() throws RemoteException {
        super();
        //TODO Auto-generated constructor stub
    }

    public static void main(String[] args) throws Exception {

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
               new App();
            }
        });
        /*
         * Levantamiento del servidor donde transmitira por un puerto diferente y con el nombre GUIRMI
         */
        try {
            int port = 1099;
            MiInterfazRecibir remote = new MiClienteRMI();
            Registry registry = LocateRegistry.createRegistry(port);
            System.out.println("Servidor escuchando en el puerto: " + String.valueOf(port) + " Con la IP: " + java.net.InetAddress.getLocalHost().getHostAddress());
            registry.bind("GUIRMI", remote);
            
        } catch (Exception e) {
            //TODO: handle exception
        }
        
    }



    @Override
    public void recibirMatrixA(Matrix mA) throws RemoteException {
        // TODO Auto-generated method stub
        ma = mA;
        // System.out.println("\nMatriz A: \n");
        // for (int x=0; x < ma.getRows(); x++) {
        //     System.out.print("|");
        //     for (int y=0; y < ma.getCols(); y++) {
        //       System.out.print (ma.getValue(x,y));
        //       if (y!=ma.getCols()-1) System.out.print("\t");
        //     }
        //     System.out.println("|");
        // }
    }

    @Override
    public void recibirMatrixB(Matrix mB) throws RemoteException {
        // TODO Auto-generated method stub
        mb = mB;
        // System.out.println("\nMatriz B: \n");
        // for (int x=0; x < mb.getRows(); x++) {
        //     System.out.print("|");
        //     for (int y=0; y < mb.getCols(); y++) {
        //       System.out.print (mb.getValue(x,y));
        //       if (y!=mb.getCols()-1) System.out.print("\t");
        //     }
        //     System.out.println("|");
        // }
    }

}