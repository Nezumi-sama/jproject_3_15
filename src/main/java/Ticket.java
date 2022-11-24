import java.util.Comparator;

public class Ticket implements Comparator<Ticket> {
    protected int id;
    protected int price;
    protected String airportOfDeparture;
    protected String airportOfArrival;
    protected int time;

    public Ticket(int id, int price, String airportOfDeparture, String airportOfArrival, int time) {
        this.id = id;
        this.price = price;
        this.airportOfDeparture = airportOfDeparture;
        this.airportOfArrival = airportOfArrival;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public String getAirportOfDeparture() {
        return airportOfDeparture;
    }

    public String getAirportOfArrival() {
        return airportOfArrival;
    }

    public int getTime() {
        return time;
    }


    public void setid(int id) {
        this.id = id;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setAirportOfDeparture(String airportOfDeparture) {
        this.airportOfDeparture = airportOfDeparture;
    }

    public void setAirportOfArrival(String airportOfArrival) {
        this.airportOfArrival = airportOfArrival;
    }

    public void setTime(int time) {
        this.time = time;
    }

  /*  @Override
    public int compareTo(Ticket o) {
        if (this.price < o.price) {
            return -1;
        } else if (this.price > o.price) {
            return 1;
        } else {
            return 0;
        }
    }*/

    @Override
    public int compare(Ticket o1, Ticket o2) {

            return o1.price-o2.price;


    }
}
