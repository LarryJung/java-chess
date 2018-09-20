package pieces;

import pieces.coordinate.Coordinate;
import pieces.coordinate.Coordinate.PositionDiff;
import pieces.unitInfo.PawnInfo;
import pieces.unitInfo.UnitInfo;

public enum Player {

    BLACK,
    WHITE,
    NONE;

    public boolean isEnemy(Player target) {
        if (this == BLACK) {
            return target == WHITE;
        }
        return this == WHITE && target == BLACK;
    }

    public boolean isAlly(Player target) {
        return this == target;
    }

    public PositionDiff directionCheck(PositionDiff positionDiff) {
        if (this == BLACK && positionDiff.getRowDiff() < 0) {
            throw new RuntimeException("선택한 방향이 거꾸로입니다.");
        }
        if (this == WHITE && positionDiff.getRowDiff() > 0) {
            throw new RuntimeException("선택한 방향이 거꾸로입니다.");
        }
        return positionDiff;
    }
}
