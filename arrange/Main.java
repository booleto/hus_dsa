import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * Main
 */
public class Main {
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

    public static void main(String[] args) {
        FasterReader fr = new FasterReader();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int test_cases = fr.nextInt();
        int amp_count;
        int[] test;

        for (int i = 0; i < test_cases; i++) {
            amp_count = fr.nextInt();
            test = new int[amp_count];

            for (int j = 0; j < test.length; j++) {
                test[j] = fr.nextInt();
            }
            arrangeAmps(test, bw);
        }
    }

    static void arrangeAmps(int[] amps, BufferedWriter bw) {
        int[] sig_amps = getSignificantAmps(amps);
        int ones = amps.length - sig_amps.length;

        if (sig_amps.length == 2 && (sig_amps[0] + sig_amps[1] == 5)) {
            sig_amps[0] = 2;
            sig_amps[1] = 3;
        } else {
            sorting(sig_amps, 0, sig_amps.length - 1);
        }
        
        for (int i = 0; i < ones; i++) {
            try {
                bw.write("1 ");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        printArr(sig_amps, bw);
    }

    static int[] getSignificantAmps(int[] amps) {
        int[] result = new int[amps.length];
        int result_idx = 0;
        for (int i = 0; i < amps.length; i++) {
            if (amps[i] != 1) {
                result[result_idx] = amps[i];
                result_idx++;
            }
        }
        return Arrays.copyOfRange(result, 0, result_idx);
    }

    static void printArr(int[] arr, BufferedWriter bw) {
        try {
            for (int i = 0; i < arr.length; i++) {
                bw.write(arr[i] + " ");
            }
            bw.flush();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    static int partition(int arr[], int left, int right) {
        int pivot = arr[left];
        int i = left;
        for(int j = left + 1; j <= right; j++){
            if (arr[j] > pivot){
                i = i + 1;
                int temp = arr[i];
                arr[i]= arr[j];
                arr[j]= temp;
            }
        }
    
        int temp = arr[i];
        arr[i] = arr[left];
        arr[left] = temp;
    
        return i;
    
    }
    
    static void sorting(int arr[], int left, int right) {
        if(left < right)
        {
            int q = partition(arr, left, right);
            sorting(arr, left, q);
            sorting(arr, q + 1, right);
        }
    }
}