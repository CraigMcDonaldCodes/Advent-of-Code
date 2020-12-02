import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Puzzle1 {

    private static final String FILE = "./input.txt";

    public static void main(String... args) throws Exception {

        Path path = Path.of(FILE);
        var lines = Files.readAllLines(path);
        var regexPattern = "(\\d+)-(\\d+) ([a-z]): (\\w+)";
        var pattern = Pattern.compile(regexPattern);
        int validPasswords = 0;

        for (var line : lines) {

            var matcher = pattern.matcher(line);
            matcher.find();

            // Skip if regex not a match
            if (matcher.groupCount() != 4) {
                continue;
            }

            // Not sure if I am making assumptions about the data
            int min = Integer.parseInt(matcher.group(1));
            int max = Integer.parseInt(matcher.group(2));
            char charToCount = matcher.group(3).charAt(0);
            String password = matcher.group(4);

            var count = password.chars()
                                .filter(c -> c == charToCount)
                                .count();

            if (count >= min && count <= max) {
                validPasswords++;
            }
        }

        System.out.printf("Valid passwords: %d\n", validPasswords);
    }
}
