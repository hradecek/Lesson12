package exercise.maybe;

import exercise.solution.User;

import java.util.Optional;

public class OptionalExplanation {

    public static void main(String[] args) {
        motivation();
        solution();

        final var optional = Optional.empty();
        System.out.println(optional.isPresent());
        System.out.println(optional.isEmpty());
        System.out.println(optional.orElse("default"));
    }

    public static void motivation() {
        // NullPointerException is often issue in Java
        // It is caused by calling method on null reference

        // We call method in order to retrieve user object
        // ... e.g. from database
        // but the user might not exist - in such case null is returned
        final User user = getUser("username");
        // We have to perform so-called null check, before calling any method on user object
        if (user != null) {
            System.out.println(user.username());
        }

        // What if we forget to perform null check?
        // Calling method on null reference causes NullPointerException
        System.out.println(user.username());

        // The issue is how to reasonably signalize that method returned no user (null is one way, but causes many bugs)
        // ... Java's Optional has been added
    }

    public static void solution() {
        final Optional<User> maybeUser = findUser("username");
        // We have retrieved the user, which might not exist
        // ... before we can call any method on user object, we have to check whether it exists
        if (maybeUser.isPresent()) {
            // Now we are sure that user exists
            final var user = maybeUser.get();
            System.out.println(user.username());
        }

        // What if we forget to perform present check?
        // System.out.println(maybeUser.username());
        // ... We cannot call method on Optional object, because it is not user object (using type system)
        // ... So we have to be aware that the value in the Optional might not be present
        System.out.println(maybeUser.get().username());
        // Yes, we still can call get() method on Optional object
        // ... but compiler (or linter) can warn us that we have not done presence check
    }

    public static User getUser(String username) {
        return null;
    }

    public static Optional<User> findUser(String username) {
        return Optional.empty();
    }
}
