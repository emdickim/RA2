public class Assosiacio {

    private static int numSocis = 1000;
    private static Soci[] socis;

    public Assosiacio() {
        socis = new Soci[numSocis];
        for (int i = 0; i < numSocis; i++) {
            socis[i] = new Soci(Compte.getInstance());
        }
    }

    public static void main(String[] args) {
        
        Assosiacio assosiacio = new Assosiacio();

        iniciaCompteTempsSocis(assosiacio);

        esperaPeriodeDeSocis();

        mostraBalanceComptes();


    }

    private static void iniciaCompteTempsSocis(Assosiacio assosiacio) {

        for (int i = 0; i < assosiacio.numSocis; i++) {
            socis[i].start();
        }
    }
    
    private static void esperaPeriodeDeSocis() {
        
        try {
            for (int i = 0; i < numSocis; i++) {
                socis[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void mostraBalanceComptes() {
        for (int i = 0; i < numSocis; i++) {
            System.out.println("El compte del soci numero " + i + " es de " + socis[i].getCompte().getSaldo());
        }
    }
}
