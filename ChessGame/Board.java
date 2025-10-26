// Board.java
class Board {
    Piece[][] b = new Piece[8][8];

    // публичен конструктор - слага началните фигури
    Board() {
        setup();
    }

    // конструктор за копиране/вътрешна употреба (без setup)
    private Board(boolean initEmpty) {
        if (initEmpty) setup();
    }

    void setup() {
        // изчистваме дъската
        for (int r = 0; r < 8; r++)
            for (int c = 0; c < 8; c++)
                b[r][c] = null;

        // пешки
        for (int c = 0; c < 8; c++) {
            b[6][c] = new Piece(Type.PAWN, Color.WHITE);
            b[1][c] = new Piece(Type.PAWN, Color.BLACK);
        }

        // топове
        b[7][0] = new Piece(Type.ROOK, Color.WHITE);
        b[7][7] = new Piece(Type.ROOK, Color.WHITE);
        b[0][0] = new Piece(Type.ROOK, Color.BLACK);
        b[0][7] = new Piece(Type.ROOK, Color.BLACK);

        // коне
        b[7][1] = new Piece(Type.KNIGHT, Color.WHITE);
        b[7][6] = new Piece(Type.KNIGHT, Color.WHITE);
        b[0][1] = new Piece(Type.KNIGHT, Color.BLACK);
        b[0][6] = new Piece(Type.KNIGHT, Color.BLACK);

        // офицери (бишопи)
        b[7][2] = new Piece(Type.BISHOP, Color.WHITE);
        b[7][5] = new Piece(Type.BISHOP, Color.WHITE);
        b[0][2] = new Piece(Type.BISHOP, Color.BLACK);
        b[0][5] = new Piece(Type.BISHOP, Color.BLACK);

        // дами
        b[7][3] = new Piece(Type.QUEEN, Color.WHITE);
        b[0][3] = new Piece(Type.QUEEN, Color.BLACK);

        // царе
        b[7][4] = new Piece(Type.KING, Color.WHITE);
        b[0][4] = new Piece(Type.KING, Color.BLACK);
    }

    Piece get(int r, int c) {
        if (r < 0 || r > 7 || c < 0 || c > 7) return null;
        return b[r][c];
    }

    void set(int r, int c, Piece p) {
        if (r < 0 || r > 7 || c < 0 || c > 7) return;
        b[r][c] = p;
    }

    void makeMove(Move m) {
        Piece p = get(m.fromR, m.fromC);
        if (p == null) return;
        // промоция
        if (p.type == Type.PAWN && (m.toR == 0 || m.toR == 7)) {
            Type prom = (m.promotion == null) ? Type.QUEEN : m.promotion;
            set(m.toR, m.toC, new Piece(prom, p.color));
            set(m.fromR, m.fromC, null);
            return;
        }
        set(m.toR, m.toC, p);
        set(m.fromR, m.fromC, null);
    }

    boolean isLegalMove(Move m, Color side) {
        Piece p = get(m.fromR, m.fromC);
        if (p == null || p.color != side) return false;
        Piece target = get(m.toR, m.toC);
        if (target != null && target.color == side) return false;
        if (!validPieceMove(p, m)) return false;
        // симулираме и проверяваме дали царят остава в шах
        Board copy = this.copy();
        copy.makeMove(m);
        if (copy.isInCheck(side)) return false;
        return true;
    }

    boolean validPieceMove(Piece p, Move m) {
        int dr = m.toR - m.fromR;
        int dc = m.toC - m.fromC;
        switch (p.type) {
            case PAWN:
                return validPawnMove(p, m, dr, dc);
            case KNIGHT:
                return (Math.abs(dr) == 2 && Math.abs(dc) == 1) || (Math.abs(dr) == 1 && Math.abs(dc) == 2);
            case BISHOP:
                if (Math.abs(dr) != Math.abs(dc)) return false;
                return clearPath(m);
            case ROOK:
                if (dr != 0 && dc != 0) return false;
                return clearPath(m);
            case QUEEN:
                if (dr == 0 || dc == 0 || Math.abs(dr) == Math.abs(dc)) return clearPath(m);
                return false;
            case KING:
                if (Math.abs(dr) <= 1 && Math.abs(dc) <= 1) return true;
                return false;
        }
        return false;
    }

    boolean validPawnMove(Piece p, Move m, int dr, int dc) {
        int dir = (p.color == Color.WHITE) ? -1 : 1;
        Piece dest = get(m.toR, m.toC);
        // едно напред
        if (dc == 0 && dr == dir && dest == null) return true;
        // две от начална позиция
        if (dc == 0 && dr == 2 * dir && dest == null) {
            int startRow = (p.color == Color.WHITE) ? 6 : 1;
            if (m.fromR != startRow) return false;
            if (get(m.fromR + dir, m.fromC) != null) return false;
            return true;
        }
        // взимане на диагонал
        if (Math.abs(dc) == 1 && dr == dir && dest != null && dest.color != p.color) return true;
        return false;
    }

    boolean clearPath(Move m) {
        int dr = Integer.signum(m.toR - m.fromR);
        int dc = Integer.signum(m.toC - m.fromC);
        int r = m.fromR + dr;
        int c = m.fromC + dc;
        while (r != m.toR || c != m.toC) {
            if (get(r, c) != null) return false;
            r += dr;
            c += dc;
        }
        return true;
    }

    boolean isInCheck(Color side) {
        int kr = -1, kc = -1;
        for (int r = 0; r < 8; r++)
            for (int c = 0; c < 8; c++) {
                Piece p = get(r, c);
                if (p != null && p.type == Type.KING && p.color == side) {
                    kr = r;
                    kc = c;
                }
            }
        if (kr == -1) return true; // няма цар (технически - в шах)
        Color enemy = (side == Color.WHITE) ? Color.BLACK : Color.WHITE;
        for (int r = 0; r < 8; r++)
            for (int c = 0; c < 8; c++) {
                Piece p = get(r, c);
                if (p == null || p.color != enemy) continue;
                Move m = new Move(r, c, kr, kc);
                if (p.type == Type.PAWN) {
                    int dir = (p.color == Color.WHITE ? -1 : 1);
                    if (kr == r + dir && Math.abs(kc - c) == 1) return true;
                    continue;
                }
                if (validPieceMove(p, m)) return true;
            }
        return false;
    }

    Board copy() {
        Board nb = new Board(false);
        for (int r = 0; r < 8; r++)
            for (int c = 0; c < 8; c++)
                nb.b[r][c] = (this.b[r][c] == null) ? null : new Piece(this.b[r][c].type, this.b[r][c].color);
        return nb;
    }

    // принтиране на дъската
    void print() {
        System.out.println("    a b c d e f g h");
        System.out.println("  +------------------------+");
        for (int r = 0; r < 8; r++) {
            System.out.print((8 - r) + " | ");
            for (int c = 0; c < 8; c++) {
                Piece p = b[r][c];
                System.out.print((p == null ? "." : p.toString()) + " ");
            }
            System.out.println("|");
        }
        System.out.println("  +------------------------+");
        System.out.println("    a b c d e f g h");
    }
}
