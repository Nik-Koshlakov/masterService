package masterService.web;

import masterService.domain.*;
import masterService.domain.fromTo.InformationAboutSession;
import masterService.domain.fromTo.User;
import masterService.service.ResponseServiceDB;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.List;

/**
 * Created by Nik on 18.06.2017.
 */
@RestController
@RequestMapping("/db")
public class DBController {

    @RequestMapping(value = "/getFilms", method = RequestMethod.GET)//produces = "text/plain" "application/json")
    public @ResponseBody List<Film> getFilms(HttpServletResponse response) {
        List<Film> f = (List)ResponseServiceDB.getFilms();
        System.out.println(f);
        return f;
    }

    @RequestMapping(value = "/getCinemas", method = RequestMethod.GET)
    public @ResponseBody Collection<Film> getCinemas() {
        return ResponseServiceDB.getCinemas();
    }

    @RequestMapping(value = "/getCinemasByFilm/{filmName}", method = RequestMethod.GET)
    public @ResponseBody Collection<Film> getCinemasByFilm(@PathVariable String filmName) {
        return ResponseServiceDB.getCinemasByFilm(filmName);
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public boolean saveUser(@RequestBody User user) {
        return ResponseServiceDB.saveUser(user);
    }

    @RequestMapping(value = "/getUser", method = RequestMethod.POST)
    public boolean getUser(@RequestBody User user) {
        return ResponseServiceDB.getUser(user);
    }

    @RequestMapping(value = "/setReserve", method = RequestMethod.POST)
    public @ResponseBody Collection<Reserve> setReserve(@RequestBody InformationAboutSession aboutSessions) {
        return ResponseServiceDB.setReserve(aboutSessions);
    }

    @RequestMapping(value = "/getShowsForFilmCinema/{filmName}/{cinemaName}", method = RequestMethod.GET)
    public @ResponseBody Collection<Show> getShowsForFilm(@PathVariable String filmName, @PathVariable String cinemaName) {
        return ResponseServiceDB.getShowsForFilmCinema(filmName, cinemaName);
    }

    @RequestMapping(value = "/getBougthTickets/{filmName}/{cinemaName}/{room_id}", method = RequestMethod.GET)
    public @ResponseBody Collection<Ticket> getBougthTickets(@PathVariable String filmName,
                                               @PathVariable String cinemaName, @PathVariable int room_id) {
        return ResponseServiceDB.getBougthTickets(filmName, cinemaName, room_id);
    }

    @RequestMapping(value = "/getBougthTickets/{show_id}", method = RequestMethod.GET)
    public @ResponseBody Collection<Ticket> getBougthTickets(@PathVariable int show_id) {
        return ResponseServiceDB.getBougthTickets(show_id);
    }

    @RequestMapping(value = "/getMaxPositionRoom/{room_id}", method = RequestMethod.GET)
    public @ResponseBody Room getMaxPositionOfRoom(@PathVariable int room_id) {
        return ResponseServiceDB.getMaxPositionOfRoom(room_id);
    }
}
