import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.SeparateChainingHashST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Spell {
    public static void main(String[] args) {
        In in = new In(args[0]);
        String[] lines = in.readAllLines();
        in.close();
        SeparateChainingHashST<String, String> st =
            new SeparateChainingHashST<String, String>();
        for (String line : lines) {
            String[] tokens = line.trim().split(",");
            st.put(tokens[0], tokens[1]);
        }
        int i = 0;
        while (!StdIn.isEmpty()) {
            String line = StdIn.readLine();
            i++;
            String[] words = line.trim().split("\\b");
            for (String word : words) {
                if (st.contains(word)) {
                    StdOut.printf("%s:%d -> %s\n", word, i, st.get(word));
                    
                }
            }
        }
    }
}
