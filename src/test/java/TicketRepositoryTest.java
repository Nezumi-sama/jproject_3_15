import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketRepositoryTest {
    Ticket ticket01 = new Ticket(81, 6480, "GOJ", "SVO", 90);
    Ticket ticket02 = new Ticket(12, 2100, "DME", "LED", 100);
    Ticket ticket03 = new Ticket(15, 3600, "DME", "LED", 100);
    Ticket ticket04 = new Ticket(41, 2080, "LED", "DME", 95);
    Ticket ticket05 = new Ticket(71, 4596, "GOJ", "DME", 100);

    @Test
    void shouldFindAll() {
        TicketRepository repo = new TicketRepository();
        repo.save(ticket01);
        repo.save(ticket02);
        repo.save(ticket03);

        Ticket[] expected = {ticket01, ticket02, ticket03};
        Ticket[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindByIdThereIs() {
        TicketRepository repo = new TicketRepository();
        repo.save(ticket01);
        repo.save(ticket02);
        repo.save(ticket03);
        repo.save(ticket04);
        repo.save(ticket05);

        Ticket expected = ticket03;
        Ticket actual = repo.findById(15);

        assertEquals(expected, actual);

    }

    @Test
    void shouldFindByIdThereIsNot() {
        TicketRepository repo = new TicketRepository();
        repo.save(ticket01);
        repo.save(ticket02);
        repo.save(ticket03);
        repo.save(ticket04);
        repo.save(ticket05);

        Ticket expected = null;
        Ticket actual = repo.findById(77);

        assertEquals(expected, actual);

    }


    @Test
    void saveFirstItem() {
        TicketRepository repo = new TicketRepository();
        repo.save(ticket01);

        Ticket[] expected = {ticket01};
        Ticket[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void saveNoFirstItem() {
        TicketRepository repo = new TicketRepository();
        repo.save(ticket01);
        repo.save(ticket02);
        repo.save(ticket03);
        repo.save(ticket04);
        repo.save(ticket05);

        Ticket[] expected = {ticket01, ticket02, ticket03, ticket04, ticket05};
        Ticket[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void saveItemWithDuplicateNumber() {
        TicketRepository repo = new TicketRepository();
        repo.save(ticket01);
        repo.save(ticket02);
        repo.save(ticket03);
        repo.save(ticket04);
        repo.save(ticket05);

        assertThrows(AlreadyExistsException.class, () -> {
            repo.save(ticket03);
        });

    }


    @Test
    void removeByIdThereIs() {
        TicketRepository repo = new TicketRepository();
        repo.save(ticket01);
        repo.save(ticket02);
        repo.save(ticket03);
        repo.save(ticket04);
        repo.save(ticket05);

        repo.removeById(15);

        Ticket[] expected = {ticket01, ticket02, ticket04, ticket05};
        Ticket[] actual = repo.findAll();

        assertArrayEquals(expected, actual);

    }

    @Test
    void removeByIdThereIsNot() {
        TicketRepository repo = new TicketRepository();
        repo.save(ticket01);
        repo.save(ticket02);
        repo.save(ticket03);
        repo.save(ticket04);
        repo.save(ticket05);

        assertThrows(NotFoundException.class, () -> {
            repo.removeById(77);
        });

    }
}