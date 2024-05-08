package gsPractice;


/*
 *  poll
 *  peek
 *  front
 *  rear
 * */

import java.util.Stack;

/**
 * ---------------
 * <p>
 * ==============
 * <p>
 * ---------------
 * 1
 * 2
 * 3
 * ---------------
 * <p>
 * CustomQueue.add(1);
 * CustomQueue.add(2);
 * CustomQueue.add(3);
 * CustomQueue.poll() 1 {2,3}
 */

public class QueueUsingStack {
    public static void main(String[] args) {
        CustomQueue customQueue = new CustomQueue();
        customQueue.add(1);
        customQueue.add(2);
        customQueue.add(3);
        customQueue.add(4);

        System.out.println(customQueue.peek());
        System.out.println(customQueue.size());
        System.out.println(customQueue.poll());
        System.out.println(customQueue.poll());
        System.out.println(customQueue.size());


    }
}

class CustomQueue {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void add(int num) {
        stack1.push(num);
    }

    public int poll() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    public int size() {
        return stack1.size() + stack2.size();
    }
}


