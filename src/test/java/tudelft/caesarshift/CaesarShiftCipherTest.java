package tudelft.caesarshift;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CaesarShiftCipherTest {
    // TODO null msg == null ?? or exc

    @Test
    void noShiftYieldsSameMsg() {
        String msg = "abc";
        assertEquals(msg, CaesarShiftCipher.caesarShiftCipher(msg, 0));
        assertEquals(msg, CaesarShiftCipher.caesarShiftCipher(msg, 26));
        assertEquals(msg, CaesarShiftCipher.caesarShiftCipher(msg, 52));
    }

    @Test
    void shiftOne() {
        String msg = "abc";
        assertEquals("bcd", CaesarShiftCipher.caesarShiftCipher(msg, 1));
    }

    @Test
    void shiftOneAtBoundary() {
        String msg = "xyz";
        assertEquals("yza", CaesarShiftCipher.caesarShiftCipher(msg, 1));
    }

    @Test
    void invalidCharacters() {
        String msg = "jhgsdf)(*&%";
        assertEquals("invalid", CaesarShiftCipher.caesarShiftCipher(msg, 1));
    }

}
