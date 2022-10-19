import java.util.Scanner;
/**
 * sntgt
 */
public class Main {
    static int[] factorial = {0, 1, 2, 6, 24, 120, 720, 5040, 40320};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test_num = sc.nextInt();
        int[] test_cases = new int[test_num];

        for (int i = 0; i < test_cases.length; i++) {
            test_cases[i] = sc.nextInt();
        }

        for (int i = 0; i < test_cases.length; i++) {
            checkFactorialPrime(test_cases[i]);
        }
    }

    private static void checkFactorialPrime(int n) {
        if (isFactorialPrime(n)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
    
    private static boolean isFactorialPrime(int n) {
        return isPrime(n) && isNearFactorial(n);
    }
    
    private static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        } else if (n == 2) {
            return true;
        } else if (n % 2 == 0) {
            return false;
        }

        int sqrt = (int) Math.sqrt(n);
        for (int i = 3; i <= sqrt; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isNearFactorial(int n) {
        for (int i = 0; i < factorial.length; i++) {
            int diff = factorial[i] - n;
            if (Math.abs(diff) == 1) {
                return true;
            }
            if (diff > 0) {
                return false;
            }
        }

        return false;
    }
}