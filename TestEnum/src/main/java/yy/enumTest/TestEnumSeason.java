package yy.enumTest;

/**
 * 使用enum关键字
 *  enum枚举类要求对象必须放在最前面
 */
public enum  TestEnumSeason {
    Spring("春天", "春暖花开"),
    Summer("夏天", "烈日炎炎"),
    Autumn("秋天", "硕果累累"),
    Winter("冬天", "冰天雪地");

    private String name;
    private String desc;

    TestEnumSeason(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "yy.enumTest.TestEnumSeason{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }

    public static void main(String[] args) {
        TestEnumSeason winter = TestEnumSeason.Winter;
        System.out.println(winter.getName());
        System.out.println(winter.getDesc());
        System.out.println(winter.toString());
    }
}
