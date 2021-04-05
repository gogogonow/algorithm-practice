package week1;

/**
 * @author 61404
 */
class MyCircularDeque {

    int[] elements;
    int index = 0;
    int size = 0;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        elements = new int[k];
        size = k;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (index >= size) {
            return false;
        }
        if (index > 0) {
            int[] newElements = new int[size];
            System.arraycopy(elements, 0, newElements, 1, index);
            elements = newElements;
        }
        elements[0] = value;
        index++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (index >= size) {
            return false;
        }
        elements[index++] = value;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (index <= 0) {
            return false;
        }
        int[] newElements = new int[size];
        System.arraycopy(elements, 1, newElements, 0, index - 1);
        elements = newElements;
        index--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (index <= 0) {
            return false;
        }
        index--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (index <= 0) {
            return -1;
        }
        return elements[0];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (index <= 0) {
            return -1;
        }
        return elements[index-1];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        if (index <= 0) {
            return true;
        }
        return false;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        if (index == size) {
            return true;
        }
        return false;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
