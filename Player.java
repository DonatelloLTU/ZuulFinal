import java.util.Stack;
import java.util.ArrayList;
import java.util.Random;
/**
 * Player class is what player does within the game itself
 *
 * @author Donatas Vasauskas
 * @version 2019.12.11-01
 */
public class Player
{
    // instance variables - replace the example below with your own
    private Room currentRoom;
    private Stack<Room> backRoom;
    private ArrayList<Artifact> inventory;
    private int carryWeight;
    private String name;
    private GUI english;
    /**
     * Constructor for class Player with defined values
     * @param name is a String wih user defined name.
     */
    public Player(String name)
    {
       this.name = name;
       backRoom = new Stack<Room>();
       inventory = new ArrayList<Artifact>();
       carryWeight = 10;
    }
    
    /**
     * This method sets room plus stacks the rooms for next method,
     * @param room, is objects Room instance.
     */
    public void setRoom(Room room)
    {
        
        backRoom.push(currentRoom);
        currentRoom = room;
        randomRoom(room);
    }
    
    /**
     * This method sets random room when specific room is use.
     * @param room is an instance of the Room class.
     */
    private void randomRoom(Room room)
    {
        if (room.teleport()==true)
        {
            Random rand = new Random();
            int j = rand.nextInt(backRoom.size());
            for(int i = -1; i < j; i++) {
                if (i == j) {
                    teleportPlayer(backRoom.pop());
                    
                }
                else {
                    backRoom.pop();
                    
                }
            }
            
        }
    }
    
    /**
     * Sets the currentRoom of the player via teleportation and clears the history of rooms the player can go back to
     * @param Room room for the player to be assigned
     */
    public void teleportPlayer(Room room)
    {
        System.out.println("You've been teleported"); //Remove when main takes over and make theGame public
        currentRoom = room;
        backRoom.clear(); //You can not go back, you were teleported
    }
    
    
    /**
     * This method sets carry weight for a player,
     * @param weight is an integer which describes the limit which players has.
     */
    public void setCarryWeight (int weight)
    {
        carryWeight += weight;
    }
    
    /**
     * This method sets starting room for the player
     */
    public void setStarting(Room room)
    {
        currentRoom = room;
    }
    
    /**
     * This method gets current room of the game.
     * @return currentRoom is literally current room of the game.
     */
    public Room getCurrentRoom()
    {
        return currentRoom;
    }
   
    /**
     * This method get whole inventory of the player. 
     */
    public ArrayList<Artifact> getInventory()
    {
        ArrayList<Artifact> artifactList = new ArrayList<>();
        for (Artifact artifact : inventory)
        {
            
            artifactList.add(artifact);
        }
        return artifactList;
    }
    
    /**
     * This method is to check for previous rooms.
     * @return backRoom.isEmpty() returns back room empty.
     */
    public boolean hasPrevious()
    {
        return (!(backRoom.isEmpty()));
    }
    
    /**
     * This method goes back the rooms when it is called.
     */
    public void goBack()
    {
        currentRoom = backRoom.pop();
    }
    
    /**
     * This method is boolean grab artifact,
     * once artifact is grabbed it is stoored in inventory.
     * @param artifact is instance of class Artifact.
     * @return true if artifact is added.
     * @return false if artifact does not fit or anything else.
     */
    public boolean grabArtifact(Artifact artifact)
    {
        if ((inventoryWeight() + artifact.getWeight()) <= carryWeight)
        {
            inventory.add(artifact);
            return true;
        }
        return false;
    }
    
    /**
     * This method is to eat specific Artifact, and once specific artifact is eaten, it gives boos to playe.
     * @param artifact is an instance of class Artifact.
     * @return true is the artifact is magic.
     * @return false if artifact is not magic.
     */
    public boolean eatArtifact(Artifact artifact)
    {
        if (artifact.getArtifactName().equals("magic") || artifact.getArtifactName().equals("magija"))
        {
            carryWeight *= 2.0;
            return true;
        }
        return false;
    }
    
    /**
     * This method for finding the artifact it is boolean.
     * @param name is a String, name for the artifact, checks the inventory for it.
     * @return false if not found.
     * @return ture if found.
     */
    public boolean findArtifact(String name)
    {
        int i = 0;
        while (i < inventory.size())
        {
            if (inventory.get(i).getArtifactName().equals(name))
            {
                return true;
            }
            ++i;
        }
        return false;
    }
    
    /**
     * This boolean method checks if player has key in his inventory.
     * @return true if player has the key it returns true.
     * @return false if player does not have the key it returns false.
     */
    public boolean getKey()
    {
          int i = 0;
          boolean key = false;
        while (i < inventory.size())
        {
            if (inventory.get(i).getArtifactName().equals("key")||inventory.get(i).getArtifactName().equals("rakta"))
            {
                key = true;
                break;
            }
            else
            {
                key = false;
            }
            ++i;
            
        }
        if (key == true)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * This method is to drop artifact.
     * @param name is a string of artifact.
     */
    public Artifact dropArtifact(String name)
    {
        int i = 0;
        while (i < inventory.size())
        {
            if (inventory.get(i).getArtifactName().equals(name))
            {
                Artifact j = inventory.get(i);
                inventory.remove(i);
                return j;
            }
            ++i;
        }
        
        return null;
    }
    
    /**
     * This method shows the inventory weight total.
     * @return currentWeight.
     */
    private int inventoryWeight()
    {
        int currentWeight = 0;
        for (Artifact artifact : inventory)
        {
            currentWeight += artifact.getWeight();
        }
        return currentWeight;
    }
    
 
    
    /**
     * This method shows inventory, what it contains and shows its weight
     * @return string with names of artifacts and weight.
     */
    public String seeInventory()
    {
          if(english.english())
          {
                ArrayList<String> inventoryList = new ArrayList<>();
                for (Artifact artifact : inventory)
                {
                    inventoryList.add(artifact.getArtifactName());
                }
                return String.join(", ", inventoryList) + ". With the total weight of " + inventoryWeight() ;
          }
          else
          {
              ArrayList<String> inventoryList = new ArrayList<>();
                for (Artifact artifact : inventory)
                {
                    inventoryList.add(artifact.getArtifactName());
                }
                return String.join(", ", inventoryList) + ". Visas svoris kurį tu turi savo kuprinėje yra " + inventoryWeight() ;
          }
          
    }
    
    
}
