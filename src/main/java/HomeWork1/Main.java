package HomeWork1;

public class Main {
    public static void main(String[] args) {
        Human human1 = new Human(5, 1);
        Cat cat1 = new Cat(15, 2);
        Robot robot1 = new Robot(20, 5);

        System.out.println("Человек бежит со скоростью: " + human1.getRunHuman() + " км/ч");
        System.out.println("Человек может подпрыгнуть на " + human1.getJumpHuman() + " м");
        System.out.println("Кошка бежит со скоростью: " + cat1.getRunLengthCat() + " км/ч");
        System.out.println("Кошка может подпрыгнуть на " + cat1.getJumpHeightCat() + " м");
        System.out.println("Робот бежит со скоростью: " + robot1.getRunRobot() + " км/ч");
        System.out.println("Робот может подпрыгнуть на " + robot1.getJumpRobot() + " м");

        System.out.println("*****************************************************");

        human1.getRun(5);
        human1.getJump(4);
        cat1.getRun(5);
        cat1.getJump(4);
        robot1.getJump(5);
        robot1.getRun(4);

        System.out.println("*****************************************************");

        Competitable[] competitors = {new Cat(15, 2), new Human(5, 1),
                new Robot(20, 5)};

        Barriers[] barrier = {new Wall(4), new Treadmill(5)};

        for (Competitable competitable : competitors) {
            for (Barriers barriers : barrier) {
                barriers.overcame(competitable);
            }
        }


    }


}


