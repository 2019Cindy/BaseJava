public class Person {
    int age;
    String name;
    int height;

    public String introduce() {
        return String.format("我是%s，年龄%d，身高%d", name, age, height);
    }
}
