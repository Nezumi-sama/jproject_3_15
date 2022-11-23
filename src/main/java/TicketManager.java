import java.util.Arrays;


public class TicketManager {
    private TicketRepository repo;

    public TicketManager(TicketRepository repo) {
        this.repo = repo;
    }

    public void addItem(Ticket item) {
        repo.save(item);
    }

    public Ticket[] getAllItems() {
        Ticket[] allItems = repo.findAll();
        return allItems;
    }

    public Ticket[] searchTickets(String airportFrom, String airportTo) {
        Ticket[] result = new Ticket[0]; // тут будем хранить подошедшие запросу продукты
        TicketRepository tmp = new TicketRepository();

        for (Ticket product : repo.findAll()) {
            if (product.getAirportOfDeparture().equals(airportFrom) && product.getAirportOfArrival().equals(airportTo)) {
                tmp.save(product);
                result = tmp.findAll();
            }

        }
        Arrays.sort(result);
        return result;
    }

}
