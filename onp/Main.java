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
    // end of fast i/o code
    public static void main(String[] args) {
        FastReader reader = new FastReader();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder ans = new StringBuilder();
        Stack<Character> stack = new Stack<Character>();
        int test_cases = reader.nextInt();
        String expression;
        
        for (int i = 0; i < test_cases; i++) {
            expression = reader.nextLine();
            for (char c : expression.toCharArray()) {
                switch (c) {
                    case '(':
                        break;

                    case '+':
                        stack.add(c);
                        break;

                    case '-':
                        stack.add(c);
                        break;

                    case '*':
                        stack.add(c);
                        break;

                    case '/':
                        stack.add(c);
                        break;

                    case '^':
                        stack.add(c);
                        break;

                    case ')':
                        ans.append(stack.pop());
                        break;

                    default:
                        ans.append(c);
                        break;
                }
            }
            ans.append('\n');
        }
        try {
            bw.write(ans.toString());
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}