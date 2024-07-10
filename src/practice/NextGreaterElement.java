package practice;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] arr = new int[]{73, 74, 75, 71, 69, 72, 76, 73};

        System.out.println(Arrays.stream(getNextGreatestElement(arr))
                .boxed()
                .collect(Collectors.toList()));

        System.out.println(Arrays.stream(getNextGreatestElementIndexes(arr))
                .boxed()
                .collect(Collectors.toList()));
    }


    public static int[] getNextGreatestElement(int[] arr) {
        int[] answers = new int[arr.length];
        Stack<Integer> helperStack = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            if (helperStack.isEmpty()) {
                answers[i] = -1;
                helperStack.push(arr[i]);
                continue;
            }

            if (helperStack.peek() > arr[i]) {
                answers[i] = helperStack.peek();
                helperStack.push(arr[i]);
                continue;
            }

            while (!helperStack.isEmpty() && helperStack.peek() <= arr[i]) {
                helperStack.pop();
            }

            if (helperStack.isEmpty()) {
                answers[i] = -1;
            } else {
                answers[i] = helperStack.peek();
            }
            helperStack.push(arr[i]);
        }
        return answers;
    }

    public static int[] getNextGreatestElementIndexes(int[] arr) {
        int[] answers = new int[arr.length];
        Stack<Integer> helperStack = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            if (helperStack.isEmpty()) {
                answers[i] = 0;
                helperStack.push(i);
                continue;
            }

            if (arr[helperStack.peek()] > arr[i]) {
                answers[i] = helperStack.peek() - i;
                helperStack.push(i);
                continue;
            }

            while (!helperStack.isEmpty() && arr[helperStack.peek()] <= arr[i]) {
                helperStack.pop();
            }

            if (helperStack.isEmpty()) {
                answers[i] = 0;
            } else {
                answers[i] = helperStack.peek() - i;
            }
            helperStack.push(i);
        }
        return answers;
    }
}

