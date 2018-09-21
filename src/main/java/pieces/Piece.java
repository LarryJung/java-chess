package pieces;

public enum Piece {

    KING('K', Figure.kingBlack, Figure.kingWhite),
    QUEEN('Q', Figure.queenBlack, Figure.queenWhite),
    ROOK('R', Figure.rookBlack, Figure.rookWhite),
    BISHOP('B', Figure.bishopBlack, Figure.bishopWhite),
    KNIGHT('N', Figure.knightBlack, Figure.knightWhite),
    PAWN('P', Figure.pawnBlack, Figure.pawnWhite),
    EMPTY(' ', Figure.emptyBlack, Figure.emptyWhite);

    private char symbol;
    private Figure black;
    private Figure white;

    Piece(char symbol, Figure black, Figure white) {
        this.symbol = symbol;
        this.black = black;
        this.white = white;
    }

    public Figure mark(Player player) {
        if (player == Player.BLACK) return black;
        if (player == Player.WHITE) return white;
        return null;
    }

    public char getSymbol() {
        return symbol;
    }

    public Figure getBlack() {
        return black;
    }

    public Figure getWhite() {
        return white;
    }

    public static class Figure {
        static Figure queenWhite = new Figure(new String[]{
                "Q.W"
        });

        static Figure queenBlack = new Figure(new String[]{
                "Q.B"
        });

        static Figure kingWhite = new Figure(new String[]{
                "K.W"
        });

        static Figure kingBlack = new Figure(new String[]{
                "K.B"
        });

        static Figure bishopWhite = new Figure(new String[]{
                "B.W"
        });

        static Figure bishopBlack = new Figure(new String[]{
                "B.B"
        });

        static Figure knightWhite = new Figure(new String[]{
                "N.W"
        });

        static Figure knightBlack = new Figure(new String[]{
                "N.B"
        });

        static Figure rookWhite = new Figure(new String[]{
                "R.W"
        });

        static Figure rookBlack = new Figure(new String[]{
                "R.B"
        });

        static Figure pawnWhite = new Figure(new String[]{
                "P.W"
        });

        static Figure pawnBlack = new Figure(new String[]{
                "P.B"
        });

        static Figure emptyWhite = new Figure(new String[]{
                "   "
        });

        static Figure emptyBlack = new Figure(new String[]{
                "###"
        });

        String[] figure;
        public Figure (String[] figure) {
            this.figure = figure;
        }

        public void draw()  {
            for (int i = 0; i < figure.length; i++) {
                System.out.print(figure[i]);
            }
        }


        public static Figure getQueenWhite() {
            return queenWhite;
        }

        public static Figure getQueenBlack() {
            return queenBlack;
        }

        public static Figure getKingWhite() {
            return kingWhite;
        }

        public static Figure getKingBlack() {
            return kingBlack;
        }

        public static Figure getBishopWhite() {
            return bishopWhite;
        }

        public static Figure getBishopBlack() {
            return bishopBlack;
        }

        public static Figure getKnightWhite() {
            return knightWhite;
        }

        public static Figure getKnightBlack() {
            return knightBlack;
        }

        public static Figure getRookWhite() {
            return rookWhite;
        }

        public static Figure getRookBlack() {
            return rookBlack;
        }

        public static Figure getPawnWhite() {
            return pawnWhite;
        }

        public static Figure getPawnBlack() {
            return pawnBlack;
        }

        public static Figure getEmptyWhite() {
            return emptyWhite;
        }

        public static Figure getEmptyBlack() {
            return emptyBlack;
        }
    }

}
