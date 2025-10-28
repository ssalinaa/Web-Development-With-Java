class Pawn extends Piece {
    Pawn(Color color) { super(color); }

    @Override
    boolean isValidMove(Board board, Move m) {
        int dir = (color == Color.WHITE ? -1 : 1);
        int dr = m.toR - m.fromR;
        int dc = m.toC - m.fromC;
        Piece dest = board.get(m.toR, m.toC);

        if (dc == 0 && dr == dir && dest == null) return true;

        if (dc == 0 && dr == 2*dir && !hasMoved &&
                dest == null && board.get(m.fromR + dir, m.fromC) == null)
            return true;

        if (Math.abs(dc) == 1 && dr == dir && dest != null && dest.color != color) return true;

        return false;
    }

    @Override
    Type getType() { return Type.PAWN; }
}