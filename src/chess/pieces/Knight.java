package chess.pieces;

public class Knight extends Piece {
    private Knight(Color color, char representation){
        super(color);
        setRepresentation(representation);
        setForce(2.5f);
    }

    public static Knight createWhite(){
        return new Knight(Color.WHITE, 'n');
    }

    public static Knight createBlack(){
        return new Knight(Color.BLACK, 'N');
    }
}
