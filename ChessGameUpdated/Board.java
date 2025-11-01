import java.util.ArrayList;
import java.util.List;

class Board {
    private Piece[][] boardState;
    private List<String> history;
    private Move lastMove = null;

    Board() {
        this.boardState = new Piece[8][8];
        this.history = new ArrayList<>();
    }

    void setup() {
        for(int r = 0; r < 8; r++) for(int c = 0; c < 8; c++) boardState[r][c] = null;

        for(int c = 0; c < 8; c++){
            boardState[6][c] = new Pawn(Color.WHITE);
            boardState[1][c] = new Pawn(Color.BLACK);
        }

        boardState[7][0] = new Rook(Color.WHITE); boardState[7][7] = new Rook(Color.WHITE);
        boardState[0][0] = new Rook(Color.BLACK); boardState[0][7] = new Rook(Color.BLACK);

        boardState[7][1] = new Knight(Color.WHITE); boardState[7][6] = new Knight(Color.WHITE);
        boardState[0][1] = new Knight(Color.BLACK); boardState[0][6] = new Knight(Color.BLACK);

        boardState[7][2] = new Bishop(Color.WHITE); boardState[7][5] = new Bishop(Color.WHITE);
        boardState[0][2] = new Bishop(Color.BLACK); boardState[0][5] = new Bishop(Color.BLACK);

        boardState[7][3] = new Queen(Color.WHITE); boardState[0][3] = new Queen(Color.BLACK);
        boardState[7][4] = new King(Color.WHITE); boardState[0][4] = new King(Color.BLACK);
    }

    Piece get(int r, int c){
        return (r < 0 || r > 7 || c < 0 || c > 7) ? null : boardState[r][c];
    }

    void set(int r, int c, Piece p){
        if(r >= 0 && r < 8 && c >= 0 && c < 8) boardState[r][c] = p;
    }

    public void setLastMove(Move m) {
        this.lastMove = m;
    }

    public Move getLastMove() {
        return this.lastMove;
    }

    void makeMove(Move m){
        Piece p = get(m.getFromR(), m.getFromC());
        if(p == null) return;

        set(m.getToR(), m.getToC(), p);
        set(m.getFromR(), m.getFromC(), null);

        p.setHasMoved(true);
    }

    void recordBoardState(){
        StringBuilder sb = new StringBuilder();
        for(int r = 0; r < 8; r++) for(int c = 0; c < 8; c++){
            Piece p = get(r, c);
            sb.append(p == null ? "." : p.toString());
        }
        history.add(sb.toString());
    }

    boolean isThreefoldRepetition(){
        if(history.isEmpty()) return false;
        String last = history.get(history.size() - 1);
        long count = history.stream().filter(s -> s.equals(last)).count();
        return count >= 3;
    }

    Piece getLastMovedPawn() {
        if (lastMove == null) return null;

        Piece p = get(lastMove.getToR(), lastMove.getToC());

        if (p != null && p.getType() == Type.PAWN && Math.abs(lastMove.getToR() - lastMove.getFromR()) == 2)
            return p;

        return null;
    }

    Board copy(){
        Board nb = new Board();
        for(int r = 0; r < 8; r++) {
            for(int c = 0; c < 8; c++){
                Piece p = get(r, c);
                if(p != null){
                    nb.boardState[r][c] = p.copy();
                } else nb.boardState[r][c] = null;
            }
        }
        nb.lastMove = this.lastMove;
        nb.history.addAll(this.history);
        return nb;
    }

    void print(){
        System.out.println("    a b c d e f g h");
        System.out.println("  +------------------------+");
        for(int r = 0; r < 8; r++){
            System.out.print((8 - r) + " | ");
            for(int c = 0; c < 8; c++){
                Piece p = boardState[r][c];
                System.out.print((p == null ? "." : p) + " ");
            }
            System.out.println("|");
        }
        System.out.println("  +------------------------+");
        System.out.println("    a b c d e f g h");
    }
}