@TestAnnotation(value = {"111","222"})
public class TestMain {

}

@TestAnnotation2()
class Test{

}

@TestAnnotation3
class TestTarget{
//    @TestAnnotation3
    int age;
    @TestAnnotation3
    public TestTarget(){

    }
    @TestAnnotation3
    public void eat(){

    }
}
