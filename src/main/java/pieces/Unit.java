package pieces;

import pieces.coordinate.Coordinate;

import static pieces.Piece.*;

public interface Unit {
    Piece getPiece();
    Unit moveTo(int row, char col);
    boolean isPosition(int row, char col);
    boolean isPosition(Coordinate target);
    boolean isEnemy(Player player);
    Figure getMark();
}
