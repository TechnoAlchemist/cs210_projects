import java.io.*;
import java.util.*;

public abstract class Count implements Comparator<String> {

    public static void main(String[] args) throws IOException {
  if (args.length != 1) {
      System.err.println("Usage: java Count text-file");
      System.exit(-1);
  }

  HashMap<String, Integer> map = new HashMap<String, Integer>();

  String filename = args[0];
  BufferedReader input = new BufferedReader(new FileReader(filename));
  String line;
     
  
  while((line = input.readLine()) != null) {
      StringTokenizer st = new StringTokenizer(line, " XIV\\.\1234\'56789 \t\n\r\f,.:;?![]'&%@");

      while(st.hasMoreTokens()) {
	  String word = st.nextToken();
	  if (map.get(word) != null) {
	      int count = map.get(word);
	      count++;
	      map.put(word, count);
	  } else {
	      map.put(word, 1);
	  }
      }
  }

  ArrayList keys = new ArrayList(map.keySet());
  Collections.sort(keys);

  Comparator<String> comp = new Comparator<String>() {
    @Override
    public int compare(String a, String b) {
        if (map.get(a) > map.get(b)) {
	    return 1;
        }
        else {
	    return -1;
        }
    }
  };

  int min = Collections.min(map.values());
  int  max = Collections.max(map.values());
  System.out.println("Total unique words: " + keys.size());
  System.out.println("Most common word \"" + Collections.max(keys, comp) + "\" used " + max + " times");
  System.out.println("Least common word \""  + Collections.min(keys, comp) +  "\" used " + min + " time(s)");
  }


}
