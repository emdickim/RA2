import java.util.Random;

public class Soci extends Thread {
    
    private final float aportacio = 10f;
    private final int esperaMax = 100;
    private Random rnd = new Random();
    private final int maxAnys = 5;

    public Soci() {


    }

    @Override
    public void run() {
        for (int any = 0; any < maxAnys; i++) {
            if (any % 2 == 0) Compte.setSaldo(Compte.getInstance())
        }
    }


}
