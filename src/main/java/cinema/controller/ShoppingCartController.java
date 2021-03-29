package cinema.controller;

import com.cinema.mapper.ShoppingCartMapper;
import com.cinema.model.User;
import com.cinema.model.dto.ShoppingCartResponseDto;
import com.cinema.service.MovieSessionService;
import com.cinema.service.ShoppingCartService;
import com.cinema.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private final ShoppingCartService cartService;
    private final MovieSessionService sessionService;
    private final UserService userService;
    private final ShoppingCartMapper mapper;

    public ShoppingCartController(ShoppingCartService cartService,
                                  MovieSessionService sessionService,
                                  UserService userService, ShoppingCartMapper mapper) {
        this.cartService = cartService;
        this.sessionService = sessionService;
        this.userService = userService;
        this.mapper = mapper;
    }

    @PostMapping("/movie-sessions")
    public void addMovieSession(@RequestParam Long movieSessionId,
                                Authentication authentication) {
        UserDetails principal = (UserDetails) authentication.getPrincipal();
        User user = userService.findByEmail(principal.getUsername()).get();
        cartService.addSession(sessionService.get(movieSessionId),
                user);
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getByUserId(Authentication authentication) {
        UserDetails principal = (UserDetails) authentication.getPrincipal();
        return mapper.fromEntityToDto(cartService
                .getByUser(userService
                        .findByEmail(principal.getUsername())
                        .get()));
    }
}
