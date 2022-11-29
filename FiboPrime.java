import java.util.Scanner;
/**
 * FiboPrime
 */
public class FiboPrime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test_num = sc.nextInt();
        int[] test_cases = new int[test_num];

        for (int i = 0; i < test_cases.length; i++) {
            test_cases[i] = sc.nextInt();
        }

        for (int i = 0; i < test_cases.length; i++) {
            checkFiboPrime(test_cases[i]);
        }
    }

    private static void checkFiboPrime(int n) {
        if (isFiboPrime(n)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static boolean isFiboPrime(int n) {
        return isFibo(n) && isPrime(n);
    }

    private static boolean isPrime(int n) {
        if (n <= 2) {
            return n != 1;
        }
    
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isFibo(int n) {
        return isPerfectSquare(5*Math.pow(n, 2) - 4) || isPerfectSquare(5*Math.pow(n, 2) + 4);
    }

    private static boolean isPerfectSquare(double n) {
        if (Math.sqrt(n) % 1 == 0) {
            return true;
        }
        return false;
    }
}