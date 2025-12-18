public class Fil<T> extends Thread{
    private T nom;
    private boolean esEstricte;

    public Fil(T nom) {
        this.nom = nom;
    }

    public Fil(T nom, boolean esEstricte) {
        this.nom = nom;
        this.esEstricte = esEstricte;
    }

    public void saluda() {
        for (int i = 1; i < 10; i++) {
            int comptador = 0;
           for (int j = 0; j < 100000000; j++) {

                comptador++;
            }   
            System.out.println(nom + " " + i);

            if (esEstricte) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (i == 9) {
                System.out.println("Acaba el fil del " + nom);
            }
        }
    }

    public void run() {
        saluda();
    }
}