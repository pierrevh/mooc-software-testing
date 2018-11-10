package tudelft.ghappy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class GHappyTest {
    @Test
    void oneGeeIsUnhappy() {
        GHappy gHappy = new GHappy();
        assertFalse(gHappy.gHappy("g"));
    }
}
