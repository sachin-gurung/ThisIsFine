package game;



import java.util.ArrayList;

public class Room {

    String name;
    String description;
    String detailedDescription;
    ArrayList<String> items;
    ArrayList<String> exits;
    Puzzle puzzle;
    String north;
    String south;
    String east;
    String west;


    public Room(String name, String description, String detailedDescription, ArrayList<String> items, ArrayList<String> exits) {
        this.name = name;
        this.description = description;
        this.detailedDescription = detailedDescription;
        this.items = items;
        this.exits = exits;
        this.puzzle = null;
        this.north = null;
        this.south = null;
        this.east = null;
        this.west = null;
    }
    public ArrayList<String> getRoomItems() {
        return items;
    }

    public void deleteRoomItem(String item) {
        items.remove(item);
    }

    public void addRoomItem(String item){
        items.add(item);
    }

    public String getDirection(String desiredDirection){
        String direction = "";
        switch (desiredDirection){
            case "north":
                direction = getNorth();
                break;
            case "west":
                direction = getWest();
                break;
            case "east":
                direction = getEast();
                break;
            case "south":
                direction = getSouth();
                break;
        }
        return direction;
    }

    public String getNorth() {
        return north;
    }

    public String getSouth() {
        return south;
    }

    public String getEast() {
        return east;
    }

    public String getWest() {
        return west;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getDetailedDescription() {
        return detailedDescription;
    }

    public Puzzle getPuzzle() {
        return puzzle;
    }

    public ArrayList<String> getExits() {
        return exits;
    }

    public void setPuzzle(Puzzle puzzle) {
        this.puzzle = puzzle;
    }

    public void setNorth(String north) {
        this.north = north;
    }

    public void setSouth(String south) {
        this.south = south;
    }

    public void setEast(String east) {
        this.east = east;
    }

    public void setWest(String west) {
        this.west = west;
    }
}