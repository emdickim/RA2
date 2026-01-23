// AIXO ES HACIENDA, NOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO

public class Administracio extends Thread {

    private final int num_poblacio_activa = 50;
    private static final Treballador[] poblacio_activa = new Treballador[50];

    public Administracio() {            // <-- AIXÒ és el constructor
        for (int i = 0; i < poblacio_activa.length; i++) {
            poblacio_activa[i] = new Treballador(25000, 20, 65);
            poblacio_activa[i].setName("Ciutadà-" + i);
        }
    }


    public static void main(String[] args) {
        Administracio admin = new Administracio();

        for (int i = 0; i < poblacio_activa.length; i++) {
            poblacio_activa[i].start();              
        }

        
        for (int i = 0; i < poblacio_activa.length; i++) {
            try {
                poblacio_activa[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.printf("%s -> edat: %d / total: %.2f%n",
            admin.poblacio_activa[i].getName(),
            admin.poblacio_activa[i].getEdat(),
            admin.poblacio_activa[i].getCobrat());
            
        }
        
    }


    
}
