import java.util.List;
import java.util.ArrayList;

public class Esdeveniment {
    
    public List<Assistent> assistents;
    private int placesMaximes;
    private int placesDisponibles;

    

    
    public synchronized int getPlacesDisponibles() {
        return placesDisponibles;
    }

    public Esdeveniment(int placesMaximes) {
        this.placesMaximes = placesMaximes;
        this.placesDisponibles = placesMaximes;
        this.assistents = new ArrayList<>();
    }

    public synchronized void ferReserva(Assistent assitent) {
        while (placesDisponibles == 0){

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        if (assistents.contains(assitent)) {
            return;
        }
        assistents.add(assitent);
        System.out.println(assitent.getName() + " ha fet una reserva. Plaçes disponibles: " + placesDisponibles);
        placesDisponibles--;
    }

    public synchronized void cancelaReserva(Assistent assitent) {
        if (assistents.contains(assitent) && placesDisponibles < placesMaximes) {
            System.out.println(assitent.getName() + " ha cancelat una reserva. Plaçes disponibles: " + placesDisponibles);
            assistents.remove(assitent);
            placesDisponibles++;
            notifyAll();
        } else {
            System.out.println(assitent.getName() + " no s'ha pogut cancelar una reserva. Plaçes disponibles: " + placesDisponibles);

        }
    }

}
