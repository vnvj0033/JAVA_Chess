package chess.pieces;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PieceTest {

    @Test
    void testCreate() {
        Piece pawn = Piece.createPawn(Piece.WHITE);
        assertEquals(pawn.getColor(), Piece.WHITE);

        Piece pawn2 = Piece.createPawn(Piece.BLACK);
        assertEquals(pawn2.getColor(), Piece.BLACK);

        verifyCreation(Piece.createPawn(Piece.WHITE), Piece.createPawn(Piece.BLACK),
                Piece.Type.PAWN, Piece.PAWN_REPRESENTATION);
        verifyCreation(Piece.createRook(Piece.WHITE), Piece.createRook(Piece.BLACK),
                Piece.Type.ROOK, Piece.ROOK_REPRESENTATION);
        verifyCreation(Piece.createKnight(Piece.WHITE), Piece.createKnight(Piece.BLACK),
                Piece.Type.KNIGHT, Piece.KNIGHT_REPRESENTATION);
        verifyCreation(Piece.createBishop(Piece.WHITE), Piece.createBishop(Piece.BLACK),
                Piece.Type.BISHOP, Piece.BISHOP_REPRESENTATION);
        verifyCreation(Piece.createQueen(Piece.WHITE), Piece.createQueen(Piece.BLACK),
                Piece.Type.QUEEN, Piece.QUEEN_REPRESENTATION);
        verifyCreation(Piece.createKing(Piece.WHITE), Piece.createKing(Piece.BLACK),
                Piece.Type.KING, Piece.KING_REPRESENTATION);
    }

    @Test
    void testPawnColor(){
        Piece whitePawn = Piece.createPawn(Piece.WHITE);
        assertEquals(whitePawn.toString(),"p");

        Piece blackPawn = Piece.createPawn(Piece.BLACK);
        assertEquals(blackPawn.toString(),"P");
    }

    @Test
    void testIncrementCount() {
        Piece.resetCount();
        Piece.createPawn(Piece.BLACK);
        assertEquals(1, Piece.blackCount);

        Piece.createPawn(Piece.WHITE);
        assertEquals(1, Piece.whiteCount);

        Piece.createPawn(Piece.BLACK);
        assertEquals(2, Piece.blackCount);
    }

    @Test
    void testIsColor() {
        Piece whitePawn = Piece.createPawn(Piece.WHITE);
        Piece blackPawn = Piece.createPawn(Piece.BLACK);

        assertEquals(true, whitePawn.isWhite());

        assertEquals(true, blackPawn.isBlack());
    }

    @Test
    void testSetForce() {
        Piece pawn = Piece.createPawn(Piece.WHITE);
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