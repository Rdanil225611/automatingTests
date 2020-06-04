package model;

public class UserWithTicket {

    private String ticketId;
    private String userLastName;

    public UserWithTicket(String ticketId, String lastName) {
        this.ticketId = ticketId;
        this.userLastName = lastName;
    }

    public void setTicketId(String id) {
        this.ticketId = id;
    }
    public void setUserLastName(String data) {
        this.userLastName = data;
    }

    public String getTicketId(){
        return  this.ticketId;
    }
    public String getUserLastName() {
        return  this.userLastName;
    }

}
