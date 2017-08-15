package masterService;

/**
 * Created by Nik on 26.06.2017.
 */
public interface Constants {
    public static final String GET_FILMS = "http://localhost:8084/getFilms";
    public static final String GET_CINEMAS = "http://localhost:8084/getCinemas";
    public static final String GET_CINEMAS_BY_FILM = "http://localhost:8084/getCinemasByFilm/{filmName}";
    public static final String SET_RESERVE = "http://localhost:8084/setReserve";
    public static final String SET_USER = "http://localhost:8084/saveUser";
    public static final String GET_USER = "http://localhost:8084/getUser";
    public static final String GET_MAX_POSITION_ROOM = "http://localhost:8084/getMaxPositionRoom={room_id}";
    public static final String GET_BOUGTH_TICKETS = "http://localhost:8084/getBougthTickets/{filmName}/{cinemaName}/{room_id}";
    public static final String GET_BOUGTH_TICKETS_BY_SHOW_ID = "http://localhost:8084/getBougthTickets/{show_id}";
    public static final String GET_SHOWS_FOR_FILMCINEMA = "http://localhost:8084/getShowsForFilmCinema/{filmName}/{cinemaName}";
}
