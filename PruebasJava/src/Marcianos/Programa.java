package Marcianos;

public class Programa {
    public static void main(String[] args) {
        Marciano m1 = new Marciano("Calamar");
        m1.x = 10;
        m1.y = 5;
        m1.tipo = "Calamar";

        Marciano m2 = new Marciano("Pulpo", 20, 5);

        System.out.println(m1);
        System.out.println(m2);
    }
}

