package view;

import chessGame.ChessBoard;
import pieces.Piece;
import pieces.coordinate.Coordinate;

public class Tile {

    private Coordinate coordinate;

    private Piece.Figure mark;

    public Tile(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Piece.Figure mark(ChessBoard chessBoard) {
        this.mark = chessBoard.findMark(coordinate);
        return mark;
    }

    public String toString() {
        return String.valueOf(mark);
    }

    public void draw() {
        mark.draw();
    }
}
