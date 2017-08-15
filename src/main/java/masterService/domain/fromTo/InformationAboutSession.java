package masterService.domain.fromTo;

import java.util.Date;
import java.util.List;

/**
 * Created by Nik on 26.06.2017.
 */
public class InformationAboutSession {
    private String visitorName;
    private String film_name;
    private String film_nameCinema;
    private Integer room_id;
    private Date show_time;
    private Integer show_id;
    private List<Integer> pricesOfTickets;
    private List<Integer> ticket_row;
    private List<Integer> ticket_place;
    private String visitorEmail;

    public InformationAboutSession() {
    }

    public InformationAboutSession(InformationAboutSession session) {
    }

    public InformationAboutSession(String visitorName, String film_name, String film_nameCinema,
                                   Integer room_id, Date show_time, Integer show_id,
                                   List<Integer> pricesOfTickets, List<Integer> ticket_row,
                                   List<Integer> ticket_place, String visitorEmail) {
        this.visitorName = visitorName;
        this.film_name = film_name;
        this.film_nameCinema = film_nameCinema;
        this.room_id = room_id;
        this.show_time = show_time;
        this.show_id = show_id;
        this.pricesOfTickets = pricesOfTickets;
        this.ticket_row = ticket_row;
        this.ticket_place = ticket_place;
        this.visitorEmail = visitorEmail;
    }

    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    public String getFilm_name() {
        return film_name;
    }

    public void setFilm_name(String film_name) {
        this.film_name = film_name;
    }

    public String getFilm_nameCinema() {
        return film_nameCinema;
    }

    public void setFilm_nameCinema(String film_nameCinema) {
        this.film_nameCinema = film_nameCinema;
    }

    public Integer getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Integer room_id) {
        this.room_id = room_id;
    }

    public Date getShow_time() {
        return show_time;
    }

    public void setShow_time(Date show_time) {
        this.show_time = show_time;
    }

    public Integer getShow_id() {
        return show_id;
    }

    public void setShow_id(Integer show_id) {
        this.show_id = show_id;
    }

    public List<Integer> getPricesOfTickets() {
        return pricesOfTickets;
    }

    public void setPricesOfTickets(List<Integer> pricesOfTickets) {
        this.pricesOfTickets = pricesOfTickets;
    }

    public List<Integer> getTicket_row() {
        return ticket_row;
    }

    public void setTicket_row(List<Integer> ticket_row) {
        this.ticket_row = ticket_row;
    }

    public List<Integer> getTicket_place() {
        return ticket_place;
    }

    public void setTicket_place(List<Integer> ticket_place) {
        this.ticket_place = ticket_place;
    }

    public String getVisitorEmail() {
        return visitorEmail;
    }

    @Override
    public String toString() {
        return "InformationAboutSession{" +
                "visitorName='" + visitorName + '\'' +
                ", film_name='" + film_name + '\'' +
                ", film_nameCinema='" + film_nameCinema + '\'' +
                ", room_id=" + room_id +
                ", show_time=" + show_time +
                ", show_id=" + show_id +
                ", pricesOfTickets=" + pricesOfTickets +
                ", ticket_row=" + ticket_row +
                ", ticket_place=" + ticket_place +
                ", visitorEmail='" + visitorEmail + '\'' +
                '}';
    }

    public void setVisitorEmail(String visitorEmail) {
        this.visitorEmail = visitorEmail;


    }
}
