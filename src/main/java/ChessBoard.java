import pieces.Piece;
import pieces.Player;
import pieces.Unit;
import pieces.UnitImpl;
import pieces.coordinate.Coordinate;

import java.util.HashMap;
import java.util.Map;

public class ChessBoard {

    private Map<Coordinate, Unit> chessMap = new HashMap<>();

    public void initBlack() {
        chessMap.put(new Coordinate(8, 'a'), new UnitImpl(Piece.ROOK, Player.BLACK));
        chessMap.put(new Coordinate(8, 'b'), new UnitImpl(Piece.KNIGHT, Player.BLACK));
        chessMap.put(new Coordinate(8, 'c'), new UnitImpl(Piece.BISHOP, Player.BLACK));
        chessMap.put(new Coordinate(8, 'd'), new UnitImpl(Piece.QUEEN, Player.BLACK));
        chessMap.put(new Coordinate(8, 'e'), new UnitImpl(Piece.KING, Player.BLACK));
        chessMap.put(new Coordinate(8, 'f'), new UnitImpl(Piece.BISHOP, Player.BLACK));
        chessMap.put(new Coordinate(8, 'g'), new UnitImpl(Piece.KNIGHT, Player.BLACK));
        chessMap.put(new Coordinate(8, 'h'), new UnitImpl(Piece.ROOK, Player.BLACK));

        chessMap.put(new Coordinate(7, 'a'), new UnitImpl(Piece.PAWN, Player.BLACK));
        chessMap.put(new Coordinate(7, 'b'), new UnitImpl(Piece.PAWN, Player.BLACK));
        chessMap.put(new Coordinate(7, 'c'), new UnitImpl(Piece.PAWN, Player.BLACK));
        chessMap.put(new Coordinate(7, 'd'), new UnitImpl(Piece.PAWN, Player.BLACK));
        chessMap.put(new Coordinate(7, 'e'), new UnitImpl(Piece.PAWN, Player.BLACK));
        chessMap.put(new Coordinate(7, 'f'), new UnitImpl(Piece.PAWN, Player.BLACK));
        chessMap.put(new Coordinate(7, 'g'), new UnitImpl(Piece.PAWN, Player.BLACK));
        chessMap.put(new Coordinate(7, 'h'), new UnitImpl(Piece.PAWN, Player.BLACK));
    }

    public Unit atPosition(int i, char a) {
        return chessMap.get(new Coordinate(i, a));
    }

    public void initWhite() {
        chessMap.put(new Coordinate(1, 'a'), new UnitImpl(Piece.ROOK, Player.BLACK));
        chessMap.put(new Coordinate(1, 'b'), new UnitImpl(Piece.KNIGHT, Player.BLACK));
        chessMap.put(new Coordinate(1, 'c'), new UnitImpl(Piece.BISHOP, Player.BLACK));
        chessMap.put(new Coordinate(1, 'd'), new UnitImpl(Piece.QUEEN, Player.BLACK));
        chessMap.put(new Coordinate(1, 'e'), new UnitImpl(Piece.KING, Player.BLACK));
        chessMap.put(new Coordinate(1, 'f'), new UnitImpl(Piece.BISHOP, Player.BLACK));
        chessMap.put(new Coordinate(1, 'g'), new UnitImpl(Piece.KNIGHT, Player.BLACK));
        chessMap.put(new Coordinate(1, 'h'), new UnitImpl(Piece.ROOK, Player.BLACK));

        chessMap.put(new Coordinate(2, 'a'), new UnitImpl(Piece.PAWN, Player.BLACK));
        chessMap.put(new Coordinate(2, 'b'), new UnitImpl(Piece.PAWN, Player.BLACK));
        chessMap.put(new Coordinate(2, 'c'), new UnitImpl(Piece.PAWN, Player.BLACK));
        chessMap.put(new Coordinate(2, 'd'), new UnitImpl(Piece.PAWN, Player.BLACK));
        chessMap.put(new Coordinate(2, 'e'), new UnitImpl(Piece.PAWN, Player.BLACK));
        chessMap.put(new Coordinate(2, 'f'), new UnitImpl(Piece.PAWN, Player.BLACK));
        chessMap.put(new Coordinate(2, 'g'), new UnitImpl(Piece.PAWN, Player.BLACK));
        chessMap.put(new Coordinate(2, 'h'), new UnitImpl(Piece.PAWN, Player.BLACK));
    }
}
