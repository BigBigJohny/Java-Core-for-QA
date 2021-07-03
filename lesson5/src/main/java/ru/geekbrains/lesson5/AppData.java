package ru.geekbrains.lesson5;

public class AppData {
    private String[] header;
    private int[][] data;

    public AppData() {
        this.header = new String[]{"Value1", "Value2", "Value3"};
        this.data = arrayCreator();
    }

    public int[][] getData() {
        return data;
    }

    public String[] getHeader() {
        return header;
    }

    public static int[][] arrayCreator() {
        int[][] arr = new int[100][3];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (int) ((Math.random() * 1000));
            }
        }
        return arr;
    }
}
