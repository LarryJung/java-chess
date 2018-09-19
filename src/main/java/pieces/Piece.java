package pieces;

public enum Piece {

    KING('K'),
    QUEEN('Q'),
    ROOK('R'),
    BISHOP('B'),
    KNIGHT('N'),
    PAWN('P');

    private char symbol;

    Piece(char symbol) {
        this.symbol = symbol;
    }

}
