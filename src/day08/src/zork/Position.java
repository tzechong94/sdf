package zork;

import java.util.HashMap;
import java.util.Map;

public class Position {

    private String room;
    private String name;
    private String description;
    private Map<String, String> directionMap = new HashMap<>();


    public String getRoom() {
        return room;
    }
    public void setRoom(String room) {
        this.room = room;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Map<String, String> getDirection() {
        return directionMap;
    }

    public Map<String, String> setDirection(Map<String, String> directionMap) {
        return directionMap;
    }

    public void addDirection(String key, String value) {
        this.directionMap.put(key, value);
    }



    @Override
    public String toString(){
        return "room: " + room + "| name: " + name + "| description: " + description + "| directionMap: " + directionMap;
    }
}
