package ru.geekbrains.lesson1;

public class Treadmill {
    private int length;

    public Treadmill(int length) {
        this.length = length;
    }

    public boolean run(int restrictionRun){
        if(length <= restrictionRun){
            System.out.println(" успешно пробежал");
            return true;
        }else {
            System.out.println(" не смог пробежать");
            return false;
        }
    }
}
