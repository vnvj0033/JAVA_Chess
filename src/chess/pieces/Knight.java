package chess.pieces;

public class Knight extends Piece {
    private Knight(Color color, char representation){
        super(color);
        setRepresentation(representation);
        setForce(2.5f);
    }

    public static Knight createWhite(){
        Knight piece = new Knight(Color.WHITE, 'n');
        return piece;
    }

    public static Knight createBlack(){
        Knight piece = new Knight(Color.BLACK, 'N');
        return piece;
    }
}
