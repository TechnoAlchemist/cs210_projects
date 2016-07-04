import edu.princeton.cs.algs4.StdOut ;
import java.util.Iterator;
import edu.princeton.cs.algs4.StdIn ;
import java.util.NoSuchElementException;

public class Bag<Item> implements Iterable<Item> {
    private Node first;    // beginning of bag
    private int N;         // number of elements in bag

    // helper linked list class
    private class Node {
        private Item item;
        private Node next;
    }

    /**
     * Initializes an empty bag.
     */
    public Bag() {
	first = null;
	N = 0;
    }

    /**
     * Is this bag empty?
     * @return true if this bag is empty; false otherwise
     */
    public boolean isEmpty() {
	return first == null;
    }

    /**
     * Returns the number of items in this bag.
     * @return the number of items in this bag
     */
    public int size() {
        return N;
    }

    /**
     * Adds the item to this bag.
     * @param item the item to add to this bag
     */
    public void add(Item item) {
	Node oldfirst = first;
	first = new Node();
	first.item = item;
	first.next = oldfirst;
	N++;
    }


    /**
     * Returns an iterator that iterates over the items in the bag.
     */
    public Iterator<Item> iterator()  {
	return new ListIterator();
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext()  { return current != null;  }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
	    if (!hasNext()) { throw new NoSuchElementException();}
	    Item item = current.item;
	    current = current.next;
	    return item;
        }
    }

    /**
     * Unit tests the <tt>LinkedBag</tt> data type.
     */
    public static void main(String[] args) {
        Bag<String> bag = new Bag<String>();
        while (!StdIn.isEmpty()) {
        	
            String item = StdIn.readString();
            if(item.equals("END")){
            	break;
            }
            bag.add(item);
        }

        StdOut.println("size of bag = " + bag.size());
        for (String s : bag) {
            StdOut.println(s);
        }
    }


}
