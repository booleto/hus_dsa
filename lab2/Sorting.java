import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Random;


/**
 * BubbleSort
 */
public class Sorting {
    static long quickSort_comparisons;
    static long quickSort_swaps;

    static class FasterReader {
        BufferedReader br;
        StringTokenizer st;

        public FasterReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    static int[] generateTest(int test_count, Random rd) {
        int[] test = new int[test_count];

        for (int i = 0; i < test.length; i++) {
            test[i] = rd.nextInt(test_count);
        }

        return test;
    }

    public static void main(String[] args) {
        Random rd = new Random();
        int[] initial_test = generateTest(20, rd);

        // int[] initial_test = {7, 3, 5, 2, 4, 1, 6, 0, 8, 9};
        int[] test = initial_test.clone();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            bw.write("Initial array: ");
            printArr(test, bw);
        } catch (Exception e) {
            e.printStackTrace();
        }
            
        try {
            bw.write("Bubble sort: ");
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        bubbleSort(test, bw);
        test = initial_test.clone();

        try {
            bw.write("Selection sort: ");
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        selectionSort(test, bw);
        test = initial_test.clone();

        try {
            bw.write("Quicksort: ");
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        quickSort(test, 0, test.length - 1, bw);
        printReport(bw, quickSort_comparisons, quickSort_swaps);    
    }

    static void bubbleSort(int[] arr, BufferedWriter bw) {
        boolean sorted = true;
        long comparisons = 0;
        long swaps = 0;
        int temp = 0;
        
        for (int i = 0; i < arr.length; i++) {
            sorted = true;
            for (int j = 0; j < arr.length - i - 1; j++) {
                comparisons++;
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swaps++;
                    sorted = false;
                    //printArr(arr, bw);
                }
            }
            if (sorted) {
                printReport(bw, comparisons, swaps);
                break;
            }
        }
    }

    static void selectionSort(int[] arr, BufferedWriter bw) {
        int curr_max = 0;
        long comparisons = 0;
        long swaps = 0;
        int temp = 0;

        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j <= i; j++) {
                comparisons++;
                if (arr[j] > arr[curr_max]) {
                    curr_max = j;
                }
            }

            comparisons++;
            if (curr_max != i) {
                temp = arr[i];
                arr[i] = arr[curr_max];
                arr[curr_max] = temp;
                swaps++;
                //printArr(arr, bw);
            }
            curr_max = 0;
        }

        printReport(bw, comparisons, swaps);
    }

    static void quickSort(int[] arr, int left, int right, BufferedWriter bw) {
        int pivot_idx;

        if (left < right) {
            pivot_idx = partition(arr, left, right, bw);

            quickSort(arr, left, pivot_idx - 1, bw);
            quickSort(arr, pivot_idx + 1, right, bw);
        }
    }

    static int partition(int[] arr, int left, int right, BufferedWriter bw) {
        int pivot_val = arr[left];
        int pivot_idx = left;
        int temp = 0;

        for (int i = left + 1; i <= right; i++) {
            quickSort_comparisons++;
            if (arr[i] < pivot_val) {
                pivot_idx++;
                temp = arr[i];
                arr[i] = arr[pivot_idx];
                arr[pivot_idx] = temp;
                quickSort_swaps++;
                //printArr(arr, bw);
            }
        }

        temp = arr[left];
        arr[left] = arr[pivot_idx];
        arr[pivot_idx] = temp;
        quickSort_swaps++;
        //printArr(arr, bw);
        return pivot_idx;
    }

    static void printArr(int[] arr, BufferedWriter bw) {
        try {
            for (int i = 0; i < arr.length; i++) {
                bw.write(arr[i] + " ");
            }
            bw.newLine();
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void printReport(BufferedWriter bw, long comparisons, long swaps) {
        try {
            bw.write("- Comparisons: " + comparisons);
            bw.newLine();
            bw.write("- Swaps: " + swaps);
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}