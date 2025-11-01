import java.util.List;
import java.util.ArrayList;

public class ChessRuleEngine implements RuleEngine {

    @Override
    public boolean isLegalMove(Board board, Move m, Color side) {
        Piece p = board.get(m.getFromR(), m.getFromC());
        if(p == null || p.getColor() != side) return false;
        Piece target = board.get(m.getToR(), m.getToC());
        if(target != null && target.getColor() == side) return false;

        if(!p.isValidMove(board, m)) return false;

        return !leavesKingInCheck(board, m, side);
    }

    @Override
    public boolean isInCheck(Board board, Color side) {
        int kr = -1, kc = -1;
        for(int r = 0; r < 8; r++) {
            for(int c = 0; c < 8; c++){
                Piece p = board.get(r, c);
                if(p != null && p.getType() == Type.KING && p.getColor() == side){
                    kr = r; kc = c;
                    break;
                }
            }
        }
        if(kr == -1) return true;

        Color enemy = side.getOpposite();
        return isSquareAttacked(board, kr, kc, enemy);
    }

    @Override
    public boolean isCheckmate(Board board, Color side) {
        return isInCheck(board, side) && !hasLegalMoves(board, side);
    }

    @Override
    public boolean hasLegalMoves(Board board, Color side) {
        for(int r = 0; r < 8; r++) {
            for(int c = 0; c < 8; c++){
                Piece p = board.get(r, c);
                if(p == null || p.getColor() != side) continue;

                for(int tr = 0; tr < 8; tr++) {
                    for(int tc = 0; tc < 8; tc++){
                        Move m = new Move(r, c, tr, tc, null);
                        if(isLegalMove(board, m, side)) return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean leavesKingInCheck(Board board, Move m, Color side) {
        Board copy = board.copy();
        Piece p = copy.get(m.getFromR(), m.getFromC());
        copy.set(m.getToR(), m.getToC(), p);
        copy.set(m.getFromR(), m.getFromC(), null);

        return isInCheck(copy, side);
    }

    public boolean isSquareAttacked(Board board, int r, int c, Color enemy) {
        for(int fr = 0; fr < 8; fr++) {
            for(int fc = 0; fc < 8; fc++){
                Piece p = board.get(fr, fc);
                if(p == null || p.getColor() != enemy) continue;

                Move m = new Move(fr, fc, r, c, null);

                if (p.getType() == Type.PAWN) {
                    int dir = (enemy == Color.WHITE ? -1 : 1);
                    int dr = m.getToR() - m.getFromR();
                    int dc = m.getToC() - m.getFromC();

                    if (Math.abs(dc) == 1 && dr == dir) {
                        return true;
                    }
                    continue;
                }

                if(p.isValidMove(board, m)) {
                    return true;
                }
            }
        }
        return false;
    }
}