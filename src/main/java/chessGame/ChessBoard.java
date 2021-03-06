package chessGame;

import pieces.*;
import pieces.coordinate.Coordinate;
import pieces.unitInfo.UnitInfo;

import java.util.LinkedList;

public class ChessBoard {

    private LinkedList<Unit> chessUnitSetAlive = new LinkedList<>();
    private LinkedList<Unit> chessUnitSetDead = new LinkedList<>();

    private static ChessBoard chessBoard = new ChessBoard().init();

    public static ChessBoard getInstance() {
        if (chessBoard == null) {
            chessBoard = new ChessBoard().init();
        }
        return chessBoard;
    }

    private ChessBoard() {

    }

    public ChessBoard init() {
        initBlack();
        initWhite();
        return this;
    }

    public Unit pickUnitAt(int i, char a) {
        return chessUnitSetAlive.stream().filter(unit -> unit.isPosition(i, a)).findFirst().orElse(new UnitImpl(Piece.EMPTY, Player.NONE, new Coordinate(i, a)));
    }

    public Unit pickUnitAt(Coordinate target) {
        return chessUnitSetAlive.stream().filter(unit -> unit.isPosition(target)).findFirst().orElse(new UnitImpl(Piece.EMPTY, Player.NONE, target));
    }

    public Unit pickDeadUnitAt(int i, char a) {
        return chessUnitSetDead.stream().filter(unit -> unit.isPosition(i, a)).findFirst().orElse(new UnitImpl(Piece.EMPTY, Player.NONE, new Coordinate(i, a)));
    }

    public Unit pickDeadUnitAt(Coordinate target) {
        return chessUnitSetDead.stream().filter(unit -> unit.isPosition(target)).findFirst().orElse(new UnitImpl(Piece.EMPTY, Player.NONE, target));
    }

    public boolean isEnemy(UnitInfo unitInfo, Coordinate destination) {
        return pickUnitAt(destination).isEnemy(unitInfo.getPlayer());
    }

    public boolean isAlly(UnitInfo unitInfo, Coordinate destination) {
        return pickUnitAt(destination).isAlly(unitInfo.getPlayer());
    }

    public boolean removeUnit(Unit target) {
        return chessUnitSetAlive.remove(target);
    }

    public void updatePosition(Unit target) {
        chessUnitSetAlive.add(target);
    }

    public void addUnit(Unit unit) {
        chessUnitSetAlive.add(unit);
    }

    public void initBlack() {
        chessUnitSetAlive.add(new UnitImpl(Piece.ROOK, Player.BLACK, new Coordinate(8, 'a')));
        chessUnitSetAlive.add(new UnitImpl(Piece.KNIGHT, Player.BLACK, new Coordinate(8, 'b')));
        chessUnitSetAlive.add(new UnitImpl(Piece.BISHOP, Player.BLACK, new Coordinate(8, 'c')));
        chessUnitSetAlive.add(new UnitImpl(Piece.QUEEN, Player.BLACK, new Coordinate(8, 'd')));
        chessUnitSetAlive.add(new UnitImpl(Piece.KING, Player.BLACK, new Coordinate(8, 'e')));
        chessUnitSetAlive.add(new UnitImpl(Piece.BISHOP, Player.BLACK, new Coordinate(8, 'f')));
        chessUnitSetAlive.add(new UnitImpl(Piece.KNIGHT, Player.BLACK, new Coordinate(8, 'g')));
        chessUnitSetAlive.add(new UnitImpl(Piece.ROOK, Player.BLACK, new Coordinate(8, 'h')));

        chessUnitSetAlive.add(new UnitImpl(Piece.PAWN, Player.BLACK, new Coordinate(7, 'a')));
        chessUnitSetAlive.add(new UnitImpl(Piece.PAWN, Player.BLACK, new Coordinate(7, 'b')));
        chessUnitSetAlive.add(new UnitImpl(Piece.PAWN, Player.BLACK, new Coordinate(7, 'c')));
        chessUnitSetAlive.add(new UnitImpl(Piece.PAWN, Player.BLACK, new Coordinate(7, 'd')));
        chessUnitSetAlive.add(new UnitImpl(Piece.PAWN, Player.BLACK, new Coordinate(7, 'e')));
        chessUnitSetAlive.add(new UnitImpl(Piece.PAWN, Player.BLACK, new Coordinate(7, 'f')));
        chessUnitSetAlive.add(new UnitImpl(Piece.PAWN, Player.BLACK, new Coordinate(7, 'g')));
        chessUnitSetAlive.add(new UnitImpl(Piece.PAWN, Player.BLACK, new Coordinate(7, 'h')));
    }

