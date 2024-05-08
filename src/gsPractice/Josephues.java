package gsPractice;

import java.util.ArrayList;
import java.util.List;

public class Josephues {
    static void Josh(List<Integer> person, int k, int index) {
        if (person.size() == 1) {
            System.out.println(person.get(0));
            return;
        }

        index = ((index + k) % person.size());
        person.remove(index);
        System.out.println(person);
        Josh(person, k, index);
    }

    public static void main(String[] args) {
        int n = 14;

        int k = 2;
        k--;
        int index = 0;

        List<Integer> person = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            person.add(i);
        }
        System.out.println(person);
        Josh(person, k, index);
    }
}

