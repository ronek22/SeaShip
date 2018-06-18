package ship;
import ship.Coord;
import ship.Direction;
import ship.Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ConsoleGame {

    public static void main(String[] args){
        Coord[] islands = new Coord[]{
                new Coord(1, 3),
                new Coord(4, 4),
                new Coord(5, 5),
                new Coord(7, 3)
        };


        Game game = new Game(10, islands, 0,0,Direction.E);
        game.printGame();
        while(true){
            game.command(handleInput());
            game.printGame();
        }
    }


    public static String handleInput(){
        Scanner input = new Scanner(System.in);
        System.out.print("Podaj polecenie[nwlp]: ");
        return input.nextLine();
    }
}