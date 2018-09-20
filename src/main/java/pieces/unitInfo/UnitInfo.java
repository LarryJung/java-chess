package pieces.unitInfo;

import pieces.Piece;
import pieces.Piece.Figure;
import pieces.Player;
import pieces.coordinate.Coordinate;

import static pieces.coordinate.Coordinate.*;

public abstract class UnitInfo {

    private Piece pieceName;
    private Player player;
    private Coordinate presentPosition;
    private int countOfAction;

    public UnitInfo(Piece pieceName, Player player, Coordinate coordinate) {
        this(pieceName, player, coordinate, 0);
    }

    public UnitInfo(Piece pieceName, Player player, Coordinate presentPosition, int countOfAction) {
        this.pieceName = pieceName;
        this.player = player;
        this.presentPosition = presentPosition;
        this.countOfAction = countOfAction;
    }

    public Piece getPieceName() {
        return pieceName;
    }

    public Player getPlayer() {
        return player;
    }

    public boolean isPosition(int row, char col) {
        return presentPosition.equals(new Coordinate(row, col));
    }

    public boolean isPosition(Coordinate target) {
        return presentPosition.equals(target);
    }

    public abstract UnitInfo changeInfo(int row, char col);

    public abstract boolean isPossibleDestination(Coordinate destination);

    public boolean isOneDiffWithDirection(PositionDiff positionDiff) {
        if (Math.abs(positionDiff.getColDiff()) == 1) {
            if (player == Player.BLACK && positionDiff.getRowDiff() == 1) {
                System.out.println("블랙");
                return true;
            }
            if (player == Player.WHITE && positionDiff.getRowDiff() == -1) return true;
        }
        return false;
    }

    public boolean isFirstAction() {
        return countOfAction == 0;
    }

    public String getPositionString() {
        return presentPosition.toString();
    }

    public Figure findMark() {
        Figure mark = pieceName.mark(player);
        if (mark == null) {
            return presentPosition.assignEmptyMark();
        }
        return mark;
    }

    public int getCountOfAction() {
        return countOfAction;
    }

    public Coordinate getPresentPosition() {
        return presentPosition;
    }

    public abstract boolean eachMovingLengthCheck(PositionDiff positionDiff, Coordinate destination);
}
