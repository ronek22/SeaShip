package ship;

public class Ship {
    public Coord coord;
    private Direction dir;

    public Ship(int x, int y, Direction dir){
        coord = new Coord(x, y);
        this.dir = dir;
    }


    public Coord swim(Move move){
        int step = (move == Move.FORWARD) ? 1 : -1;
        int shipX = coord.getX(); int shipY = coord.getY();
        
        switch(dir){
            case N:
                shipY-=step;
                break;
            case S:
                shipY+=step;
                break;
            case E:
                shipX+=step;
                break;
            case W:
                shipX-=step;
                break;
        }

        return new Coord(shipX, shipY);
    }

    public void turnShip(Turn t){
       this.dir = dir.turnTo(t);
    }

    public void setCoord(int x, int y){
        coord.setX(x);
        coord.setY(y);
    }
    public void setCoord(Coord newPos){coord = newPos;}

    public Direction getDirection(){return dir;}

    
    @Override

    public boolean equals(Object o) {
        Ship c = (Ship) o;
        return c.dir == this.dir && c.coord.equals(this.coord);
    }
}