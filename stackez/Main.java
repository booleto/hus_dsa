import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.StringTokenizer;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
    // For fast input output
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {st = new StringTokenizer(br.readLine());}
                catch (IOException e) {
                    e.printStackTrace();}
            }
            return st.nextToken();
        }
        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() {return Double.parseDouble(next()); }
        String nextLine()
        {
            String str = "";
            try {
            str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    // end of fast i/o code
    public static void main(String[] args) {
        FastReader reader = new FastReader();
        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int test_count = reader.nextInt();
        String[] stack = new String[test_count];
        int size = 0;
        String cmd;

        // resolve cmd
		for (int i = 0; i < test_count; i++) {
			cmd = reader.next();

			switch (cmd) {
				case "1": //push
					stack[size++] = reader.next();
					break;

				case "2": //pop
					if (size == 0) break;
                    size--;
					break;

				default: //top
					if (size == 0) {
						sb.append("Empty!\n");
                        break;
					}
					sb.append((stack[size - 1] + "\n"));
					break;
			}
        }
        try {
            bw.append(sb);
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}