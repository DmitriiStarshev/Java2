package HomeWork1;

public class Robot implements Competitable {
    private int runRobot;
    private int jumpRobot;

    public Robot(int runRobot, int jumpRobot) {
        this.runRobot = runRobot;
        this.jumpRobot = jumpRobot;
    }

    public int getRunRobot() {
        return runRobot;
    }

    public void setRunRobot(int runRobot) {
        this.runRobot = runRobot;
    }

    public int getJumpRobot() {
        return jumpRobot;
    }

    public void setJumpRobot(int jumpRobot) {
        this.jumpRobot = jumpRobot;
    }

    public void getRun(int treadmill) {
        if (getRunRobot() >= treadmill) {
            System.out.println("Робот пробежал дистанцию");
        } else {
            System.out.println("Робот не смог пробежать дистанцию");
        }

    }

    public void getJump(int wall) {
        if (getJumpRobot() >= wall) {
            System.out.println("Робот перепрыгнул стену");
        } else {
            System.out.println("Робот не смог перепрыгнуть через стену");
        }
    }

    @Override
    public void run(int length) {
        if (length <= runRobot) {
            System.out.println("Робот пробежал дистанцию");
        } else {
            System.out.println("Робот не смог пробежать дистанцию");
        }

    }

    @Override
    public void jump(int height) {
        if (height <= jumpRobot) {
            System.out.println("Робот перепрыгнул стену");
        } else {
            System.out.println("Робот не смог перепрыгнуть через стену");
        }

    }
}
