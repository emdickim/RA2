import java.util.Random;

public class Assistent extends Thread {
    
    private Esdeveniment esdeveniment;
    private String nom;
    private Random rnd = new Random();


    public Assistent(String nom, Esdeveniment esdeveniment) {
        super(nom);
        this.esdeveniment = esdeveniment;
    }

    @Override
    public void run() {
        while (true) {
        if (rnd.nextInt(100) <= 50) {

            esdeveniment.ferReserva(this);
        } else {
            esdeveniment.cancelaReserva(this);
        }

        try {
            Thread.sleep(rnd.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    }
}
