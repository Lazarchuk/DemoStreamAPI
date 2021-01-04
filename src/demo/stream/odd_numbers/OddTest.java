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
        // Sum of all odd numbers
        Integer sumOddStream = Arrays.stream(numbers).filter(num -> num%2!=0).reduce((s1, s2) -> s1+s2).orElse(0);
        System.out.println(sumOddStream);

        // Sum of all numbers
        Integer sum = Arrays.stream(numbers).reduce((s1, s2) -> s1+s2).orElse(0);
        System.out.println(sum);

        // Sum of even numbers
        Integer sumEvenStream = Arrays.stream(numbers).filter(num -> num%2==0).reduce((n1, n2) -> n1+n2).orElse(0);
        System.out.println(sumEvenStream);

        // Print the reminder of the division by 2
        Arrays.stream(numbers).forEach(n -> System.out.print(n%2));
    }

}
