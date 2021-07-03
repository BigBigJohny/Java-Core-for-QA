package ru.geekbrains.lesson5;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        //сохранение данных в csv файл
        AppData appData = new AppData();
        try (OutputStream out = new BufferedOutputStream(new FileOutputStream("file.csv"))) {
            for (int i = 0; i < appData.getHeader().length; i++) {
                out.write((appData.getHeader()[i] + " ").getBytes(StandardCharsets.UTF_8));
            }
            out.write("\n".getBytes(StandardCharsets.UTF_8));
            for (int i = 0; i < appData.getData().length; i++) {
                for (int j = 0; j < appData.getData()[i].length; j++) {
                    if (j == appData.getData()[i].length - 1) {
                        out.write(String.valueOf(appData.getData()[i][j]).getBytes(StandardCharsets.UTF_8));
                    } else {
                        out.write((appData.getData()[i][j] + ";").getBytes(StandardCharsets.UTF_8));
                    }
                }
                out.write("\n".getBytes(StandardCharsets.UTF_8));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        //загрузку данных из csv файла
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("file.csv"))) {
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String[] tokens = line.split("\\s");
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
