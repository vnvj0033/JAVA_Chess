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
        assertEquals(sut.countType(Piece.WHITE, Piece.Type.PAWN), 8);
        assertEquals(sut.countType(Piece.WHITE, Piece.Type.KING), 1);
    }

    @Test
    void testPicecPosition() {
        sut.initialize();
        assertEquals(sut.getPositionPicec(8, 'a').getRepresentation(), 'R');
        assertEquals(sut.getPositionPicec(1, 'e').getRepresentation(), 'k');
    }

    @Test
    void testAddPicec() {
        assertNull(sut.getPositionPicec(8, 'a'));

        Piece piece = Piece.createPawn(Piece.BLACK);
        sut.addPicec(8, 'a', piece);
    }

    @Test
    void testTotalScore(){
        sut.addPicec(4, 'a', Piece.createQueen(Piece.BLACK));
        assertEquals(sut.totalScore(Piece.BLACK), 9);

        sut.addPicec(3, 'c', Piece.createPawn(Piece.BLACK));
        assertEquals(sut.totalScore(Piece.BLACK), 10);

        sut.addPicec(2, 'c', Piece.createPawn(Piece.BLACK));
        assertEquals(sut.totalScore(Piece.BLACK), 10.5);
    }

    @Test
    void testPieceSort() {
        Piece pawn = Piece.createPawn(Piece.BLACK);
        Piece knight = Piece.createKnight(Piece.BLACK);
        Piece rook = Piece.createRook(Piece.BLACK);

        pawn.setForce(1);
        knight.setForce(2.5f);
        rook.setForce(5);

        sut.addPicec(1, 'a', knight);
        sut.addPicec(2, 'a', pawn);
        sut.addPicec(3, 'a', rook);

        List<Piece> collection = sut.sort(Piece.BLACK);

        assertEquals(collection.get(0).getRepresentation(), 'R');
        assertEquals(collection.get(1).getRepresentation(), 'N');
        assertEquals(collection.get(2).getRepresentation(), 'P');

    }
}
