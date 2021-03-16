package chess.pieces;

public class Queen extends Piece {
    private Queen(Color color, char representation){
        super(color);
        setRepresentation(representation);
        setForce(9f);
    }

    public static Queen createWhite(){
        Queen piece = new Queen(Color.WHITE, 'q');
        return piece;
    }

    public static Queen createBlack(){
        Queen piece = new Queen(Color.BLACK, 'Q');
        return piece;
    }
}
