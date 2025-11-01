import java.util.List;

class Game {
    private final Board board;
    private final UI ui;
    private final List<MoveHandler> specialMoveHandlers;
    private final RuleEngine ruleEngine;
    private Color turn = Color.WHITE;

    public Game(UI ui, Board board, List<MoveHandler> specialMoveHandlers, RuleEngine ruleEngine) {
        this.ui = ui;
        this.board = board;
        this.specialMoveHandlers = specialMoveHandlers;
        this.ruleEngine = ruleEngine;
    }

    public void play(){
        ui.showMessage("Java Chess - SOLID Refactoring Complete");
        board.setup();
        board.recordBoardState();

        while(true){
            ui.showBoard(board);

            if(ruleEngine.isInCheck(board, turn)) ui.showMessage("*** " + turn + " is in check!");

            String input = ui.getMoveInput(turn);
            if(input.equalsIgnoreCase("quit")){ ui.showMessage("Goodbye"); break; }

            Move m = Move.parse(input);
            if(m == null){
                ui.showMessage("Invalid move format! Use e2e4 or e7e8q.");
                continue;
            }

            MoveResult result;
            Piece p = board.get(m.getFromR(), m.getFromC());
            if (p == null) {
                result = MoveResult.failure(MoveResultType.NO_PIECE, "No piece at source.");
            } else if (p.getColor() != turn) {
                result = MoveResult.failure(MoveResultType.ILLEGAL_MOVE, "That's not your piece.");
            } else if (m.getPromotion() != null && p.getType() != Type.PAWN) {
                result = MoveResult.failure(MoveResultType.INVALID_PROMOTION_TYPE, "Only pawns can promote.");
            } else {
                result = null;
            }

            if (result == null) {
                for (MoveHandler handler : specialMoveHandlers) {
                    if (handler.canHandle(board, m, turn)) {
                        result = handler.execute(board, m, turn);
                        break;
                    }
                }
            }

            if (result == null) {
                if(!ruleEngine.isLegalMove(board, m, turn)){
                    result = MoveResult.failure(MoveResultType.ILLEGAL_MOVE, "Illegal move!");
                } else {
                    board.makeMove(m);
                    board.setLastMove(m);
                    board.recordBoardState();
                    result = MoveResult.success();
                }
            }

            if (result.isSuccessful()) {
                turn = (turn == Color.WHITE ? Color.BLACK : Color.WHITE);
            } else {
                ui.showMessage(result.getMessage());
                continue;
            }

            if(ruleEngine.isCheckmate(board, turn)){
                ui.showBoard(board);
                ui.showMessage("CHECKMATE! " + (turn == Color.WHITE ? "Black" : "White") + " wins!");
                break;
            } else if(!ruleEngine.hasLegalMoves(board, turn)){
                ui.showBoard(board);
                ui.showMessage("STALEMATE! It's a draw.");
                break;
            } else if(board.isThreefoldRepetition()){
                ui.showBoard(board);
                ui.showMessage("DRAW by threefold repetition!");
                break;
            }
        }
    }
}