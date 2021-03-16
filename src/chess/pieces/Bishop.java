package chess.pieces;

public class Bishop extends Piece {
    private Bishop(Color color, char representation){
        super(color);
        setRepresentation(representation);
        setForce(3f);
    }

    public static Bishop createWhite(){
        Bishop piece = new Bishop(Color.WHITE, 'b');
        return piece;
    }

    public static Bishop createBlack(){
        Bishop piece = new Bishop(Color.BLACK, 'B');
        return piece;
    }
}
