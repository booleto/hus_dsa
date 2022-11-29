import java.util.*;
import java.io.*;
public class Main {
    // For fast input output
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader() {
            try {br = new BufferedReader(
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
        HashMap<String, Long> friendList = new HashMap<String, Long>();
        int test_cases = reader.nextInt();
        int unfrien = reader.nextInt();
        String frienName;
        long result = 0;

        for (int i = 0; i < test_cases; i++) {
            frienName = reader.next();
            if (friendList.containsKey(frienName)) {
                friendList.replace(frienName, friendList.get(frienName).longValue() + reader.nextLong());
                continue;
            }
            friendList.put(frienName, reader.nextLong());
        }
        ArrayList<Long> cost_list = new ArrayList<>(friendList.values());
        int size = cost_list.size();
        if (unfrien >= size) {
            for (int i = 0; i < size; i++) {
                result += cost_list.get(i);
            }
        } else {
            Collections.sort(cost_list);
            for (int i = size - 1; i >= size - unfrien; --i) {
                result += cost_list.get(i);
            }
        }

        try {
            bw.write(Long.toString(result));
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}