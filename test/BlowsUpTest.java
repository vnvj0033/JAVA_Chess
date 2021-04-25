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

    @Test
    void testReThrows() {
        try {
            reThrows();
        } catch (Exception e) {
            System.out.println(e.getCause().getMessage());
        }
    }

    private void reThrows() {
        try {
            blowsUp();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    void blowsUp() {
        throw new RuntimeException("Somebody showld catch this!");
    }
}
