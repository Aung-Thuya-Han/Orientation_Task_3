public class Main {
    public static void main(String[] args) {
        Clock firstClock = Clock.getInstance();
        Clock secondClock = Clock.getInstance();

        firstClock.setTime(0);
        System.out.println("Starting time: " + firstClock.getTime());
        System.out.println("Same object: " + (firstClock == secondClock));

        firstClock.setTime(10);
        System.out.println("Second reference sees: " + secondClock.getTime());

        secondClock.setTime(secondClock.getTime() + 5);
        System.out.println("First reference sees: " + firstClock.getTime());
    }
}
