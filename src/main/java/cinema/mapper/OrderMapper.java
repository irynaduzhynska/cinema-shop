package cinema.mapper;

import com.cinema.model.Order;
import com.cinema.model.dto.order.OrderResponseDto;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class OrderMapper {
    private final TicketMapper mapper;

    public OrderMapper(TicketMapper mapper) {
        this.mapper = mapper;
    }

    public OrderResponseDto fromEntityToDto(Order order) {
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setId(order.getId());
        orderResponseDto.setOrderCreationTime(order.getOrderDate());
        orderResponseDto.setUserId(order.getUser().getId());
        orderResponseDto.setTickets(order.getTickets().stream()
                .map(mapper::fromEntityToDto)
                .collect(Collectors.toList()));
        return orderResponseDto;
    }
}
