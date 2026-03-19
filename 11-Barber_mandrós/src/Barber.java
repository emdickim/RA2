import java.util.concurrent.ThreadLocalRandom;

public class Barber extends Thread {
    
    private final String nom;

    public Barber(String nom) {
        this.nom = nom;
    }
    public String getNom() {
        return nom;
    }

    @Override
    public void run() {
        Barberia barberia = Barberia.getInstancia();

        while (!isInterrupted()) {
            try {
                Client client;

                synchronized (barberia.getCondBarber()) {
                    client = barberia.seguentClient();
                    if (client == null) {
                        System.out.println("Ningú en espera");
                        System.out.println("Barber " + nom + " dormint");
                        barberia.getCondBarber().wait();
                        continue;
                    }
                }

                System.out.println("Li toca al client " + client.getNom());
                Thread.sleep(900 + ThreadLocalRandom.current().nextInt(101));
                client.tallarSeElCabell();

            } catch (InterruptedException e) {
                interrupt();
            }
        }
    }
}
