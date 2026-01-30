import java.util.Random;

public class Soci extends Thread {
    
    private final Compte compte;
    private final float aportacio = 10f;
    private final int esperaMax = 100;
    private Random rnd = new Random();
    private final int maxAnys = 10;

    public Soci(Compte compte) {
        this.compte = compte;
    }

    public synchronized Compte getCompte() {
        return compte;
    }

    @Override
    public void run() {
        for (int any = 0; any < maxAnys; any++) {
            for (int i = 1; i <= 12; i++) {
                if (i % 2 != 0) {
                    compte.setSaldo(aportacio);
                } else {
                    compte.setSaldo(-aportacio);
                }
                try {
                    Thread.sleep(rnd.nextInt(esperaMax));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }   
        }

        
    }


}
