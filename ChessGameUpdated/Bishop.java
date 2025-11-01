class Bishop extends Piece {
    Bishop(Color color) {
        super(color);
    }

    @Override
    Piece copy() {
        Bishop newBishop = new Bishop(getColor());
        newBishop.setHasMoved(hasMoved());
        return newBishop;
    }

    @Override
    boolean isValidMove(Board board, Move m) {
        int dr = Math.abs(m.getToR() - m.getFromR());
        int dc = Math.abs(m.getToC() - m.getFromC());

        if (dr != dc || dr == 0) return false;

        return isClearPathInternal(board, m);
    }

    @Override
    Type getType() {
        return Type.BISHOP;
    }

    private boolean isClearPathInternal(Board board, Move m) {
        int dr = Integer.signum(m.getToR() - m.getFromR());
        int dc = Integer.signum(m.getToC() - m.getFromC());

        int r = m.getFromR() + dr;
        int c = m.getFromC() + dc;

        while(r != m.getToR() || c != m.getToC()){
            if(board.get(r, c) != null) return false;
            r += dr; c += dc;
        }
        return true;
    }
}