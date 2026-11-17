import eduni.distributions.Negexp;

public class Main {
    public static void main(String[] args) {
        Clock clock = Clock.getInstance();
        clock.setTime(0);
        EventList eventList = new EventList();
        ServicePoint servicePoint = new ServicePoint();
        ArrivalProcess arrivals = new ArrivalProcess(EventType.ARRIVAL, new Negexp(10, 123));


        for (int i = 0; i < 10; i++) {
            Event event = arrivals.generateArrival(eventList);
            clock.setTime(event.getTime());
        }
        System.out.printf("Clock after generating arrivals: %.2f%n", clock.getTime());


        while (!eventList.isEmpty()) {
            Event event = eventList.getNextEvent();
            Customer customer = new Customer(event.getTime());
            servicePoint.addToQueue(customer);
        }
        System.out.printf("Clock after filling queue: %.2f%n", clock.getTime());


        clock.setTime(clock.getTime() + 5);
        System.out.printf("Departure time: %.2f%n", clock.getTime());


        while (!servicePoint.isEmpty()) {
            Customer customer = servicePoint.removeFromQueue();
            customer.setDepartureTime(clock.getTime());
            System.out.printf("Customer %d: arrival %.2f, time in system %.2f%n",
                    customer.getId(), customer.getArrivalTime(), customer.getTimeInSystem());
        }
        System.out.println("Queue empty: " + servicePoint.isEmpty());
    }
}
