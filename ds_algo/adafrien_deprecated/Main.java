import java.util.*;
import java.io.*;
public class Main {
    // For fast input output
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader() {
            try {br = new BufferedReader(
                      new FileReader("input.txt")); }
            catch(Exception e) {
                br = new BufferedReader(new InputStreamReader(System.in));
            }
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
    static class Friend {
        String name;
        long cost;

        public Friend() {
            name = "";
            cost = 0;
        }

        public Friend(String name, long cost) {
            this.name = name;
            this.cost = cost;
        }
    }
    // end of fast i/o code
    public static void main(String[] args) {
        FastReader reader = new FastReader();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int test_cases = reader.nextInt();
        int unfrien = reader.nextInt();
        ArrayList<Friend> friendList = new ArrayList<Friend>();
        
        for (int i = 0; i < test_cases; i++) {
            addData(friendList, reader.next(), reader.nextLong());
        }

        unfrien = Math.min(unfrien, friendList.size());
        Friend[] unfriended = new Friend[unfrien];
        Friend mostCostly;
        for (int i = 0; i < unfrien; i++) {
            mostCostly = friendList.get(0);
            for (Friend friend : friendList) {
                if (friend.cost > mostCostly.cost) {
                    mostCostly = friend;
                }
            }
            unfriended[i] = mostCostly;
            friendList.remove(mostCostly);
        }

        long result = 0;
        for (int i = 0; i < unfrien; i++) {
            result += unfriended[i].cost;
        }

        try {
            bw.write(Long.toString(result));
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void addData(ArrayList<Friend> friendList, String friendName, long friendCost) {
        for (Friend friend : friendList) {
            if (friendName.equals(friend.name)) {
                friend.cost += friendCost;
                return;
            }
        }
        friendList.add(new Friend(friendName, friendCost));
    }
}