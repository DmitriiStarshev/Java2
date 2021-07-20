package HomeWork1;

public class Cat implements Competitable {
    private int runLengthCat;
    private int jumpHeightCat;

    public Cat(int runLengthCat, int jumpHeightCat) {
        this.runLengthCat = runLengthCat;
        this.jumpHeightCat = jumpHeightCat;
    }

    public int getRunLengthCat() {
        return runLengthCat;
    }

    public void setRunLengthCat(int runLengthCat) {
        this.runLengthCat = runLengthCat;
    }

    public int getJumpHeightCat() {
        return jumpHeightCat;
    }

    public void setJumpHeightCat(int jumpHeightCat) {
        this.jumpHeightCat = jumpHeightCat;
    }

    public void getRun(int treadmill) {
        if (getRunLengthCat() >= treadmill) {
            System.out.println("Кот пробежал дистанцию");
        } else {
            System.out.println("Кот не смог пробежать дистанцию");
        }

    }

    public void getJump(int wall) {
        if (getJumpHeightCat() >= wall) {
            System.out.println("Кот перепрыгнул стену");
        } else {
            System.out.println("Кот не смог перепрыгнуть через стену");
        }
    }

    @Override
    public void run(int length) {
        if (length <= runLengthCat) {
            System.out.println("Кот пробежал дистанцию");
        } else {
            System.out.println("Кот не смог пробежать дистанцию");
        }

    }

    @Override
    public void jump(int height) {
        if (height <= jumpHeightCat) {
            System.out.println("Кот перепрыгнул стену");
        } else {
            System.out.println("Кот не смог перепрыгнуть через стену");
        }

    }
}
