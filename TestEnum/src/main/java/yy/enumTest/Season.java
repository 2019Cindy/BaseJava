package yy.enumTest;

/**
 * 季节枚举类
 */
public class Season {
    // 名字
    private String name;
    // 描述
    private String description;

    public Season(String name,String description){
        this.name=name;
        this.description=description;
    }

    public static final Season spring =new Season("春天","春暖花开");
    public static final Season summer =new Season("夏天","烈日炎炎");
    public static final Season autumn =new Season("秋天","硕果累累");
    public static final Season winter =new Season("冬天","冰天雪地");

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "yy.enumTest.Season{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Season spring = Season.spring;
        System.out.println(spring);
    }
}
