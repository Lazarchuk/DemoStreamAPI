package demo.stream.conveyer_methods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Методы стримов: конвеерные, терминальные
public class ConveyerTest {
    private static Integer[] numbers = {3, 5, 2, 6, 2, 8, 0, 10, 67, 5, 23, 7658, 236, 10};
    private static String[] names = {"Dan","Daniel", "Mark", "Ali"};
    private static String[] strNumbers = {"2","3", "7", "5"};
    private static User[] users = {new User("Dan"), new User("Mark"), new User("Daniel"), new User("Ali")};
    public static void main(String[] args) {

        // filter() - возвращает только записи, соответствующие условию
        System.out.println("Get elements with two digits. " +Arrays.stream(numbers).filter(num -> num.toString().matches("\\d{2}")).collect(Collectors.toList()));

        // skip()- позволяет пропустить N первых элементов
        System.out.println("Skip the first 3 elements. " +Arrays.stream(numbers).skip(3).collect(Collectors.toList()));

        // distinct() - возвращает стрим без дубликатов
        List<Integer> list = Arrays.stream(numbers).distinct().collect(Collectors.toCollection(ArrayList::new));
        System.out.println("Distinct numbers. " +list.toString());

        // map() - преобразует каждый элемент стрима
        System.out.println("Map stram. " +Arrays.stream(numbers).map(s -> "User_" +s).collect(Collectors.toList()));

        // peek() - возвращает тот же стрим, но применяет функцию к каждому єлементу стрима
        Stream<String> peekStream = Arrays.stream(names).filter(e -> e.length() > 3).peek(e -> System.out.println("Filtered value: " +e)).map(e -> e.toUpperCase()).peek(e -> System.out.println("Mapped value " +e));
        System.out.println(peekStream.collect(Collectors.toList()));
        //or
        System.out.println("LowerCase of the names. " +Arrays.stream(users).peek(e -> e.setName(e.getName().toLowerCase())).collect(Collectors.toList()));

        // limit() - позволяет ограничить выборку N количеством первых элементов
        Stream<String> streamStr = Stream.generate(() -> "str");
        System.out.println("Limir stream with 5 elements. " +streamStr.limit(5).collect(Collectors.toList()));

        // sorted() - позволяет отсортировать значения либо в натуральном порядке, либо задать Comparator
        System.out.println("Sorted numbers. " +Arrays.stream(numbers).sorted().collect(Collectors.toList()));
        System.out.println("Sorted names. " +Arrays.stream(names).sorted().collect(Collectors.toList()));
        System.out.println("Sorted users. " +Arrays.stream(users).sorted(new UserComparator()).collect(Collectors.toList()));

        // mapToInt() - аналог map(), но возвращает числовой стрим
        int[] numbersFromString = Arrays.stream(strNumbers).mapToInt(e -> Integer.parseInt(e)).toArray();
        System.out.println(Arrays.toString(numbersFromString));
    }
}
