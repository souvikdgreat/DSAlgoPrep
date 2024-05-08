package gsPractice;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1,2,3,4);
        Collection<Integer> anotherIntegers = Arrays.asList(1,2,3,4);

        integers.remove(2); //{1,2,4}
        anotherIntegers.remove(2); //{1,2,4}



        System.out.println(integers);
        System.out.println(anotherIntegers);

    }

}