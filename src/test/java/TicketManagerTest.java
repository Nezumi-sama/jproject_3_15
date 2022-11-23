import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);

    Ticket ticket01 = new Ticket(81, 6480, "GOJ", "SVO", 90);
    Ticket ticket02 = new Ticket(12, 2100, "DME", "LED", 100);
    Ticket ticket03 = new Ticket(15, 3600, "DME", "LED", 100);
    Ticket ticket04 = new Ticket(41, 2080, "LED", "DME", 95);
    Ticket ticket05 = new Ticket(71, 4596, "GOJ", "DME", 100);
    Ticket ticket06 = new Ticket(21, 2100, "LED", "DME", 100);
    Ticket ticket07 = new Ticket(16, 4201, "DME", "GOJ", 80);
    Ticket ticket08 = new Ticket(13, 1470, "VKO", "LED", 90);
    Ticket ticket09 = new Ticket(14, 2080, "DME", "LED", 100);
    Ticket ticket10 = new Ticket(61, 4360, "GOJ", "SVO", 85);

    @Test
    void addItemFirst() {
        manager.addItem(ticket01);

        Ticket[] expected = {ticket01};
        Ticket[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void addItemNoFirst() {
        manager.addItem(ticket01);
        manager.addItem(ticket02);
        manager.addItem(ticket03);

        Ticket[] expected = {ticket01, ticket02, ticket03};
        Ticket[] actual = manager.getAllItems();

        assertArrayEquals(expected, actual);
    }

    @Test
    void getAllItems() {
        TicketManager manager1 = new TicketManager(repo);
        manager1.addItem(ticket01);
        manager1.addItem(ticket02);
        manager1.addItem(ticket03);

        manager = manager1;

        Ticket[] expected = {ticket01, ticket02, ticket03};
        Ticket[] actual = manager.getAllItems();

        assertArrayEquals(expected, actual);

    }

    @Test
    void searchTicketsSeveral() {
        manager.addItem(ticket01);
        manager.addItem(ticket02);
        manager.addItem(ticket03);
        manager.addItem(ticket04);
        manager.addItem(ticket05);
        manager.addItem(ticket06);
        manager.addItem(ticket07);
        manager.addItem(ticket08);
        manager.addItem(ticket09);
        manager.addItem(ticket10);

        Ticket[] expected = {ticket09, ticket02, ticket03};
        Ticket[] actual = manager.searchTickets("DME", "LED");

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchTicketsOne() {
        manager.addItem(ticket01);
        manager.addItem(ticket02);
        manager.addItem(ticket03);
        manager.addItem(ticket04);
        manager.addItem(ticket05);
        manager.addItem(ticket06);
        manager.addItem(ticket07);
        manager.addItem(ticket08);
        manager.addItem(ticket09);
        manager.addItem(ticket10);

        Ticket[] expected = {ticket05};
        Ticket[] actual = manager.searchTickets("GOJ", "DME");

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchTicketsNotFound() {
        manager.addItem(ticket01);
        manager.addItem(ticket02);
        manager.addItem(ticket03);
        manager.addItem(ticket04);
        manager.addItem(ticket05);
        manager.addItem(ticket06);
        manager.addItem(ticket07);
        manager.addItem(ticket08);
        manager.addItem(ticket09);
        manager.addItem(ticket10);

        Ticket[] expected = {};
        Ticket[] actual = manager.searchTickets("SVX", "DME");

        assertArrayEquals(expected, actual);
    }

}