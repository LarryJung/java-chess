package pieces.unitInfo;

import pieces.Piece;
import pieces.Player;
import pieces.coordinate.Coordinate;

public class KingInfo extends UnitInfo {
    public KingInfo(Piece pieceName, Player player, Coordinate coordinate) {
        super(pieceName, player, coordinate);
    }

    public KingInfo(Piece pieceName, Player player, Coordinate presentPosition, int countOfAction) {
        super(pieceName, player, presentPosition, countOfAction);
    }

    @Override
    public UnitInfo changeInfo(int row, char col) {
        if (isPossibleDestination(new Coordinate(row, col))) {
            attackCheck(new Coordinate(row, col));
            return new KingInfo(super.getPieceName(), super.getPlayer(), new Coordinate(row, col), super.getCountOfAction() + 1);
        }
        throw new RuntimeException("이동 가능한 목적지가 아닙니다.");
    }

    @Override
    public UnitInfo directionConditionCheck(Coordinate destination) {
        Coordinate.PositionDiff positionDiff = super.getPresentPosition().diffTo(destination);
        if (!((positionDiff.isOthogonal() && positionDiff.isLength(1)) || (positionDiff.isDiagonal()) && positionDiff.isLength(Math.sqrt(2)))) {
            throw new RuntimeException("수직 이동 또는 대각선 이동이 아닙니다.");
        }
        return this;
    }
}
