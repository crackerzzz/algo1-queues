/***
 * 
 * Client. Write a client program Permutation.java that takes an integer k as a
 * command-line argument; reads in a sequence of strings from standard input
 * using StdIn.readString(); and prints exactly k of them, uniformly at random.
 * Print each item from the sequence at most once.
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
 * Command-line input. You may assume that 0 ≤ k ≤ n, where n is the number of
 * string on standard input.
 * 
 * Performance requirements. The running time of Permutation must be linear in
 * the size of the input. You may use only a constant amount of memory plus
 * either one Deque or RandomizedQueue object of maximum size at most n. (For an
 * extra challenge, use only one Deque or RandomizedQueue object of maximum size
 * at most k.)
 * 
 * Deliverables. Submit the programs RandomizedQueue.java, Deque.java, and
 * Permutation.java. Your submission may not call library functions except those
 * in StdIn, StdOut, StdRandom, java.lang, java.util.Iterator, and
 * java.util.NoSuchElementException. In particular, do not use either
 * java.util.LinkedList or java.util.ArrayList.
 * 
 */
public class Permutation {

}
