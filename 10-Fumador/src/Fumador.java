
public class Fumador extends Thread {
    private static Estanc estanc;
    private static int id;
    
    private static Estanc.Tabac tabac;
    private static Estanc.Paper paper;
    private static Estanc.Llumi llumi;
    
    public Fumador(int id, Estanc estanc) {
        this.id = id;
        this.estanc = estanc;
    }

    int fumades = 0;

    public static void fuma() {

        if (tabac != null || paper != null || llumi != null) {
            System.out.printf("Fumador %d", id);
            tabac = null;
            paper = null;
            llumi = null;

            try {
                Thread.sleep(500, 1501);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void compraTabac() {
        tabac = Estanc.venWinston();
        if (tabac == null) {
            return;
        }
        System.out.println("Fumador " + id + " compra tabac");
    }

    public static void compraPaper() {
        paper = Estanc.venPaper();
        if (paper == null) {
            return;
        }
        System.out.println("Fumador " + id + " compra paper");
    }
    public static void compraLlumi() {

        llumi = Estanc.venLlumi();
        if (llumi == null) {
            return;
        }
        System.out.println("Fumador " + id + " compra llumi");
    }

    @Override
    public void run() {
        while (true) {
            if (tabac == null) {
                compraTabac();
            } else if (paper == null) {
                 compraPaper();
            } else if (llumi == null) {
                compraLlumi();
            } else {
                fuma();
            }

            if (fumades ==3) {
               break;
            }

        }
    }
    
}
