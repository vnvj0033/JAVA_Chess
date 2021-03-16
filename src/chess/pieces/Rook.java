package chess.pieces;

public class Rook extends Piece {
    private Rook(Color color, char representation){
        super(color);
        setRepresentation(representation);
        setForce(5f);
    }

    public static Rook createWhite(){
        Rook piece = new Rook(Color.WHITE, 'r');
        return piece;
    }

    public static Rook createBlack(){
        Rook piece = new Rook(Color.BLACK, 'R');
        return piece;
    }
}
