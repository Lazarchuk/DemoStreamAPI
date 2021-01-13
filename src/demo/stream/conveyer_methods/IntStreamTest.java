package demo.stream.conveyer_methods;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.IntStream;

public class IntStreamTest {
    public static void main(String[] args) {
        String[] stringNumbers = {"4", "5", "57"};
        Collection<String> col = Arrays.asList(stringNumbers);

        IntStream intStream = col.stream().mapToInt(s -> Integer.parseInt(s));
        System.out.println(Arrays.toString(intStream.toArray()));
    }
}
