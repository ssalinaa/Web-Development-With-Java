// Game.java
import java.util.Scanner;

class Game {
    Board board = new Board();
    Color turn = Color.WHITE;
    Scanner sc = new Scanner(System.in);

    void play() {
        System.out.println("Simple Java Chess (console) - separated files version");
        while (true) {
            board.print();
            if (board.isInCheck(turn))
                System.out.println("*** " + turn + " in check!");
            System.out.print(turn + " to move: ");
            String line = sc.nextLine().trim();
            if (line.equalsIgnoreCase("quit") || line.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye");
                break;
            }
            if (line.equalsIgnoreCase("help")) {
                System.out.println("Enter moves in format e2e4 or e7e8q (promotion). Type 'quit' to exit.");
                continue;
            }
            Move m = parseMove(line);
            if (m == null) {
                System.out.println("Invalid move format. Use e2e4 or e7e8q for promotions.");
                continue;
            }
            Piece p = board.get(m.fromR, m.fromC);
            if (p == null) {
                System.out.println("No piece at source.");
                continue;
            }
            if (p.color != turn) {
                System.out.println("That's not your piece.");
                continue;
            }
            if (m.promotion != null && p.type != Type.PAWN) {
                System.out.println("Only pawns can promote.");
                continue;
            }
            if (!board.isLegalMove(m, turn)) {
                System.out.println("Illegal move.");
                continue;
            }

            board.makeMove(m);
            // смяна на реда
            turn = (turn == Color.WHITE) ? Color.BLACK : Color.WHITE;
        }
    }

    Move parseMove(String s) {
        // очаква формати: e2e4 или e7e8q
        if (s.length() < 4) return null;
        int fc = s.charAt(0) - 'a';
        int fr = 8 - Character.getNumericValue(s.charAt(1));
        int tc = s.charAt(2) - 'a';
        int tr = 8 - Character.getNumericValue(s.charAt(3));
        if (!inBounds(fr, fc) || !inBounds(tr, tc)) return null;
        Move m = new Move(fr, fc, tr, tc);
        if (s.length() >= 5) {
            char c = Character.toLowerCase(s.charAt(4));
            if (c == 'q') m.promotion = Type.QUEEN;
            else if (c == 'r') m.promotion = Type.ROOK;
            else if (c == 'b') m.promotion = Type.BISHOP;
            else if (c == 'n') m.promotion = Type.KNIGHT;
            else return null;
        }
        return m;
    }

    boolean inBounds(int r, int c) {
        return r >= 0 && r < 8 && c >= 0 && c < 8;
    }
}
