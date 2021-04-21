package chess.pieces;

import chess.Board;

public class Bishop extends Piece {
    private Bishop(Color color, char representation){
        super(color);
        setRepresentation(representation);
        setForce(3f);
    }

    public static Bishop createWhite(){
        return new Bishop(Color.WHITE, 'b');
    }

    public static Bishop createBlack(){
        return new Bishop(Color.BLACK, 'B');
    }

    @Override
    public String[] getPossibleMoves(String position, Board board) {
        return new String[0];
    }
}
