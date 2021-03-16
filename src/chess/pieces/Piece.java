package chess.pieces;

import chess.Board;
import chess.CharUtill;
import chess.pieces.type.*;

/**
 * 체스에서 쫄병말이다
 *
 * @author 상엽
 */
public class Piece implements Comparable<Piece> {

    private enum Color {WHITE, BLACK}

    public enum Type {
        PAWN(1d), KNIGHT(2.5), ROOK(5d), BISHOP(3d), QUEEN(9d), KING(0d);
        private double force;

        Type(double force) {
            this.force = force;
        }

        public double getForce() {
            return force;
        }

    }

    public enum Representation {
        PAWN('p'), KNIGHT('n'), ROOK('r'), BISHOP('b'), QUEEN('q'), KING('k');
        private char representation;

        Representation(char representation){
            this.representation = representation;
        }

        public char getRepresentation(){
            return representation;
        }
    }

    public static int blackCount = 0;
    public static int whiteCount = 0;

    private PieceType pieceTypeImp;

    private Color color;
    private Type type;
    private float force;

    private Piece(Color color, Type type) {
        this.color = color;
        this.type = type;
        if (type == Type.PAWN) pieceTypeImp = new Pawn();
        if (type == Type.KNIGHT) pieceTypeImp = new Knight();
        if (type == Type.ROOK) pieceTypeImp = new Rook();
        if (type == Type.BISHOP) pieceTypeImp = new Bishop();
        if (type == Type.QUEEN) pieceTypeImp = new Queen();
        if (type == Type.KING) pieceTypeImp = new King();
    }

    public static Piece createWhitePawn() {
        return create(Color.WHITE, Type.PAWN);
    }

    public static Piece createWhiteKnight() {
        return create(Color.WHITE, Type.KNIGHT);
    }

    public static Piece createWhiteRook() {
        return create(Color.WHITE, Type.ROOK);
    }

    public static Piece createWhiteBishop() {
        return create(Color.WHITE, Type.BISHOP);
    }

    public static Piece createWhiteKing() {
        return create(Color.WHITE, Type.KING);
    }

    public static Piece createWhiteQueen() {
        return create(Color.WHITE, Type.QUEEN);
    }

    public static Piece createBlackPawn() {
        return create(Color.BLACK, Type.PAWN);
    }

    public static Piece createBlackKnight() {
        return create(Color.BLACK, Type.KNIGHT);
    }

    public static Piece createBlackRook() {
        return create(Color.BLACK, Type.ROOK);
    }

    public static Piece createBlackBishop() {
        return create(Color.BLACK, Type.BISHOP);
    }

    public static Piece createBlackKing() {
        return create(Color.BLACK, Type.KING);
    }

    public static Piece createBlackQueen() {
        return create(Color.BLACK, Type.QUEEN);
    }


    public static void resetCount() {
        Piece.blackCount = Piece.whiteCount = 0;
    }

    public Type getType() {
        return type;
    }

    public void setForce(float score) {
        this.force = score;
    }

    public float getForce() {
        return force;
    }

    public char getRepresentation() {
        char representation = pieceTypeImp.getRepresentation();

        representation = isWhite() ? Character.toLowerCase(representation) : Character.toUpperCase(representation);
        return representation;
    }

    public Color getColor() {
        return isWhite() ? Color.WHITE : Color.BLACK;
    }

    public static Color getWhite() {
        return Color.WHITE;
    }

    public static Color getBlack() {
        return Color.BLACK;
    }

    public boolean isWhite() {
        return color == Color.WHITE;
    }

    public boolean isBlack() {
        return color == Color.BLACK;
    }

    public boolean move(char charRow, int col, char newCharRow, int newCol) {
        int row = CharUtill.chessCharToInt(charRow);
        int newRow = CharUtill.chessCharToInt(newCharRow);
        col--;
        newCol--;

        System.out.println(row + " " + col + " " + newRow + " " + newCol);

        if (newCol < 0 || newCol >= Board.COL || newRow < 0 || newRow >= Board.ROW)
            return false;
        if (col == newCol && row == newRow)
            return false;

        boolean result = false;

        if (getType() == Type.KING)
            result = kingMoveVerification(col, row, newCol, newRow);
        if (getType() == Type.QUEEN)
            result = queenMoveVerification(col, row, newCol, newRow);

        return result;
    }

    private boolean kingMoveVerification(int col, int row, int newCol, int newRow) {
        if (col == newCol) return Math.abs(row - newRow) == 1;
        if (row == newRow) return Math.abs(col - newCol) == 1;

        return false;
    }

    private boolean queenMoveVerification(int col, int row, int newCol, int newRow) {
        if (col == newCol || row == newRow)
            return true;
        if (Math.abs(newCol - col) == Math.abs(newRow - row))
            return true;

        return false;
    }

    @Override
    public String toString() {
        String n = pieceTypeImp.getRepresentation() + "";

        return isWhite() ? n.toLowerCase() : n.toUpperCase();
    }

    @Override
    public int compareTo(Piece that) {
        return that.getForce() > this.getForce() ? 1 : -1;
    }

    private static Piece create(Piece.Color color, Type type) {
        incrementCount(color);
        return new Piece(color, type);
    }

    private static void incrementCount(Color color) {
        if (color == Color.BLACK) {
            Piece.blackCount++;
        } else {
            Piece.whiteCount++;
        }
    }
}
