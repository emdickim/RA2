public class Forquilla {

    private int LLIURE = -1;
    private int numero;
    private int numeroDePropietari;
    private boolean enUs;

    public Forquilla(int numero) {
        this.numero = numero;
        this.numeroDePropietari = LLIURE;
        this.enUs = false;
    }

    public int getNumero() {
        return numero;
    }

    public int getNumeroDePropietari() {
        return numeroDePropietari;
    }

    public void setNumeroDePropietari(int numero) {
        this.numeroDePropietari = numero;
    }

    public boolean isEnUs() {
        return enUs;
    }

    public void agafar(int propietari) {
        this.enUs = true;
        this.numeroDePropietari = propietari;
    }

    public void deixar() {
        this.enUs = false;
        this.numeroDePropietari = LLIURE;
    }


    
}
