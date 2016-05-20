/**
 * Created by Xiaokai on 2/09/2016.
 *
 */
import java.util.Scanner;

public class Game {

    private Player  player = null;
    private Rooms  rooms = null;

    public Game(Player p, Rooms r) {
         player = p;
         rooms = r;
    }

    public int doSomething(String move) {
        int toReturn = 0;
        if(!(move.equalsIgnoreCase("N") || move.equalsIgnoreCase("S") || move.equalsIgnoreCase("H")
                || move.equalsIgnoreCase("L") || move.equalsIgnoreCase("I") || move.equalsIgnoreCase("D"))) {
            System.out.println("Invalid instruction.");
            System.out.println("Please enter one of the following instructions (N,S,L,I,D,H), press H to see help.  ");
        } else if (move.equalsIgnoreCase("N")) {
             rooms.moveNorth();
        } else if (move.equalsIgnoreCase("S")) {
            rooms.moveSouth();
        }else if (move.equalsIgnoreCase("H") ) {
            instructions();
        } else if (move.equalsIgnoreCase("L")) {
             rooms.look( player);
        } else if (move.equalsIgnoreCase("I")) {
             player.showInventory();
        } else if (move.equalsIgnoreCase("D")) {
            boolean finalStatus = player.drink();
            if (finalStatus) {
                toReturn = 1;
            } else {
                toReturn = -1;
            }
        }
        return toReturn;
    }

    private void instructions() {
        System.out.println("Instructions for Coffee Maker Quest - ");
        System.out.println("You are a brave student trying to study for finals, but you need caffeine.");
        System.out.println("The goal of the game is to collect sugar, coffee, and cream so that you can study.");
        System.out.println("enter one of six commands - \"N\" to go North, \"S\" to go South, \"L\" to Look for items" +
                ", \"I\" for Inventory, \"H\" for Help, or \"D\" to Drink.");
    }

    public int run() {
        int toReturn = 0;

        Scanner in = new Scanner(System.in);
        String move = null;

        boolean gameOver = false;
        boolean win = false;

        while (!gameOver) {
            System.out.println(rooms.getCurrentRoomInfo());
            System.out.println("INSTRUCTIONS (N,S,L,I,D,H) > ");
            move = in.nextLine();
            int status = doSomething(move);
            if (status == 1) {
                gameOver = true;
                win = true;
            } else if (status == -1) {
                gameOver = true;
                win = false;
            }
        }

        if (win) {
            System.out.println("You win!");
            toReturn = 0;
        } else {
            System.out.println("You lose!");
            toReturn = 1;
        }

        return toReturn;
    }

}
