public class EnPassantHandler implements MoveHandler {

    private final RuleEngine ruleEngine;

    public EnPassantHandler(RuleEngine ruleEngine) {
        this.ruleEngine = ruleEngine;
    }

    @Override
    public boolean canHandle(Board board, Move m, Color side) {
        Piece pawn = board.get(m.getFromR(), m.getFromC());
        if (pawn == null || pawn.getType() != Type.PAWN || pawn.getColor() != side) return false;

        int dir = (pawn.getColor() == Color.WHITE ? -1 : 1);
        int dr = m.getToR() - m.getFromR();
        int dc = m.getToC() - m.getFromC();

        if (Math.abs(dc) != 1 || dr != dir || board.get(m.getToR(), m.getToC()) != null) return false;

        Piece lastMovedPawn = board.getLastMovedPawn();

        return lastMovedPawn != null &&
                lastMovedPawn.getColor() != side &&
                board.get(m.getFromR(), m.getToC()) == lastMovedPawn;
    }

    @Override
    public MoveResult execute(Board board, Move m, Color side) {
        Board copy = board.copy();

        Piece copyPawn = copy.get(m.getFromR(), m.getFromC());

        copy.set(m.getToR(), m.getToC(), copyPawn);
        copy.set(m.getFromR(), m.getFromC(), null);
        copy.set(m.getFromR(), m.getToC(), null);

        if (ruleEngine.isInCheck(copy, side)) {
            return MoveResult.failure(
                    MoveResultType.SPECIAL_MOVE_FAILED,
                    "En Passant leads to a check."
            );
        }

        Piece originalPawn = board.get(m.getFromR(), m.getFromC());

        board.set(m.getToR(), m.getToC(), originalPawn);
        board.set(m.getFromR(), m.getFromC(), null);
        board.set(m.getFromR(), m.getToC(), null);

        originalPawn.setHasMoved(true);
        board.setLastMove(m);
        board.recordBoardState();

        return MoveResult.success();
    }
}