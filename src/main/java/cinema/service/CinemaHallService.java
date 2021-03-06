package cinema.service;

import com.cinema.model.CinemaHall;

import java.util.List;

public interface CinemaHallService {
    CinemaHall add(CinemaHall cinemaHall);
    
    List<CinemaHall> getAll();

    CinemaHall get(Long id);
}
