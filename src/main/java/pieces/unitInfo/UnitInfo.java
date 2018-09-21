package pieces.unitInfo;

import chessGame.ChessBoard;
import pieces.Piece;
import pieces.Piece.Figure;
import pieces.Player;
import pieces.coordinate.Coordinate;

import java.util.ArrayList;
import java.util.List;

import static pieces.coordinate.Coordinate.*;

public abstract class UnitInfo {

    private Piece pieceName;
    private Player player;
    private Coordinate presentPosition;
    private int countOfAction;

    public UnitInfo() {
        
    }

    public UnitInfo(Piece pieceName, Player player, Coordinate coordinate) {
        this(pieceName, player, coordinate, 0);
    }

    public UnitInfo(Piece pieceName, Player player, Coordinate presentPosition, int countOfAction) {
        this.pieceName = pieceName;
        this.player = player;
        this.presentPosition = presentPosition;
        this.countOfAction = countOfAction;
    }

    public Piece getPieceName() {
        return pieceName;
    }

    public Player getPlayer() {
        return player;
    }

    public boolean isPosition(int row, char col) {
        return presentPosition.equals(new Coordinate(row, col));
    }

    public boolean isPosition(Coordinate target) {
        return presentPosition.equals(target);
    }

    public abstract UnitInfo changeInfo(int row, char col);

    public boolean isPossibleDestination(Coordinate destination) {
        return directionConditionCheck(destination)
                .stepScan(destination);
    }

    public abstract UnitInfo directionConditionCheck(Coordinate destination);

    public boolean isFirstAction() {
        return countOfAction == 0;
    }

    public String getPositionString() {
        return presentPosition.toString();
    }

    public Figure findMark() {
        Figure mark = pieceName.mark(player);
        if (mark == null) {
            return presentPosition.assignEmptyMark();
        }
        return mark;
    }

    public int getCountOfAction() {
        return countOfAction;
    }

    public Coordinate getPresentPosition() {
        return presentPosition;
    }

    public boolean stepScan(Coordinate destination) {
        ChessBoard chessBoard = ChessBoard.getInstance();
        List<Coordinate> coordinates = makeLineSteps(presentPosition, destination);
        return coordinates.stream().noneMatch(c -> chessBoard.isAlly(this, c));
    }

    private List<Coordinate> makeLineSteps(Coordinate presentPosition, Coordinate destination) {
        PositionDiff positionDiff = presentPosition.diffTo(destination);
        List<Coordinate> coordinates = new ArrayList<>();
        if (positionDiff.isDiagonal()) {
            coordinates = Coordinate.makeStepsDiagonal(coordinates, presentPosition, destination);
        }
        if (positionDiff.isOthogonal()) {
            coordinates = Coordinate.makeStepsOthogonal(coordinates, presentPosition, destination);
        }
        return coordinates;
    }
}
