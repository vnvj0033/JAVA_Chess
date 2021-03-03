package chess;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharacterTest {

    @Test
    void testWhitespace() {
        assertEquals(Character.isWhitespace('\n'), true);
        assertEquals(Character.isWhitespace('\t'), true);
        assertEquals(Character.isWhitespace(' '), true);
    }

    @Test
    void testIdentifier() {
        assertEquals(Character.isJavaIdentifierPart('^'), false);
    }


}
