class Piece {
    final Type type;
    final Color color;
    Piece(Type t, Color c){ type = t; color = c; }
    public String toString(){
        char ch;
        switch(type){
            case KING: ch='K'; break;
            case QUEEN: ch='Q'; break;
            case ROOK: ch='R'; break;
            case BISHOP: ch='B'; break;
            case KNIGHT: ch='N'; break;
            case PAWN: ch='P'; break;
            default: ch='?';
        }
        return color==Color.WHITE?""+ch:""+Character.toLowerCase(ch);
    }
}