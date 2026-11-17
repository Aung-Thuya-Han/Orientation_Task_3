public class Event implements Comparable<Event> {
    private EventType type;
    private double time;

    public Event(EventType type, double time) {
        this.type = type;
        this.time = time;
    }

    public EventType getType() {
        return type;
    }

    public double getTime() {
        return time;
    }

    @Override
    public int compareTo(Event other) {
        return Double.compare(time, other.time);
    }

    @Override
    public String toString() {
        return String.format("%s at %.2f", type, time);
    }
}
