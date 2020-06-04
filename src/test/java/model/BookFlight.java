package model;

public class BookFlight {

    private String fromWay;
    private String toWay;
    private String departureDate;
    private String returnDate;
    private String passangers;

    public BookFlight(String from, String to, String departureDate, String returnDate){
        this.fromWay = from;
        this.toWay= to;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
    }

    public void setFromWay(String data){
        this.fromWay = data;
    }
    public void setToWay(String data){
        this.toWay = data;
    }
    public void setDepartureDate(String data){
        this.departureDate = data;
    }
    public void setReturnDate(String data){
        this.returnDate = data;
    }


}
