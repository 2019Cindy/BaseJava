package com.yy.strategy;

public class Dog implements ComparableTest<Dog> {
    private int age;
    private int height;

    public Dog(int age, int height) {
        this.age = age;
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int compareTo(Dog dog) {
//        Dog dog = (Dog) o;
        if (this.age < dog.age) return -1;
        else if (this.age > dog.age) return 1;
        else return 0;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "age=" + age +
                ", height=" + height +
                '}';
    }
}

class DogComparator implements Comparator<Dog> {

    @Override
    public int compare(Dog o1, Dog o2) {
        if (o1.getAge() < o2.getAge())
            return -1;
        else if (o1.getAge() > o2.getAge())
            return 1;
        else return 0;
    }
}
