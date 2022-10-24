/*
 * Clase encargada del calculo secuencial de metrices
 */
public class Secuencial {

    static Matrix ex = MiClienteRMI.ma;
    static Matrix ex2 = MiClienteRMI.mb;   
    static Matrix ansS;

        
    static void imprmirAnsS(){
        for (int x=0; x < ansS.getRows(); x++) {
            System.out.print("|");
            for (int y=0; y < ansS.getCols(); y++) {
              System.out.print (ansS.getValue(x,y));
              if (y!=ansS.getCols()-1) System.out.print("\t");
            }
            System.out.println("|");
        }
    }

    static void imprmirB(){
        System.out.println("ejemplo2: ");
        for (int x=0; x < ex2.getRows(); x++) {
            System.out.print("|");
            for (int y=0; y < ex2.getCols(); y++) {
              System.out.print (ex2.getValue(x,y));
              if (y!=ex2.getCols()-1) System.out.print("\t");
            }
            System.out.println("|");
        }
    }

    static void multiplicarMatrices(){

        Matrix ans = new Matrix(ex.getRows(),ex2.getCols());

        int[][] matrizA = new int[ex.getRows()][ex.getCols()];
        int[][] matrizB = new int[ex2.getRows()][ex2.getCols()];
        int[][] producto = new int[ex.getRows()][ex2.getCols()];


        matrizA = ex.doubleArray;
        matrizB = ex2.doubleArray;

        for (int a = 0; a < matrizB[0].length; a++) {
            // Dentro recorremos las filas de la primera (A)
            for (int i = 0; i < matrizA.length; i++) {
                int suma = 0;
                // Y cada columna de la primera (A)
                for (int j = 0; j < matrizA[0].length; j++) {
                    // Multiplicamos y sumamos resultado
                    suma += matrizA[i][j] * matrizB[j][a];
                }
                // Lo acomodamos dentro del producto
                producto[i][a] = suma;
            }
        }

        ans.doubleArray = producto;

        ansS = ans;

    }


}
