package HomeWork3;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> fruitList = new ArrayList<>();

    public Box() {
    }

    public ArrayList<T> getFruitList() {
        return fruitList;
    }

    public void setFruitList(ArrayList<T> fruitList) {
        this.fruitList = fruitList;
    }

    public void addFruit(T fruit, int amount) {
        for (int i = 0; i < amount; i++) {
            fruitList.add(fruit);
        }
    }

    public float getWeight() {
        try {
            return fruitList.size() * fruitList.get(0).getWeight();
        } catch (IndexOutOfBoundsException e) {
            throw new ArithmeticException("В корзине осталось 0 фруктов, и умножать на 0 нельзя");
        }


    }

    public boolean compare(Box<?> boxToCompare) {
        return Math.abs(getWeight() - boxToCompare.getWeight()) < 0.000001;
    }

    public void pourOver(Box<T> box) {
        box.getFruitList().addAll(fruitList);
        fruitList.clear();

    }


}
