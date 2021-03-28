package chess.pieces;

import chess.Board;
import chess.CharUtill;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Queen extends Piece {
    private Queen(Color color, char representation) {
        super(color);
        setRepresentation(representation);
        setForce(9f);
    }

    public static Queen createWhite() {
        return new Queen(Color.WHITE, 'q');
    }

    public static Queen createBlack() {
        return new Queen(Color.BLACK, 'Q');
    }

    @Override
    public int[][] getPossibleMoves(char charRow, int col) {
        int row = CharUtill.chessCharToInt(charRow);

        ArrayList<int[]> moves = recursionMove(--col, row);

        return moves.toArray(int[][]::new);
    }

    private ArrayList<int[]> recursionMove(int col, int row) {
        ArrayList<int[]> moves = new ArrayList();
        int newCol;
        int newRow;
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

        Iterator<int[]> iterator = Arrays.stream(offsets).iterator();

        while (iterator.hasNext()) {
            newCol = col;
            newRow = row;
            int[] offsetValue = iterator.next();

            while (true) {
                newCol += offsetValue[0];
                newRow += offsetValue[1];
                if (newCol < 0 || newCol >= Board.COL || newRow < 0 || newRow >= Board.ROW)
                    break;
                moves.add(new int[]{newCol, newRow});
            }
        }
        return moves;
    }
}
