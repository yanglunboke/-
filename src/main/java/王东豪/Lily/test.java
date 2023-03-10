package 王东豪.Lily;

public class test {
    public static void main(String[] args) {
        Lily lily = new Lily();
        instrument i1= new piano();
        instrument i2= new violin();
        lily.play(i1);
        System.out.println("--------------------------------");
        lily.play(i2);
    }
}
