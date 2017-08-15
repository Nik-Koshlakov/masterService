package masterService.service;

import masterService.Constants;
import masterService.domain.*;
import masterService.domain.fromTo.InformationAboutSession;
import masterService.domain.fromTo.User;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Nik on 26.06.2017.
 */
public class ResponseServiceDB {

    public static Collection<Film> getFilms() {
        try {
            SimpleClientHttpRequestFactory s = new SimpleClientHttpRequestFactory();
            s.setReadTimeout(6000); s.setConnectTimeout(1500);

            RestTemplate restTemplate = new RestTemplate(s);
            ResponseEntity<List<Film>> entity = restTemplate.exchange(
                    Constants.GET_FILMS,
                    HttpMethod.GET, null, new ParameterizedTypeReference<List<Film>>() {}
            );
            if (entity.getStatusCode() != HttpStatus.OK)
                System.out.println("Server answered wrong or maybe he broke");

            return entity.getBody();
        } catch (ResourceAccessException exception) {
            System.out.println("Server is`t available");
        }

        return null;
    }

    public static boolean saveUser(User user) {
        return user(user, Constants.SET_USER);
    }
    public static boolean getUser(User user) {
        return user(user, Constants.GET_USER);
    }
    private static boolean user(User user, String query) {
        try {
            SimpleClientHttpRequestFactory s = new SimpleClientHttpRequestFactory();
            s.setReadTimeout(6000); s.setConnectTimeout(1500);

            RestTemplate restTemplate = new RestTemplate(s);

            HttpEntity<User> httpEntity = new HttpEntity<User>(user, new HttpHeaders());

            ResponseEntity<Boolean> response = restTemplate.exchange(
                    query,
                    HttpMethod.POST,
                    httpEntity,
                    new ParameterizedTypeReference<Boolean>() {}
            );

            if (response.getStatusCode() != HttpStatus.OK)
                System.out.println("Server answered wrong or maybe he broke");

            return response.getBody();
        } catch (ResourceAccessException exception) {
            System.out.println("Server is`t available");
        }

        return false;
    }

    public static Collection<Film> getCinemas() {
        try {
            SimpleClientHttpRequestFactory s = new SimpleClientHttpRequestFactory();
            s.setReadTimeout(6000); s.setConnectTimeout(1500);

            RestTemplate restTemplate = new RestTemplate(s);
            ResponseEntity<List<Film>> entity = restTemplate.exchange(
                    Constants.GET_CINEMAS,
                    HttpMethod.GET, null, new ParameterizedTypeReference<List<Film>>() {}
            );

            if (entity.getStatusCode() != HttpStatus.OK)
                System.out.println("Server answered wrong or maybe he broke");

            return entity.getBody();
        } catch (ResourceAccessException exception) {
            System.out.println("Server is`t available");
        }

        return null;
    }

    public static Collection<Show> getShowsForFilmCinema(String filmName, String cinemaName) {
        try {
            Map<String, String> uriParam = new HashMap<String, String>();
            uriParam.put("filmName", filmName);
            uriParam.put("cinemaName", cinemaName);

            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(Constants.GET_SHOWS_FOR_FILMCINEMA);

            SimpleClientHttpRequestFactory s = new SimpleClientHttpRequestFactory();
            s.setReadTimeout(6000); s.setConnectTimeout(1500);

            RestTemplate restTemplate = new RestTemplate(s);
            ResponseEntity<List<Show>> entity = restTemplate.exchange(
                    builder.buildAndExpand(uriParam).toUri().toString(),
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<Show>>() {}
            );

            if (entity.getStatusCode() != HttpStatus.OK)
                System.out.println("Server answered wrong or maybe he broke");

            return entity.getBody();
        } catch (ResourceAccessException exception) {
            System.out.println("Server is`t available");
        }

        return null;
    }

    public static Collection<Film> getCinemasByFilm(String filmName) {
        try {
            Map<String, String> uriParam = new HashMap<String, String>();
            uriParam.put("filmName", filmName);

            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(Constants.GET_CINEMAS_BY_FILM);

            SimpleClientHttpRequestFactory s = new SimpleClientHttpRequestFactory();
            s.setReadTimeout(6000); s.setConnectTimeout(1500);

            RestTemplate restTemplate = new RestTemplate(s);
            ResponseEntity<List<Film>> entity = restTemplate.exchange(
                    builder.buildAndExpand(uriParam).toUri().toString(),
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<Film>>() {}
            );

            if (entity.getStatusCode() != HttpStatus.OK)
                System.out.println("Server answered wrong or maybe he broke");

            return entity.getBody();
        } catch (ResourceAccessException exception) {
            System.out.println("Server is`t available");
        }

        return null;
    }

