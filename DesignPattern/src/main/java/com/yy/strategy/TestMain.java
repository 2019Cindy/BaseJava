package com.yy.strategy;

import java.util.Arrays;

/**
 * 策略模式
 */
public class TestMain {
    public static void main(String[] args) {
//        int[] a = new int[]{11, 2, 3, 44, 6, 9, 0};
//        Cat[] a = new Cat[]{new Cat(1, 1), new Cat(10, 10), new Cat(5, 5)};
        Dog[] a = new Dog[]{new Dog(10, 5), new Dog(5, 1), new Dog(20, 10)};
        Sorter.sort(a);
        System.out.println(Arrays.toString(a));

        Sorter<Dog> dogSorter = new Sorter<>();
        dogSorter.sort(a, new DogComparator());
        System.out.println(Arrays.toString(a));
    }
}
