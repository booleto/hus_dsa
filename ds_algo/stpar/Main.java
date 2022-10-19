import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Stack;

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
        int next_par = fr.nextInt();
        int[] par;
        String result;

        while (next_par != 0) {
            par = new int[next_par];

            for (int i = 0; i < par.length; i++) {
                par[i] = fr.nextInt();
            }

            if (checkParade(par)) {
                result = "yes";
            } else {
                result = "no";
            }

            try {
                bw.write(result);
                bw.newLine();
                bw.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

            next_par = fr.nextInt();
        }
    }

    static boolean checkParade(int[] par) {
        Stack<Integer> sideroad = new Stack<Integer>();
        int correct_mobile = 1;
        int last_pop;

        for (int i : par) {
            if (i == correct_mobile) {
                correct_mobile++;
            } else if (!sideroad.empty() && i > sideroad.peek().intValue()) {
                return false;
            } else {
                sideroad.add(i);
                continue;
            }
            if (!sideroad.empty() && i == sideroad.peek().intValue() - 1) {                
                last_pop = sideroad.pop();
                correct_mobile++;

                while (!sideroad.empty() && last_pop == sideroad.peek().intValue() - 1) {
                    last_pop = sideroad.pop();
                    correct_mobile++;
                }
                continue;
            }
        }
        return true;
    }
}