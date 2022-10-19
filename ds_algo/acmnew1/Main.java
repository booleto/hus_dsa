import java.util.Arrays;
import java.util.Scanner;
/**
 * Main
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int schools_count = sc.nextInt();
        int[][] weight_list = new int[schools_count][];
        int[] max_weight = new int[schools_count];

        for (int i = 0; i < weight_list.length; i++) {
            int students_count = sc.nextInt();
            weight_list[i] = new int[students_count];
            for (int j = 0; j < weight_list[i].length; j++) {
                weight_list[i][j] = sc.nextInt();
            }
            max_weight[i] = sc.nextInt();
        }
        
        for (int i = 0; i < max_weight.length; i++) {
            System.out.println(maxTeamWeight(weight_list[i], max_weight[i]));
        }
    }

    private static int maxTeamWeight(int[] weight, int limit) {
        Arrays.sort(weight);
        reverseArr(weight);

        for (int i = 0; i < weight.length; i++) {
            for (int j = i + 1; j < weight.length; j++) {
                for (int k = j + 1; k < weight.length; k++) {
                    int curr_weight = weight[i] + weight[j] + weight[k];
                    if (curr_weight <= limit) {
                        return curr_weight;
                    }
                }
            }
        }

        return 0;
    }

    private static void reverseArr(int[] array)
    {
        int n = array.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = array[i];
            array[i] = array[n - i - 1];
            array[n - i - 1] = temp;
        }
    }
}