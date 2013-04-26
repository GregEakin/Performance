package book.graph;

class Pair {
    final int x;
    final int y;

    public Pair(int x, int y) {
//        if (x < y) {
            this.x = x;
            this.y = y;
//        } else {
//            this.x = y;
//            this.y = x;
//        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj == this)
            return true;
        if (!(obj instanceof Pair))
            return false;

        Pair pair = (Pair) obj;
        return x == pair.x && y == pair.y;
    }

    @Override
    public int hashCode() {
        return x + y * 1003;
    }
}
