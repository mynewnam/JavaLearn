package firstClass;

import usageOne.People;
import usageOne.Student;

public class dayOne {
    public static void main(String[] args) {
        People me = new People("Tom", 36);
        System.out.println(me.getAge());

        Student person = new Student("Amy", 6, "2021010617");
        person.getAge();
        person.fly();

        System.out.println("hello git!");
        System.out.println("hello git3!");
        System.out.println("hello git4!");
    }
}
