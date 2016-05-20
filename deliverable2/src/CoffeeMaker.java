
public class CoffeeMaker {


    public static void main(String[] args) {
        System.out.println("Coffee Maker Quest 1.1");
        int returnValue = 0;

        if (args.length == 0) {
            Player p = new Player();
            Rooms r = new Rooms(6);
            Game g = new Game(p, r);
            returnValue = g.run();
        } else {
            returnValue = 2;
        }
        System.out.println("The End");
        if (returnValue != 0) {
            System.out.println("Exiting with error code " + returnValue);
        }

    }

}