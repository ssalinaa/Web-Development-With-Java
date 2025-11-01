class Rook extends Piece {
    Rook(Color color) { super(color); }

    @Override
    boolean isValidMove(Board board, Move m) {
        int dr = m.toR - m.fromR;
        int dc = m.toC - m.fromC;
        if (dr == 0 || dc == 0) return board.isClearPath(m);
        return false;
    }

    @Override
    Type getType() { return Type.ROOK; }
}
