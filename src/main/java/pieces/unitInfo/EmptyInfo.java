package pieces.unitInfo;

import pieces.Piece;
import pieces.Player;
import pieces.coordinate.Coordinate;

public class EmptyInfo extends UnitInfo {

    public EmptyInfo(Piece pieceName, Player player, Coordinate coordinate) {
        super(pieceName, player, coordinate);
    }

    public EmptyInfo(Piece pieceName, Player player, Coordinate presentPosition, int countOfAction) {
        super(pieceName, player, presentPosition, countOfAction);
    }

    @Override
    public UnitInfo changeInfo(int row, char col) {
        return null;
    }

    @Override
    public boolean isPossibleDestination(Coordinate destination) {
        return true;
    }

}




