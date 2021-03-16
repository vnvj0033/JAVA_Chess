package chess.pieces;


/**
 * 체스에서 쫄병말이다
 *
 * @author 상엽
 */
public class Piece implements Comparable<Piece> {

    protected enum Color {WHITE, BLACK}

    public static int blackCount = 0;
    public static int whiteCount = 0;

    private Color color;
    private float force;
    private char representation;

    protected Piece(Color color) {
        this.color = color;
        incrementCount(color);
    }

    public static void resetCount() {
        Piece.blackCount = Piece.whiteCount = 0;
    }

    public void setForce(float score) {
        this.force = score;
    }

    public float getForce() {
        return force;
    }

    protected void setRepresentation(char c) {
        this.representation = c;
    }

    public char getRepresentation(){
        return representation;
    };

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

    public int[][] getPossibleMoves(char charRow, int col) {
        return null;
    }

    @Override
    public String toString() {
        String n = getRepresentation() + "";

        return isWhite() ? n.toLowerCase() : n.toUpperCase();
    }

    @Override
    public int compareTo(Piece that) {
        return that.getForce() > this.getForce() ? 1 : -1;
    }

    private static void incrementCount(Color color) {
        if (color == Color.BLACK) {
            Piece.blackCount++;
        } else {
            Piece.whiteCount++;
        }
    }
}
