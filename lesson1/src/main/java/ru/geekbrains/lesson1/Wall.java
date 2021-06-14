package ru.geekbrains.lesson1;

public class Wall {
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    public boolean jump(int restrictionJump){
        if(height <= restrictionJump){
            System.out.println(" успешно перепрыгнул");
            return true;
        }else {
            System.out.println("не смог перепрыгнуть");
            return false;
        }
    }
}
