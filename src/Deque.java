import java.util.Iterator;
import java.util.NoSuchElementException;

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
    private Node head;
    private Node tail;
    private int n = 0;

    // construct an empty deque
    public Deque() {
    }

    // is the deque empty?
    public boolean isEmpty() {
        return n == 0;
    }

    // return the number of items on the deque
    public int size() {
        return n;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        if (head == null) {
            head = new Node(item);
            tail = head;
        } else {
            final Node oldHead = head;
            head = new Node(item);
            head.next = oldHead;
            oldHead.previous = head;
        }
        n++;
    }

    // add the item to the end
    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        if (tail == null) {
            tail = new Node(item);
            head = tail;
        } else {
            final Node oldTail = tail;
            tail = new Node(item);
            oldTail.next = tail;
            tail.previous = oldTail;
        }
        n++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        final Node removed = head;
        final Item item = removed.item;

        head = head.next;
        // when only single item is there.
        if (head != null) {
            head.previous = null;
        }

        removed.item = null;
        removed.next = null;

        // handle special condition
        if (head == null) {
            tail = null;
        }
        n--;
        return item;
    }

    // remove and return the item from the end
    public Item removeLast() {
        if (tail == null) {
            throw new NoSuchElementException();
        }
        final Node removed = tail;
        final Item item = removed.item;

        tail = tail.previous;
        tail.next = null;

        removed.previous = null;
        removed.item = null;

        // handle special condition
        if (tail == null) {
            head = null;
        }

        n--;
        return item;
    }

    // return an iterator over items in order from front to end
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {
        private Node current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (current == null) {
                throw new NoSuchElementException();
            }
            final Item item = current.item;
            current = current.next;
            return item;
        }

    }

    private class Node {
        Item item;
        Node previous;
        Node next;

        public Node(Item item) {
            this.item = item;
        }
    }

    // unit testing (optional)
    public static void main(String[] args) {
        final Deque<Integer> deck = new Deque<>();
//        deck.addFirst(3);
        deck.addLast(1);
        deck.addLast(2);
        System.out.println(deck.removeFirst());
        for (Integer i : deck) {
            System.out.println(i);
        }
    }
}
