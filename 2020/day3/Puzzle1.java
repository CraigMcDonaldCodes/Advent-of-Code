import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;

public class Puzzle1 {

    private static final String FILE = "./input.txt";
    private static final char TREE = '#';
    private static final int xIncrement = 3;
    private static final int yIncrement = 1;

    public static void main(String... args) throws IOException {

        int posX = 0;
        int posY = 0;
        int treeCount = 0;
        var path = Path.of(FILE);
        char[][] map = buildMap(path);

        for (int i = 0; i < map.length; i++) {

            if (map[posY][posX] == TREE) {
                treeCount++;
            }

            posX += xIncrement;
            posY += yIncrement;
        }

        System.out.printf("Trees: %d\n", treeCount);
    }

    private static char[][] buildMap(Path path) throws IOException {

        var lines = Files.readAllLines(path);
        var lineCount = lines.size();
        var lineLength = lines.get(0).length();

        // Totally made up value for how long the X value should extend
        // It just has to extend long enough for the search
        char[][] map = new char[lineCount][lineLength * 50];

        for (int i = 0; i < lineCount; i++) {
            map[i] = lines.get(i).repeat(50).toCharArray();
        }

        return map;
    }
}
