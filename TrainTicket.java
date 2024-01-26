public class TrainTicket {
    private String from;
    private String to;
    private String userFirstName;
    private String userLastName;
    private String userEmail;
    private double pricePaid;
    private String seatSection;

    // getters
    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public double getPricePaid() {
        return pricePaid;
    }

    public String getSeatSection() {
        return seatSection;
    }

    //setters
    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setPricePaid(double pricePaid) {
        this.pricePaid = pricePaid;
    }

    public void setSeatSection(String seatSection) {
        this.seatSection = seatSection;
    }

}