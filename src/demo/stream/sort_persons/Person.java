package demo.stream.sort_persons;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Person implements Comparable<Person>{
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
    private String name;
    private String gender;
    private Date birthDay;

    public Person(String name, String gender, Date birthDay) {
        this.name = name;
        this.gender = gender;
        this.birthDay = birthDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    @Override
    public int compareTo(Person o) {
        return o.getBirthDay().compareTo(this.birthDay);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthDay=" + simpleDateFormat.format(birthDay) +
                '}';
    }
}
