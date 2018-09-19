package pieces;

import pieces.coordinate.Coordinate;

public class UnitImpl implements Unit {

    private Piece pieceName;
    private Player player;

    public UnitImpl(Piece pieceName, Player player) {
        this.pieceName = pieceName;
        this.player = player;
    }

    @Override
    public Coordinate getPresentPosition() {
        return null;
    }

    @Override
    public Piece getPiece() {
        return pieceName;
    }
}
