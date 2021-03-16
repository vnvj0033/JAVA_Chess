package chess;

import chess.pieces.Piece;
import util.StringUtil;

import java.util.*;

/**
 * 체스 보드
 *
 * @author 유상엽
 */
public class Board {

    public final static int COL = 8;
    public final static int ROW = 8;

    private ArrayList<ArrayList<Piece>> boards = new ArrayList(8);

    private final int WHITE_PAWN_ROW = 1;
    private final int BLACK_PAWN_ROW = 6;
    private final int WHITE_START_ROW = 0;
    private final int BLACK_START_ROW = 7;

    public Board() {
        for (int row = 0; row < ROW; row++) {
            ArrayList<Piece> list = new ArrayList<>(8);
            for (int col = 0; col < COL; col++) {
                list.add(null);
            }
            boards.add(list);
        }
    }

    public void initialize() {
        Piece.resetCount();

        for (int row = 0; row < ROW; row++) {
            if (row == BLACK_START_ROW) {
                initializeBlackStartRow();
            } else if (row == BLACK_PAWN_ROW) {
                initializeBlackPawns();
            } else if (row == WHITE_PAWN_ROW) {
                initializeWhitePawns();
            } else if (row == WHITE_START_ROW) {
                initializeWhiteStartRow();
            } else {
                initializeBlank(row);
            }
        }
    }

    public String print() {
        StringBuilder builder = new StringBuilder();
        for (int row = ROW - 1; row >= 0; row--) {
            for (int col = 0; col < COL; col++) {
                builder.append(boards.get(row).get(col) == null ? "." : boards.get(row).get(col));
            }
            builder.append(StringUtil.NEW_LINE);
        }

        return builder.toString();
    }

    public int pieceCount() {
        return Piece.blackCount + Piece.whiteCount;
    }

    public int countType(Object color, Piece.Type type) {
        int count = 0;
        for (ArrayList<Piece> board : boards) {
            for (Piece piece : board) {
                if (piece == null) continue;
                if (piece.getColor() == color && piece.getType() == type)
                    count++;
            }
        }
        return count;
    }

    public Piece getGamePositionPicec(char rowChar, int col) {
        col--;
        int row = CharUtill.chessCharToInt(rowChar);
        return get(row, col);
    }

    public ArrayList<ArrayList<Piece>> getBoards() {
        return boards;
    }

    public Piece get(int row, int col) {
        return boards.get(col).get(row);
    }

    public void put(int row, int col, Piece piece){
        boards.get(col).set(row, piece);
    }

    public void addPicec(char rowChar, int col, Piece piece) {
        col--;
        int row = CharUtill.chessCharToInt(rowChar);
        put(row, col, piece);
    }

    private void initializeBlackStartRow() {
        ArrayList<Piece> rowPieces = new ArrayList();

        rowPieces.add(Piece.createBlackRook());
        rowPieces.add(Piece.createBlackKnight());
        rowPieces.add(Piece.createBlackBishop());
        rowPieces.add(Piece.createBlackQueen());
        rowPieces.add(Piece.createBlackKing());
        rowPieces.add(Piece.createBlackBishop());
        rowPieces.add(Piece.createBlackKnight());
        rowPieces.add(Piece.createBlackRook());

        boards.set(BLACK_START_ROW, rowPieces);
    }

    private void initializeWhiteStartRow() {
        ArrayList<Piece> rowPieces = new ArrayList();

        rowPieces.add(Piece.createWhiteRook());
        rowPieces.add(Piece.createWhiteKnight());
        rowPieces.add(Piece.createWhiteBishop());
        rowPieces.add(Piece.createWhiteQueen());
        rowPieces.add(Piece.createWhiteKing());
        rowPieces.add(Piece.createWhiteBishop());
        rowPieces.add(Piece.createWhiteKnight());
        rowPieces.add(Piece.createWhiteRook());

        boards.set(WHITE_START_ROW, rowPieces);
    }

    private void initializeBlackPawns() {
        ArrayList<Piece> rowPicec = new ArrayList();
        for (int i = 0; i < COL; i++) {
            rowPicec.add(Piece.createBlackPawn());
        }
        boards.set(BLACK_PAWN_ROW, rowPicec);
    }

    private void initializeWhitePawns() {
        ArrayList<Piece> rowPicec = new ArrayList();
        for (int i = 0; i < COL; i++) {
            rowPicec.add(Piece.createWhitePawn());
        }
        boards.set(WHITE_PAWN_ROW, rowPicec);
    }

    private void initializeBlank(int row) {
        ArrayList<Piece> rowPicec = new ArrayList();
        for (int i = 0; i < COL; i++) {
            rowPicec.add(null);
        }
        boards.set(row, rowPicec);
    }

}
