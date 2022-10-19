import java.util.ArrayDeque;
import java.util.*;
import java.io.*;
public class Main {
    // For fast input output
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader()
            {try {br = new BufferedReader(
                       new FileReader("input.txt"));}
            catch(Exception e) { br = new BufferedReader(new InputStreamReader(System.in));}
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
        ArrayDeque<Integer> queue = new ArrayDeque<Integer>(1000000);
        int cmd;

        for (int i = 0; i < test_count; i++) {
			cmd = reader.nextInt();

			switch (cmd) {
				case 1: //enqueue
					queue.addLast(reader.nextInt());
					break;

				case 2: //dequeue
                    if (queue.isEmpty()) break;
					queue.removeFirst();
					break;

				default: //top
					try {
						if (queue.isEmpty()) {
							bw.write("Empty!"); bw.newLine();
						} else {
							bw.write(Integer.toString(queue.getFirst())); bw.newLine();
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					break;
			}
        }
        try {
            bw.flush();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}