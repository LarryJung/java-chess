package view;

import pieces.coordinate.Coordinate;

import java.util.Scanner;

public class Input {

    private Scanner scanner = new Scanner(System.in);

    public Coordinate takePosition() {
        System.out.print("row >>");
        char row = scanner.next().charAt(0);
        System.out.println();
        System.out.print("col >>");
        char col = scanner.next().charAt(0);
        System.out.println();
        return new Coordinate(row, col);
    }

}
