package HomeWork3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer arr1[] = {1, 2, 3, 4, 5, 6};
        String arr2[] = {"A", "B", "C"};
        Double arr3[] = {1.5, 2.5, 3.5, 4.5, 5.5};
        changeArrayElements(arr1, 0, 5);
        changeArrayElements(arr2, 0, 2);
        changeArrayElements(arr3, 0, 4);


////        Box<Orange> orangeBox = new Box<> (new Orange[]);
//        Box<Orange> orangeBox1 = new Box<>();
//        Box<Apple> appleBox= new Box<>();
//
//        Box<Apple> appleBox1= new Box<>();





        System.out.println("Вес первой коробки с опельсинами :" );
        System.out.println("Вес второй коробки с опельсинами :" );
        System.out.println("Вес первой коробки с яблоками :" );
        System.out.println("Вес второй коробки с яблоками :" );

//        orangeBox.pourOver(orangeBox1);
//        appleBox.pourOver(appleBox1);

        System.out.println("Вес первой коробки с опельсинами :" );
        System.out.println("Вес второй коробки с опельсинами :" );
        System.out.println("Вес первой коробки с яблоками :" );
        System.out.println("Вес второй коробки с яблоками :" );





    }

    public static void changeArrayElements(Object[] arr, int n1, int n2) {
        System.out.println("Массив без изменений: " + Arrays.toString(arr));
        Object change = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = change;
        System.out.println("Массив с изменением: " + Arrays.toString(arr));
    }
}
