class King extends Piece {
    King(Color color) { super(color); }

    @Override
    boolean isValidMove(Board board, Move m) {
        int dr = Math.abs(m.toR - m.fromR);
        int dc = Math.abs(m.toC - m.fromC);
        return dr <= 1 && dc <= 1;
    }

    @Override
    Type getType() { return Type.KING; }
}