package pieces.unitInfo;

import chessGame.ChessBoard;
import pieces.Piece;
import pieces.Player;
import pieces.coordinate.Coordinate;

public class PawnInfo extends UnitInfo {

    public PawnInfo() {

    }

    public PawnInfo(Piece pieceName, Player player, Coordinate coordinate) {
        super(pieceName, player, coordinate);
    }

    public PawnInfo(Piece pieceName, Player player, Coordinate presentPosition, int countOfAction) {
        super(pieceName, player, presentPosition, countOfAction);
    }

    @Override
    public UnitInfo changeInfo(int row, char col) {
        if (isPossibleDestination(new Coordinate(row, col))) {
            attackCheck(new Coordinate(row, col));
            return new PawnInfo(super.getPieceName(), super.getPlayer(), new Coordinate(row, col), super.getCountOfAction() + 1);
        }
        throw new RuntimeException("이동 가능한 목적지가 아닙니다.");
    }

    @Override
    public UnitInfo directionConditionCheck(Coordinate destination) {
        Coordinate.PositionDiff positionDiff = super.getPresentPosition().diffTo(destination);
        ChessBoard chessBoard = ChessBoard.getInstance();
        super.getPlayer().directionCheck(positionDiff);
        if (positionDiff.isDiagonal() && positionDiff.isLength(Math.sqrt(2))) {
            if (!chessBoard.isEnemy(this, destination)) {
                throw new RuntimeException("한칸 대각선 위에 적군이 없습니다.");
            }
            return this;
        }
        if (this.isFirstAction()) {
            if (!(Math.abs(positionDiff.getRowDiff()) <= 2 && positionDiff.getColDiff() == 0) && chessBoard.isEnemy(this, destination)) {
                throw new RuntimeException("첫번째 이동은 2칸 이하입니다.");
            }
            return this;
        }
        if (!this.isFirstAction()) {
            if (!(Math.abs(positionDiff.getRowDiff()) <= 1 && positionDiff.getColDiff() == 0)) {
                throw new RuntimeException("이동은 한칸 이하입니다.");
            }
            if (chessBoard.isEnemy(this, destination)) {
                throw new RuntimeException("가려는 위치에 적군이 있습니다.");
            }
        }
        return this;
    }

}
