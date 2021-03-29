package cinema.mapper;

import com.cinema.model.ShoppingCart;
import com.cinema.model.dto.ShoppingCartResponseDto;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ShoppingCartMapper {
    private final TicketMapper mapper;

    public ShoppingCartMapper(TicketMapper mapper) {
        this.mapper = mapper;
    }

    public ShoppingCartResponseDto fromEntityToDto(ShoppingCart cart) {
        ShoppingCartResponseDto cartResponseDto = new ShoppingCartResponseDto();
        cartResponseDto.setUserId(cart.getUser().getId());
        cartResponseDto.setTickets(cart.getTickets()
                .stream()
                .map(mapper::fromEntityToDto)
                .collect(Collectors.toList()));
        return cartResponseDto;
    }
}
