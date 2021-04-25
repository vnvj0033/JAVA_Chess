import org.junit.jupiter.api.Test;

public class BlowsUpTest {

    @Test
    void testException() {
        blowsUp();
    }

    void blowsUp() {throw new RuntimeException("Somebody showld catch this!");}
}
