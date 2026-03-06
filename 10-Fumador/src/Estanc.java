import java.util.ArrayList;
import java.util.Random;
public class Estanc extends Thread {
    
    public class Tabac {
 
    } 
    public class Llumi {
 
    }
    public class Paper {
 
    }
    private final ArrayList<Tabac> winstons = new ArrayList<>();
    private final ArrayList<Llumi> llumins = new ArrayList<>();
    private final ArrayList<Paper> papers = new ArrayList<>();
    private final Random rnd = new Random();

    public void nouSubministrament() {

        int num = rnd.nextInt(3);
        
        if (num == 0) {
            addWinston();
        } else if (num == 1) {
            addLlumi();
        } else {
            addPaper();
        }

        try {
            Thread.sleep(rnd.nextInt(500, 1502));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public synchronized void addWinston() {
       winstons.add(new Tabac());
        System.out.println("Afegint tabac");
        notifyAll();
    }
    public synchronized void addLlumi() {
        System.out.println("Afegint llumi");
        llumins.add(new Llumi());
        notifyAll();
    }
    public synchronized void addPaper() {
        System.out.println("Afegint paper");
        papers.add(new Paper());
        notifyAll();
    }
    public synchronized Tabac venWinston() {
       while (winstons.isEmpty()) {
        try {
            wait();  // el fumador espera aquí
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
       return winstons.remove(winstons.size() - 1);
    }
    public synchronized Llumi venLlumi() {
        while (llumins.isEmpty()) {
            try {
                wait();  // el fumador espera aquí
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return llumins.remove(llumins.size() - 1);
    }
    public synchronized Paper venPaper() {
        while (papers.isEmpty()) {
            try {
                wait();  // el fumador espera aquí
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return papers.remove(papers.size() - 1);
    } 

    public boolean tancarEstanc() {
        return Barri.fumadors[0].fumades == 3 && Barri.fumadors[1].fumades == 3 && Barri.fumadors[2].fumades == 3;
    }
    @Override
    public void run() {
        while (!tancarEstanc()) {

            nouSubministrament();
            
            

            try {
                Thread.sleep(rnd.nextInt(500, 1501));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

       // Estanc estanc = new Estanc();
        
       
    }
     
}