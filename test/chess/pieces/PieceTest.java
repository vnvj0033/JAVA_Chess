package chess.pieces;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PieceTest {

    @Test
    void testCreate() {
        verifyCreation(Piece.createWhitePawn(), Piece.createBlackPawn(),
                Piece.Type.PAWN, Piece.PAWN_REPRESENTATION);
        verifyCreation(Piece.createWhiteRook(), Piece.createBlackRook(),
                Piece.Type.ROOK, Piece.ROOK_REPRESENTATION);
        verifyCreation(Piece.createWhiteKnight(), Piece.createBlackKnight(),
                Piece.Type.KNIGHT, Piece.KNIGHT_REPRESENTATION);
        verifyCreation(Piece.createWhiteBishop(), Piece.createBlackBishop(),
                Piece.Type.BISHOP, Piece.BISHOP_REPRESENTATION);
        verifyCreation(Piece.createWhiteQueen(), Piece.createBlackQueen(),
                Piece.Type.QUEEN, Piece.QUEEN_REPRESENTATION);
        verifyCreation(Piece.createWhiteKing(), Piece.createBlackKing(),
                Piece.Type.KING, Piece.KING_REPRESENTATION);
    }

    @Test
    void testPawnColor(){
        Piece whitePawn = Piece.createWhitePawn();
        assertEquals(whitePawn.toString(),"p");

        Piece blackPawn = Piece.createBlackPawn();
        assertEquals(blackPawn.toString(),"P");
    }

    @Test
    void testIncrementCount() {
        Piece.resetCount();
        Piece.createBlackPawn();
        assertEquals(1, Piece.blackCount);

        Piece.createWhitePawn();
        assertEquals(1, Piece.whiteCount);

        Piece.createBlackPawn();
        assertEquals(2, Piece.blackCount);
    }

    @Test
    void testIsColor() {
        Piece whitePawn = Piece.createWhitePawn();
        Piece blackPawn = Piece.createBlackPawn();

        assertTrue(whitePawn.isWhite());

        assertTrue(blackPawn.isBlack());
    }

    @Test
    void testSetForce() {
        Piece pawn = Piece.createWhitePawn();
        pawn.setForce(0.5f);

        assertEquals(pawn.getForce(), 0.5);
    }

    private void verifyCreation(Piece whitePiece, Piece blackPiece, Piece.Type type, char representation) {
        assertTrue(whitePiece.isWhite());
        assertEquals(type, whitePiece.getType());
        assertEquals(representation, whitePiece.getRepresentation());

        assertTrue(blackPiece.isBlack());
        assertEquals(type, blackPiece.getType());
        assertEquals(Character.toUpperCase(representation), blackPiece.getRepresentation());
    }
}