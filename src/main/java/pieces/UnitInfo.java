package pieces;

import pieces.coordinate.Coordinate;

import static pieces.coordinate.Coordinate.*;

public class UnitInfo {

    private Piece pieceName;
    private Player player;
    private Coordinate presentPosition;
    private int countOfAction = 0;

    public UnitInfo(Piece pieceName, Player player, Coordinate coordinate) {
        this.pieceName = pieceName;
        this.player = player;
        this.presentPosition = coordinate;
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

    public UnitInfo changeInfo(int row, char col) {
        if (isPossibleDestination(new Coordinate(row, col))) {
            countOfAction++;
            presentPosition = new Coordinate(row, col);
            return this;
        }
        throw new RuntimeException("이동 가능한 목적지가 아닙니다.");
    }

    private boolean isPossibleDestination(Coordinate destination) {
        return pieceName.isPossibleDestination(presentPosition, destination, this);
    }


    public boolean isOneDiffWithDirection(PositionDiff positionDiff) {
        if (Math.abs(positionDiff.getColDiff()) == 1) {
            if (player == Player.BLACK && positionDiff.getRowDiff() == 1) return true;
            if (player == Player.WHITE && positionDiff.getRowDiff() == -1) return true;
        }
        return false;
    }

    public boolean isFirstAction() {
        return countOfAction == 0;
    }
}
