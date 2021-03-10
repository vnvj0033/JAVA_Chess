package chess.pieces;

/**
 * 체스에서 쫄병말이다
 *
 * @author 상엽
 */
public class Piece implements Comparable<Piece> {

    private enum Color {WHITE, BLACK}

    public enum Type {PAWN, KNIGHT, ROOK, BISHOP, QUEEN, KING}

    public static final char PAWN_REPRESENTATION = 'p';
    public static final char ROOK_REPRESENTATION = 'r';
    public static final char KNIGHT_REPRESENTATION = 'n';
    public static final char BISHOP_REPRESENTATION = 'b';
    public static final char QUEEN_REPRESENTATION = 'q';
    public static final char KING_REPRESENTATION = 'k';

    public final static String BLACK = "black";
    public final static String WHITE = "white";

    private final static String PAWN = "pawn";
    private final static String KNIGHT = "knight";
    private final static String ROOK = "rook";
    private final static String BISHOP = "bishop";
    private final static String QUEEN = "queen";
    private final static String KING = "king";
    public static int blackCount = 0;
    public static int whiteCount = 0;

    private PieceTypeImp pieceTypeImp;

    private Color color;
    private Type type;
    private float force;

    private Piece(Color color, Type type) {
        this.color = color;
        this.type = type;
        if (type == Type.PAWN) pieceTypeImp = new PawnTypeStrategy();
        if (type == Type.KNIGHT) pieceTypeImp = new KnightTypeStrategy();
        if (type == Type.ROOK) pieceTypeImp = new RookTypeStrategy();
        if (type == Type.BISHOP) pieceTypeImp = new BishopTypeStrategy();
        if (type == Type.QUEEN) pieceTypeImp = new QueenTypeStrategy();
        if (type == Type.KING) pieceTypeImp = new KingTypeStrategy();
    }

    public static Piece createPawn(String color) {
        return create(color, PAWN);
    }

    public static Piece createKnight(String color) {
        return create(color, KNIGHT);
    }

    public static Piece createRook(String color) {
        return create(color, ROOK);
    }

    public static Piece createBishop(String color) {
        return create(color, BISHOP);
    }

    public static Piece createKing(String color) {
        return create(color, KING);
    }

    public static Piece createQueen(String color) {
        return create(color, QUEEN);
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

    /**
     * Pawn의 색을 반환한다.
     */
    public String getColor() {
        return isWhite() ? Piece.WHITE : Piece.BLACK;
    }

    public boolean isWhite() {
        return color == Color.WHITE;
    }

    public boolean isBlack() {
        return color == Color.BLACK;
    }

    @Override
    public String toString() {
        String n = pieceTypeImp.getRepresentation()+"";

        return isWhite() ? n.toLowerCase() : n.toUpperCase();
    }

    @Override
    public int compareTo(Piece that) {
        int comoare = that.getForce() > this.getForce() ? 1 :-1;
        return comoare;
    }

    private static Piece create(String color, String name) {
        Piece.Color pieceColor = color.equals(Piece.WHITE) ? Color.WHITE : Color.BLACK;
        Piece.Type pieceName = Type.PAWN;

        if (name.equals(Piece.KNIGHT)) pieceName = Type.KNIGHT;
        if (name.equals(Piece.ROOK)) pieceName = Type.ROOK;
        if (name.equals(Piece.BISHOP)) pieceName = Type.BISHOP;
        if (name.equals(Piece.QUEEN)) pieceName = Type.QUEEN;
        if (name.equals(Piece.KING)) pieceName = Type.KING;

        incrementCount(pieceColor);
        return new Piece(pieceColor, pieceName);
    }

    private static void incrementCount(Color color) {
        if (color == Color.BLACK) {
            Piece.blackCount++;
        } else {
            Piece.whiteCount++;
        }
    }
}
