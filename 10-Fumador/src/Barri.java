public class Barri {
    private static Estanc estanc;
    Fumador[] fumadors;

    public Barri() {
        estanc = new Estanc();
        fumadors = new Fumador[3];
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

    public static void main(String[] args) {
        Barri barri = new Barri();
        barri.iniciar();
    }
}
