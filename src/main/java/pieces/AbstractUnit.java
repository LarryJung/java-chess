package pieces;

import pieces.coordinate.Coordinate;

public class AbstractUnit {

    private Piece pieceName;
    private Player player;
    private Coordinate coordinate;

    public AbstractUnit(Piece pieceName, Player player) {
        this.pieceName = pieceName;
        this.player = player;
    }

    public void initCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

}
