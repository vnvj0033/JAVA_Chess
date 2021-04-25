import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class BlowsUpTest {

    @Test
    void testException() {
        try {
            blowsUp();
            fail();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    void blowsUp() {
        throw new RuntimeException("Somebody showld catch this!");
    }
}
