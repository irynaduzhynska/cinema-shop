package cinema.dao;

import com.cinema.model.Order;
import com.cinema.model.User;

import java.util.List;

public interface OrderDao {
    Order create(Order order);

    List<Order> getOrderHistory(User user);
}
