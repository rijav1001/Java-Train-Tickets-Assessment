import java.util.HashMap;
import java.util.Map;

public class TrainTicketingService {
    private Map<String, TrainTicket> tickets = new HashMap<>();

    // API to purchase ticket
    public void purchaseTicket(TrainTicket ticket) {
        tickets.put(ticket.getUserEmail(), ticket);
    }

    // API to get ticket details (receipt)
    public TrainTicket getTicketDetails(String userEmail) {
        return tickets.get(userEmail);
    }

    // API to show users and seat allocated by section
    public Map<String, String> getUserSeatsBySection(String section) {
        Map<String, String> userSeats = new HashMap<>();
        for (TrainTicket ticket : tickets.values()) {
            if (ticket.getSeatSection().equals(section)) {
                userSeats.put(ticket.getUserEmail(), ticket.getSeatSection());
            }
        }
        return userSeats;
    }

    // API to remove user
    public void removeUser(String userEmail) {
        tickets.remove(userEmail);
    }

    // API to modify seat
    public void modifyUserSeat(String userEmail, String newSeatSection) {
        if (tickets.containsKey(userEmail)) {
            tickets.get(userEmail).setSeatSection(newSeatSection);
        }
    }
}
