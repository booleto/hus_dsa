import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
/**
 * ONP
 */
public class Main {
    static class FastReader {
        static StringTokenizer st;
        static BufferedReader br;

        public FastReader() {
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

    static class Expression {
        static char operator;
        static Expression operand1;
        static Expression operand2;
        static String expression;

        public Expression(String str) {
            char[] temp = new char[400];
            int temp_idx = 0;
            int in_exp = 0;

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c == '(') {
                    in_exp++;
                } else if (c == ')') {
                    in_exp--;
                    if (in_exp == 0) {
                        operand2 = new Expression(String.valueOf(temp));
                    }
                } else if (i > 0) {
                    if (in_exp == 1 && (c >= '*' && c <= '^')) {
                        operator = c;
                        operand1 = new Expression(String.valueOf(temp));
                        temp_idx = 0;
                        temp = new char[400];
                    } else {
                        temp[temp_idx] = c;
                        temp_idx++;
                    }
                } 
            }
        }
    

        public Expression(char a) {
            expression = String.valueOf(a);
        }

        @Override
        public String toString() {
            if (expression == null) {
                return operand1.toString() + operand2.toString() + operator;
            }
            return expression;
        }
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int test_count = fr.nextInt();
        Expression exp;

        for (int i = 0; i < test_count; i++) {
            String test_case = fr.next();
            exp = new Expression(test_case);
            try {
                bw.write(exp.toString());
                bw.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

/*     static String toRPN(String str) {
        if (str.length() == 3) {
            
        }
        for (int i = 0; i < array.length; i++) {
            
        }
        return str;
    }

    static String[] strPart(String str) {
        String[] result = new String[3];

        for (int i = 0; i < str.length(); i++) {
            
        }
    } */

    /* private static String toRPN(String str) {
        int[][] priority = new int[str.length()][2];
        int str_length = str.length();
        int brackets = 0;

        for (int i = 0; i < str_length; i++) {
            if (str.charAt(i) == '(') {
                brackets++;
                priority[brackets][0] = i;
            }
            if (str.charAt(i) == ')') {
                brackets--;
                priority[brackets][1] = i;
            }
        }
        
        return str;
    }

    static String convert(String str) {
        
        return str;
    } */
}