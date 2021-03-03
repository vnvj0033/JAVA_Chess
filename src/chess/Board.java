package chess;

import chess.pieces.Piece;
import util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;

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
            for (int col = 0; col < COL; col++){
                list.add(null);
            }
            boards.add(list);
        }
    }

    public void initialize() {
        Piece.resetCount();

        for (int row = 0; row < ROW; row++) {
            if (row == BLACK_START_ROW) {
                initializeStartRow(Piece.BLACK, row);
            } else if (row == BLACK_PAWN_ROW) {
                initializePawns(Piece.BLACK, row);
            } else if (row == WHITE_PAWN_ROW) {
                initializePawns(Piece.WHITE, row);
            } else if (row == WHITE_START_ROW) {
                initializeStartRow(Piece.WHITE, row);
            } else {
                initializeBlackRank(row);
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

    public int countType(String color, Piece.Type type) {
        int count = 0;
        for (ArrayList<Piece> board : boards) {
            for (Piece piece : board) {
                if (piece == null) continue;
                if (piece.getColor().equals(color) && piece.getType() == type)
                    count++;
            }
        }
        return count;
    }

    public Piece getPositionPicec(int col, char rowChar) {
        int row = Character.getNumericValue(rowChar) - 10;
        return boards.get(8 - col).get(row);
    }


    public void addPicec(int col, char rowChar, Piece piece) {
        int row = Character.getNumericValue(rowChar) - 10;
        boards.get(8 - col).set(row, piece);
    }

    public float totalScore(String color) {
        float score = 0;
        Boolean[] isColHavePawns = new Boolean[COL];
        Arrays.fill(isColHavePawns, false);

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                Piece piece;

                try {
                    piece = boards.get(i).get(j);
                } catch (Exception e) {
                    continue;
                }
                if (piece == null) continue;

                if (color.equals(Piece.BLACK))
                    if (piece.isWhite()) continue;
                if (color.equals(Piece.WHITE))
                    if (piece.isBlack()) continue;

                if (piece.getType() == Piece.Type.PAWN) {
                    score += isColHavePawns[j] ? 0.5 : 1;
                    isColHavePawns[j] = true;
                }
                if (piece.getType() == Piece.Type.BISHOP) score += 3;
                if (piece.getType() == Piece.Type.KNIGHT) score += 2.5;
                if (piece.getType() == Piece.Type.QUEEN) score += 9;
                if (piece.getType() == Piece.Type.ROOK) score += 5;
                System.out.println(score);
            }

        }
        return score;
    }


    private void initializeStartRow(String color, int row) {
        ArrayList<Piece> rowPieces = new ArrayList();

        rowPieces.add(Piece.createRook(color));
        rowPieces.add(Piece.createKnight(color));
        rowPieces.add(Piece.createBishop(color));
        rowPieces.add(Piece.createQueen(color));
        rowPieces.add(Piece.createKing(color));
        rowPieces.add(Piece.createBishop(color));
        rowPieces.add(Piece.createKnight(color));
        rowPieces.add(Piece.createRook(color));

        boards.set(row, rowPieces);
    }

    private void initializePawns(String color, int row) {
        ArrayList<Piece> rowPicec = new ArrayList();
        for (int i = 0; i < 8; i++) {
            rowPicec.add(Piece.createPawn(color));
        }
        boards.set(row, rowPicec);
    }

    private void initializeBlackRank(int row) {
        ArrayList<Piece> rowPicec = new ArrayList();
        for (int i = 0; i < 8; i++) {
            rowPicec.add(null);
        }
        boards.set(row, rowPicec);
    }
}
