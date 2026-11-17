public class Clock {

    private static final Clock instance = new Clock();
    private double time;

    private Clock() {
        time = 0;
    }

    public static Clock getInstance() {
        return instance;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }
}
