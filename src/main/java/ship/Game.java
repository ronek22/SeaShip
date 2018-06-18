package ship;

import static ship.Turn.*;
import static ship.Move.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Game {
    public Board board;
    public Ship ship;
    private int numberOfCollisions;


    public Game(){
        numberOfCollisions = 0;
    }

    public Game(int boardSize, Coord[] islands, int shipX, int shipY, Direction shipDir) {
        numberOfCollisions = 0;
        board = new Board(boardSize, islands);
        if(isCollision(shipX, shipY)) throw new IllegalArgumentException("Statek nie może startować z wyspy.");        
        ship = new Ship(shipX, shipY, shipDir);
    }

    public Game(Board board, int shipX, int shipY, Direction shipDir){
        numberOfCollisions = 0;
        this.board = board;
        if(isCollision(shipX, shipY)) throw new IllegalArgumentException("Statek nie może startować z wyspy.");        
        ship = new Ship(shipX, shipY, shipDir);
    }

    public void moveShip(Move move){
        Coord newPos = ship.swim(move);

        if(!isCollision(newPos.getX(), newPos.getY())){
            ship.coord = newPos;
        }
    }

    public void command(String commandList){
        for(char comm : commandList.toCharArray()){
            switch(comm){
                case 'n':
                    moveShip(FORWARD);
                    break;
                case 'w':
                    moveShip(BACKWARD);
                    break;
                case 'l':
                    ship.turnShip(LEFT);
                    break;
                case 'p':
                    ship.turnShip(RIGHT);
                    break;
                default:
                    throw new IllegalArgumentException("Nie ma takiego polecenia!");                
            }

        }
    }

    public boolean isCollision(int x, int y){
        if(x < 0 || x > board.size - 1 || y < 0 || y > board.size - 1) throw new IllegalArgumentException("Statek poza plansza!");
        if(board.isIsland(x, y)){
            raiseCollision();
            return true;
        } return false;
    }

    public void raiseCollision(){
        // System.out.println("Anulowanie. Statek nie moze wplynac na wyspe");
        numberOfCollisions++;
    }

    public int getNumberOfCollisions(){return numberOfCollisions;}

    public void SaveDatabase() throws IOException{
        BufferedWriter bw = new BufferedWriter(new FileWriter("src/test/resources/database.txt"));
        bw.write(board.size + "\n");
        bw.write(ship.coord.getX() + ";" + ship.coord.getY() + ";" + ship.getDirection() + "\n");
        for(int i = 0; i < board.size; i++){
            for(int j = 0; j < board.size; j++){
                if(board.isIsland(i, j)){
                    bw.write(i + ";" + j);
                    bw.newLine();
                }
            }
        }
        bw.close();
    }

    public void ReadDatabase() throws IOException{
        long count = Files.lines(Paths.get("src/test/resources/database.txt")).count() - 2;
        Coord[] islands = new Coord[(int)count];       
        BufferedReader br = new BufferedReader(new FileReader("src/test/resources/database.txt"));
        int size = Integer.parseInt(br.readLine());
        String[] shipData = br.readLine().split(";");
        
        this.ship = new Ship(Integer.parseInt(shipData[0]), Integer.parseInt(shipData[1]), Direction.valueOf(shipData[2]));
        String nextLine; int i = 0;
        while((nextLine = br.readLine()) != null){
            String[] pos = nextLine.split(";");
            islands[i++] = new Coord(Integer.parseInt(pos[0]), Integer.valueOf(pos[1]));
        }
        this.board = new Board(size, islands);
    }

    public void printGame(){
        for(int i = 0; i < board.size; i++){
            for(int j = 0; j < board.size; j++){
                if(ship.coord.getX() == j && ship.coord.getY() == i){
                    System.out.print(ship + "\t");
                } else if(board.isIsland(j, i)){
                    System.out.print("O\t");
                } else {
                    System.out.print("~\t");
                }
            }
            System.out.println();
        }
        System.out.println("SHIP POSITION: " + ship.coord);
    }



}