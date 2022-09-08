package usageOne;

/**
 * @author: liunairui
 * @create: 2022/9/1 21:34
 */
public class People {
    private String name;
    private int age;

    public People() {

    }

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
