package chess;

import chess.pieces.Piece;
import util.StringUtil;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 체스 보드
 *
 * @author 유상엽
 */
public class Board {

    private ArrayList<Piece> pieces = new ArrayList();
    private ArrayList<ArrayList<Piece>> boards = new ArrayList(8);
    private final int COL = 8;
    private final int ROW = 8;
    private final int WHITE_PAWN_ROW = 1;
    private final int BLACK_PAWN_ROW = 6;
    private final int WHITE_START_ROW = 0;
    private final int BLACK_START_ROW = 7;

    Board() {
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
        for (int i = ROW-1; i >= 0; i--) {
            for (int j = 0; j < COL; j++) {
                builder.append(boards.get(i).get(j) == null ? "." : boards.get(i).get(j));
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

    public Piece getPositionPicec(char rowChar, int col) {
        col--;
        int row = charToInt(rowChar);
        return boards.get(col).get(row);
    }

    public void addPicec(char rowChar, int col, Piece piece) {
        col--;
        int row = charToInt(rowChar);
        boards.get(col).set(row, piece);
    }

    public float totalScore(Object color) {
        float score = 0;
        Boolean[] isColHavePawns = new Boolean[COL];

        Arrays.fill(isColHavePawns, false);

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                Piece piece = boards.get(i).get(j);
                if (piece == null) continue;
                if (piece.getColor() != color) continue;

                score += piece.getType().getForce();

                if (isColHavePawns[j]) score -= 0.5;
                if (piece.getType() == Piece.Type.PAWN)
                    isColHavePawns[j] = true;
            }
        }
        return score;
    }

    public List<Piece> sort(Object color) {
        return boards.stream()
                .flatMap(Collection::stream)
                .filter(Objects::nonNull)
                .filter(it -> it.getColor() == color)
                .sorted()
                .collect(Collectors.toList());
    }

    private int charToInt(char c) {
        return Character.getNumericValue(c) - 10;
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
        for (int i = 0; i < 8; i++) {
            rowPicec.add(Piece.createBlackPawn());
        }
        boards.set(BLACK_PAWN_ROW, rowPicec);
    }

    private void initializeWhitePawns() {
        ArrayList<Piece> rowPicec = new ArrayList();
        for (int i = 0; i < 8; i++) {
            rowPicec.add(Piece.createWhitePawn());
        }
        boards.set(WHITE_PAWN_ROW, rowPicec);
    }

    private void initializeBlank(int row) {
        ArrayList<Piece> rowPicec = new ArrayList();
        for (int i = 0; i < 8; i++) {
            rowPicec.add(null);
        }
        boards.set(row, rowPicec);
    }

    public void movePiece(char charRow, int col, char newCharRow, int newCol) {
        col--;
        newCol--;
        int row = charToInt(charRow);
        int newRow = charToInt(newCharRow);
        Piece piece = boards.get(col).get(row);
        if (piece.getType() == Piece.Type.KING) {
            if (kingMoveVerification(col, row, newCol, newRow)){
                boards.get(newCol).set(newRow, piece);
                boards.get(col).set(row, null);
            }
            else throw new RuntimeException("king move err");
        }
    }

    private boolean kingMoveVerification(int col, int row, int newCol, int newRow) {

        if (newCol < 0 || newCol >= COL || newRow < 0 || newRow >= ROW)
            return false;
        if (col == newCol) return Math.abs(row - newRow) == 1;
        if (row == newRow) return Math.abs(col - newCol) == 1;

        return false;
    }
}
