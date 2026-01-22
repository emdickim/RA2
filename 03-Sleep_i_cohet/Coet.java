// AIXO ES UN COHET MOLT XULO!!
import java.util.Scanner;

public class Coet {

    // Array de 4 motors del coet
    private static Motor[] motores = new Motor[4];

    // Crea i arrenca els 4 motors
    private static void arrancarMotors(int potenciaInicial) {
        for (int i = 0; i < motores.length; i++) {
            motores[i] = new Motor("Motor " + i);
            motores[i].setPotenciaObjectiu(potenciaInicial);
            motores[i].start();
        }
    }

    // Mètode que comprova la potència i la passa als 4 motors
    private static void passaAPotencia(int p) {
        if (p < 0 || p > 10) {
            System.out.println("Numero incorrecte, torna-ho a provar");
            return;
        }

        System.out.println("Passant a potencia " + p);
        for (Motor m : motores) {
            m.setPotenciaObjectiu(p);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introdueix la potencia del cohet: (0-10, escriu 0 per sortir)");

        
        int numero = sc.nextInt();
        // Crear i arrencar els motors UNA VEGADA
        arrancarMotors(numero);

        
        while (true) {
            numero = sc.nextInt();
            if (numero == 0) {
                // Posem potència 0 i sortim
                passaAPotencia(0);
                break;
            }

            passaAPotencia(numero);
        }
        
        sc.close();
    }

    
}
