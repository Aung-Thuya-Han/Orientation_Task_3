import java.util.PriorityQueue;

public class EventList {
    private PriorityQueue<Event> events = new PriorityQueue<>();

    public void add(Event event) {
        events.add(event);
    }

    public Event getNextEvent() {
        return events.poll(); // Removes and returns the earliest event.
    }

    public boolean isEmpty() {
        return events.isEmpty();
    }

    public void printEvents() {
        for (Event event : events) {
            System.out.println(event);
        }
    }
}
