import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.io.*;
public class Main {
    // For fast input output
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader()
            {br = new BufferedReader(new InputStreamReader(System.in));
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
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int test_count = reader.nextInt();
        ArrayDeque<String> stack = new ArrayDeque<String>();
        int cmd;
        
        for (int i = 0; i < test_count; i++) {
			cmd = reader.nextInt();

			switch (cmd) {
				case 1: //push
                    stack.push(reader.next());
					break;

				case 2: //pop
					if (stack.size() == 0) break;
                    stack.pop();
					break;

				default: //top
					try {
						if (stack.size() == 0) {
							bw.write("Empty!"); bw.newLine();
						} else {
							bw.write(stack.peek()); bw.newLine();
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
			}

            try {
                bw.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}