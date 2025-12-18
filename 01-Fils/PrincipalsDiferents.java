public class PrincipalsDiferents {
    public static void main(String[] args) {
        Fil<String> juan = new Fil<>("Juan");
        Fil<String> pepe = new Fil<>("Pepe");

        juan.setPriority(Thread.MAX_PRIORITY);
        pepe.setPriority(Thread.MIN_PRIORITY);

        
        juan.start();
        pepe.start();
        System.out.println("Acaba tread Fil");
    }
}
