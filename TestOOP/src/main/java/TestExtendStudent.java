public class TestExtendStudent extends TestExtendPeople {
    private int cid;
    private int age = 100;

    TestExtendStudent() {
        super();
    }

    TestExtendStudent(int age, String name, int cid) {
        super(age, name);   // super调用父类构造器
        this.cid = cid;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public void study() {
        System.out.println("=======正在学习");
    }

    @Override
    public void eat() {
        System.out.println("学生正在吃饭");
    }

    public void a() {
        System.out.println("父：" + super.getAge());
        System.out.println("子：" + getAge());
    }
}
