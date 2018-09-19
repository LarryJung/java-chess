package pieces;

public enum Player {

    BLACK,
    WHITE,
    NONE;

    public boolean isEnemy(Player target) {
        if (this == BLACK) {
            return target == WHITE;
        }
        return this == WHITE && target == BLACK;
    }


}
