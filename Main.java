import java.util.Map;

public class Main {
    public static void main(String[] args) {
        TrainTicketingService ticketingService = new TrainTicketingService();
        TrainTicket t1 = new TrainTicket();
        TrainTicket t2 = new TrainTicket();

        // Ticket 1 details
        t1.setFrom("London");
        t1.setTo("France");
        t1.setUserFirstName("John");
        t1.setUserLastName("Doe");
        t1.setUserEmail("johndoe123@gmail.com");
        t1.setPricePaid(20.0);
        t1.setSeatSection("A");

        // Ticket 2 details
        t2.setFrom("London");
        t2.setTo("France");
        t2.setUserFirstName("Steve");
        t2.setUserLastName("Smith");
        t2.setUserEmail("steve.smith@gmail.com");
        t2.setPricePaid(20.0);
        t2.setSeatSection("B");

        // Purchase tickets
        ticketingService.purchaseTicket(t1);
        ticketingService.purchaseTicket(t2);

        // Get ticket details
        TrainTicket johnsTicket = ticketingService.getTicketDetails("johndoe123@gmail.com");
        System.out.println("John's Ticket Details: " + johnsTicket);

        // View user seats by section
        Map<String, String> seatsInSectionA = ticketingService.getUserSeatsBySection("A");
        System.out.println("Seats in Section A: " + seatsInSectionA);

        // Remove a user
        ticketingService.removeUser("johndoe123@gmail.com");
        System.out.println("John's ticket removed.");

        // Modify user seat
        ticketingService.modifyUserSeat("steve.smith@gmail.com", "A");
        System.out.println("Jane's seat modified to Section A.");

        // View updated user seats by section
        seatsInSectionA = ticketingService.getUserSeatsBySection("A");
        System.out.println("Seats in Section A: " + seatsInSectionA);
    }
}
