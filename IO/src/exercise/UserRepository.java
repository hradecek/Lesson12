package exercise;

import exercise.solution.User;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Repository responsible for manipulation and querying users.
 */
public interface UserRepository {

    /**
     * Saves the given user.
     *
     * <p>If user with the same username already exists, it is updated. Otherwise, new user is created.
     *
     * @param userToSave user to save
     */
    void save(User userToSave);

    /**
     * Saves the given users.
     *
     * <p>Existing users in the collection are updated, new users are created.
     *
     * @param usersToSave users to save
     */
    void save(Collection<User> usersToSave);

    /**
     * Retrieves all users.
     *
     * @return list of all users
     */
    List<User> findAll();

    /**
     * Retrieves user with the given {@code username}.
     *
     * @param username username
     * @return user with the given {@code username}
     */
    Optional<User> findByUsername(String username);
}
