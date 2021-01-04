package demo.stream.odd_numbers;

import java.util.Arrays;

public class OddTest {
    public static void main(String[] args) {
        Integer[] numbers = new Integer[]{1, 2, 4, 5, 3, 7, 1, 3};
        Integer sumOdd = 0;
        for(Integer num: numbers){
            if (num%2 != 0){
                sumOdd+=num;
            }
        }
        System.out.println(sumOdd);

        // Stream API
        Integer sumStream = Arrays.stream(numbers).filter(num -> num%2!=0).reduce((s1, s2) -> s1+s2).orElse(0);
        System.out.println(sumStream);

        Integer sum = Arrays.stream(numbers).reduce((s1, s2) -> s1+s2).orElse(0);
        System.out.println(sum);
    }

}
