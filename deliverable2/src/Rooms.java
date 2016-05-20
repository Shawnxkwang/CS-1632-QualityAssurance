/**
 * Created by Xiaokai on 2/09/2016.
 */
public class Rooms {

    private int numRooms = 6;

    private Room[] rooms = new Room[numRooms];

    private int currentRoom = 0;

    public Rooms(int numRooms) {

        rooms = generateRooms(numRooms);
    }

    public String getCurrentRoomInfo() {
        if (currentRoom < 0 || currentRoom > (numRooms -1)) {

            return " ";
        } else {
            return rooms[currentRoom].getDescription();
        }
    }

    public void moveNorth() {
        if (currentRoom <5) {
            currentRoom += 1;
        } else {
            System.out.println("No door to enter!\nThis is the last room.");

        }
    }

    public void moveSouth() {
        if (currentRoom >0) {
            currentRoom -= 1;
        } else {
            System.out.println("No door to enter!\nThis is the first room.");
        }
    }

    public void look(Player player) {
        Room room = rooms[currentRoom];
        if (room.hasItem()) {
            System.out.println("There might be something here...");
            if (room.hasCoffee()) {
                player.getCoffee();
            }
            if (room.hasCream()) {
                player.getCream();
            }
            if (room.hasSugar()) {
                player.getSugar();
            }
        } else {
            System.out.println("You don't see anything out of the ordinary.");
        }
    }

    public Room[] generateRooms(int numRooms) {

        Room[] toReturn = new Room[numRooms];
        boolean northDoor, southDoor,hasCoffee,hasCream,hasSugar;


        for (int j = 0; j < numRooms; j++) {

            if (j == 0) {
                hasCream = true;
                southDoor = false;
            } else {
                hasCream = false;
                southDoor = true;
            }
            if (j == 2) {
                hasCoffee = true;
            } else {
                hasCoffee = false;
            }
            if (j == (numRooms - 1)) {
                hasSugar = true;
                northDoor = false;
            } else {
                hasSugar = false;
                northDoor = true;
            }

            toReturn[j] = new Room(hasCoffee, hasCream, hasSugar, northDoor, southDoor);
        }

        return toReturn;
    }


}
