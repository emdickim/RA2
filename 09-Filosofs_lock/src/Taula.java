public class Taula {
    

    private static Filosof[] filosofs;
    private static Forquilla[] forquilles;

    public Taula(int numeroFilosofs) {
        this.filosofs = new Filosof[numeroFilosofs];
        this.forquilles = new Forquilla[numeroFilosofs];
        for (int i = 0; i < numeroFilosofs; i++) {
            forquilles[i] = new Forquilla(i);
        }

        for (int i = 0; i < numeroFilosofs; i++) {
            Forquilla esquerra = forquilles[i];
            Forquilla dreta = forquilles[(i + 1) % numeroFilosofs];
            filosofs[i] = new Filosof("Fil" + i, esquerra, dreta);
        }

    }

    public static void showTaula() {
        for (int i = 0; i < filosofs.length; i++) {
            System.out.printf("Comensal:%s esq:%d dret:%d%n",
                    filosofs[i].getName(),
                    filosofs[i].getForquillaEsquerra().getNumero(),
                    filosofs[i].getForquillaDreta().getNumero());
        }
    }
    
    public static void cridarAtaula() {
        for (int i = 0; i < filosofs.length; i++) {
            filosofs[i].start();
        }
    }



    public static void main(String[] args) {

        Taula taula = new Taula(5);
        showTaula();
        cridarAtaula();
        
    }
}
