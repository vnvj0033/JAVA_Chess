package util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringUtilTest {
    @Test
    void testNewLine() {
        Assertions.assertEquals(System.lineSeparator(), StringUtil.NEW_LINE);
    }
}
