package cinema.dao;

import com.cinema.model.User;

import java.util.Optional;

public interface UserDao {
    User add(User user);

    Optional<User> findByEmail(String email);

    User get(Long id);
}
