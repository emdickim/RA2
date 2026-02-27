import java.util.ArrayList;
import java.util.Random;
public class Estanc extends Thread {
    
    public static class Tabac {
 
    } 
    public static class Llumi {
 
    }
    public static class Paper {
 
    }
    private static ArrayList<Tabac> winstons = new ArrayList<>();
    private static ArrayList<Llumi> llumins = new ArrayList<>();
    private static ArrayList<Paper> papers = new ArrayList<>();
    private static Random rnd = new Random();

    public static void nouSubministrament() {

        int num = rnd.nextInt(3);
        
        if (num == 0) {
            addWinston();
        } else if (num == 1) {
            addLlumi();
        } else {
            addPaper();
        }

        try {
            Thread.sleep(500, 1501);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void addWinston() {
       winstons.add(new Tabac());
    }
    public static void addLlumi() {
        System.out.println("Afegint llumi");
        llumins.add(new Llumi());
    }
    public static void addPaper() {
        System.out.println("Afegint paper");
        papers.add(new Paper());
    }
    public static Tabac venWinston() {
       if (winstons == null || winstons.isEmpty()) return null;
       return winstons.remove(winstons.size() - 1);
    }
    public static Llumi venLlumi() {
        if (llumins == null || llumins.isEmpty()) return null;
        return llumins.remove(llumins.size() - 1);
    }
    public static Paper venPaper() {
        if (papers == null || papers.isEmpty()) return null;
        return papers.remove(papers.size() - 1);
    } 

    public static void tancarEstanc() {}

    @Override
    public void run() {
        while (true) {
            nouSubministrament();

            try {
                sleep(rnd.nextInt(500, 1501));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

       // Estanc estanc = new Estanc();
        
       
    }
     
}