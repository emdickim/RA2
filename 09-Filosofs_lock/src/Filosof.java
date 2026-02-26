import java.util.concurrent.ThreadLocalRandom;

public class Filosof extends Thread {

    private final Forquilla forquillaDreta;
    private final Forquilla forquillaEsquerra;

    private long iniciGana;
    private long fiGana;
    private int gana;

    public Filosof(String nom, Forquilla esquerra, Forquilla dreta) {
        super(nom);
        this.forquillaEsquerra = esquerra;
        this.forquillaDreta = dreta;
        resetGana();
    }

    public Forquilla getForquillaEsquerra() {
        return forquillaEsquerra;
    }

    public Forquilla getForquillaDreta() {
        return forquillaDreta;
    }

    public void menjar() {
        gana = calcularGana();
        System.out.printf("%s menja amb gana %d%n", getName(), gana);
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 2001));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.printf("%s ha acabat de menjar%n", getName());
        deixarForquilles();
        resetGana();
    }

    public void pensar() {
        iniciGana = System.currentTimeMillis();
        System.out.printf("%s pensant%n", getName());
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 2001));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public boolean agafarForquillaEsquerra() {
        return forquillaEsquerra.agafar();
    }

    public boolean agafarForquillaDreta() {
        return forquillaDreta.agafar();
    }

    public boolean agafarForquilles() {
        if (!agafarForquillaEsquerra()) {
            return false;
        }
        if (!agafarForquillaDreta()) {
            forquillaEsquerra.deixar();
            return false;
        }
        System.out.printf("%s te forquilles esq(%d) dreta(%d)%n",
                getName(), forquillaEsquerra.getNumero(), forquillaDreta.getNumero());
        return true;
    }

    public void deixarForquilles() {
        forquillaDreta.deixar();
        forquillaEsquerra.deixar();
        System.out.printf("%s deixa les forquilles%n", getName());
    }

    public int calcularGana() {
        fiGana = System.currentTimeMillis();
        return (int) ((fiGana - iniciGana) / 1000);
    }

    public void resetGana() {
        iniciGana = System.currentTimeMillis();
        gana = 0;
    }

    @Override
    public void run() {
        while (true) {
            pensar();
            while (!agafarForquilles()) {
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(50, 151));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            menjar();
        }
    }
    
}
