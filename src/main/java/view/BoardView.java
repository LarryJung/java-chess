package view;

import chessGame.ChessBoard;
import pieces.coordinate.Coordinate;

import java.io.IOException;

public class BoardView {

    private Tile[][] tileMap = new Tile[8][8];
    private ChessBoard chessBoard = ChessBoard.getInstance();

    public BoardView() {
        initTiles();
    }

    private void initTiles() {
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                Tile tile = new Tile(new Coordinate(i+1, j+97));
                tile.mark(chessBoard);
                tileMap[7- i][j] = tile;
            }
        }
    }

    public void drawBoard() throws IOException {
        System.out.println();
        System.out.println("=+=+=+=+=+=+=+ CHESS GAME =+=+=+=+=+=+=+=");
        System.out.println();
        initTiles();
        for (int i = 0; i <= 7; i++) {
            System.out.print(8-i+ " ");
            for (int j = 0; j <= 7; j++) {
                System.out.print("|");
                tileMap[i][j].draw();
                System.out.print("|");
            }
            System.out.println();
        }
        System.out.println("    a    b    c    d    e    f    g    h ");
    }

}
