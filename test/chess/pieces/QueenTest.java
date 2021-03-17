package chess.pieces;

import org.junit.jupiter.api.Test;
import util.StringUtil;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QueenTest {

    @Test
    void testMovePiece() {
        Piece queen = Queen.createBlack();

        int[][] moves = queen.getPossibleMoves('a', 1);

        StringBuilder builder = new StringBuilder();
        builder.append(StringUtil.appendNewLine("1, 0"));
        builder.append(StringUtil.appendNewLine("2, 0"));
        builder.append(StringUtil.appendNewLine("3, 0"));
        builder.append(StringUtil.appendNewLine("4, 0"));
        builder.append(StringUtil.appendNewLine("5, 0"));
        builder.append(StringUtil.appendNewLine("6, 0"));
        builder.append(StringUtil.appendNewLine("7, 0"));
        builder.append(StringUtil.appendNewLine("0, 1"));
        builder.append(StringUtil.appendNewLine("0, 2"));
        builder.append(StringUtil.appendNewLine("0, 3"));
        builder.append(StringUtil.appendNewLine("0, 4"));
        builder.append(StringUtil.appendNewLine("0, 5"));
        builder.append(StringUtil.appendNewLine("0, 6"));
        builder.append(StringUtil.appendNewLine("0, 7"));
        builder.append(StringUtil.appendNewLine("1, 1"));
        builder.append(StringUtil.appendNewLine("2, 2"));
        builder.append(StringUtil.appendNewLine("3, 3"));
        builder.append(StringUtil.appendNewLine("4, 4"));
        builder.append(StringUtil.appendNewLine("5, 5"));
        builder.append(StringUtil.appendNewLine("6, 6"));
        builder.append(StringUtil.appendNewLine("7, 7"));

        StringBuilder result = new StringBuilder();

        for (int[] move : moves) {
            result.append(StringUtil.appendNewLine(move[0] + ", " + move[1]));
        }

        assertEquals(result.toString(), builder.toString());

    }
}