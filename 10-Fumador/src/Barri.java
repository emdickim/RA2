public class Barri {
    private final Estanc estanc;
    static final Fumador[] fumadors = new Fumador[3];

    public Barri() {
        estanc = new Estanc();
        for (int i = 0; i < 3; i++) {
            fumadors[i] = new Fumador(i, estanc);
        }
    }

    public void iniciar() {
        estanc.start();
        for (Fumador fumador : fumadors) {
            fumador.start();
        }
    }
    public static void esperarFi() {
        try {
            for (Fumador fumador : fumadors) {
                fumador.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Barri barri = new Barri();
        barri.iniciar();
        esperarFi();
        System.out.println("El estanc ha cerrado. Todos los fumadores han fumado 3 veces.");
    }
}
