package pieces.unitInfo;

import chessGame.ChessBoard;
import pieces.Piece;
import pieces.Player;
import pieces.coordinate.Coordinate;

public class PawnInfo extends UnitInfo {

    public PawnInfo(Piece pieceName, Player player, Coordinate coordinate) {
        super(pieceName, player, coordinate);
    }

    public PawnInfo(Piece pieceName, Player player, Coordinate presentPosition, int countOfAction) {
        super(pieceName, player, presentPosition, countOfAction);
    }

    @Override
    public UnitInfo changeInfo(int row, char col) {
        if (isPossibleDestination(new Coordinate(row, col))) {
            return new PawnInfo(super.getPieceName(), super.getPlayer(), new Coordinate(row, col), super.getCountOfAction() + 1);
        }
        throw new RuntimeException("이동 가능한 목적지가 아닙니다.");
    }

    public boolean isPossibleDestination(Coordinate destination) {
        Coordinate.PositionDiff positionDiff = super.getPresentPosition().diffTo(destination);
        return eachMovingLengthCheck(positionDiff, destination);
    }

    @Override
    public boolean eachMovingLengthCheck(Coordinate.PositionDiff positionDiff, Coordinate destination) {
        ChessBoard chessBoard = ChessBoard.getInstance();
        super.getPlayer().directionCheck(positionDiff);
        if (this.isOneDiffWithDirection(positionDiff) && chessBoard.isEnemy(this, destination))
            return true;
        if (this.isFirstAction()) {
            return Math.abs(positionDiff.getRowDiff()) <= 2 && positionDiff.getColDiff() == 0;
        }
        return Math.abs(positionDiff.getRowDiff()) <= 1 && positionDiff.getColDiff() == 0;
    }

}
