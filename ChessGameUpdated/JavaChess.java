import java.util.Arrays;
import java.util.List;

public class JavaChess {
    public static void main(String[] args) {

        UI ui = new ConsoleUI();
        Board board = new Board();
        RuleEngine ruleEngine = new ChessRuleEngine();
        PromotionPieceSupplier pieceSupplier = new DefaultPieceSupplier();

        BoardInitializer initializer = new StandardBoardInitializer();
        GameHistory history = new GameHistory();

        List<MoveHandler> handlers = Arrays.asList(
                new CastlingHandler(ruleEngine),
                new EnPassantHandler(ruleEngine),
                new PawnPromotionHandler(pieceSupplier)
        );

        Game game = new Game(ui, board, handlers, ruleEngine, history, initializer);
        game.play();
    }
}