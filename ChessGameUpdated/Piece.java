abstract class Piece {
    final Color color;
    boolean hasMoved = false;

    Piece(Color color) { this.color = color; }

    abstract boolean isValidMove(Board board, Move move);

    abstract Type getType();

    @Override
    public String toString() {
        char ch;
        switch (getType()) {
            case KING: ch = 'K'; break;
            case QUEEN: ch = 'Q'; break;
            case ROOK: ch = 'R'; break;
            case BISHOP: ch = 'B'; break;
            case KNIGHT: ch = 'N'; break;
            case PAWN: ch = 'P'; break;
            default: ch = '?';
        }
        return color == Color.WHITE ? "" + ch : "" + Character.toLowerCase(ch);
    }
}
