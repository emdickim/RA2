//Aixo es un treballador!!!!!!!!!!!!!

import java.util.Random;

public class Treballador extends Thread {
    
    //private static final String nom;
    private float SOU_ANUAL_BRUT;
    private int EDAT_INICI_TREBALL;
    private int EDAT_FI_TREBALL;
    private int edatActual;
    private float cobrat = 0.0f;
    private Random rnd = new Random();

    public Treballador(float souAnualBrut, int edatIniciTreball, int edatFiTreball) {
        this.SOU_ANUAL_BRUT = souAnualBrut;
        this.EDAT_INICI_TREBALL = edatIniciTreball;
        this.EDAT_FI_TREBALL = edatFiTreball;
        this.edatActual = 0;
    }
    
    public void cobra() {
        this.cobrat += (SOU_ANUAL_BRUT / 12.0f); 
    }

    public void pagaImpostos() {
        this.cobrat -= (SOU_ANUAL_BRUT / 12.0f) * 0.24f; 
    }

    public float getCobrat() {
        return cobrat;
    }

    public int getEdat() {
        return edatActual;
    }

    @Override
    public void run() {
        while (true) {
            edatActual++;
            if (edatActual >= 20 && edatActual < 65) {
                for (int i = 0; i < 12; i++) {
                    cobra();
                    pagaImpostos();
                }
            } 
            
            if (edatActual == 65) {
                break;
            }

            
            
            try {
                Thread.sleep(rnd.nextInt(10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
        }
    }






}
