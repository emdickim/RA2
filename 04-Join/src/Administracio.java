// AIXO ES HACIENDA, NOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO

public class Administracio extends Thread {

    private final int num_poblacio_activa = 50;
    private static final Treballador[] poblacio_activa = new Treballador[50];


    public static void main(String[] args) {
        constructor();
    }


    private static void constructor() {
        
        for (int i = 0; i < poblacio_activa.length; i++) {
            poblacio_activa[i] = new Treballador(25000, 20, 65);
            poblacio_activa[i].setName("Ciutadà-" + 1);
        }
    }
}
