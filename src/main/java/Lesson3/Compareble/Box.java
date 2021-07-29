package Lesson3.Compareble;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.SortedMap;

public class Box implements Comparable{
    public int size;

    public Box(int size) {
        this.size= size;
    }

    @Override
    public String toString() {
        return "Box{" +
                "size=" + size +
                '}';
    }

    @Override
    public int compareTo(Object o) {
//        this  otherBox:  0 - this==otherBox; отрицательное - this< otherBox -this > otherBox
        return ((Box)o).size- size; //сортировка по убыванию
//        return size-((Box)o).size; сортировка по увеличению
    }

    public static void main(String[] args) {
        Box box1 =new Box(50);
        Box box2= new Box(10);
        System.out.println(box1.compareTo(box2));

        Box[] boxes= {new Box(10),new Box(5),new Box(35),new Box(2)};
        Arrays.sort(boxes);
        System.out.println(Arrays.toString(boxes));


    }
}
