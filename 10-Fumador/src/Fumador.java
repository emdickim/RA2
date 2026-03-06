import java.util.Random;

public class Fumador extends Thread {
    private final Estanc estanc;
    private final int id;
    private final Random rnd = new Random();
    
    private Estanc.Tabac tabac;
    private Estanc.Paper paper;
    private Estanc.Llumi llumi;
    
    public Fumador(int id, Estanc estanc) {
        this.id = id;
        this.estanc = estanc;
    }

    int fumades = 0;

    public void fuma() {

        
            System.out.printf("Fumador %d fuma\n", id);
            
            tabac = null;
            paper = null;
            llumi = null;
            fumades++;

            try {
                Thread.sleep(rnd.nextInt(500, 1502));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Fumador " + id + " ha fumat " + (fumades + 1) + " veces");
    }

    public void compraTabac() {
        tabac = estanc.venWinston();
        if (tabac == null) {
            return;
        }
        System.out.println("Fumador " + id + " compra tabac");
    }

    public void compraPaper() {
        paper = estanc.venPaper();
        if (paper == null) {
            return;
        }
        System.out.println("Fumador " + id + " compra paper");
    }
    public void compraLlumi() {

        llumi = estanc.venLlumi();
        if (llumi == null) {
            return;
        }
        System.out.println("Fumador " + id + " compra llumi");
    }

    @Override
    public void run() {
        while (true) {
            
            compraTabac();

            compraPaper();

            compraLlumi();

            if (tabac != null && paper != null && llumi != null) fuma();


            if (fumades == 3) {
                break;
            }

        }
    }
    
}
