/**
 * Test
 */
public class Test {

    public static void main(String[] args) {
        double x = 10000000;
        int fact = 50;

        for (int i = 0; i < fact; i++) {
            x = Math.sqrt(x);
        }
        System.out.println(x);
        
        for (int i = 0; i < fact; i++) {
            x = Math.pow(x, 2);
        }
        System.out.println(x);
    }
}