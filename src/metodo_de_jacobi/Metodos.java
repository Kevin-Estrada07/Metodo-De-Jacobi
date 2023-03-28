package metodo_de_jacobi;

import java.util.Scanner;

public class Metodos {

    String letra[] = {"a", "b", "c", "z"};
    Scanner leer = new Scanner(System.in);

    public void encabezado() {
        System.out.println("--------------------------------------------------");
        System.out.println("n |    X1    |    X2    |    X3    |    EaX1    |    EaX2    |    EaX3    ");
    }

    public void Inicia() {
        int noValores = 4;
        double ecuaciones[][] = Ecuaciones(noValores);
        encabezado();
        Resolucion(ecuaciones);
    }

    public double[][] Ecuaciones(int noValores) {
        double ecu[][] = new double[3][noValores];
        for (int i = 0; i < 3; i++) {
            System.out.println("Ecuacion " + (i + 1));
            for (int j = 0; j < noValores; j++) {
                System.out.print(letra[j] + ": ");
                ecu[i][j] = leer.nextDouble();
            }
        }
        return ecu;
    }


    public void Resolucion(double ecu[][]) {
        double X1 = 0;
        double X2 = 0;
        double X3 = 0;
        for (int i = 0; i < 10; i++) {

            double x1 = X1;
            double x2 = X2;
            double x3 = X3;

            X1 = (ecu[0][3] - (ecu[0][1] * x2) - (ecu[0][2] * x3)) / ecu[0][0];
            X2 = (ecu[1][3] - (ecu[1][0] * x1) - (ecu[1][2] * x3)) / ecu[1][1];
            X3 = (ecu[2][3] - (ecu[2][0] * x1) - (ecu[2][1] * x2)) / ecu[2][2];

            double EaX1 = ((X1 - x1) / X1) * 100;
            double EaX2 = ((X2 - x2) / X2) * 100;
            double EaX3 = ((X3 - x3) / X3) * 100;

            System.out.println(+(i + 1) + "  |  " + String.format("%.4f", X1) + "  |  " + String.format("%.4f", X2) + "  |  " + String.format("%.4f", X3) + "  |  " + String.format("%.4f", EaX1) + "  |  " + String.format("%.4f", EaX2) + "  |  " + String.format("%.4f", EaX3));

        }
    }
}
