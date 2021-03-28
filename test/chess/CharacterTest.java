package chess;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class CharacterTest {

    @Test
    void testWhitespace() {
        assertTrue(Character.isWhitespace('\n'));
        assertTrue(Character.isWhitespace('\t'));
        assertTrue(Character.isWhitespace(' '));
    }

    @Test
    void testIdentifier() {
        assertFalse(Character.isJavaIdentifierPart('^'));
    }


}
