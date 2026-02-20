import java.util.Random;

public class Filosof extends Thread {


    Forquilla forquillaDreta;
    Forquilla forquillaEsquerra;

    Random rnd;


    private int contadoGana = 0;

    public Filosof (String nom) {
        super(nom);
    }

    public void menjar() {
        System.out.printf("Filòsof: %s menja%n", getName());
        try {
            Thread.sleep(java.util.concurrent.ThreadLocalRandom.current().nextInt(1000, 2001));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Filòsof: %s ha acabat de menjar%n", getName());
        forquillaDreta.setEnUs(false);
        forquillaEsquerra.setEnUs(false);
    }

    public void pensar() {
        System.out.printf("Filòsof: %s pensant%n", getName());
        try {
            Thread.sleep(java.util.concurrent.ThreadLocalRandom.current().nextInt(1000, 2001));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            if (!forquillaEsquerra.isEnUs()) {
                System.out.printf("Filòsof: %s agafa la forquilla Esquerra %d%n", getName() , forquillaEsquerra.getNumero());
                forquillaEsquerra.setEnUs(true);
                if (!forquillaDreta.isEnUs()) {
                    System.out.printf("Filòsof: %s agafa la forquilla dreta %d%n", getName() , forquillaDreta.getNumero());
                    forquillaDreta.setEnUs(true);
                    contadoGana = 0;
                    menjar();
                    pensar();
                    continue;
                } else {
                    System.out.printf("Filòsof: %s deixa la forquilla Esquerra %d i espera (dreta ocupada)%n", getName() , forquillaEsquerra.getNumero());
                    forquillaEsquerra.setEnUs(false);
                }

            } else {
                System.out.printf("Filòsof: %s no pot agafar la forquilla dreta %d i espera (esquerraOcupada)%n", getName() , forquillaDreta.getNumero());
                forquillaDreta.setEnUs(false);
            }
            contadoGana++;

            System.out.printf("%s gana=%d%n", getName(), contadoGana);
            try {
                Thread.sleep(java.util.concurrent.ThreadLocalRandom.current().nextInt(1000, 2001));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            //break;
            
        }
    }
    
}
