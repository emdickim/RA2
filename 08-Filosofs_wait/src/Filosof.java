public class Filosof extends Thread {

    private int numeroDeFilosof;
    Forquilla forquillaDreta;
    Forquilla forquillaEsquerra;

    private int contadoGana = 0;

    public Filosof (String nom, int numeroDeFilosof) {
        super(nom);
        this.numeroDeFilosof = numeroDeFilosof;
    }

    public void menjar() {
        System.out.printf("Filòsof: %s menja%n", getName());
        try {
            Thread.sleep(java.util.concurrent.ThreadLocalRandom.current().nextInt(1000, 2001));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        contadoGana = 0;
        System.out.printf("Filòsof: %s ha acabat de menjar%n", getName());
    }

    public void deixarForquilles() {
        deixarForquilla(forquillaEsquerra);
        deixarForquilla(forquillaDreta);
    }

    public void pensar() {
        System.out.printf("Filòsof: %s pensant%n", getName());
        try {
            Thread.sleep(java.util.concurrent.ThreadLocalRandom.current().nextInt(1000, 2001));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    


    private void agafarForquilles() {
        while (true) {
            agafarForquillaEsquerra();
            if (agafarForquillaDreta()) {
                return;
            }
            deixarForquilla(forquillaEsquerra);
            esperaAmbTemps(forquillaDreta);
            contadoGana++;
            System.out.printf("%s gana=%d%n", getName(), contadoGana);
        }
    }

    private void agafarForquillaEsquerra() {
        synchronized (forquillaEsquerra) {
            while (forquillaEsquerra.isEnUs()) {
                esperaAmbTemps(forquillaEsquerra);
            }
            System.out.printf("Filòsof: %s agafa la forquilla esquerra %d%n", getName(), forquillaEsquerra.getNumero());
            forquillaEsquerra.agafar(numeroDeFilosof);
        }
    }

    private boolean agafarForquillaDreta() {
        synchronized (forquillaDreta) {
            if (forquillaDreta.isEnUs()) {
                return false;
            }
            System.out.printf("Filòsof: %s agafa la forquilla dreta %d%n", getName(), forquillaDreta.getNumero());
            forquillaDreta.agafar(numeroDeFilosof);
            return true;
        }
    }

    private void deixarForquilla(Forquilla forquilla) {
        synchronized (forquilla) {
            forquilla.deixar();
            forquilla.notifyAll();
        }
    }

    private void esperaAmbTemps(Object monitor) {
        synchronized (monitor) {
            try {
                monitor.wait(java.util.concurrent.ThreadLocalRandom.current().nextInt(500, 1001));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    @Override
    public void run() {
        while (true) {
            agafarForquilles();
            menjar();
            deixarForquilles();
            pensar();
        }
    }
    
}
