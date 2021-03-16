package chess;

import chess.pieces.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.StringUtil;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
    private Board sut;

    @BeforeEach
    void setUp() {
        sut = new Board();
    }

    @Test
    void testCreate() {
        sut.initialize();
        assertEquals(32, sut.pieceCount());
        String blankRank = StringUtil.appendNewLine("........");

        StringBuilder builder = new StringBuilder();
        builder.append(StringUtil.appendNewLine("RNBQKBNR"));
        builder.append(StringUtil.appendNewLine("PPPPPPPP"));
        builder.append(blankRank);
        builder.append(blankRank);
        builder.append(blankRank);
        builder.append(blankRank);
        builder.append(StringUtil.appendNewLine("pppppppp"));
        builder.append(StringUtil.appendNewLine("rnbqkbnr"));
        assertEquals(builder.toString(), sut.print());
    }

    @Test
    void testCountType() {
        sut.initialize();
        assertEquals(sut.countType(Piece.getWhite(), Piece.Type.PAWN), 8);
        assertEquals(sut.countType(Piece.getWhite(), Piece.Type.KING), 1);
    }

    @Test
    void testPicecPosition() {
        sut.initialize();
        assertEquals(sut.getPositionPicec('a', 8).getRepresentation(), 'R');
        assertEquals(sut.getPositionPicec('e', 1).getRepresentation(), 'k');
    }

    @Test
    void testAddPicec() {
        assertNull(sut.getPositionPicec('a', 8));

        Piece piece = Piece.createBlackPawn();
        sut.addPicec('a', 8, piece);
    }

    @Test
    void testTotalScore(){
        sut.addPicec('a', 4, Piece.createBlackQueen());
        assertEquals(sut.totalScore(Piece.getBlack()), 9);

        sut.addPicec('c', 3, Piece.createBlackPawn());
        assertEquals(sut.totalScore(Piece.getBlack()), 10);

        sut.addPicec('c', 2, Piece.createBlackPawn());
        assertEquals(sut.totalScore(Piece.getBlack()), 10.5);
    }

    @Test
    void testPieceSort() {
        Piece pawn = Piece.createBlackPawn();
        Piece knight = Piece.createBlackKnight();
        Piece rook = Piece.createBlackRook();

        pawn.setForce(1);
        knight.setForce(2.5f);
        rook.setForce(5);

        sut.addPicec('a', 1, knight);
        sut.addPicec('a', 2, pawn);
        sut.addPicec('a', 3, rook);

        List<Piece> collection = sut.sort(Piece.getBlack());

        assertEquals(collection.get(0).getRepresentation(), 'R');
        assertEquals(collection.get(1).getRepresentation(), 'N');
        assertEquals(collection.get(2).getRepresentation(), 'P');

    }

    @Test
    void testMovePiece() {
        Piece king = Piece.createBlackKing();
        sut.addPicec('a', 4, king);

        sut.movePiece('a', 4, 'a', 5);

        assertNull(sut.getPositionPicec('a', 4));
        assertEquals(sut.getPositionPicec('a', 5).getRepresentation(), king.getRepresentation());
    }
}
