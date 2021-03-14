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
    private final int WHITE_PAWN_ROW = 6;
    private final int BLACK_PAWN_ROW = 1;
    private final int WHITE_START_ROW = 7;
    private final int BLACK_START_ROW = 0;

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
        for (int i = 0; i < ROW; i++) {
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

    public Piece getPositionPicec(int col, char rowChar) {
        int row = charToInt(rowChar);
        return boards.get(COL - col).get(row);
    }

    public void addPicec(int col, char rowChar, Piece piece) {
        int row = charToInt(rowChar);
        boards.get(COL - col).set(row, piece);
    }

    public float blackTotalScore() {
        float score = 0;
        Boolean[] isColHavePawns = new Boolean[COL];
        Arrays.fill(isColHavePawns, false);

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                Piece piece = boards.get(i).get(j);
                if (piece == null) continue;
                if (piece.isWhite()) continue;

                switch (piece.getType()) {
                    case PAWN -> {
                        score += isColHavePawns[j] ? 0.5 : 1;
                        isColHavePawns[j] = true;
                    }
                    case BISHOP -> score += 3;
                    case KNIGHT -> score += 2.5;
                    case QUEEN -> score += 9;
                    case ROOK -> score += 5;
                }
            }
        }
        return score;
    }

    public List<Piece> whiteSort() {
        return boards.stream()
                .flatMap(Collection::stream)
                .filter(Objects::nonNull)
                .filter(Piece::isWhite)
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Piece> blackSort() {
        return boards.stream()
                .flatMap(Collection::stream)
                .filter(Objects::nonNull)
                .filter(Piece::isBlack)
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
}
