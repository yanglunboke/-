package 王东豪;

class dog {
    private String name;
    private int age;
    private String color;
    private String what;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getWhat() {
        return what;
    }

    public void setWhat(String what) {
        this.what = what;
    }
}
public class toDog {
    public static void main(String[] args) {
        dog dog = new dog();
        dog.setName("王东豪");
        dog.setAge(2);
        dog.setColor("粉色");
        dog.setWhat("睡觉吃饭叫");

        System.out.println("我是一条"+dog.getColor()+"小狗，我叫"+dog.getName()+"我狗龄"+dog.getAge()+"岁了,我会"+dog.getWhat());
    }
}
