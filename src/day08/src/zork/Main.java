package zork;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Position currentPosition = new Position();
    private static List<Position> allPositions = new ArrayList<>();

    
    public static void main(String[] args) throws Exception {

        String fileName = args[0];
        ReadFile(fileName);
        GamePlay(currentPosition);
    }
    

    public static void ReadFile(String fileName) throws Exception {

        //read file line by line and create class 
        // if blank line encountered, create new class 

        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        Position position = new Position();
        String next;

        while ((next=br.readLine()) != null) {
            if (!next.isEmpty()) {
                String[] items = next.split(": ");
                System.out.println(items[0]);
                switch(items[0]) {
                    case "room":
                        position.setRoom(items[1].trim());
                        break;
                    case "name":
                        position.setName(items[1].trim());
                        break;
                    case "description":
                        position.setDescription(items[1].trim());
                        break;
                    case "direction":
                        String[] directionItem = items[1].split(" ");
                        System.out.println(directionItem[0] + " " + directionItem[1]);
                        position.addDirection(directionItem[0], directionItem[1]);
                        break;
                    case "start":
                        currentPosition.setRoom(items[1]);
                    default:
                        break; 
                }
            } else {
                allPositions.add(position);
                position = new Position();
            }
        }

        br.close();
        for (Position pos : allPositions) {
            if (pos.getRoom().equalsIgnoreCase(currentPosition.getRoom())){
                currentPosition = pos;

            }
        }

        System.out.println(allPositions);
        System.out.println("current position is " + currentPosition.getName());


    }


    public static void GamePlay(Position current){
        System.out.println("Your starting position is: " + current.getName());

        while(true) {
            System.out.println("You are now in: " + currentPosition.getName());

            System.out.println(currentPosition.getDescription());

            Scanner sc = new Scanner(System.in);
            System.out.println("Available directions: " + currentPosition.getDirection());
            System.out.println("where would you like to go?");
            String command = sc.nextLine().trim().toLowerCase();

            if (currentPosition.getDirection().containsKey(command)) {
                for (Position posi : allPositions) {
                    if (posi.getRoom().equalsIgnoreCase(currentPosition.getDirection().get(command))){
                        System.out.println("get command: " + currentPosition.getDirection().get(command));
                        currentPosition = posi;
                        break;
                    }
                }
            }
        }
    }
}
