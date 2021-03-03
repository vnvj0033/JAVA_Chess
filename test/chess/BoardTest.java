package chess;

import chess.pieces.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.StringUtil;

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
        sut.initialize();
        assertNull(sut.getPositionPicec(5, 'e'));

        Piece piece = Piece.createPawn(Piece.BLACK);
        sut.addPicec(8, 'a', piece);
    }

    @Test
    void testTotalScore(){
        sut.initialize();
        assertEquals(sut.totalScore(Piece.BLACK), 38);
    }
}
