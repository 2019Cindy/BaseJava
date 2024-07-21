package yy.enumTest;

import java.util.Arrays;

/**
 * 常用方法
 */
public class TestEnumFunc {
    public static void main(String[] args) {
        // 用enum关键字创建的season枚举类的父类为java.lang.Enum，常用方法子类可以直接使用
        // toString,获取对象的名字
        System.out.println(SeasonTest.SPRING.toString());
        // values,返回枚举类对象的数组
        System.out.println(Arrays.toString(SeasonTest.values()));
        // valueOf,通过对象名字获取枚举对象，对象名字必须正确，否则抛出异常
        SeasonTest summer = SeasonTest.valueOf("SUMMER");
        System.out.println(summer);

        // 所有的枚举对象，调用这个show方法的时候都走的是同一个方法，结果都一样
        SeasonTest winter = SeasonTest.WINTER;
        winter.show();
        SeasonTest spring = SeasonTest.SPRING;
        spring.show();

    }
}

enum SeasonTest implements TestInterface {
    // 不同的对象， 调用的show方法也不同,在每个对象中重写方法
    SPRING {
        @Override
        public void show() {
            System.out.println("春天...");
        }
    },

    SUMMER {
        @Override
        public void show() {
            System.out.println("夏天...");
        }
    },

    AUTUMN {
        @Override
        public void show() {
            System.out.println("秋天...");
        }
    },

    WINTER {
        public void show() {
            System.out.println("冬天...");
        }
    };

//    @Override
//    public void show() {
//        System.out.println("yy.enumTest.SeasonTest...");
//    }
    }
