import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * 用于修饰注解的注解Target，用于指定被修饰的注解能用于修饰哪些元素
 * 如Type：类，Constructor：构造器，Method：方法
 */
@Target({ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.METHOD})
public @interface TestAnnotation3 {

}
