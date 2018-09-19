package pieces;

import pieces.coordinate.Coordinate;

public interface Unit {
    Piece getPiece();
    Unit moveTo(int row, char col);
    boolean isPosition(int row, char col);
    boolean isPosition(Coordinate target);
    boolean isEnemy(Player player);
}
