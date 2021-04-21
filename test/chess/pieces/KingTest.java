package chess.pieces;

import chess.Board;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class KingTest {
    private Board board = new Board();

    @Test
    void testKingMoveNotOnEdge() {
        Piece piece = King.createBlack();
        board.put("d3", piece);
        String[] moves = piece.getPossibleMoves("d3", board);

        assertTrue(Arrays.asList(moves).containsAll(Arrays.asList("c4", "d4", "e4", "c3", "e3", "c2", "d2", "e2")));
    }
}