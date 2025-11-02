import java.util.Scanner;

class ConsoleUI implements UI {
    private final Scanner sc = new Scanner(System.in);

    @Override
    public String getMoveInput(Color turn) {
        System.out.print(turn + " to move: ");
        return sc.nextLine().trim();
    }

    @Override
    public void showBoard(Board board) {
        System.out.println("    a b c d e f g h");
        System.out.println("  +------------------------+");
        for(int r = 0; r < 8; r++){
            System.out.print((8-r) + " | ");
            for(int c = 0; c < 8; c++){
                Piece p = board.get(r, c);
                System.out.print((p == null ? ". " : p.toString() + " "));
            }
            System.out.println("| " + (8-r));
        }
        System.out.println("  +------------------------+");
        System.out.println("    a b c d e f g h");
    }

    @Override
    public void showMessage(String msg) {
        System.out.println(msg);
    }
}