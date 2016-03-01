package finalproject.util;

import finalproject.collection.ListStack;
import finalproject.collection.Stack;

/**
 * Utility for Stacks. See {@link Stack} for more.
 *
 * @author Benjapol Worakan 5710546577
 * @version 16.3.2
 * @see Stack
 */
public class StackUtil {
    /**
     * Sort the given stack.
     *
     * @param s is the stack to be sorted
     */
    public static <E extends Comparable<E>> void sortStack(Stack<E> s) {
        Stack<E> t = new ListStack<>();
        while (!s.isEmpty()) {
            t.push(s.pop());
        }

//        System.out.println("INIT: " + s.toString() + " " + t.toString());
        while (!t.isEmpty()) {
            E e = t.pop();
            while (!s.isEmpty() && s.peek().compareTo(e) < 0) {
                t.push(s.pop());
//                System.out.println(e + ": TOS too low (" + t.peek() + "): " + s.toString() + " " + t.toString());
            }
            s.push(e);
//            System.out.println(e + ": PUSH: " + s.toString() + " " + t.toString());
        }
    }
}
