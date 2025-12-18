public class PrincipalEstricte {
    public static void main(String[] args) {
        Fil<String> juan = new Fil<>("Juan", true);
        Fil<String> pepe = new Fil<>("Pepe", true);


        
        juan.start();
        pepe.start();
        System.out.println("Acaba tread Fil");
    }
}
