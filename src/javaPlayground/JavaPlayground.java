package javaPlayground;

import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class JavaPlayground {
    public static void main(String[] args) {
        ArrayList<String> values = new ArrayList<String>() {{
            add("Adghj");
            add("Basdsdas");
            add("Basdsdas");
        }};

        List<String> strings = Collections.synchronizedList(values);

        for (String value : strings) {
            if (value.length() > 5) {
                strings.remove(0);
            }
        }

        System.out.println(strings);
    }
}
