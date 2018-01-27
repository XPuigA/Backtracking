package rat_maze_1;

import org.junit.jupiter.api.Assertions;
import utils.MainIO;

public class RatMazeTest {

    @org.junit.jupiter.api.Test
    void test1() {
        String input = "2\n10\n01";
        MainIO mainIO = new MainIO(input);
        RatMaze.main(new String[0]);
        Assertions.assertEquals("NO", mainIO.getOutput().toString());
    }

    @org.junit.jupiter.api.Test
    void test2() {
        String input = "2\n11\n01";
        MainIO mainIO = new MainIO(input);
        RatMaze.main(new String[0]);
        Assertions.assertEquals("22\n02\n", mainIO.getOutput().toString());
    }

    @org.junit.jupiter.api.Test
    void test3() {
        String input = "4\n1000\n1101\n0100\n1111";
        MainIO mainIO = new MainIO(input);
        RatMaze.main(new String[0]);
        Assertions.assertEquals("2000\n2201\n0200\n1222\n", mainIO.getOutput().toString());
    }
}
