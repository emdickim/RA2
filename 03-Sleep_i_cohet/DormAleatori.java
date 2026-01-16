import java.util.Random;

public class DormAleatori extends Thread {

    private String nom;
    private long tempsCreacio;

    public DormAleatori (String nom) {
        this.nom = nom;
        this.tempsCreacio = System.currentTimeMillis();
    }

    @Override
    public void run() {

        Random rd = new Random();
        

        for (int i = 0; i < 10; i++) {
            int tempsAleatori = rd.nextInt(1000);
            long tempsTranscorregut = System.currentTimeMillis() - tempsCreacio;
            System.out.printf("%-5s(%d) a dormir %4dms total %6dms%n", 
                this.nom, i, tempsAleatori, tempsTranscorregut);

            try {
                Thread.sleep(tempsAleatori);
            } catch (InterruptedException e) {
                System.out.println("Error: " + e.getMessage());
            }

           
        }
            
    }
    public static void main(String[] args) {
        DormAleatori pep = new DormAleatori("PEPE");
        DormAleatori juan = new DormAleatori("JUAN");


        pep.start();
        juan.start();


        System.out.println("--- Fi de main ----------");
    }
}
