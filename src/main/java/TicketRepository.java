public class TicketRepository {
    private Ticket[] tickets = new Ticket[0];


    public Ticket[] findAll() {
        return tickets;
    }

    public Ticket findById(int id) {

        for (Ticket item : tickets) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void save(Ticket item) {
        if (findById(item.id) != null) {
            throw new AlreadyExistsException(
                    "Билет id: " + item.id + " уже добавлен"
            );
        }

        Ticket[] tmp = new Ticket[tickets.length + 1];

        if (tickets.length == 0) {
            tmp[0] = item;
        } else {
            for (int i = 0; i < tickets.length; i++) {
                tmp[i] = tickets[i];
            }
            tmp[tmp.length - 1] = item;
        }
        tickets = tmp;
    }


    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException(
                    "Билет с id: " + id + " не найден"
            );
        }

        Ticket[] tmp = new Ticket[tickets.length - 1];
        int number = 0;

        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i].getId() != id) {
                tmp[number] = tickets[i];
                number++;
            }
        }
        tickets = tmp;
    }


}
