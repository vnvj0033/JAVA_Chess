package chess.pieces;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PieceTest {

    @Test
    void testCreate() {
        verifyCreation(Pawn.createWhite(), Pawn.createBlack(),
                Pawn.class, 'p');
        verifyCreation(Rook.createWhite(), Rook.createBlack(),
                Rook.class, 'r');
        verifyCreation(Knight.createWhite(), Knight.createBlack(),
                Knight.class, 'n');
        verifyCreation(Bishop.createWhite(), Bishop.createBlack(),
                Bishop.class, 'b');
        verifyCreation(Queen.createWhite(), Queen.createBlack(),
                Queen.class, 'q');
        verifyCreation(King.createWhite(), King.createBlack(),
                King.class, 'k');
    }

    @Test
    void testPawnColor(){
        Piece whitePawn = Pawn.createWhite();
        assertEquals(whitePawn.toString(),"p");

        Piece blackPawn = Pawn.createBlack();
        assertEquals(blackPawn.toString(),"P");
    }

    @Test
    void testIncrementCount() {
        Piece.resetCount();
        Pawn.createBlack();
        assertEquals(1, Piece.blackCount);

        Pawn.createWhite();
        assertEquals(1, Piece.whiteCount);

        Pawn.createBlack();
        assertEquals(2, Piece.blackCount);
    }

    @Test
    void testIsColor() {
        Piece whitePawn = Pawn.createWhite();
        Piece blackPawn = Pawn.createBlack();

        assertTrue(whitePawn.isWhite());

        assertTrue(blackPawn.isBlack());
    }

    @Test
    void testSetForce() {
        Piece pawn = Pawn.createWhite();
        pawn.setForce(0.5f);

        assertEquals(pawn.getForce(), 0.5);
    }

    private void verifyCreation(Piece whitePiece, Piece blackPiece, Class type, char representation) {
        assertTrue(whitePiece.isWhite());
        assertEquals(type, whitePiece.getClass());
        assertEquals(representation, whitePiece.getRepresentation());

        assertTrue(blackPiece.isBlack());
        assertEquals(type, blackPiece.getClass());
        assertEquals(Character.toUpperCase(representation), blackPiece.getRepresentation());
    }



//    @Test
//    void testMovePiece() {
//        Piece king = King.createBlack();
//
//        assertTrue(king.move('a', 4, 'a', 5));
//        assertTrue(king.move('a', 4, 'b', 4));
//
//        Piece queen = Queen.createBlack();
//
//        assertTrue(queen.move('a', 1, 'a', 8));
//        assertTrue(queen.move('a', 1, 'h', 1));
//        assertTrue(queen.move('a', 1, 'h', 8));
//    }
}