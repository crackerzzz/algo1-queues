import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

/***
 * <p>
 * Client. Write a client program Permutation.java that takes an integer k as a
 * command-line argument; reads in a sequence of strings from standard input
 * using StdIn.readString(); and prints exactly k of them, uniformly at random.
 * Print each item from the sequence at most once.
 * </p>
 * 
 * <pre>
% more distinct.txt                        % more duplicates.txt
A B C D E F G H I                          AA BB BB BB BB BB CC CC

% java-algs4 Permutation 3 < distinct.txt   % java-algs4 Permutation 8 < duplicates.txt
C                                               BB
G                                               AA
A                                               BB
                                                CC
% java-algs4 Permutation 3 < distinct.txt       BB
E                                               BB
F                                               CC
G                                               BB
Your program must implement the following API:

public class Permutation {
   public static void main(String[] args)
}
 * </pre>
 * 
 * <p>
 * Command-line input. You may assume that 0 ≤ k ≤ n, where n is the number of
 * string on standard input.
 * </p>
 * Performance requirements. The running time of Permutation must be linear in
 * the size of the input. You may use only a constant amount of memory plus
 * either one Deque or RandomizedQueue object of maximum size at most n. (For an
 * extra challenge, use only one Deque or RandomizedQueue object of maximum size
 * at most k.)
 * <p>
 * Deliverables. Submit the programs RandomizedQueue.java, Deque.java, and
 * Permutation.java. Your submission may not call library functions except those
 * in StdIn, StdOut, StdRandom, java.lang, java.util.Iterator, and
 * java.util.NoSuchElementException. In particular, do not use either
 * java.util.LinkedList or java.util.ArrayList.
 * </p>
 * 
 */
public class Permutation {

  /**
   * Main method which executes.
   * 
   * @param args number of elements to print
   */
  public static void main(String[] args) {
    if (args.length != 1) {
      throw new IllegalArgumentException("Number of expected parameters is 1.");
    }
    final int k = Integer.parseInt(args[0]);

    String[] strs = StdIn.readAllStrings();
    StdRandom.shuffle(strs);

    final RandomizedQueue<String> queue = new RandomizedQueue<>();
    for (int i = 0; i < k; i++) {
      queue.enqueue(strs[i]);
    }
    for (int i = 0; i < k; i++) {
      System.out.println(queue.dequeue());
    }
  }

}
