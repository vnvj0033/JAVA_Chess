package chess.pieces;

import chess.Board;
import chess.CharUtill;

import java.util.ArrayList;

public class King extends Piece {
    private King(Piece.Color color, char representation) {
        super(color);
        setRepresentation(representation);
        setForce(0f);
    }

    public static King createWhite() {
        return new King(Color.WHITE, 'k');
    }

    public static King createBlack() {
        return new King(Color.BLACK, 'K');
    }

    public String[] getPossibleMoves(String position, Board board) {
        int col = CharUtill.chessCharToInt(position.charAt(0));
        int row = Integer.parseInt(String.valueOf(position.charAt(1)));

        int newCol, newRow;
        ArrayList<String> moves = new ArrayList();

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
            moves.add(CharUtill.chessIntToChar(newCol) + String.valueOf(newRow));

        }
        return moves.toArray(String[]::new);
    }
}
