public class CastlingHandler implements MoveHandler {
    private final RuleEngine ruleEngine;

    public CastlingHandler(RuleEngine ruleEngine) {
        this.ruleEngine = ruleEngine;
    }

    @Override
    public boolean canHandle(Board board, Move m, Color side) {
        Piece king = board.get(m.getFromR(), m.getFromC());
        if (king == null || king.getType() != Type.KING || king.getColor() != side) return false;

        int dr = Math.abs(m.getToR() - m.getFromR());
        int dc = Math.abs(m.getToC() - m.getFromC());
        if (dr != 0 || dc != 2) return false;

        if (king.hasMoved() || ruleEngine.isInCheck(board, side)) return false;

        int rookCol = (m.getToC() > m.getFromC()) ? 7 : 0;
        Piece rook = board.get(m.getFromR(), rookCol);

        if (rook == null || rook.getType() != Type.ROOK || rook.hasMoved()) return false;

        int startR = m.getFromR();
        int intermediateCol = (m.getToC() > m.getFromC()) ? m.getFromC() + 1 : m.getFromC() - 1;
        int finalCol = m.getToC();

        if (m.getToC() < m.getFromC()) {
            if (board.get(startR, 1) != null) return false;
        }
        if (board.get(startR, intermediateCol) != null) return false;
        if (board.get(startR, finalCol) != null) return false;

        if (ruleEngine.isSquareAttacked(board, startR, intermediateCol, side.getOpposite())) return false;
        if (ruleEngine.isSquareAttacked(board, startR, finalCol, side.getOpposite())) return false;

        return true;
    }

    @Override
    public MoveResult execute(Board board, Move m, Color side) {

        Piece originalKing = board.get(m.getFromR(), m.getFromC());

        board.set(m.getToR(), m.getToC(), originalKing);
        board.set(m.getFromR(), m.getFromC(), null);
        originalKing.setHasMoved(true);

        if (m.getToC() > m.getFromC()) {
            Piece rook = board.get(m.getFromR(), 7);
            board.set(m.getFromR(), 5, rook);
            board.set(m.getFromR(), 7, null);
            rook.setHasMoved(true);
        } else {
            Piece rook = board.get(m.getFromR(), 0);
            board.set(m.getFromR(), 3, rook);
            board.set(m.getFromR(), 0, null);
            rook.setHasMoved(true);
        }

        board.setLastMove(m);
        board.recordBoardState();

        return MoveResult.success();
    }
}