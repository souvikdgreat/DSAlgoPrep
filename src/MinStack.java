import java.util.Comparator;
import java.util.Stack;
import java.util.TreeSet;

public class MinStack {
    private Stack<Integer> stack = new Stack<>();
    private TreeSet<Integer> minList = new TreeSet<>(Comparator.comparing(i -> i, Integer::compareTo));

    public void push(int x) {
        stack.push(x);
        minList.add(x);
    }

    public Integer pop() {
        Integer i = stack.pop();
        minList.remove(i);
        return i;
    }

    public Integer top(){
        return stack.peek();
    }

    public Integer getMin() {
        return minList.first();
    }

    public static void main(String[] args) {
        MinStack stack1 = new MinStack();
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top());    // return 0
        System.out.println(minStack.getMin()); // return -2

    }


}
