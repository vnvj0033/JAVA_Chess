package chess;

import chess.pieces.*;
import util.StringUtil;

import java.util.*;
import java.util.function.Consumer;

/**
 * 체스 보드
 *
 * @author 유상엽
 */
public class Board implements Iterable<Piece> {

    public final static int COL = 8;
    public final static int ROW = 8;

    private Piece[][] boards = new Piece[ROW][COL];

    private final int WHITE_PAWN_ROW = 1;
    private final int BLACK_PAWN_ROW = 6;
    private final int WHITE_START_ROW = 0;
    private final int BLACK_START_ROW = 7;

    public Board() {
        for (int row = 0; row < ROW; row++)
            for (int col = 0; col < COL; col++)
                boards[row][col] = null;
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
            for (int col = 0; col < COL; col++)
                builder.append(boards[row][col] == null ? "." : boards[row][col]);
            builder.append(StringUtil.NEW_LINE);
        }
        return builder.toString();
    }

    public int pieceCount() {
        return Piece.blackCount + Piece.whiteCount;
    }

    public int countType(Object color, Class type) {
        int count = 0;
        for (Piece[] board : boards)
            for (Piece piece : board) {
                if (piece == null) continue;
                if (piece.getColor() == color && piece.getClass() == type)
                    count++;
            }
        return count;
    }

    public Piece getGamePositionPiece(int row, char colChat) {
        int col = CharUtill.chessCharToInt(colChat);
        return get(--row, col);
    }

    public Piece[][] getBoards() {
        return boards;
    }

    public Piece get(int row, int col) {
        return boards[row][col];
    }

    public void put(int row, int col, Piece piece) {
        boards[row][col] = piece;
    }

    public void addPiece(int row, char colChar, Piece piece) {
        int col = CharUtill.chessCharToInt(colChar);
        put(--row, col, piece);
    }

    private void initializeBlackStartRow() {
        Piece[] rowPieces = boards[BLACK_START_ROW];

        rowPieces[0] = Rook.createBlack();
        rowPieces[1] = Knight.createBlack();
        rowPieces[2] = Bishop.createBlack();
        rowPieces[3] = Queen.createBlack();
        rowPieces[4] = King.createBlack();
        rowPieces[5] = Bishop.createBlack();
        rowPieces[6] = Knight.createBlack();
        rowPieces[7] = Rook.createBlack();
    }

    private void initializeWhiteStartRow() {
        Piece[] rowPieces = boards[WHITE_START_ROW];

        rowPieces[0] = Rook.createWhite();
        rowPieces[1] = Knight.createWhite();
        rowPieces[2] = Bishop.createWhite();
        rowPieces[3] = Queen.createWhite();
        rowPieces[4] = King.createWhite();
        rowPieces[5] = Bishop.createWhite();
        rowPieces[6] = Knight.createWhite();
        rowPieces[7] = Rook.createWhite();
    }

    private void initializeBlackPawns() {
        Piece[] rowPiece = boards[BLACK_PAWN_ROW];
        for (int i = 0; i < COL; i++)
            rowPiece[i] = Pawn.createBlack();
    }

    private void initializeWhitePawns() {
        Piece[] rowPiece = boards[WHITE_PAWN_ROW];
        for (int i = 0; i < COL; i++)
            rowPiece[i] = Pawn.createWhite();
    }

    private void initializeBlank(int row) {
        Piece[] rowPiece = boards[row];
        for (int i = 0; i < COL; i++)
            rowPiece[i] = null;
    }

    @Override
    public Iterator<Piece> iterator() {

        ArrayList<Piece> pieceList = new ArrayList<>();
        for (Piece[] pieces : boards)
            pieceList.addAll(Arrays.asList(pieces));

        return pieceList.iterator();
    }
}