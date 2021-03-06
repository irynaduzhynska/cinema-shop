package cinema.service;

import com.cinema.model.User;

import java.util.Optional;

public interface UserService {
    User add(User user);

    Optional<User> findByEmail(String email);

    User get(Long userId);
}
