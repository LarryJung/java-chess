package pieces;

import pieces.coordinate.Coordinate;
import pieces.unitInfo.UnitInfo;

import static pieces.Piece.*;

public interface Unit {
    Piece getPiece();
    Unit moveTo(int row, char col);
    Unit moveTo(Coordinate destination);
    boolean isPosition(int row, char col);
    boolean isPosition(Coordinate target);
    boolean isEnemy(Player player);
    Figure getMark();
    boolean isAlly(Player player);
    void isAttackedBy(Unit unit);
    UnitInfo getUnitInfo();

}
