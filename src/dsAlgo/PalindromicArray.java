package dsAlgo;

public class PalindromicArray {
    public static void main(String[] args) {
        String[] arr = new String[]{"aa", "bab", "cde", "aba", "ab"};
        int i = 0;
        int j = arr.length - 1;

        boolean isPalindromic = true;

        while (i < j) {
            String left = arr[i];
            String right = arr[j];
            String transformedLeftString =
                    arr[i + 1].length() > 2 ?
                            left + arr[i + 1].charAt(0) : left;

            String transformedRightString =
                    arr[j - 1].length() > 2 ?
                            arr[j - 1].charAt(arr[j - 1].length() - 1) + right : right;

            if (left.equals(right)) {
                i++;
                j--;
            } else if (transformedLeftString.equals(right)) {
                arr[i + 1] = arr[i + 1].substring(1);
                i++;
                j--;
            } else if (left.equals(transformedRightString)) {
                arr[j - 1] = arr[j - 1].substring(0, arr[j - 1].length() - 1);
                i++;
                j--;
            } else if (transformedLeftString.equals(transformedRightString)) {
                arr[i + 1] = arr[i + 1].substring(1);
                arr[j - 1] = arr[j - 1].substring(0, arr[j - 1].length() - 1);
                i++;
                j--;
            } else {
                isPalindromic = false;
                break;
            }
        }
        System.out.println(isPalindromic);


    }
}
