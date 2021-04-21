package chess.pieces;

import chess.Board;

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

    @Override
    public String[] getPossibleMoves(String position, Board board) {
        return new String[0];
    }
}
