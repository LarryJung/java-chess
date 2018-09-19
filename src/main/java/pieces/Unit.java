package pieces;

import pieces.coordinate.Coordinate;

public interface Unit {
    Coordinate getPresentPosition();
    Piece getPiece();
}
