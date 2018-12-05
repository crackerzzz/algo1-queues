import java.util.Iterator;

/***
 * Randomized queue. A randomized queue is similar to a stack or queue, except
 * that the item removed is chosen uniformly at random from items in the data
 * structure. Create a generic data type RandomizedQueue that implements the
 * following API:
 * 
 * <pre>
    public class RandomizedQueue<Item> implements Iterable<Item> {
       public RandomizedQueue()                 // construct an empty randomized queue
       public boolean isEmpty()                 // is the randomized queue empty?
       public int size()                        // return the number of items on the randomized queue
       public void enqueue(Item item)           // add the item
       public Item dequeue()                    // remove and return a random item
       public Item sample()                     // return a random item (but do not remove it)
       public Iterator<Item> iterator()         // return an independent iterator over items in random order
       public static void main(String[] args)   // unit testing (optional)
    }
 * 
 * </pre>
 * 
 * Corner cases. Throw the specified exception for the following corner cases:
 * <ul>
 * <li>Throw a java.lang.IllegalArgumentException if the client calls enqueue()
 * with a null argument.</li>
 * <li>Throw a java.util.NoSuchElementException if the client calls either
 * sample() or dequeue() when the randomized queue is empty.</li>
 * <li>Throw a java.util.NoSuchElementException if the client calls the next()
 * method in the iterator when there are no more items to return.</li>
 * <li>Throw a java.lang.UnsupportedOperationException if the client calls the
 * remove() method in the iterator.</li>
 * </ul>
 * 
 * <p>
 * Performance requirements. Your randomized queue implementation must support
 * each randomized queue operation (besides creating an iterator) in constant
 * amortized time. That is, any sequence of m randomized queue operations
 * (starting from an empty queue) must take at most cm steps in the worst case,
 * for some constant c. A randomized queue containing n items must use at most
 * 48n + 192 bytes of memory. Additionally, your iterator implementation must
 * support operations next() and hasNext() in constant worst-case time; and
 * construction in linear time; you may (and will need to) use a linear amount
 * of extra memory per iterator.
 * </p>
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
    // construct an empty randomized queue
    public RandomizedQueue() {
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return false;
    }

    // return the number of items on the randomized queue
    public int size() {
        return -1;
    }

    // add the item
    public void enqueue(Item item) {
    }

    // remove and return a random item
    public Item dequeue() {
        return null;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        return null;
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return null;
    }

    // unit testing (optional)
    public static void main(String[] args) {
    }
}
