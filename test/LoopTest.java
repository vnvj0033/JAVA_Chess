import org.junit.jupiter.api.Test;

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
        int n = 12;
        StringBuilder builder = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            if (i != 1) builder.append(" ");
            builder.append(i);
            if (i % 5 != 0)
                continue;
            builder.append("*");
        }

        System.out.println(builder.toString());
    }
}
