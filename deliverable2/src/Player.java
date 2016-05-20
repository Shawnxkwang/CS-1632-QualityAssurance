/**
 * Created by Xiaokai on 2/09/2016.
 */
public class Player {

    public boolean hasSugar = false;
    public boolean hasCream = false;
    public boolean hasCoffee = false;

    public Player() {

    }

    public void getSugar() {
        System.out.println("You found some sweet sugar!");
        hasSugar = true;
    }

    public void getCream() {

        System.out.println("You found some creamy cream!");
        hasCream = true;
    }

    public void getCoffee() {
        System.out.println("You found some caffeinated coffee!");
        hasCoffee = true;
    }

    public boolean hasAllItems() {
        return (hasCoffee && hasCream && hasSugar);
    }

    public void showInventory() {
        if (hasCoffee) {
            System.out.println("You have a cup of delicious coffee.");
        } else {
            System.out.println("YOU HAVE NO COFFEE!");
        }
        if (hasCream) {
            System.out.println("You have some fresh cream.");
        } else {
            System.out.println("YOU HAVE NO CREAM!");
        }
        if (hasSugar) {
            System.out.println("You have some tasty sugar.");
        } else {
            System.out.println("YOU HAVE NO SUGAR!");
        }
    }

    public boolean drink() {
        boolean win = false;

        showInventory();

        System.out.println();

        if (hasCoffee && hasCream && hasSugar) {
            System.out.println("You drink the beverage and are ready to study!");
            win = true;
        } else if (hasCoffee) {
            if (!hasCream) {
                System.out.println("Without cream, you get an ulcer and cannot study.");
            } else {
                System.out.println("Without sugar, the coffee is too bitter.  You cannot study.");
            }
        } else if (hasCream) {
            if (!hasSugar) {
                System.out.println("You drink the cream, but without caffeine, you cannot study.");
            } else {
                System.out.println("You drink the sweetened cream, but without caffeine, you cannot study.");
            }
        } else if (hasSugar) {
            System.out.println("You eat the sugar, but without caffeine, you cannot study.");
        } else {
            System.out.println("You drink the air, as you have no coffee, sugar, or cream.\n"
                    + "The air is invigorating, but not invigorating enough.  You cannot study.");
        }
        return win;
    }
}
