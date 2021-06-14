package ru.geekbrains.lesson1;

public class Main {
    public static void main(String[] args) {
        Object[] members = {new Cat("Борис"), new Cat("Снежок"), new Human("Иван"), new Robot("Бендер")};
        Object[] obstacles = {new Treadmill(3), new Wall(1), new Treadmill(10), new Treadmill(3)};

        for (Object member : members) {
            if (member instanceof Cat) {
                runObstacle(obstacles, ((Cat) member).getRestrictionRun(), ((Cat) member).getRestrictionJump());
            } else if (member instanceof Human) {
                runObstacle(obstacles, ((Human) member).getRestrictionRun(), ((Human) member).getRestrictionJump());
            } else if (member instanceof Robot) {
                runObstacle(obstacles, ((Robot) member).getRestrictionRun(), ((Robot) member).getRestrictionJump());
            }
            System.out.println("------------------------------------");
        }


    }

    public static void runObstacle(Object[] obstacles, int restrictionRun, int restrictionJump) {
        for (Object obstacle : obstacles) {
            if (obstacle instanceof Treadmill) {
                if(!((Treadmill) obstacle).run(restrictionRun)){
                    break;
                }
            } else if (obstacle instanceof Wall) {
                if( !((Wall) obstacle).jump(restrictionJump)){
                    break;
                }
            }
        }
    }
}
