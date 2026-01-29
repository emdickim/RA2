

public class Assosiacio {

    private int numSocis = 1000;
    private Soci[] socis;

    public Assosiacio() {
        socis = new Soci[numSocis];
        for (int i = 0; i < numSocis; i++) {
            socis[i] = new Soci();
        }
    }

    
    
}
