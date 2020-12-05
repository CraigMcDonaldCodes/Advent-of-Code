import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;

public class Puzzle2 {

    private static final String FILE = "./input.txt";
    private static final char TREE = '#';

    public static void main(String... args) throws IOException {

        var path = Path.of(FILE);
        char[][] map = buildMap(path);

        System.out.printf(
            "Total Trees: %d\n",
            treeCount(map, 1, 1) *
            treeCount(map, 1, 3) *
            treeCount(map, 1, 5) *
            treeCount(map, 1, 7) *
            treeCount(map, 2, 1)
        );
    }

    private static long treeCount(char[][] map, int yIncrement, int xIncrement) {

        int posX = 0;
        int posY = 0;
        long treeCount = 0;

        for (int i = 0; i < map.length; i += yIncrement) {

            if (map[posY][posX] == TREE) {
                treeCount++;
            }

            posX += xIncrement;
            posY += yIncrement;
        }

        return treeCount;
    }

    private static char[][] buildMap(Path path) throws IOException {

        var lines = Files.readAllLines(path);
        var lineCount = lines.size();
        var lineLength = lines.get(0).length();

        // Totally made up value for how long the X value should extend
        // It just has to extend long enough for the search
        char[][] map = new char[lineCount][lineLength * 100];

        for (int i = 0; i < lineCount; i++) {
            map[i] = lines.get(i).repeat(100).toCharArray();
        }

        return map;
    }
}
