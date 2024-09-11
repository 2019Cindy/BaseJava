package com.yy.strategy;

public class Sorter<T> {
    // 数组排序
    public static void sort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                minPos = arr[j] < arr[minPos] ? j : minPos;
            }
            swap(arr, i, minPos);
        }
    }

    static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 自定义对象排序
    public static void sort(Cat arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                minPos = arr[i].compareTo(arr[j]) == 1 ? j : minPos;
            }
            swap(arr, i, minPos);
        }
    }

    static void swap(Cat arr[], int i, int j) {
        Cat temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 自定义对象实现比较接口，内部比较器
    public static void sort(ComparableTest arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                minPos = arr[i].compareTo(arr[j]) == 1 ? j : minPos;
            }
            swap(arr, i, minPos);
        }
    }

    static void swap(ComparableTest arr[], int i, int j) {
        ComparableTest temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 自定义比较器,外部比较器
    public void sort(T arr[], Comparator<T> comparator) {
        for (int i = 0; i < arr.length; i++) {
            int minPos = i;
            for (int j = i+1; j < arr.length; j++) {
                minPos = comparator.compare(arr[i], arr[j]) == 1 ? j : minPos;
            }
            swap(arr, i, minPos);
        }
    }

    public void swap(T arr[], int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
