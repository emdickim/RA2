public class Compte {

    private static Compte instance;
    private int saldo;


    private Compte() {
        this.saldo = 0;
    }

    public static synchronized Compte getInstance() {
        if (instance == null) {
            instance = new Compte();
        }
        return instance;
    }
    public int getSaldo() {
        return saldo;
    }
    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
    
}
