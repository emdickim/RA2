import java.util.LinkedList;

public class Barberia {

    private LinkedList<Client> cua = new LinkedList<>();
    private final int numCadires;
    //private final Barber barber;
    private static Barberia instancia;

    private Barberia(int numCadires) {
        this.numCadires = numCadires;
    }

    //Metode per obtenir la instància
    public static Barberia getInstancia() {
        if (instancia == null) {
            instancia = new Barberia(3);
        }
        return instancia;
    }
    

    Object condBarber = new Object();

    

    public Client seguentClient() {
        return cua.removeFirst();
    }
    public synchronized void entrarClient(Client client) {
        if (cua.length < numCadires) {
            return cua.addLast(client);
        }
    }
}