    public static Collection<Reserve> setReserve(InformationAboutSession aboutSessions) {
        try {
            SimpleClientHttpRequestFactory s = new SimpleClientHttpRequestFactory();
            s.setReadTimeout(6000); s.setConnectTimeout(1500);

            RestTemplate restTemplate = new RestTemplate(s);

            HttpEntity<InformationAboutSession> httpEntity =
                    new HttpEntity<InformationAboutSession>(aboutSessions, new HttpHeaders());

            ResponseEntity<List<Reserve>> response = restTemplate.exchange(
                    Constants.SET_RESERVE,
                    HttpMethod.POST,
                    httpEntity,
                    new ParameterizedTypeReference<List<Reserve>>() {}
            );

            if (response.getStatusCode() != HttpStatus.OK)
                System.out.println("Server answered wrong or maybe he broke");

            return response.getBody();
        } catch (ResourceAccessException exception) {
            System.out.println("Server is`t available");
        }

        return null;
    }

    public static Collection<Ticket> getBougthTickets(String filmName, String cinemaName, int room_id) {
        try {
            Map<String, Object> uriParam = new HashMap<String, Object>();
            uriParam.put("filmName", filmName);
            uriParam.put("cinemaName", cinemaName);
            uriParam.put("room_id", room_id);

            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(Constants.GET_BOUGTH_TICKETS);

            SimpleClientHttpRequestFactory s = new SimpleClientHttpRequestFactory();
            s.setReadTimeout(6000); s.setConnectTimeout(1500);

            RestTemplate restTemplate = new RestTemplate(s);
            ResponseEntity<List<Ticket>> entity = restTemplate.exchange(
                    builder.buildAndExpand(uriParam).toUri().toString(),
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<Ticket>>() {}
            );

            if (entity.getStatusCode() != HttpStatus.OK)
                System.out.println("Server answered wrong or maybe he broke");

            return entity.getBody();
        } catch (ResourceAccessException exception) {
            System.out.println("Server is`t available");
        }

        return null;
    }

    public static Collection<Ticket> getBougthTickets(int show_id) {
        try {
            Map<String, Object> uriParam = new HashMap<String, Object>();
            uriParam.put("show_id", show_id);

            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(Constants.GET_BOUGTH_TICKETS_BY_SHOW_ID);

            SimpleClientHttpRequestFactory s = new SimpleClientHttpRequestFactory();
            s.setReadTimeout(6000); s.setConnectTimeout(1500);

            RestTemplate restTemplate = new RestTemplate(s);
            ResponseEntity<List<Ticket>> entity = restTemplate.exchange(
                    builder.buildAndExpand(uriParam).toUri().toString(),
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<Ticket>>() {}
            );

            if (entity.getStatusCode() != HttpStatus.OK)
                System.out.println("Server answered wrong or maybe he broke");

            return entity.getBody();
        } catch (ResourceAccessException exception) {
            System.out.println("Server is`t available");
        }

        return null;
    }

    public static Room getMaxPositionOfRoom(int room_id) {
        try {
            Map<String, Integer> uriParam = new HashMap<String, Integer>();
            uriParam.put("room_id", room_id);

            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(Constants.GET_MAX_POSITION_ROOM);

            SimpleClientHttpRequestFactory s = new SimpleClientHttpRequestFactory();
            s.setReadTimeout(6000); s.setConnectTimeout(1500);

            RestTemplate restTemplate = new RestTemplate(s);
            ResponseEntity<Room> entity = restTemplate.exchange(
                    builder.buildAndExpand(uriParam).toUri(),
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<Room>() {}
            );

            if (entity.getStatusCode() != HttpStatus.OK)
                System.out.println("Server answered wrong or maybe he broke");

            return entity.getBody();
        } catch (ResourceAccessException exception) {
            System.out.println("Server is`t available");
        }

        return null;
    }
}
