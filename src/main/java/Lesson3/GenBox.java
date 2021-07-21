package Lesson3;

import java.util.ArrayList;

public class GenBox<T> {
    private T object;

    public GenBox(T object) {
        this.object = object;
    }

    public T getObject() {
        return object;
    }

//    public static T  test(){
//        return T;
//    }

//    public void test1 (){
//        T test = new T();
//            T[] array = new T[10];
//    }

    public void setObject(T object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "GenBox{" +
                "object=" + object +
                '}';
    }

    public static void main(String[] args) {
        GenBox<Integer> integerGenBox1 =new GenBox<>(5);
        GenBox<Integer> integerGenBox2 = new GenBox<>(10);

        System.out.println("Класс генбокс с целыи числом: "+ integerGenBox1.getClass());
        System.out.println(integerGenBox1.getObject()+integerGenBox2.getObject());

        GenBox<String> stringGenBox1 = new GenBox<>("Test1");
//        stringGenBox1.setObject(4);

        GenBox genBox = new GenBox(5);

        int a= new Integer(5);
        Number b= a;

        ArrayList<Integer> integerArrayList= new ArrayList<>();
//        ArrayList<Number> numberArrayList = integerArrayList;
    }
}
