public enum Color {
    WHITE, BLACK;

    public Color getOpposite() {
        return (this == WHITE) ? BLACK : WHITE;
    }
}