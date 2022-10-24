/*
 * Interface que recibe un objeto de tipo Matrix del servidor
 */
public interface MiInterfazRecibir extends java.rmi.Remote{
    public void recibirMatrixA(Matrix mA) throws java.rmi.RemoteException;
    public void recibirMatrixB(Matrix mB) throws java.rmi.RemoteException;
}
