package chess.pieces;

import chess.Board;

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

    @Override
    public String[] getPossibleMoves(String position, Board board) {
        return new String[0];
    }
}
