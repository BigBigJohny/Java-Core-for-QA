package ru.geekbrains.lesson2;

public class Main {
    public static void main(String[] args) {
        String[][] array = new String[4][4];

        generateArray(array);
        printArr(array);

        try {
            try {
                System.out.println("Сумма элементов массива равна: " + getArray(array));
            } catch (MyArraySizeException e) {
                e.printStackTrace();
            }
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }
    }

    public static void printArr(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static String[][] generateArray(String[][] array) {

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = String.valueOf((int) (Math.random() * 10));
            }
        }
//        array[3][2] = "т";
        return array;
    }

    public static int getArray(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;

        if (arr.length == 4 && arr[0].length == 4) {
            System.out.println("Длина массива правильная");
        } else {
            throw new MyArraySizeException("Длина массива неправильная");
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("нельзя преобразовать ячейку " + i + "x" + j);
                }
            }
        }
        return sum;
    }
}
