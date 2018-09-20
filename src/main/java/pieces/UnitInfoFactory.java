package pieces;

import pieces.coordinate.Coordinate;
import pieces.unitInfo.EmptyInfo;
import pieces.unitInfo.PawnInfo;
import pieces.unitInfo.UnitInfo;

public class UnitInfoFactory {

    public static UnitInfo createUnitInfo(Piece pieceName, Player player, Coordinate coordinate) {
        switch (pieceName) {
            case PAWN:
                return new PawnInfo(pieceName, player, coordinate);
            default:
                return new EmptyInfo(pieceName, player, coordinate);
        }
    }
}
