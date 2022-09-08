package usageOne;

/**
 * @author: liunairui
 * @create: 2022/9/1 21:39
 */
public class Student extends People implements Fly {
    private String ID;

    public Student() {
        super();
    }

    public Student(String name, int age, String ID) {
        super(name, age);
        this.ID = ID;
    }

    public String getID() {
        return ID;
    }

    @Override
    public int getAge() {
        System.out.println("under 18!");
        return 0;
    }

    @Override
    public void fly() {
        System.out.println("我不会飞！");
    }
}
