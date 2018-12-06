import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

/***
 * <p>
 * Randomized queue. A randomized queue is similar to a stack or queue, except
 * that the item removed is chosen uniformly at random from items in the data
 * structure. Create a generic data type RandomizedQueue that implements the
 * following API:
 * 
 * <pre>
 * {@code
    public class RandomizedQueue<Item> implements Iterable<Item> {
       public RandomizedQueue()               // construct an empty randomized queue
       public boolean isEmpty()               // is the randomized queue empty?
       public int size()                      // return the number of items on the randomized queue
       public void enqueue(Item item)         // add the item
       public Item dequeue()                  // remove and return a random item
       public Item sample()                   // return a random item (but do not remove it)
       public Iterator<Item> iterator() // return an iterator over items in random order
       public static void main(String[] args) // unit testing (optional)
    }    
 * }
 * </pre>
 * </p>
 * <p>
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
 * </p>
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
  private Item[] items;
  private int n;

  // construct an empty randomized queue
  public RandomizedQueue() {
    items = (Item[]) new Object[1];
    n = 0;
  }

  // is the randomized queue empty?
  public boolean isEmpty() {
    return n == 0;
  }

  // return the number of items on the randomized queue
  public int size() {
    return n;
  }

  /**
   * add the item to end of queue.
   * 
   * @param item the item to be added to queue.
   */
  public void enqueue(Item item) {
    if (item == null) {
      throw new IllegalArgumentException("Item cannot be null");
    }
    if (n == items.length) {
      resize();
    }
    items[n++] = item;
  }

  private void resize() {
    final Item[] copy = (Item[]) new Object[items.length * 2];
    for (int i = 0; i < items.length; i++) {
      copy[i] = items[i];
    }
    items = copy;
  }

  /**
   * remove and return a random item .
   * 
   * @return random item
   */
  public Item dequeue() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    final int random = getRandom(n);
    final Item item = items[random];
    // move item at tail of queue to random index.
    items[random] = items[n - 1];
    n--;
    return item;
  }

  private int getRandom(int n) {
    return StdRandom.uniform(n);
  }

  /**
   * return a random item (but do not remove it).
   * 
   * @return random item
   */
  public Item sample() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    return items[getRandom(n)];
  }

  // return an independent iterator over items in random order
  public Iterator<Item> iterator() {
    return new RandomIterator();
  }

  private class RandomIterator implements Iterator<Item> {
    private int current = n;
    private Item[] itrItems;

    public RandomIterator() {
      itrItems = (Item[]) new Object[n];
      for (int i = 0; i < n; i++) {
        itrItems[i] = items[i];
      }
    }

    @Override
    public boolean hasNext() {
      return current > 0;
    }

    @Override
    public Item next() {
      if (current == 0) {
        throw new NoSuchElementException();
      }
      final int random = getRandom(current);
      final Item item = itrItems[random];
      // move item at tail of queue to random index.
      itrItems[random] = itrItems[current - 1];
      current--;
      return item;
    }
  }

  /**
   * unit testing (optional).
   * 
   * @param args empty args.
   */
  public static void main(String[] args) {
    final RandomizedQueue<Integer> queue = new RandomizedQueue<>();
    for (int i = 1; i < 10; i++) {
      queue.enqueue(i);
    }
    System.out.println("Dequeue: " + queue.dequeue());
    for (Integer i : queue) {
      System.out.println(i);
    }
  }
}
