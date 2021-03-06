package cinema.dao;

import com.cinema.model.Movie;

import java.util.List;

public interface MovieDao {
    Movie add(Movie movie);

    List<Movie> getAll();

    Movie get(Long id);
}
