package chess.pieces;

public class Pawn extends Piece {
    private Pawn(Color color, char representation){
        super(color);
        setRepresentation(representation);
        setForce(1f);
    }

    public static Pawn createWhite(){
        Pawn piece = new Pawn(Color.WHITE, 'p');
        return piece;
    }

    public static Pawn createBlack(){
        Pawn piece = new Pawn(Color.BLACK, 'P');
        return piece;
    }
}
