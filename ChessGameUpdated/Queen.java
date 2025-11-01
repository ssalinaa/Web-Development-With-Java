class Queen extends Piece {
    Queen(Color color) {
        super(color);
    }

    @Override
    Piece copy() {
        Queen newQueen = new Queen(getColor());
        newQueen.setHasMoved(hasMoved());
        return newQueen;
    }

    @Override
    boolean isValidMove(Board board, Move m) {
        int dr = m.getToR() - m.getFromR();
        int dc = m.getToC() - m.getFromC();

        boolean isStraight = (dr == 0 && dc != 0) || (dc == 0 && dr != 0);
        boolean isDiagonal = Math.abs(dr) == Math.abs(dc);

        if (!isStraight && !isDiagonal) return false;
        if (dr == 0 && dc == 0) return false;

        return isClearPathInternal(board, m);
    }

    @Override
    Type getType() {
        return Type.QUEEN;
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