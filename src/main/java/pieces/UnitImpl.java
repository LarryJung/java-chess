package pieces;

import chessGame.ChessBoard;
import pieces.coordinate.Coordinate;
import pieces.unitInfo.UnitInfo;

import static pieces.Piece.*;

public class UnitImpl implements Unit {

    private UnitInfo unitInfo;

    public UnitImpl(Piece pieceName, Player player, Coordinate coordinate) {
        this.unitInfo = UnitInfoFactory.createUnitInfo(pieceName, player, coordinate);
    }

    @Override
    public Piece getPiece() {
        return unitInfo.getPieceName();
    }

    @Override
    public Unit moveTo(int row, char col) {
        UnitInfo updatedUnitInfo = unitInfo.changeInfo(row, col);
        System.out.println(String.format("%s 유저가 %s 을 옮겼습니다. %s -> %s", unitInfo.getPlayer(), unitInfo.getPieceName(), unitInfo.getPositionString(), updatedUnitInfo.getPositionString()));
        ChessBoard.getInstance().removeUnit(this);
        this.unitInfo = updatedUnitInfo;
        ChessBoard.getInstance().updatePosition(this);
        return this;
    }

    @Override
    public Unit moveTo(Coordinate destination) {
        UnitInfo updatedUnitInfo = unitInfo.changeInfo(destination.getRow(), (char) destination.getColumn());
        System.out.println(String.format("%s 유저가 %s 을 옮겼습니다. %s -> %s", unitInfo.getPlayer(), unitInfo.getPieceName(), unitInfo.getPositionString(), updatedUnitInfo.getPositionString()));
        ChessBoard.getInstance().removeUnit(this);
        this.unitInfo = updatedUnitInfo;
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
        return this.unitInfo.getPlayer().isEnemy(player);
    }

    @Override
    public Figure getMark() {
        return unitInfo.findMark();
    }

    @Override
    public boolean isAlly(Player player) {
        return this.unitInfo.getPlayer().isAlly(player);
    }

    @Override
    public void isAttackedBy(Unit unit) {
        System.out.println(String.format("%s의 %s가 %s의 %s에 의해 공격 당했습니다.", unitInfo.getPlayer(), unitInfo.getPieceName(), unit.getUnitInfo().getPlayer(), unit.getUnitInfo().getPieceName()));
        unitInfo.isAttacked();
        ChessBoard chessBoard = ChessBoard.getInstance();
        chessBoard.addDeadUnit(this);
    }

    @Override
    public UnitInfo getUnitInfo() {
        return unitInfo;
    }

    @Override
    public String toString() {
        return unitInfo.toString();
    }
}
