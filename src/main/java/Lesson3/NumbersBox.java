package Lesson3;

import java.util.Arrays;

public class NumbersBox<T extends Number> {
    private T[] array;

    @Override
    public String toString() {
        return "NumbersBox{" +
                "array=" + Arrays.toString(array) +
                '}';
    }

    public T[] getArray() {
        return array;
    }

    public void setArray(T[] array) {
        this.array = array;
    }

    public double calcAverage() {
        double sum = 0.0;
        for (T num : array) {
            sum = sum + num.doubleValue();
        }
        return sum / array.length;
    }
    public static <U extends Number> U getFirstElement(NumbersBox<U> numbersBox){
        return numbersBox.getArray()[0];
    }

    public boolean isSameAvg(NumbersBox<?> boxToCompare) {
        return Math.abs(calcAverage() - boxToCompare.calcAverage()) < 0.00001;
    }

    public NumbersBox(T... array) {
        this.array = array;
    }

    public static void main(String[] args) {
        NumbersBox<Integer> integerNumbersBox = new NumbersBox<>(1, 3, 4, 5, 6, 7, 7);
        System.out.println(integerNumbersBox.calcAverage());


        NumbersBox<Integer> integerNumbersBox2 = new NumbersBox<>(1, 23, 25, 65);
      
        NumbersBox<Double> doubleNumbersBox1= new NumbersBox<>(1.1,2.1,5.4,5.5,7.1);

        System.out.println(integerNumbersBox.isSameAvg(doubleNumbersBox1));

        System.out.println(getFirstElement(doubleNumbersBox1));
    }
}


