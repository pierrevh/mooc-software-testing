package tudelft.ghappy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GHappyTest {
    private GHappy gHappy;
    @BeforeEach
    void setUp() {
        gHappy = new GHappy();
    }

    @Test
    void emptyInputIsHappy() {
        assertTrue(gHappy.gHappy(""));
    }

    @Test
    void oneGeeIsUnhappy() {
        assertFalse(gHappy.gHappy("g"));
    }

    @Test
    void twoGeesSideBySideAreHappy() {
        assertTrue(gHappy.gHappy("gg"));
        assertTrue(gHappy.gHappy("ggxxxx"));
        assertTrue(gHappy.gHappy("ggx"));
        assertTrue(gHappy.gHappy("xxxxxgg"));
        assertTrue(gHappy.gHappy("xgg"));
        assertTrue(gHappy.gHappy("xxggxx"));
        assertTrue(gHappy.gHappy("xxggxxggxxxggxggs"));
    }

    @Test
    void twoSeparatedGeesAreUnhappy() {
        assertFalse(gHappy.gHappy("gxg"));
        assertFalse(gHappy.gHappy("gxcg"));
        assertFalse(gHappy.gHappy("xgxg"));
        assertFalse(gHappy.gHappy("xgxgx"));
        assertFalse(gHappy.gHappy("dssadgxasdsdagasdasdas"));
    }

    @Test
    void anySeparatedGeesAreUnhappy() {
        assertFalse(gHappy.gHappy("gxgxg"));
        assertFalse(gHappy.gHappy("gxcgxg"));
        assertFalse(gHappy.gHappy("xgxgsg"));
        assertFalse(gHappy.gHappy("xgxgx"));
        assertFalse(gHappy.gHappy("dssgadgxasdgsdgagasdgasdgags"));
    }
}
