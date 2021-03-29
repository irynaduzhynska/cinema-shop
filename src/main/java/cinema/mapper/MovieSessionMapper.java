package cinema.mapper;

import com.cinema.model.CinemaHall;
import com.cinema.model.Movie;
import com.cinema.model.MovieSession;
import com.cinema.model.dto.session.MovieSessionRequestDto;
import com.cinema.model.dto.session.MovieSessionResponseDto;
import com.cinema.service.CinemaHallService;
import com.cinema.service.MovieService;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MovieSessionMapper {
    private final MovieService movieService;
    private final CinemaHallService cinemaHallService;

    public MovieSessionMapper(MovieService movieService, CinemaHallService cinemaHallService) {
        this.movieService = movieService;
        this.cinemaHallService = cinemaHallService;
    }

    public MovieSession mapFromReqDtoToEntity(MovieSessionRequestDto dto) {
        CinemaHall cinemaHall = cinemaHallService.get(dto.getCinemaHallId());
        Movie movie = movieService.get(dto.getMovieId());
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movie);
        movieSession.setCinemaHall(cinemaHall);
        movieSession.setShowTime(LocalDateTime.parse(dto.getShowTime()));
        return movieSession;
    }

    public MovieSessionResponseDto mapToRespDto(MovieSession entity) {
        MovieSessionResponseDto responseDto = new MovieSessionResponseDto();
        responseDto.setCinemaHallId(entity.getCinemaHall().getId());
        responseDto.setMovieId(entity.getMovie().getId());
        responseDto.setMovieTitle(entity.getMovie().getTitle());
        responseDto.setShowTime(entity.getShowTime().toString());
        responseDto.setMovieSessionId(entity.getId());
        return responseDto;
    }
}
