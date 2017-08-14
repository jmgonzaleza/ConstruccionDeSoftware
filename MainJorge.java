
import java.util.Scanner;

public class MainJorge {

    public static int movimientos[][] = {{1,2},{1,-2},{-1,2},{-1,-2},{2,1},{2,-1},{-2,1},{-2,-1}};

    public static void main(String[] Args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for (int i = 1; i <= n; i++) {            
            System.out.println(minimosMovimientos(s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt(), 0));
        }
        
    }

    private static int minimosMovimientos(int r1, int c1, int r2, int c2, int costo) {        
        if ((r1 == r2 && c1 == c2) || costo >=9) {
            return costo;
        } else {
            int costoMinimo = 100;
            int costoActual;
            int nuevo_r1;
            int nuevo_c1;
            for (int i = 0; i < 8; i++) {
                nuevo_r1 = r1 + movimientos[i][0];
                nuevo_c1 = c1 + movimientos[i][1];
                if (!((nuevo_r1 < 0 || nuevo_r1 > 7) || (nuevo_c1 < 0 || nuevo_c1 > 7))) {
                    costoActual = minimosMovimientos(nuevo_r1, nuevo_c1, r2, c2, costo + 1);
                    if (costoActual < costoMinimo) {
                        costoMinimo = costoActual;
                    }
                }
            }
            return costoMinimo;
        }
    }

}
