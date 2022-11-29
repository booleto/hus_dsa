import java.util.Scanner;
/**
 * slpln
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test_count = sc.nextInt();
        int[] test_cases = new int[test_count];

        for (int i = 0; i < test_cases.length; i++) {
            test_cases[i] = sc.nextInt();
        }

        for (int i : test_cases) {
            System.out.println(nearestSquare(i));
        }
    }

    private static int nearestSquare(int n) {
        return (int) Math.cbrt(n);
    }
}