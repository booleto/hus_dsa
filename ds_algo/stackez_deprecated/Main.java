import java.util.*;
import java.io.*;
public class Main {
    // For fast input output
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader() {
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
    static class Node {
        Node next;
        int val;
    }
    // end of fast i/o code
    public static void main(String[] args) {
        FastReader reader = new FastReader();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int test_count = reader.nextInt();
        Node top = null;
        int cmd;
        Node temp;
        
        for (int i = 0; i < test_count; i++) {
			cmd = reader.nextInt();

			switch (cmd) {
				case 1: //push
                    temp = top;
                    top = new Node();
                    top.val = reader.nextInt();
                    top.next = temp;
					break;

				case 2: //pop
					if (top == null) break;
                    top = top.next;
					break;

				default: //top
					try {
						if (top == null) {
							bw.write("Empty!"); bw.newLine();
						} else {
							bw.write(Integer.toString(top.val)); bw.newLine();
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