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
            fail();
        }catch (Exception success) {
            reversStackTrace(success);
        }
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

    void reversStackTrace(Exception e) {
        StringBuilder builder = new StringBuilder();
        StackTraceElement[] stackTrace = e.getStackTrace();
        for (int i = stackTrace.length-1; i >= 0; i--) {
            builder.append(stackTrace[i].toString());
            builder.append(System.lineSeparator());
        }
        System.out.println(builder.toString());
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
