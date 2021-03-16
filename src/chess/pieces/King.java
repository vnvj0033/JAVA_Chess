package chess.pieces;

import chess.Board;
import chess.CharUtill;

import java.util.ArrayList;

public class King extends Piece {
    private King(Piece.Color color, char representation){
        super(color);
        setRepresentation(representation);
        setForce(0f);
    }

    public static King createWhite(){
        King piece = new King(Color.WHITE, 'k');
        return piece;
    }

    public static King createBlack(){
        King piece = new King(Color.BLACK, 'K');
        return piece;
    }

    public int[][] getPossibleMoves(char charRow, int col) {
        int row = CharUtill.chessCharToInt(charRow);
        int newCol, newRow;
        col--;
        ArrayList<int[]> moves = new ArrayList();

        int[][] offsets = {
                {1, 0},
                {0, 1},
                {-1, 0},
                {0, -1},
                {1, 1},
                {-1, 1},
                {-1, -1},
                {1, -1}
        };

        for (int[] offset : offsets) {
            newCol = col + offset[0];
            newRow = row + offset[1];

            if (newCol < 0 || newCol >= Board.COL || newRow < 0 || newRow >= Board.ROW)
                continue;
            if (col == newCol && row == newRow)
                continue;
            moves.add(new int[]{newCol+1, newRow+1});

        }
        return moves.toArray(int[][]::new);
    }

}
