// AIXO ES UN MOTOR!

public class Motor extends Thread {
    private int potenciaObjectiu = 0;
    private int potenciaActual = 0;

    public Motor(int potenciaObjectiu) {
        this.potenciaActual = potenciaActual;
        this.potenciaObjectiu = potenciaObjectiu;
    }

    public void setPotencia(int p) {
        this.potenciaActual += p;
    }
}
