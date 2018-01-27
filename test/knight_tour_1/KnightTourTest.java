package knight_tour_1;

import org.junit.jupiter.api.Assertions;
import utils.MainIO;

public class KnightTourTest {
    @org.junit.jupiter.api.Test
    void test1() {
        String input = "2";
        MainIO mainIO = new MainIO("");
        KnightTour.main(new String[] {input});
        Assertions.assertEquals("NO", mainIO.getOutput().toString());
    }

    @org.junit.jupiter.api.Test
    void test2() {
        String input = "8";
        MainIO mainIO = new MainIO("");
        KnightTour.main(new String[] {input});
        Assertions.assertEquals("YES", mainIO.getOutput().toString());
    }
}