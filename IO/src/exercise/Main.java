package exercise;

import exercise.solution.User;
import exercise.solution.file.FileUserRepository;

import java.util.List;
import java.util.Set;

public class Main {

    // Change to a path that exists on your machine
    public static final String STORAGE_FILE = "users.txt";

    public static void main(String[] args) {
        final var userRepository = new FileUserRepository(STORAGE_FILE);

//        saveAllExample(userRepository);

//        findAllExample(userRepository);

//        saveExample(userRepository);

//        findByUsernameExample(userRepository);

//        findByUsernameExampleNotFound(userRepository);

//        saveExisting(userRepository);
    }

    private static void saveAllExample(UserRepository userRepository) {
        final var users = List.of(new User("alice"), new User("bob"));
        userRepository.save(users);
    }

    private static void findAllExample(UserRepository userRepository) {
        final var users = userRepository.findAll();
        System.out.println("All users: " + users);
    }

    private static void saveExample(UserRepository userRepository) {
        final var user = new User("joe", Set.of("alice", "bob"));
        userRepository.save(user);
    }

    private static void findByUsernameExample(UserRepository userRepository) {
        final var maybeUser = userRepository.findByUsername("joe");
        maybeUser.ifPresentOrElse(user -> System.out.println(user.username() + " friends: " + user.friends()), () -> System.out.println("User 'joe' not found"));
    }

    private static void findByUsernameExampleNotFound(UserRepository userRepository) {
        final var nonExistingUser = userRepository.findByUsername("frank");
        if (nonExistingUser.isEmpty()) {
            System.out.println("User 'frank' not found");
        }
    }

    private static void saveExisting(UserRepository userRepository) {
        final var maybeUser = userRepository.findByUsername("joe");
        maybeUser.ifPresent(user -> {
            user.removeFriend("alice");
            userRepository.save(user);
        });

    }
}
