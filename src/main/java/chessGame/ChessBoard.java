package chessGame;

import pieces.*;
import pieces.coordinate.Coordinate;

import java.util.LinkedList;

public class ChessBoard {

    private LinkedList<Unit> chessUnitSet = new LinkedList<>();

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
        return chessUnitSet.stream().filter(unit -> unit.isPosition(i, a)).findFirst().orElse(new UnitImpl(Piece.EMPTY, Player.NONE, new Coordinate(i, a)));
    }

    public Unit pickUnitAt(Coordinate target) {
        return chessUnitSet.stream().filter(unit -> unit.isPosition(target)).findFirst().orElse(new UnitImpl(Piece.EMPTY, Player.NONE, target));
    }

    public boolean isEnemy(UnitInfo unitInfo, Coordinate destination) {
        return pickUnitAt(destination).isEnemy(unitInfo.getPlayer());
    }


    public boolean removeUnit(Unit target) {
        return chessUnitSet.remove(target);
    }

    public void updatePosition(Unit target) {
        chessUnitSet.add(target);
    }

    public void initBlack() {
        chessUnitSet.add(new UnitImpl(Piece.ROOK, Player.BLACK, new Coordinate(8, 'a')));
        chessUnitSet.add(new UnitImpl(Piece.KNIGHT, Player.BLACK, new Coordinate(8, 'b')));
        chessUnitSet.add(new UnitImpl(Piece.BISHOP, Player.BLACK, new Coordinate(8, 'c')));
        chessUnitSet.add(new UnitImpl(Piece.QUEEN, Player.BLACK, new Coordinate(8, 'd')));
        chessUnitSet.add(new UnitImpl(Piece.KING, Player.BLACK, new Coordinate(8, 'e')));
        chessUnitSet.add(new UnitImpl(Piece.BISHOP, Player.BLACK, new Coordinate(8, 'f')));
        chessUnitSet.add(new UnitImpl(Piece.KNIGHT, Player.BLACK, new Coordinate(8, 'g')));
        chessUnitSet.add(new UnitImpl(Piece.ROOK, Player.BLACK, new Coordinate(8, 'h')));

        chessUnitSet.add(new UnitImpl(Piece.PAWN, Player.BLACK, new Coordinate(7, 'a')));
        chessUnitSet.add(new UnitImpl(Piece.PAWN, Player.BLACK, new Coordinate(7, 'b')));
        chessUnitSet.add(new UnitImpl(Piece.PAWN, Player.BLACK, new Coordinate(7, 'c')));
        chessUnitSet.add(new UnitImpl(Piece.PAWN, Player.BLACK, new Coordinate(7, 'd')));
        chessUnitSet.add(new UnitImpl(Piece.PAWN, Player.BLACK, new Coordinate(7, 'e')));
        chessUnitSet.add(new UnitImpl(Piece.PAWN, Player.BLACK, new Coordinate(7, 'f')));
        chessUnitSet.add(new UnitImpl(Piece.PAWN, Player.BLACK, new Coordinate(7, 'g')));
        chessUnitSet.add(new UnitImpl(Piece.PAWN, Player.BLACK, new Coordinate(7, 'h')));
    }

    public void initWhite() {
        chessUnitSet.add(new UnitImpl(Piece.ROOK, Player.WHITE, new Coordinate(1, 'a')));
        chessUnitSet.add(new UnitImpl(Piece.KNIGHT, Player.WHITE, new Coordinate(1, 'b')));
        chessUnitSet.add(new UnitImpl(Piece.BISHOP, Player.WHITE, new Coordinate(1, 'c')));
        chessUnitSet.add(new UnitImpl(Piece.QUEEN, Player.WHITE, new Coordinate(1, 'd')));
        chessUnitSet.add(new UnitImpl(Piece.KING, Player.WHITE, new Coordinate(1, 'e')));
        chessUnitSet.add(new UnitImpl(Piece.BISHOP, Player.WHITE, new Coordinate(1, 'f')));
        chessUnitSet.add(new UnitImpl(Piece.KNIGHT, Player.WHITE, new Coordinate(1, 'g')));
        chessUnitSet.add(new UnitImpl(Piece.ROOK, Player.WHITE, new Coordinate(1, 'h')));

        chessUnitSet.add(new UnitImpl(Piece.PAWN, Player.WHITE, new Coordinate(2, 'a')));
        chessUnitSet.add(new UnitImpl(Piece.PAWN, Player.WHITE, new Coordinate(2, 'b')));
        chessUnitSet.add(new UnitImpl(Piece.PAWN, Player.WHITE, new Coordinate(2, 'c')));
        chessUnitSet.add(new UnitImpl(Piece.PAWN, Player.WHITE, new Coordinate(2, 'd')));
        chessUnitSet.add(new UnitImpl(Piece.PAWN, Player.WHITE, new Coordinate(2, 'e')));
        chessUnitSet.add(new UnitImpl(Piece.PAWN, Player.WHITE, new Coordinate(2, 'f')));
        chessUnitSet.add(new UnitImpl(Piece.PAWN, Player.WHITE, new Coordinate(2, 'g')));
        chessUnitSet.add(new UnitImpl(Piece.PAWN, Player.WHITE, new Coordinate(2, 'h')));
    }

    public void clear() {
        chessBoard = null;
    }
}
