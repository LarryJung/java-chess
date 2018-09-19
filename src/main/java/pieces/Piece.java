package pieces;

import chessGame.ChessBoard;
import pieces.coordinate.Coordinate;

import static pieces.coordinate.Coordinate.*;

public enum Piece {

    KING('K'),
    QUEEN('Q'),
    ROOK('R'),
    BISHOP('B'),
    KNIGHT('N'),
    PAWN('P'),
    EMPTY(' ');

    private char symbol;

    Piece(char symbol) {
        this.symbol = symbol;
    }

    public boolean isPossibleDestination(Coordinate presentPosition, Coordinate destination, UnitInfo unitInfo) {
        PositionDiff positionDiff = presentPosition.diffTo(destination);
        switch (this) {
            case PAWN:
                if (unitInfo.isOneDiffWithDirection(positionDiff) && ChessBoard.getInstance().isEnemy(unitInfo, destination)) return true;
                if (unitInfo.isFirstAction() && positionDiff.getRowDiff() == 2 && positionDiff.getColDiff() == 0) return true;
                return !unitInfo.isFirstAction() && positionDiff.getRowDiff() == 1 && positionDiff.getColDiff() == 0;
            default:
                return true;
        }

    }
}
