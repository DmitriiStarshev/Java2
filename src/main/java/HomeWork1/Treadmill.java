package HomeWork1;

public class Treadmill implements Barriers {
    private int lengthTreadmill;

    public Treadmill(int lengthTreadmill) {
        this.lengthTreadmill = lengthTreadmill;
    }

    public int getLengthTreadmill() {
        return this.lengthTreadmill;
    }

    public void setLengthTreadmill(int lengthTreadmill) {
        this.lengthTreadmill = lengthTreadmill;
    }

    public int getRunToTheTreadmill(Actions runner) {
        return runner.run(this);
    }

    public void overcame(Competitable competitable) {
        competitable.run(lengthTreadmill);
    }


}
