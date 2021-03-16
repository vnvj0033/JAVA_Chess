package chess;

import chess.Game;
import chess.pieces.Piece;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {

    @Test
    void testTotalScore(){
        Game game = new Game();

        game.getBoard().addPicec('a', 4, Piece.createBlackQueen());
        assertEquals(game.totalScore(Piece.getBlack()), 9);

        game.getBoard().addPicec('c', 3, Piece.createBlackPawn());
        assertEquals(game.totalScore(Piece.getBlack()), 10);

        game.getBoard().addPicec('c', 2, Piece.createBlackPawn());
        assertEquals(game.totalScore(Piece.getBlack()), 10.5);
    }

    @Test
    void testPieceSort() {
        Game game = new Game();

        Piece pawn = Piece.createBlackPawn();
        Piece knight = Piece.createBlackKnight();
        Piece rook = Piece.createBlackRook();

        pawn.setForce(1);
        knight.setForce(2.5f);
        rook.setForce(5);

        game.getBoard().addPicec('a', 1, knight);
        game.getBoard().addPicec('a', 2, pawn);
        game.getBoard().addPicec('a', 3, rook);

        List<Piece> collection = game.sort(Piece.getBlack());

        assertEquals(collection.get(0).getRepresentation(), 'R');
        assertEquals(collection.get(1).getRepresentation(), 'N');
        assertEquals(collection.get(2).getRepresentation(), 'P');

    }
}
