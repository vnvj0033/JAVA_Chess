package chess;

import chess.pieces.*;
import util.StringUtil;

import java.util.ArrayList;

/**
 * 체스 보드
 *
 * @author 유상엽
 */
public class BoardBackUp {

    public final static int COL = 8;
    public final static int ROW = 8;

    private ArrayList<ArrayList<Piece>> boards = new ArrayList(8);

    private final int WHITE_PAWN_ROW = 1;
    private final int BLACK_PAWN_ROW = 6;
    private final int WHITE_START_ROW = 0;
    private final int BLACK_START_ROW = 7;

    public BoardBackUp() {
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

    public int countType(Object color, Class type) {
        int count = 0;
        for (ArrayList<Piece> board : boards) {
            for (Piece piece : board) {
                if (piece == null) continue;
                if (piece.getColor() == color && piece.getClass() == type)
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

        rowPieces.add(Rook.createBlack());
        rowPieces.add(Knight.createBlack());
        rowPieces.add(Bishop.createBlack());
        rowPieces.add(Queen.createBlack());
        rowPieces.add(King.createBlack());
        rowPieces.add(Bishop.createBlack());
        rowPieces.add(Knight.createBlack());
        rowPieces.add(Rook.createBlack());

        boards.set(BLACK_START_ROW, rowPieces);
    }

    private void initializeWhiteStartRow() {
        ArrayList<Piece> rowPieces = new ArrayList();

        rowPieces.add(Rook.createWhite());
        rowPieces.add(Knight.createWhite());
        rowPieces.add(Bishop.createWhite());
        rowPieces.add(Queen.createWhite());
        rowPieces.add(King.createWhite());
        rowPieces.add(Bishop.createWhite());
        rowPieces.add(Knight.createWhite());
        rowPieces.add(Rook.createWhite());

        boards.set(WHITE_START_ROW, rowPieces);
    }

    private void initializeBlackPawns() {
        ArrayList<Piece> rowPicec = new ArrayList();
        for (int i = 0; i < COL; i++) {
            rowPicec.add(Pawn.createBlack());
        }
        boards.set(BLACK_PAWN_ROW, rowPicec);
    }

    private void initializeWhitePawns() {
        ArrayList<Piece> rowPicec = new ArrayList();
        for (int i = 0; i < COL; i++) {
            rowPicec.add(Pawn.createWhite());
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
