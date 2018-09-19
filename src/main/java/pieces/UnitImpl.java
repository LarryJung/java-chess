package pieces;

import chessGame.ChessBoard;
import pieces.coordinate.Coordinate;

public class UnitImpl implements Unit {

    private UnitInfo unitInfo;

    public UnitImpl(Piece pieceName, Player player, Coordinate coordinate) {
        this.unitInfo = new UnitInfo(pieceName, player, coordinate);
    }

    @Override
    public Piece getPiece() {
        return unitInfo.getPieceName();
    }

    @Override
    public Unit moveTo(int row, char col) {
        ChessBoard.getInstance().removeUnit(this);
        this.unitInfo = unitInfo.changeInfo(row, col);
        ChessBoard.getInstance().updatePosition(this);
        return this;
    }

    @Override
    public boolean isPosition(int row, char col) {
        return unitInfo.isPosition(row, col);
    }

    @Override
    public boolean isPosition(Coordinate target) {
        return unitInfo.isPosition(target);
    }

    @Override
    public boolean isEnemy(Player player) {
        return this.unitInfo.getPlayer() != player;
    }
}
