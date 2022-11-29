import java.util.Scanner;
/**
 * PerfectNumber
 */
public class PerfectNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tests_count = sc.nextInt();
        int[] test_cases = new int[tests_count];

        for (int i = 0; i < test_cases.length; i++) {
            test_cases[i] = sc.nextInt();
        }

        for (int i = 0; i < test_cases.length; i++) {
            if (isPerfectNum(test_cases[i])) {
                System.out.println(test_cases[i]);
            }
        }
    }

    private static boolean isPerfectNum(int n) {
        return getSumOfDivisors(n) == n;
    }

    private static int getSumOfDivisors(int n) {
        int sum = 0;
        for (int i = 1; i <= n/2; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        return sum;
    }
}