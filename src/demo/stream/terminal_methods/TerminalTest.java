package demo.stream.terminal_methods;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalTest {
    private static Integer[] numbers = {3, 5, 2, 6, 2, 8, 0, 10, 67, 5, 23, 7658, 236, 10};
    private static Integer[] numbers1 = {3, 5, 2,};
    private static String[] names = {"Dan","Daniel", "Mark", "Ali"};
    private static String[] strNumbers = {"2","3", "7", "5"};
    private static User[] users = {new User("Dan"), new User("Mark"), new User("Daniel"), new User("Ali")};

    public static void main(String[] args) {
        // findFirst() - возвращает первый элемент из стрима (возвращает Optional)
        System.out.println("First element. " + Arrays.stream(names).findFirst().orElse("No elements"));

        // findAny() - возвразает любой подходящий элемент из стрима
        System.out.println("Find any element. " +Arrays.stream(numbers).findAny().orElse(1));

        // collect() - представление результатов в виде коллекций и других структур данных
        System.out.println("Collect elements. " +Arrays.stream(numbers).collect(Collectors.toList()));

        // count() - возвращает количество элементов в стриме
        System.out.println("Number of elements in sorted stream. " +Arrays.stream(numbers).distinct().sorted().count());

        // anyMatch() - возвращает true, если условие выполняется хотя бы для одного элемента
        System.out.println("Check if users array contains specific name (Mark). " + Arrays.stream(users).anyMatch(user -> user.getName().equals("Mark")));

        // noneMatch() - возвращает true, если условие не выполняется ни для одного элемента
        System.out.println("Check if numbers array does not contain specific element (1000). " +Arrays.stream(numbers).noneMatch(num -> num==1000));

        // allMatch() - возвращает true, если условие выполняеться для всех элементов
        System.out.println("Check if names array has not empty names. " +Arrays.stream(names).allMatch(name -> !name.isEmpty()));

        // min() / max() - возвращает минимальный/ максимальный элемент, в качестве условия использует компаратор
        System.out.println("Min element in numbers. " +Arrays.stream(numbers).min(Integer::compare).get());
        System.out.println("Max element in numbers. " +Arrays.stream(numbers).max(Integer::compare).get());

        // forEach() - применяет функцию к каждому элементу стрима, порядок при паралельном выполнении не гарантируется
        Arrays.stream(names).forEach(System.out::println);

        // toArray() - возвращает массив значений стрима
        Integer[] orderedNumbers = new Integer[0];
         Arrays.stream(numbers).sorted(Comparator.naturalOrder()).toArray();
        for (Integer num: orderedNumbers) {
            System.out.print(num + ", ");
        }
        System.out.println();

        // reduce() - позволяет выполнить агрегатные функции над всей коллекцией и возвращает один результат
        System.out.println("Reduce. " +Arrays.stream(numbers1).reduce((s1, s2) -> s1+s2).get());
    }
}
