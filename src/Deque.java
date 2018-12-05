import java.util.Iterator;

/***
 * 
 * Dequeue. A double-ended queue or deque (pronounced “deck”) is a
 * generalization of a stack and a queue that supports adding and removing items
 * from either the front or the back of the data structure. Create a generic
 * data type Deque that implements the following API:
 * 
 * <pre>
public class Deque<Item> implements Iterable<Item> {
   public Deque()                           // construct an empty deque
   public boolean isEmpty()                 // is the deque empty?
   public int size()                        // return the number of items on the deque
   public void addFirst(Item item)          // add the item to the front
   public void addLast(Item item)           // add the item to the end
   public Item removeFirst()                // remove and return the item from the front
   public Item removeLast()                 // remove and return the item from the end
   public Iterator<Item> iterator()         // return an iterator over items in order from front to end
   public static void main(String[] args)   // unit testing (optional)
}
 * </pre>
 * 
 * Corner cases. Throw the specified exception for the following corner cases:
 * 
 * <ul>
 * <li>Throw a java.lang.IllegalArgumentException if the client calls either
 * addFirst() or addLast() with a null argument.</li>
 * <li>Throw a java.util.NoSuchElementException if the client calls either
 * removeFirst() or removeLast when the deque is empty.</li>
 * <li>Throw a java.util.NoSuchElementException if the client calls the next()
 * method in the iterator when there are no more items to return.</li>
 * <li>Throw a java.lang.UnsupportedOperationException if the client calls the
 * remove() method in the iterator.</li>
 * </ul>
 * 
 * <p>
 * Performance requirements. Your deque implementation must support each deque
 * operation (including construction) in constant worst-case time. A deque
 * containing n items must use at most 48n + 192 bytes of memory and use space
 * proportional to the number of items currently in the deque. Additionally,
 * your iterator implementation must support each operation (including
 * construction) in constant worst-case time.
 * </p>
 * 
 * @author shreejwal.shrestha
 *
 */
public class Deque<Item> implements Iterable<Item> {
    // construct an empty deque
    public Deque() {
    }

    // is the deque empty?
    public boolean isEmpty() {
        return false;
    }

    // return the number of items on the deque
    public int size() {
        return -1;
    }

    // add the item to the front
    public void addFirst(Item item) {
    }

    // add the item to the end
    public void addLast(Item item) {
    }

    // remove and return the item from the front
    public Item removeFirst() {
        return null;
    }

    // remove and return the item from the end
    public Item removeLast() {
        return null;
    }

    // return an iterator over items in order from front to end
    public Iterator<Item> iterator() {
        return null;
    }

    // unit testing (optional)
    public static void main(String[] args) {
    }
}
