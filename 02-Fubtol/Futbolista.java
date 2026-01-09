


public class Futbolista extends Thread {

    public static final int NUM_JUGADORS = 11;
    public static final int NUM_TIRADES = 20;
    public static final float PROBABILITAT = 0.5f;

    int nGols;
    int nTirades;
    
    public Futbolista(String nom) {
        super(nom);
        nGols = 0;
        nTirades = 0;
    }

    @Override
    public void run() {
        for (int i = nTirades; i < NUM_TIRADES; i++) {
            if (Math.random() < PROBABILITAT) {
                nGols++;
                nTirades++;
            }
        }

        System.out.println("El jugador " + getName() + " ha fet " + nGols + " gols de " + NUM_TIRADES + " tirades.");
    }


    public static void main(String[] args) {
        String[] noms = {"Messi", "Ronaldo", "Neymar", "Mbappé", "Haaland", 
                        "Lewandowski", "Benzema", "De Bruyne", "Modric", "Salah", "Kane"};
        
        Futbolista[] equip = new Futbolista[NUM_JUGADORS];

        // Crear tots els jugadors i iniciar-los
        for (int i = 0; i < NUM_JUGADORS; i++) {
            equip[i] = new Futbolista(noms[i]);
            equip[i].start();
        }

        // Esperar que tots acabin
        for (int i = 0; i < NUM_JUGADORS; i++) {
            try {
                equip[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
    }
}
