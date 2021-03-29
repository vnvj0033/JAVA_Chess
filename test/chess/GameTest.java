package chess;

import chess.pieces.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {

    @Test
    void testTotalScore(){
        Game game = new Game();

        game.getBoard().addPiece(4,'a', Queen.createBlack());
        assertEquals(game.totalScore(Piece.getBlack()), 9);

        game.getBoard().addPiece(3, 'c', Pawn.createBlack());
        assertEquals(game.totalScore(Piece.getBlack()), 10);

        game.getBoard().addPiece(2, 'c', Pawn.createBlack());
        assertEquals(game.totalScore(Piece.getBlack()), 10.5);
    }

    @Test
    void testPieceSort() {
        Game game = new Game();

        Piece pawn = Pawn.createBlack();
        Piece knight = Knight.createBlack();
        Piece rook = Rook.createBlack();

        pawn.setForce(1);
        knight.setForce(2.5f);
        rook.setForce(5);

        game.getBoard().addPiece(1,'a', knight);
        game.getBoard().addPiece(2,'a', pawn);
        game.getBoard().addPiece(3, 'a', rook);

        List<Piece> collection = game.sort(Piece.getBlack());

        assertEquals(collection.get(0).getRepresentation(), 'R');
        assertEquals(collection.get(1).getRepresentation(), 'N');
        assertEquals(collection.get(2).getRepresentation(), 'P');

    }
}
