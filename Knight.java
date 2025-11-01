class Knight extends Piece {
    Knight(Color color) { super(color); }

    @Override
    boolean isValidMove(Board board, Move m) {
        int dr = Math.abs(m.toR - m.fromR);
        int dc = Math.abs(m.toC - m.fromC);
        return (dr == 2 && dc == 1) || (dr == 1 && dc == 2);
    }

    @Override
    Type getType() { return Type.KNIGHT; }
}
