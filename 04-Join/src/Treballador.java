//Aixo es un treballador!!!!!!!!!!!!!

import java.util.Random;

public class Treballador extends Thread {
    
    //private static final String nom;
    private static final int SOU_ANUAL_BRUT;
    private static final int EDAT_INICI_TREBALL;
    private static final int EDAT_FI_TREBALL;
    private static int edatActual;
    private static float cobrat = 0.0f;
    private static Random rnd = new Random();

    public Treballador(int souAnualBrut, int edatIniciTreball, int edatFiTreball) {
        this.SOU_ANUAL_BRUT = souAnualBrut;
        this.EDAT_INICI_TREBALL = edatIniciTreball;
        this.EDAT_FI_TREBALL = edatFiTreball;
        this.edatActual = 0;
    }
    
    public void cobra() {
        this.cobrat += SOU_ANUAL_BRUT / 12f; 
    }

    public void pagaImpostos() {
        this.cobrat -= (SOU_ANUAL_BRUT / 12f) * 0.24f; 
    }

    public static float getCobrat() {
        return cobrat;
    }

    public static int getEdatActual() {
        return edatActual;
    }

    @Override
    public void run() {
        while (true) {
            int tempsSleep = rnd.nextInt(1000);
            edatActual++;
            if (edatActual >= 20) {
                cobra();
                pagaImpostos();
            }

            if (edatActual == 65) break;
            
            try {
                Thread.sleep(tempsSleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
        }
    }






}
