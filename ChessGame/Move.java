class Move {
    int fromR, fromC, toR, toC;
    Type promotion; // null if none
    Move(int fr,int fc,int tr,int tc){ fromR=fr; fromC=fc; toR=tr; toC=tc; }
    public String toString(){
        return coord(fromR,fromC)+"->"+coord(toR,toC)+(promotion!=null?"="+promotion:" ");
    }
    static String coord(int r,int c){ return "" + (char)('a'+c) + (8-r); }
}