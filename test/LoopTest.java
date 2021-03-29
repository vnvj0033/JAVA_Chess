import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoopTest {
    @Test
    void testFactoriarWhile() {
        int n = 5;
        int result = 1;

        while (n > 0)
            result *= n--;

        assertEquals(result, 120);
    }

    @Test
    void testFactoriarFor() {
        int n = 5;
        int result = 1;

        for (int i = 1; i <= n; i++)
            result *= i;

        assertEquals(result, 120);
    }

    @Test
    void testFactoriarDoWhile() {
        int n = 5;
        int result = 1;

        do result *= n--;
        while (n > 0);

        assertEquals(result, 120);
    }

    @Test
    void testFactoriarWhileBreak() {
        int n = 5;
        int result = 1;

        while (true) {
            result *= n--;
            if (n < 1) break;
        }

        assertEquals(result, 120);
    }

    @Test
    void testContinue() {
        System.out.println(fiveCountAddStar(12));
    }

    @Test
    void testVector() {
        StringBuilder builder = new StringBuilder();
        List<String> vector = new Vector<>(Arrays.asList(fiveCountAddStar(12).split(" ")));

        for (int i = 0; i < vector.size(); i++){
            if (i != 0) builder.append(" ");
            builder.append(vector.get(i));
        }

        System.out.println(builder.toString());
    }

    String fiveCountAddStar(int n) {
        StringBuilder builder = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            if (i != 1) builder.append(" ");
            builder.append(i);
            if (i % 5 != 0)
                continue;
            builder.append("*");
        }
        return builder.toString();
    }
}
