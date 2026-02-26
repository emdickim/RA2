import java.util.concurrent.locks.ReentrantLock;

public class Forquilla {

    private final int numero;
    private final ReentrantLock bloqueig;

    public Forquilla(int numero) {
        this.numero = numero;
        this.bloqueig = new ReentrantLock();
    }

    public int getNumero() {
        return numero;
    }

    public boolean agafar() {
        return bloqueig.tryLock();
    }

    public void deixar() {
        if (bloqueig.isHeldByCurrentThread()) {
            bloqueig.unlock();
        }
    }
}
