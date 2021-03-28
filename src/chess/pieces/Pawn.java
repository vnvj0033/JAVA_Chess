package chess.pieces;

public class Pawn extends Piece {
    private Pawn(Color color, char representation){
        super(color);
        setRepresentation(representation);
        setForce(1f);
    }

    public static Pawn createWhite(){
        return new Pawn(Color.WHITE, 'p');
    }

    public static Pawn createBlack(){
        return new Pawn(Color.BLACK, 'P');
    }
}
