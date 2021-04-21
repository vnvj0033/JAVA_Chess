package chess.pieces;

import chess.Board;

public class Rook extends Piece {
    private Rook(Color color, char representation){
        super(color);
        setRepresentation(representation);
        setForce(5f);
    }

    public static Rook createWhite(){
        return new Rook(Color.WHITE, 'r');
    }

    public static Rook createBlack(){
        return new Rook(Color.BLACK, 'R');
    }

    @Override
    public String[] getPossibleMoves(String position, Board board) {
        return new String[0];
    }
}
