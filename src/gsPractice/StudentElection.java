package gsPractice;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StudentElection {
    public static void main(String[] args) {
        List<Integer> arr = IntStream.rangeClosed(1, 4)
                .mapToObj(it -> (int) it)
                .collect(Collectors.toList());

        int index = 0;
        int k = 2;
        k--;

        //System.out.println(arr);
        whoIsElected(k, 0, arr);

        System.out.println(whoIsElected(4,2)+1);
    }

    public static int whoIsElected(int k, int index, List<Integer> arr) {
        int res = -1;
        if (arr.size() == 1) {
           // System.out.println(arr.get(0));
            return arr.get(0);
        }
        index = (index + k) % arr.size();
        arr.remove(index);
        res = whoIsElected(k, index, arr);
       // System.out.println(res);
        return res;
    }


    public static int whoIsElected(int num, int k) {
        if(num == 1){
            return 0;
        }

        return (whoIsElected(num-1,k) + k) % num;

    }
}
