import eduni.distributions.Negexp;

public class ArrivalProcess {
    private EventType eventType;
    private Negexp generator;

    public ArrivalProcess(EventType eventType, Negexp generator) {
        this.eventType = eventType;
        this.generator = generator;
    }

    public Event generateArrival(EventList eventList) {
        double interval = generator.sample();
        double arrivalTime = Clock.getInstance().getTime() + interval;
        Event event = new Event(eventType, arrivalTime);
        eventList.add(event);
        return event; // The test program uses this to move the Clock.
    }
}
