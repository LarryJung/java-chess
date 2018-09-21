package pieces;

import pieces.coordinate.Coordinate;
import pieces.unitInfo.*;

public class UnitInfoFactory {

    public static UnitInfo createUnitInfo(Piece pieceName, Player player, Coordinate coordinate) {
        switch (pieceName) {
            case PAWN:
                return new PawnInfo(pieceName, player, coordinate);
            case KNIGHT:
                return new KnightInfo(pieceName, player, coordinate);
            case ROOK:
                return new RookInfo(pieceName, player, coordinate);
            case BISHOP:
                return new BishopInfo(pieceName, player, coordinate);
            case QUEEN:
                return new QueenInfo(pieceName, player, coordinate);
            case KING:
                return new KingInfo(pieceName, player, coordinate);
            default:
                return null;
        }
    }
}
