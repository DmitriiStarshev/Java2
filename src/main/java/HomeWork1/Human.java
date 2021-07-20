package HomeWork1;

public class Human implements Competitable {
    private int runHuman;
    private int jumpHuman;

    public Human(int runHuman, int jumpHuman) {
        this.runHuman = runHuman;
        this.jumpHuman = jumpHuman;
    }

    public int getRunHuman() {
        return runHuman;
    }

    public void setRunHuman(int runHuman) {
        this.runHuman = runHuman;
    }

    public int getJumpHuman() {
        return jumpHuman;
    }

    public void setJumpHuman(int jumpHuman) {
        this.jumpHuman = jumpHuman;
    }

    @Override
    public String toString() {
        return "Human{" +
                "runHuman=" + runHuman +
                ", jumpHuman=" + jumpHuman +
                '}';
    }

    public void getRun(int treadmill) {
        if (getRunHuman() >= treadmill) {
            System.out.println("Человек пробежал дистанцию");
        } else {
            System.out.println("Человек не смог пробежать дистанцию");
        }

    }

    public void getJump(int wall) {
        if (getJumpHuman() >= wall) {
            System.out.println("Человек перепрыгнул стену");
        } else {
            System.out.println("Человек не смог перепрыгнуть через стену");
        }
    }


    @Override
    public void run(int length) {
        if (length <= runHuman) {
            System.out.println("Человек пробежал дистанцию");
        } else {
            System.out.println("Человек не смог пробежать дистанцию");
        }

    }

    @Override
    public void jump(int height) {
        if (height <= jumpHuman) {
            System.out.println("Человек перепрыгнул стену");
        } else {
            System.out.println("Человек не смог перепрыгнуть через стену");
        }

    }
}
