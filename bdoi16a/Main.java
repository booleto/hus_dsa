import java.util.*;
import java.io.*;
public class Main {
    // For fast input output
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            /* try {br = new BufferedReader(
                       new FileReader("input.txt"));}
            catch(Exception e)  {  */br = new BufferedReader(new InputStreamReader(System.in));
            //}
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
        StringBuilder result = new StringBuilder();

        int test_cases = reader.nextInt();
        int case_count = reader.nextInt();
        ArrayDeque<String> queue = new ArrayDeque<String>(case_count);
        String cmd;

        for (int i = 0; i < test_cases; i++) {
            for (int k = 0; k < case_count; k++) {
                cmd = reader.next();
                switch (cmd) {
                    case "1":
                        cmd = reader.next();
                        if (cmd.equals("B")) {
                            queue.addLast(reader.next());
                        } else {
                            queue.addFirst(reader.next());
                        }
                        break;
                
                    case "2":
                        cmd = reader.next();
                        if (cmd.equals("B")) {
                            queue.removeLast();
                        } else {
                            queue.removeFirst();
                        }
                        break;
    
                    case "3":
                        cmd = reader.next();
                        Iterator<String> iter = queue.iterator();
                        if (cmd.equals("D")) {
                            int idx = reader.nextInt();
                            for (int j = 1; j < idx; j++) {
                                iter.next();
                            }
                            result.append(iter.next() + "\n");
                        } else {
                            String id = reader.next();
                            int idx = 1;
                            while (iter.hasNext() && !iter.next().equals(id)) {
                                idx++;
                            }
                            result.append(idx + "\n");
                        }
                        break;
                }
            }
        }
        
        try {
            bw.write(result.toString());
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
