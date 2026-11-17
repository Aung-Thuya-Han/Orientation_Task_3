import eduni.distributions.Negexp;

public class Main {
    public static void main(String[] args) {
        Clock clock = Clock.getInstance();
        clock.setTime(0);
        EventList eventList = new EventList();
        ArrivalProcess arrivals = new ArrivalProcess(EventType.ARRIVAL, new Negexp(10, 123));

        for (int i = 0; i < 10; i++) {
            Event event = arrivals.generateArrival(eventList);
            clock.setTime(event.getTime());
        }

        System.out.println("Arrival events:");
        eventList.printEvents();
        System.out.printf("Clock after generating arrivals: %.2f%n", clock.getTime());
    }
}
