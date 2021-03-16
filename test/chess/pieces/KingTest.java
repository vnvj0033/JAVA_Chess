package chess.pieces;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KingTest {

    @Test
    void testMovePiece() {
        Piece king = King.createBlack();

        int[][] moves = king.getPossibleMoves('a', 4);
        for (int[] move : moves){
            System.out.println(move[0] + ", " + move[1]);
        }
    }
}