/*
 * Clase encargada de la interfaz grafica
 * Esta clase envia datos al servidor RMI
 */
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ForkJoinPool;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class App extends JFrame{

    static JLabel jFork, jLineal, jMatrizA, jMatrizB,jRowsB, jRowsA, jColsB, jTiempoF, jTiempoS,jTiempoR ,jMsF, jMsS,jMsR, jTitle, jRowsBi, jRmi;
    static JTextField jtRows, jtCols, jtColsB;
    static JButton jbSaveA, jbCalcularF, jbCalcularS, jbCalcularR, jbImprimirMatrices, jbImprimirF, jbImprimirS, jbImprimirR;
    Color bg= Color.LIGHT_GRAY;
    static Matrix a,b,c,d;
    App(){
        //JFrame 
        setTitle("Multiplicacion de matrices");
        setLocation(870,100);
        setSize(480,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setVisible(true);
        //JTitle
        jTitle = new JLabel();
        jTitle.setOpaque(true);
        jTitle.setBounds(125,10,260,30);
        jTitle.setText("MULTIPLICACION DE MATRICES ALEATORIAS");
        jTitle.setBackground(bg);
        add(jTitle);
        //jFork
        jFork = new JLabel();
        jFork.setOpaque(true);
        jFork.setBounds(10,300,125,30);
        jFork.setText("Fork/Join Framework");
        jFork.setBackground(bg);
        add(jFork);
        //jLineal
        jLineal = new JLabel();
        jLineal.setOpaque(true);
        jLineal.setBounds(185,300,70,30);
        jLineal.setText("Secuencial");
        jLineal.setBackground(bg);
        add(jLineal);
        //jFork
        jRmi = new JLabel();
        jRmi.setOpaque(true);
        jRmi.setBounds(350,300,30,30);
        jRmi.setText("RMI");
        jRmi.setBackground(bg);
        add(jRmi);
        //jMatrizA
        jMatrizA = new JLabel();
        jMatrizA.setOpaque(true);
        jMatrizA.setBounds(110,50,50,30);
        jMatrizA.setText("Matriz A");
        jMatrizA.setBackground(bg);
        add(jMatrizA);
        //jMatrizB
        jMatrizB = new JLabel();
        jMatrizB.setOpaque(true);
        jMatrizB.setBounds(340,50,50,30);
        jMatrizB.setText("Matriz B");
        jMatrizB.setBackground(bg);
        add(jMatrizB);
        //jtRows
        jtRows = new JTextField();
        jtRows.setBounds(70,100,125,30);
        add(jtRows);
        //jtCols
        jtCols = new JTextField();
        jtCols.setBounds(70,145,125,30);
        add(jtCols);
        //jtColsB
        jtColsB = new JTextField();
        jtColsB.setBounds(300,145,125,30);
        add(jtColsB);
        //jRowsA
        jRowsA = new JLabel();
        jRowsA.setOpaque(true);
        jRowsA.setBounds(10,100,50,30);
        jRowsA.setText("Filas A:");
        jRowsA.setBackground(bg);
        add(jRowsA);
        //jRowsB
        jRowsB = new JLabel();
        jRowsB.setOpaque(true);
        jRowsB.setBounds(250,100,45,30);
        jRowsB.setText("Filas B:");
        jRowsB.setBackground(bg);
        add(jRowsB);
        //jRowsBi
        jRowsBi = new JLabel();
        jRowsBi.setOpaque(true);
        jRowsBi.setBounds(300,100,125,30);
        jRowsBi.setText(" ");
        jRowsBi.setBackground(bg);
        add(jRowsBi);
        //jColsA
        jRowsA = new JLabel();
        jRowsA.setOpaque(true);
        jRowsA.setBounds(10,145,50,30);
        jRowsA.setText("Cols A:");
        jRowsA.setBackground(bg);
        add(jRowsA);
        //jColsB
        jColsB = new JLabel();
        jColsB.setOpaque(true);
        jColsB.setBounds(250,145,45,30);
        jColsB.setText("Cols B:");
        jColsB.setBackground(bg);
        add(jColsB);
        //jbSaveA
        jbSaveA = new JButton();
        jbSaveA.setBounds(190,190,90,30);
        jbSaveA.setText("Guardar");
        jbSaveA.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jSaveAActionPerformed(evt);
            }
        });
        add(jbSaveA);
        //jbImprimirMatrices
        jbImprimirMatrices = new JButton();
        jbImprimirMatrices.setBounds(165,250,140,30);
        jbImprimirMatrices.setText("Imprimir matrices");
        jbImprimirMatrices.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ImprimirActionPerformed(evt);
            }
        });
        add(jbImprimirMatrices);

        //jbCalcularF
        jbCalcularF = new JButton();
        jbCalcularF.setBounds(30,340,90,30);
        jbCalcularF.setText("Calcular");
        jbCalcularF.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jbCalcularFActionPerformed(evt);
            }
        });
        add(jbCalcularF);
        //jbCalcularS
        jbCalcularS = new JButton();
        jbCalcularS.setBounds(175,340,90,30);
        jbCalcularS.setText("Calcular");
        jbCalcularS.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jbCalcularSActionPerformed(evt);
            }
        });
        add(jbCalcularS);
        //jbCalcularRMI
        jbCalcularR = new JButton();
        jbCalcularR.setBounds(340,340,90,30);
        jbCalcularR.setText("Calcular");
        jbCalcularR.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jbCalcularRActionPerformed(evt);
            }
        });
        add(jbCalcularR);
        //jTiempoF
        jTiempoF = new JLabel();
        jTiempoF.setOpaque(true);
        jTiempoF.setBounds(10,380,125,30);
        jTiempoF.setText(" ");
        jTiempoF.setBackground(bg);
        add(jTiempoF);
        //jTiempoS
        jTiempoS = new JLabel();
        jTiempoS.setOpaque(true);
        jTiempoS.setBounds(165,380,125,30);
        jTiempoS.setText(" ");
        jTiempoS.setBackground(bg);
        add(jTiempoS);
        //jTiempoR
        jTiempoR = new JLabel();
        jTiempoR.setOpaque(true);
        jTiempoR.setBounds(320,380,125,30);
        jTiempoR.setText(" ");
        jTiempoR.setBackground(bg);
        add(jTiempoR);
        //jMsF
        jMsF = new JLabel();
        jMsF.setOpaque(true);
        jMsF.setBounds(10,420,125,30);
        jMsF.setText(" ");
        jMsF.setBackground(bg);
        add(jMsF);
        //jMsS
        jMsS = new JLabel();
        jMsS.setOpaque(true);
        jMsS.setBounds(165,420,125,30);
        jMsS.setText(" ");
        jMsS.setBackground(bg);
        add(jMsS);
        //jMsR
        jMsR = new JLabel();
        jMsR.setOpaque(true);
        jMsR.setBounds(320,420,125,30);
        jMsR.setText(" ");
        jMsR.setBackground(bg);
        add(jMsR);
        //jbImprimirF
        jbImprimirF = new JButton();
        jbImprimirF.setBounds(10,470,125,30);
        jbImprimirF.setText("Imprimir fork");
        jbImprimirF.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                imprimirForkActionPerformed(evt);
            }
        });
        add(jbImprimirF);
        //jbImprimirS
        jbImprimirS = new JButton();
        jbImprimirS.setBounds(165,470,125,30);
        jbImprimirS.setText("Imprimir lineal");
        jbImprimirS.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                imprimirSecuencialActionPerformed(evt);
            }
        });
        add(jbImprimirS);
        //jbImprimirS
        jbImprimirR = new JButton();
        jbImprimirR.setBounds(320,470,125,30);
        jbImprimirR.setText("Imprimir RMI");
        jbImprimirR.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                imprimirRmiActionPerformed(evt);
            }
        });
        add(jbImprimirR);
    }






    protected void imprimirRmiActionPerformed(ActionEvent evt) {
        try {
            MiInterfazRemota data = (MiInterfazRemota) java.rmi.Naming.lookup("//" + "192.168.137.3" + ":" + "1234" + "/ServerRMI");
            //data.miMetodo1(jPanelChatPrivate.getText());
            data.imprimirRMI();
            
        } catch (Exception ex) {
            //TODO: handle exception
            ex.printStackTrace();
        }
    }



    protected void imprimirSecuencialActionPerformed(ActionEvent evt) {
        System.out.println("\nResultado matriz secuencial: ");
        Secuencial.imprmirAnsS();
        // d=Secuencial.multiplicarMatrices().ans;
    }


    protected void imprimirForkActionPerformed(ActionEvent evt) {
        System.out.println("\nResultado matriz fork: ");
        for (int x=0; x < c.getRows(); x++) {
            System.out.print("|");
            for (int y=0; y < c.getCols(); y++) {
              System.out.print (c.getValue(x,y));
              if (y!=c.getCols()-1) System.out.print("\t");
            }
            System.out.println("|");
        }
    }


    protected void ImprimirActionPerformed(ActionEvent evt) {
        
        System.out.println("\nMatriz A: \n");
        for (int x=0; x < a.getRows(); x++) {
            System.out.print("|");
            for (int y=0; y < a.getCols(); y++) {
              System.out.print (a.getValue(x,y));
              if (y!=a.getCols()-1) System.out.print("\t");
            }
            System.out.println("|");
        }
        System.out.println("\nMatriz B: \n");
        for (int x=0; x < b.getRows(); x++) {
            System.out.print("|");
            for (int y=0; y < b.getCols(); y++) {
              System.out.print (b.getValue(x,y));
              if (y!=b.getCols()-1) System.out.print("\t");
            }
            System.out.println("|");
        }

        try {
            MiInterfazRemota data = (MiInterfazRemota) java.rmi.Naming.lookup("//" + "192.168.137.3" + ":" + "1234" + "/ServerRMI");
            //data.miMetodo1(jPanelChatPrivate.getText());
            data.imprimirMatrices();
            
        } catch (Exception ex) {
            //TODO: handle exception
            ex.printStackTrace();
        }


    }

    protected void jbCalcularRActionPerformed(ActionEvent evt) {
        long startTime = 0;
        long endTime = 0;
        jTiempoR.setText("Tiempo transcurrido: ");
        
        //TODO: invokation try catch

        try {
            MiInterfazRemota data = (MiInterfazRemota) java.rmi.Naming.lookup("//" + "192.168.137.3" + ":" + "1234" + "/ServerRMI");
            //data.miMetodo1(jPanelChatPrivate.getText());
            startTime = System.currentTimeMillis();
            data.calcularRMI();
            endTime = System.currentTimeMillis() - startTime;
        } catch (Exception ex) {
            //TODO: handle exception
            ex.printStackTrace();
        }


        
        jMsR.setText(Long.toString(endTime)+ " ms");
    }


    protected void jbCalcularSActionPerformed(ActionEvent evt) {
        long startTime = 0;
        long endTime = 0;
        jTiempoS.setText("Tiempo transcurrido: ");

        startTime = System.currentTimeMillis();
        Secuencial.multiplicarMatrices();
        endTime = System.currentTimeMillis() - startTime;
        jMsS.setText(Long.toString(endTime)+" ms");

    }


    protected void jbCalcularFActionPerformed(ActionEvent evt) {
        // a = MiClienteRMI.ma;
        // b = MiClienteRMI.mb;

        jTiempoF.setText("Tiempo transcurrido: ");
        
        long startTime = 0;
        long endTime = 0;
        Matrix f = new Matrix(a.getRows(),b.getCols());
        
        ForkJoinPool pool = new ForkJoinPool();
        startTime = System.currentTimeMillis();
        pool.invoke(new Calc(a, b, f));
        endTime = System.currentTimeMillis() - startTime;

        jMsF.setText(Long.toString(endTime) + "ms");

        /*
         * Asignacion de la matriz resultante del metodo a la matriz statica de la clase
         */
        c=f;


    }





    // public static void main(String[] args){

    //     //Iniciar la interfaz grafica
    //     /* 
    //     java.awt.EventQueue.invokeLater(new Runnable() {
    //         @Override
    //         public void run() {
    //             new App();
    //         }
    //     });
    //     */
    // }

    //Metodo del boton
    protected void jSaveAActionPerformed(ActionEvent evt) {
    
     
        int rowsA, colsA, colsB;
 
        //Recuperar los datos proporcionados por los textfield 
        rowsA = Integer.parseInt(jtRows.getText());
        colsA = Integer.parseInt(jtCols.getText());
        colsB = Integer.parseInt(jtColsB.getText());

        
    /* 
         //Crear la primera matriz
         Matrix d = new Matrix(rowsA, colsA);
         //Generar matriz aleatoria de tamano rowsAxcolsA
         for (int x=0; x < d.getRows(); x++) {
             for (int y=0; y < d.getCols(); y++) {
                 d.setValue(x, y, (int) (Math.random() * 9) + 1);
             }
         }
         //pasar como argumento primer matriz 
        Secuencial.ex = d;
        a = d;
         El numero de columnas de la matriz A tiene que ser igual al numero de filas de la matriz B
         Matrix e = new Matrix(d.getCols(), colsB );
         //Generar segunda matriz aleatoria
         for (int x=0; x < e.getRows(); x++) {
             for (int y=0; y < e.getCols(); y++) {
                 e.setValue(x, y, (int) (Math.random() * 9) + 1);
             }
         }
        Secuencial.ex2=e;
        b=e;
        jRowsBi.setText(Integer.toString(a.getCols()));
    */
        try {
            MiInterfazRemota data = (MiInterfazRemota) java.rmi.Naming.lookup("//" + "192.168.137.3" + ":" + "1234" + "/ServerRMI");
            //data.miMetodo1(jPanelChatPrivate.getText());
            data.getData(rowsA, colsA,  colsB);
            a = MiClienteRMI.ma;
            b = MiClienteRMI.mb;
            jRowsBi.setText(Integer.toString(a.getCols()));
        } catch (Exception ex) {
            //TODO: handle exception
            ex.printStackTrace();
        }
     }
    
}
