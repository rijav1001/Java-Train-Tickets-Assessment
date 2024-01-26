import java.util.Map;

public class TrainTicketingServiceTest {

    public static void main(String[] args) {
        TrainTicketingServiceTest test = new TrainTicketingServiceTest();
        test.testPurchaseTicket();
        test.testGetUserSeatsBySection();
        test.testRemoveUser();
        test.testRemoveUserWhenNotExists();
        test.testModifyUserSeatWhenUserNotExists();
    }

    private void assertEqual(Object expected, Object actual, String message) {
        if (!expected.equals(actual)) {
            throw new AssertionError(message);
        }
    }

    private void assertNull(Object object, String message) {
        if (object != null) {
            throw new AssertionError(message);
        }
    }

    private void assertEquals(int expected, int actual, String message) {
        if (expected != actual) {
            throw new AssertionError(message);
        }
    }

    private void assertTrue(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }

    private void testPurchaseTicket() {
        TrainTicketingService ticketService = new TrainTicketingService();
        TrainTicket ticket = createSampleTicket();
        ticketService.purchaseTicket(ticket);
        assertEqual(ticket, ticketService.getTicketDetails("john.doe@gmail.com"), "Purchase Ticket Test");
    }

    private void testGetUserSeatsBySection() {
        TrainTicketingService ticketService = new TrainTicketingService();
        TrainTicket ticket = createSampleTicket();
        ticketService.purchaseTicket(ticket);
        Map<String, String> seatsInSectionA = ticketService.getUserSeatsBySection("A");
        assertEquals(1, seatsInSectionA.size(), "Get User Seats By Section Test");
        assertTrue(seatsInSectionA.containsKey("john.doe@gmail.com"), "Get User Seats By Section Test");
    }

    private void testRemoveUser() {
        TrainTicketingService ticketService = new TrainTicketingService();
        TrainTicket ticket = createSampleTicket();
        ticketService.purchaseTicket(ticket);
        ticketService.removeUser("john.doe@gmail.com");
        assertNull(ticketService.getTicketDetails("john.doe@gmail.com"), "Remove User Test");
    }

    private void testRemoveUserWhenNotExists() {
        TrainTicketingService ticketService = new TrainTicketingService();
        // Remove a non-existing user, should not throw an exception
        ticketService.removeUser("nonexistent.user@gmail.com");
    }

    private void testModifyUserSeatWhenUserNotExists() {
        TrainTicketingService ticketService = new TrainTicketingService();
        // Modify the seat of a non-existing user, should not throw an exception
        ticketService.modifyUserSeat("nonexistent.user@gmail.com", "B");
    }

    private TrainTicket createSampleTicket() {
        TrainTicket ticket = new TrainTicket();
        ticket.setFrom("London");
        ticket.setTo("France");
        ticket.setUserFirstName("John");
        ticket.setUserLastName("Doe");
        ticket.setUserEmail("john.doe@gmail.com");
        ticket.setPricePaid(20.0);
        ticket.setSeatSection("A");
        return ticket;
    }
}
