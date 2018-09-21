package pieces.unitInfo;

import pieces.Piece;
import pieces.Player;
import pieces.coordinate.Coordinate;

public class EmptyInfo extends UnitInfo{

    public EmptyInfo(Piece pieceName, Player player, Coordinate coordinate) {
        super(pieceName, player, coordinate);
    }

    @Override
    public UnitInfo changeInfo(int row, char col) {
        return null;
    }

    @Override
    public UnitInfo directionConditionCheck(Coordinate destination) {
        return null;
    }


}
