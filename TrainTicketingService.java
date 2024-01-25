import java.util.HashMap;
import java.util.Map;

public class TrainTicketingService {
    private TrainTicket t1;
    private TrainTicket t2;

    public void purchaseTicket(TrainTicket ticket) {
        if (t1 == null) {
            t1 = ticket;
        } else if (t2 == null) {
            t2 = ticket;
        } else {
            System.out.println("Train is booked, try later!");
        }
    }

    public TrainTicket getTicketDetails(String userEmail) {
        if (t1 != null && t1.getUserEmail().equals(userEmail)) {
            return t1;
        } else if (t2 != null && t2.getUserEmail().equals(userEmail)) {
            return t2;
        } else {
            return null;
        }
    }

    public Map<String, String> getUserSeatsBySection(String section) {
        Map<String, String> userSeats = new HashMap<>();
        if (t1 != null && t1.getSeatSection().equals(section)) {
            userSeats.put(t1.getUserEmail(), t1.getSeatSection());
        } else if (t2 != null && t2.getSeatSection().equals(section)) {
            userSeats.put(t2.getUserEmail(), t2.getSeatSection());
        }
        return userSeats;
    }

    public void removeUser(String userEmail) {
        if (t1 != null && t1.getUserEmail().equals(userEmail)) {
            t1 = null;
        } else if (t2 != null && t2.getUserEmail().equals(userEmail)) {
            t2 = null;
        }
    }

    public void modifyUserSeat(String userEmail, String newSeatSection) {
        if (t1 != null && t1.getUserEmail().equals(userEmail)) {
            t1.setSeatSection(newSeatSection);
        } else if (t2 != null && t2.getUserEmail().equals(userEmail)) {
            t2.setSeatSection(newSeatSection);
        }
    }
}
