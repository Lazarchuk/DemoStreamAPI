package demo.stream.sort_persons;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class SortTest {
    private static ApplicationInput[] input = new ApplicationInput[]{
            new ApplicationInput("John", "male", "02.08.1997"),
            new ApplicationInput("Lora", "female", "03.09.2001"),
            new ApplicationInput("David", "male", "10.10.1995"),
            new ApplicationInput("Tom", "male", "02.03.2002"),
            new ApplicationInput("Julia", "female", "11.09.2005"),
            new ApplicationInput("Alex", "male", "09.12.1998"),
    };
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");

    public static void main(String[] args) throws ParseException {

        List<Person> sorted = Arrays.stream(input).map(s ->{
            Date date = parseDate(s.getBirthday());
            return new Person(s.getName(), s.getGender(), date);
        }).sorted().collect(Collectors.toList());

        for (Person p: sorted){
            System.out.println(p);
        }

    }

    private static Date parseDate(String stringRepresentation){
        Date date = new Date();
        try {
            date = simpleDateFormat.parse(stringRepresentation);
        } catch (ParseException e) {
            System.err.println("The date " +stringRepresentation+ " cannot be parsed");
        }
        return date;
    }
}
