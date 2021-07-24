package HomeWork3;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer arr1[] = {1, 2, 3, 4, 5, 6};
        String arr2[] = {"A", "B", "C"};
        Double arr3[] = {1.5, 2.5, 3.5, 4.5, 5.5};
        changeArrayElements(arr1, 0, 5);
        changeArrayElements(arr2, 0, 2);
        changeArrayElements(arr3, 0, 4);


        Box<Orange> orangeBox = new Box<>();
        Box<Orange> orangeBox1 = new Box<>();
        Box<Apple> appleBox = new Box<>();
        Box<Apple> appleBox1 = new Box<>();

        orangeBox.addFruit(new Orange(), 25);
        orangeBox1.addFruit(new Orange(), 15);
        appleBox.addFruit(new Apple(), 25);
        appleBox1.addFruit(new Apple(), 14);


        System.out.println("Вес первой коробки с опельсинами :" + orangeBox.getWeight());
        System.out.println("Вес второй коробки с опельсинами :" + orangeBox1.getWeight());
        System.out.println("Вес первой коробки с яблоками :" + appleBox.getWeight());
        System.out.println("Вес второй коробки с яблоками :" + appleBox1.getWeight());

        System.out.println("Сравнение первых коробок с яблоками и апельсинами " + orangeBox.compare(appleBox));
        System.out.println("Сравнение первых коробок с яблоками и апельсинами " + orangeBox1.compare(appleBox1));

        orangeBox.pourOver(orangeBox1);
        appleBox.pourOver(appleBox1);

        System.out.println(orangeBox1.getWeight());
        System.out.println(appleBox1.getWeight());
        System.out.println(orangeBox.getWeight());
        System.out.println(appleBox.getWeight());
    }

    public static void changeArrayElements(Object[] arr, int n1, int n2) {
        System.out.println("Массив без изменений: " + Arrays.toString(arr));
        Object change = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = change;
        System.out.println("Массив с изменением: " + Arrays.toString(arr));
    }
}