    public void initWhite() {
        chessUnitSetAlive.add(new UnitImpl(Piece.ROOK, Player.WHITE, new Coordinate(1, 'a')));
        chessUnitSetAlive.add(new UnitImpl(Piece.KNIGHT, Player.WHITE, new Coordinate(1, 'b')));
        chessUnitSetAlive.add(new UnitImpl(Piece.BISHOP, Player.WHITE, new Coordinate(1, 'c')));
        chessUnitSetAlive.add(new UnitImpl(Piece.QUEEN, Player.WHITE, new Coordinate(1, 'd')));
        chessUnitSetAlive.add(new UnitImpl(Piece.KING, Player.WHITE, new Coordinate(1, 'e')));
        chessUnitSetAlive.add(new UnitImpl(Piece.BISHOP, Player.WHITE, new Coordinate(1, 'f')));
        chessUnitSetAlive.add(new UnitImpl(Piece.KNIGHT, Player.WHITE, new Coordinate(1, 'g')));
        chessUnitSetAlive.add(new UnitImpl(Piece.ROOK, Player.WHITE, new Coordinate(1, 'h')));

        chessUnitSetAlive.add(new UnitImpl(Piece.PAWN, Player.WHITE, new Coordinate(2, 'a')));
        chessUnitSetAlive.add(new UnitImpl(Piece.PAWN, Player.WHITE, new Coordinate(2, 'b')));
        chessUnitSetAlive.add(new UnitImpl(Piece.PAWN, Player.WHITE, new Coordinate(2, 'c')));
        chessUnitSetAlive.add(new UnitImpl(Piece.PAWN, Player.WHITE, new Coordinate(2, 'd')));
        chessUnitSetAlive.add(new UnitImpl(Piece.PAWN, Player.WHITE, new Coordinate(2, 'e')));
        chessUnitSetAlive.add(new UnitImpl(Piece.PAWN, Player.WHITE, new Coordinate(2, 'f')));
        chessUnitSetAlive.add(new UnitImpl(Piece.PAWN, Player.WHITE, new Coordinate(2, 'g')));
        chessUnitSetAlive.add(new UnitImpl(Piece.PAWN, Player.WHITE, new Coordinate(2, 'h')));
    }

    public void clearSet() {
        chessUnitSetDead.clear();
        chessUnitSetAlive.clear();
    }

    public void clearAll() {
        chessBoard = null;
    }

    public Piece.Figure findMark(Coordinate coordinate) {
        return pickUnitAt(coordinate).getMark();
    }

    public void addDeadUnit(UnitImpl unit) {
        chessUnitSetDead.add(unit);
        chessUnitSetAlive.remove(pickUnitAt(unit.getUnitInfo().getPresentPosition()));
    }

    public boolean isCheckMate() {
        Unit whiteKing = findKing(Player.WHITE);
        Unit blackKing = findKing(Player.BLACK);
        if (chessUnitSetAlive.stream()
                .filter(unit -> unit.getUnitInfo().getPlayer() == Player.BLACK && unit.getPiece() != Piece.KING)
                .anyMatch(blackUnit -> blackUnit.getUnitInfo().isPossibleDestination(whiteKing.getUnitInfo().getPresentPosition()))
                ||
                chessUnitSetAlive.stream()
                        .filter(unit -> unit.getUnitInfo().getPlayer() == Player.WHITE && unit.getPiece() != Piece.KING)
                        .anyMatch(blackUnit -> blackUnit.getUnitInfo().isPossibleDestination(blackKing.getUnitInfo().getPresentPosition()))) {
            System.out.println("체크 메이트 입니다.");
            return true;
        }
        return false;
    }

    private Unit findKing(Player player) {
        return chessUnitSetAlive.stream().filter(unit ->
                unit.getPiece() == Piece.KING &&
                        unit.getUnitInfo().getPlayer() == player).findFirst().orElseThrow(() -> new RuntimeException("더 이상 왕이 없습니다."));
    }

    public LinkedList<Unit> getChessUnitSetAlive() {
        return chessUnitSetAlive;
    }

    public LinkedList<Unit> getChessUnitSetDead() {
        return chessUnitSetDead;
    }

    public boolean isGameEnd() {
        try {
            findKing(Player.WHITE);
            findKing(Player.BLACK);
            return false;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println("게임이 종료되었습니다.");
            return true;
        }
    }
}
