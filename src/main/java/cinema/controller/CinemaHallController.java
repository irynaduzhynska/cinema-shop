package cinema.controller;

import com.cinema.model.CinemaHall;
import com.cinema.model.dto.hall.CinemaHallRequestDto;
import com.cinema.model.dto.hall.CinemaHallResponseDto;
import com.cinema.service.CinemaHallService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cinema-halls")
public class CinemaHallController {
    private final ModelMapper mapper;
    private final CinemaHallService cinemaHallService;

    public CinemaHallController(CinemaHallService cinemaHallService, ModelMapper mapper) {
        this.cinemaHallService = cinemaHallService;
        this.mapper = mapper;
    }

    @PostMapping
    public void add(@RequestBody CinemaHallRequestDto cinemaHallRequestDto) {
        cinemaHallService.add(mapper.map(cinemaHallRequestDto, CinemaHall.class));
    }

    @GetMapping
    public List<CinemaHallResponseDto> getAll() {
        return cinemaHallService.getAll().stream()
                .map(cinemaHall -> mapper.map(cinemaHall, CinemaHallResponseDto.class))
                .collect(Collectors.toList());
    }
}
