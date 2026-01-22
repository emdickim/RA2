// AIXO ES UN MOTOR!!!!
import java.util.concurrent.ThreadLocalRandom;

public class Motor extends Thread {
    private int potenciaObjectiu = 0;
    private int potenciaActual = 0;
    private boolean enObjectiu = false;

    public Motor(String nom) {
        super(nom);
    }

    // NO fa falta sumar, la lògica del run ja incrementa/decrementa
    public void setPotencia(int p) {
        this.potenciaActual += p;
    }

    public void setPotenciaObjectiu(int potenciaObjectiu) {
        this.potenciaObjectiu = potenciaObjectiu;
    }

    @Override
    public void run() {

        while (true) {
            int numero = ThreadLocalRandom.current().nextInt(1, 3);

            if (potenciaActual < potenciaObjectiu) {
                enObjectiu = false;
                System.out.println(getName() + ": Incre. Objectiu: " + potenciaObjectiu + " Actual: " + potenciaActual);
                potenciaActual++;
            } else if (potenciaActual > potenciaObjectiu) {
                
                System.out.println(getName() + ": Decre. Objectiu: " + potenciaObjectiu + " Actual: " + potenciaActual);
                enObjectiu = false;
                potenciaActual--;
            } else {
                if (!enObjectiu) {
                    System.out.println(getName() + ": FerRes Objectiu: " + potenciaObjectiu + " Actual: " + potenciaActual);
                    enObjectiu = true;
                    // Si hem arribat a potència 0 i l'objectiu també és 0, sortim del bucle
                    if (potenciaObjectiu == 0 && potenciaActual == 0) {
                        break;
                    }
                 }
            }

            

            try {
                Thread.sleep(numero * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
