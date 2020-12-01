import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Puzzle1 {

    private static final int TO_FIND = 2020;
    private static final String FILE = "./input.txt";

    public static void main(String... args) throws Exception {

        Path path = Path.of(FILE);
        var data = Files.readAllLines(path)
                        .stream()
                        .mapToInt(Integer::valueOf)
                        .toArray();

        var numbers = new int[] { 0, 0 };

        for (int i = 0; i < data.length - 1; i++) {

            for (int k = i + 1; k < data.length; k++) {

                if (data[i] + data[k] == TO_FIND) {
                    numbers[0] = data[i];
                    numbers[1] = data[k];
                    break;
                }
            }
        }

        System.out.printf("Values are: %d and %d giving the answer of %d\n",
            numbers[0],
            numbers[1],
            numbers[0] * numbers[1]
        );
    }
}
