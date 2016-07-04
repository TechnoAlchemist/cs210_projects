import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;
import java.util.NoSuchElementException;

// Deque implementation using a linked list.
public class Deque<Item> implements Iterable<Item> {
    private int N;
    private Node first;
    private Node last;

    // Helper doubly-linked list class.
    private class Node {
        private Item item;
        private Node next;
        private Node prev;
    }

    // Constructs an empty deque.
    public Deque() {
        N = 0;
	first = null;
	last = null;
    }

    // Is the dequeue empty?
    public boolean isEmpty() {
	return N == 0;
    }

    // Returns the number of items on the deque.
    public int size() {
        return N;
    }

    // Adds item to the front of the deque.
    public void addFirst(Item item) {
	Node newfirst = new Node();
	if (first == null) {
	    newfirst.next = null;
	}
	else {
	    newfirst.next = first;
	    first.prev = newfirst;
	}
	newfirst.prev = null;
	first = newfirst;
	first.item = item;
	N++;
	if (last == null){
	    last = first;
	}
    }

    // Adds item to the end of the deque.
    public void addLast(Item item) {
        Node newlast = new Node();
	if (last == null) {
	    newlast.prev = null;
	}
	else
	{
	    newlast.prev = last;
	    last.next = newlast;
	} 
	newlast.next = null;
	last = newlast;
	last.item = item;
	N++;
	if (first == null) {
	    first = last;
	}
    }

    // Removes and returns item from the front of the deque.
    public Item removeFirst() {
	if (isEmpty()) { throw new NoSuchElementException("..."); }
	Item removeditem = first.item;
	if (N == 1)
	{
	    first = null;
	    last = null;
	}
	else
	{
	    first = first.next;
	    first.prev = null;
	}
	N--;
	return removeditem;
    }

    // Removes and returns item from the end of the deque.
    public Item removeLast() {
	if (isEmpty()) { throw new NoSuchElementException("..."); }
	Item removeditem = last.item;
        if (N == 1)
	{
	    first = null;
	    last = null;
	}
	else
	{
	    last = last.prev;
	    last.next = null;
	}
	N--;
	return removeditem;
    }

    // Returns an iterator over items in the queue in order from front to end.
    public Iterator<Item> iterator() {
	return new DequeIterator(first);
    }
    
    // An iterator, doesn't implement remove() since it's optional.
    private class DequeIterator implements Iterator<Item> {
        private Node current;
        
        public DequeIterator(Node first) {
	    current = first;
        }

        public boolean hasNext()  { return current != null;  }

        public void remove() { throw new UnsupportedOperationException(); }

        public Item next() {
	    if(!hasNext()) throw new NoSuchElementException();
	    Item item = current.item;
	    current = current.next;
	    return item;
        }
    }

    // Returns a string representation of this deque.
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item + " ");
        }
        return s.toString().substring(0, s.length() - 1);
    }
    
    // Test client. [DO NOT EDIT]
    public static void main(String[] args) {
        Deque<Character> deque = new Deque<Character>();
        String quote = "There is grandeur in this view of life, with its " 
            + "several powers, having been originally breathed into a few " 
            + "forms or into one; and that, whilst this planet has gone " 
            + "cycling on according to the fixed law of gravity, from so " 
            + "simple a beginning endless forms most beautiful and most " 
            + "wonderful have been, and are being, evolved. ~ " 
            + "Charles Darwin, The Origin of Species";
        int r = StdRandom.uniform(0, quote.length());
        for (int i = quote.substring(0, r).length() - 1; i >= 0; i--) {
            deque.addFirst(quote.charAt(i));
        }
        for (int i = 0; i < quote.substring(r).length(); i++) {
            deque.addLast(quote.charAt(r + i));
        }
        StdOut.println(deque.isEmpty());
        StdOut.printf("(%d characters) ", deque.size());
        for (char c : deque) {
            StdOut.print(c);
        }
        StdOut.println();
        double s = StdRandom.uniform();
        for (int i = 0; i < quote.length(); i++) {
            if (StdRandom.bernoulli(s)) {
                deque.removeFirst();
            }
            else {
                deque.removeLast();
            }
        }
        StdOut.println(deque.isEmpty());
    }
}
