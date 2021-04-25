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

    @Test
    void testWithProblems() {
        try {
            doSomething();
        }catch (Exception success) {}
    }

    private void doSomething() throws Exception {
        throw new Exception("blah");
    }

    private void reThrows() {
        try {
            blowsUp();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    void blowsUp() {
        throw new SimpleException("Somebody showld catch this!");
    }

    class SimpleException extends RuntimeException{
        public SimpleException(String message) {
            super(message);
        }
    }
}
