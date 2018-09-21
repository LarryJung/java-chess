package pieces.unitInfo;

import chessGame.ChessBoard;
import pieces.Piece;
import pieces.Player;
import pieces.coordinate.Coordinate;

public class KnightInfo extends UnitInfo {

    public KnightInfo(Piece pieceName, Player player, Coordinate coordinate) {
        super(pieceName, player, coordinate);
    }
    public KnightInfo(Piece pieceName, Player player, Coordinate presentPosition, int countOfAction) {
        super(pieceName, player, presentPosition, countOfAction);
    }

    @Override
    public UnitInfo changeInfo(int row, char col) {
        if (isPossibleDestination(new Coordinate(row, col))) {
            return new KnightInfo(super.getPieceName(), super.getPlayer(), new Coordinate(row, col), super.getCountOfAction() + 1);
        }
        throw new RuntimeException("이동 가능한 목적지가 아닙니다.");
    }

    @Override
    public UnitInfo directionConditionCheck(Coordinate destination) {
        Coordinate.PositionDiff positionDiff = super.getPresentPosition().diffTo(destination);
        if (!((Math.abs(positionDiff.getColDiff()) + Math.abs(positionDiff.getRowDiff())) == 3)) {
            throw new RuntimeException("나이트가 이동할 수 없는 위치입니다." + destination.toString());
        }
        return this;
    }

    @Override
    public boolean stepScan(Coordinate destination) {
        ChessBoard chessBoard = ChessBoard.getInstance();
        return !chessBoard.isAlly(this, destination);
    }

}
