import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum Direction {
    NORTH, EAST, SOUTH, WEST, UP, DOWN;

    // Cache lookup map on initialization
    private static final Map<String, Direction> LOOKUP_MAP = Arrays.stream(values())
            .collect(Collectors.toMap(
                    status -> status.name().toLowerCase(),
                    Function.identity()
            ));

    // Case-insensitive lookup method
    public static Optional<Direction> fromString(String value) {
        if (value == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(LOOKUP_MAP.get(value.toLowerCase()));
    }
}
