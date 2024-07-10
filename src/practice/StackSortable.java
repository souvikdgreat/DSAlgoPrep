package practice;


import java.util.Stack;


public class StackSortable {
    public static boolean isStackSortable(int[] array) {
        Stack<Integer> stack = new Stack<>();
        for (int num : array) {
            if (stack.isEmpty()) {
                stack.push(num);
            } else {
                if (stack.peek() > num) {
                    stack.push(num);
                }
            }
            //  System.out.println(stack);
        }

        return stack.size() == array.length;
    }

    public static void main(String[] args) {
        int[] array1 = {2,3,1};
        int[] array2 = {4, 2, 1, 3};

        System.out.println("Array 1 is stack sortable: " + isStackSortable(array1));
        System.out.println("Array 2 is stack sortable: " + isStackSortable(array2));
    }
}
