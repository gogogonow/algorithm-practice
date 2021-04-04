package week1;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author 61404
 */
public class DequeDemo {
    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<String>();
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        deque.addLast("d");
        deque.addLast("e");
        deque.addLast("f");
        System.out.println(deque);
        String str = deque.peek();
        System.out.println(str);
        System.out.println(deque);
        while (deque.size() > 0) {
            System.out.println(deque.pop());
        }
        System.out.println(deque);
    }
}
