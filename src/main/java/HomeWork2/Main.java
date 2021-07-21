package HomeWork2;

public class Main {
    public static int arraySum(String[][] twoDimensionalArray) throws MyArraySizeException, MyArrayDataException {
        if (twoDimensionalArray.length != 4) {
            throw new MyArraySizeException("Размер массива привышен!");
        }
        for (String[] array : twoDimensionalArray) {
            if (array.length != 4) {
                throw new MyArraySizeException("Высота массива != 4" +
                        " ,вы ввели длину массива равное = " + array.length);
            }
        }

        int count = 0;
        for (int i = 0; i < twoDimensionalArray.length; i++) {
            for (int j = 0; j < twoDimensionalArray[i].length; j++) {
                try {
                    count += Integer.parseInt(twoDimensionalArray[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Ошибка в ячейке: " + i + "," + j);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String[][] successArray =
                {{"1", "2", "3", "4"},
                        {"1", "2", "3", "4"},
                        {"1", "2", "3", "4"},
                        {"1", "2", "3", "4"}};
        try {
            System.out.println(arraySum(successArray));
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }


        String[][] anSuccessArray =
                {{"1", "2", "3", "D"},
                        {"1", "2", "3", "4"},
                        {"1", "2", "3", "4"},
                        {"1", "2", "3", "4"}};
        try {
            System.out.println(arraySum(anSuccessArray));
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }

        String[][] smallSizeArray =
                {{"1", "2", "3", "4"},
                        {"1", "2", "3"},
                        {"1", "2"},
                        {"1"}};
        try {
            System.out.println(arraySum(smallSizeArray));
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }

        String[][] largeSizeArray = {{"1", "2", "3", "4", "5"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}};
        try {
            System.out.println(arraySum(largeSizeArray));
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }
    }
}

