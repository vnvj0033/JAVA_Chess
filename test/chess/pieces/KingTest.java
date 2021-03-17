package chess.pieces;

import org.junit.jupiter.api.Test;
import util.StringUtil;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KingTest {

    @Test
    void testMovePiece() {
        Piece king = King.createBlack();

        int[][] moves = king.getPossibleMoves('b', 4);


        StringBuilder builder = new StringBuilder();
        builder.append(StringUtil.appendNewLine("4, 1"));
        builder.append(StringUtil.appendNewLine("3, 2"));
        builder.append(StringUtil.appendNewLine("2, 1"));
        builder.append(StringUtil.appendNewLine("3, 0"));
        builder.append(StringUtil.appendNewLine("4, 2"));
        builder.append(StringUtil.appendNewLine("2, 2"));
        builder.append(StringUtil.appendNewLine("2, 0"));
        builder.append(StringUtil.appendNewLine("4, 0"));

        StringBuilder result = new StringBuilder();

        for (int[] move : moves) {
            result.append(StringUtil.appendNewLine(move[0] + ", " + move[1]));
        }

        assertEquals(result.toString(), builder.toString());
    }
}