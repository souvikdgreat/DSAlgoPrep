package gsPractice;

public class LengthOfCycleInArray {
    public static void main(String[] args) {
        System.out.println(lengthOfCycle(new int[]{1, 0}, 0));
        System.out.println(lengthOfCycle(new int[]{1, 2, 0}, 0));
    }

    public static int lengthOfCycle(int[] arr, int startIndex) {
        boolean[] visited = new boolean[arr.length];
        int visitNow = startIndex;
        int count = 0;

        while (true) {
            if (visited[visitNow]) return count;
            count++;
            visited[visitNow] = true;
            visitNow = arr[visitNow];
        }
    }
}
