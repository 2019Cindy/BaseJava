public class TestMain {
    public static void main(String[] args) {
        // 第一次加载类的时候会进行类的加载classLoad，初始化创建对象的时候，对象的属性没有给赋值，有默认的初始化的值
        Person person = new Person();
        person.age = 18;
        person.height = 180;
        person.name = "张三";

        // 再次创建类的时候，就不会进行类加载了，类的加载只在第一次需要的时候加载一次
        Person person1 = new Person();
        person1.age = 80;
        person1.height = 160;
        person1.name = "王五";
    }
}
