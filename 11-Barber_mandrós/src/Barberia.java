import java.util.LinkedList;

public class Barberia extends Thread {

    private final LinkedList<Client> salaEspera = new LinkedList<>();
    private final int numCadires;

    private static Barberia instancia;
    private int idClient = 1;
    private final Object condBarber = new Object();

    private Barberia(int numCadires) {
        this.numCadires = numCadires;
    }

    public static synchronized Barberia getInstancia(int numCadires) {
        if (instancia == null) {
            instancia = new Barberia(numCadires);
        }
        return instancia;
    }

    public static synchronized Barberia getInstancia() {
        if (instancia == null) {
            throw new IllegalStateException("Cal inicialitzar la barberia amb getInstancia(numCadires)");
        }
        return instancia;
    }

    public Object getCondBarber() {
        return condBarber;
    }

    public Client seguentClient() {
        synchronized (condBarber) {
            if (salaEspera.isEmpty()) {
                return null;
            }
            return salaEspera.removeFirst();
        }
    }

    public void entrarClient(Client client) {
        synchronized (condBarber) {
            if (salaEspera.size() < numCadires) {
                salaEspera.addLast(client);
                System.out.println("Client " + client.getNom() + " en espera");
                condBarber.notify();
            } else {
                System.out.println("No queden cadires, client " + client.getNom() + " se'n va");
            }
        }
    }

    public boolean teClientsEnEspera() {
        synchronized (condBarber) {
            return !salaEspera.isEmpty();
        }
    }

    private void entrarNClients(int n) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            entrarClient(new Client(idClient++));
            Thread.sleep(500);
        }
    }

    @Override
    public void run() {
        try {
            entrarNClients(10);
            Thread.sleep(10_000);
            entrarNClients(10);
        } catch (InterruptedException e) {
            interrupt();
        }
    }

    public static void main(String[] args) {
        Barberia barberia = Barberia.getInstancia(3);
        Barber barber = new Barber("Pepe");

        barber.start();
        barberia.start();

        try {
            barberia.join();

            while (barberia.teClientsEnEspera()) {
                Thread.sleep(200);
            }

            barber.interrupt();
            barber.join();

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
