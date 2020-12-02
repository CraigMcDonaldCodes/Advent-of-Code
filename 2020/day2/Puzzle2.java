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

            // Subtract 1 as input data not zero based
            int pos1 = Integer.parseInt(matcher.group(1)) - 1;
            int pos2 = Integer.parseInt(matcher.group(2)) - 1;

            char charToCheck = matcher.group(3).charAt(0);
            String password = matcher.group(4);
            int count = 0;

            if (password.charAt(pos1) == charToCheck) { count++; }
            if (password.charAt(pos2) == charToCheck) { count++; }

            if (count == 1) {
                validPasswords++;
            }
        }

        System.out.printf("Valid passwords: %d\n", validPasswords);
    }
}
