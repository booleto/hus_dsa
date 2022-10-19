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
            catch(Exception e) { */ br = new BufferedReader(new InputStreamReader(System.in));//}
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
        int actions_count = reader.nextInt();
        int cmd;
        HashMap<String, Integer> stockList = new HashMap<String, Integer>();
        String stock_name;
        int stock_price;
        String min_stock;
        int min_price;

        for (int i = 1; i <= actions_count; i++) {
            cmd = reader.nextInt();
            if (cmd == 3) {
                min_price = -1;
                min_stock = "";
                for (String stock : stockList.keySet()) {
                    stock_price = stockList.get(stock).intValue();
                    if (stock_price < min_price || min_price == -1) {
                        min_price = stock_price;
                        min_stock = stock;
                    }
                }
                stockList.remove(min_stock);
                result.append(min_stock + " ");
                result.append(i + "\n");
                reader.next();
                continue;
            } 
            if (cmd == 1) {
                stock_name = reader.next();
                stock_price = reader.nextInt();
                stockList.put(stock_name, stock_price);
                continue;
            }
            if (cmd == 2) {
                stock_name = reader.next();
                stock_price = reader.nextInt();
                stockList.replace(stock_name, stock_price);
                continue;
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