package chess;

import chess.pieces.King;
import chess.pieces.Pawn;
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
        assertEquals(sut.countType(Piece.getWhite(), Pawn.class), 8);
        assertEquals(sut.countType(Piece.getWhite(), King.class), 1);
    }

    @Test
    void testPicecPosition() {
        sut.initialize();
        assertEquals(sut.getGamePositionPiece('a', 8).getRepresentation(), 'R');
        assertEquals(sut.getGamePositionPiece('e', 1).getRepresentation(), 'k');
    }

    @Test
    void testAddPicec() {
        assertNull(sut.getGamePositionPiece('a', 8));

        Piece piece = Pawn.createBlack();
        sut.addPiece('a', 8, piece);
    }
}
