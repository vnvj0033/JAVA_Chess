package chess;

import chess.pieces.Pawn;
import chess.pieces.Piece;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Game {

    private Board board = new Board();

    public Board getBoard() {
        return board;
    }

    public float totalScore(Object color) {
        float score = 0;
        Boolean[] isColHavePawns = new Boolean[Board.ROW];

        Arrays.fill(isColHavePawns, false);

        for (int row = 0; row < Board.ROW; row++) {
            for (int col = 0; col < Board.COL; col++) {
                Piece piece = board.get(row, col);
                if (piece == null) continue;
                if (piece.getColor() != color) continue;

                score += piece.getForce();

                if (isColHavePawns[row]) score -= 0.5;
                if (piece.getClass() == Pawn.class)
                    isColHavePawns[row] = true;
            }
        }
        return score;
    }

    public List<Piece> sort(Object color) {
        return board.getBoards().stream()
                .flatMap(Collection::stream)
                .filter(Objects::nonNull)
                .filter(it -> it.getColor() == color)
                .sorted()
                .collect(Collectors.toList());
    }


}
