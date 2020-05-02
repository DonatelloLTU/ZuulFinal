import java.util.Set;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each direction, the room stores a reference
 * to the neighboring room.
 * 
 * @author  Donatas Vasauskas
 * @version 2019.12.11-01
 */
public class Room 
{
    private String description;
    private HashMap<String, Room> exits; 
    private Artifact artifact;
    private ArrayList<Artifact> artifactList;
    private boolean hasArtifact;
    private int teleportation;
    
    private GUI game;
    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     * @param teleportation it shows if the room is teleportation room or not.
     */
    public Room(String description, int teleportation) 
    {
        this.description = description;
        exits = new HashMap<>();
        artifactList = new ArrayList<>();
        hasArtifact = false;
        this.teleportation = teleportation;
    }

    /**
     * Define the exits of this room.  Every direction either leads
     * to another room or is null (no exit there).
     * @param direciton is String direction defined by the room exits.
     * @param neighboor is Room defines what neighboors does the room have.
     */
    public void setExits(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }
    
    /**
     * Checks does the room has any artifacts.
     */
    public boolean artifacts()
    {
        return hasArtifact;
    }
    
    /**
     * Method to add artifact to the room,
     * @param artifactName, String with artifacts name.
     * @param descriptionArtifact, String describingg the artifact.
     * @param weight, is int defines how heavy is the artifact.
     */
    public void addArtifact(String artifactName, String descriptionArtifact, int weight)
    {
        artifactList.add(new Artifact(artifactName, descriptionArtifact, weight));
        hasArtifact = true;
    }
    
    /**
     * This method removes artifact from the room, uses artifacts name in order to work,
     * @param artifactName, is a String with artifacts name.
     * 
     */
    public void removeArtifact(String artifactName)
    {
        int i = 0;
        boolean found = false;
        while (i < artifactList.size() && (!found)) {
            if (artifactList.get(i).getArtifactName().equals(artifactName)) {
                artifactList.remove(i);
                found = true;
            }
            ++i;
         }
        if (artifactList.size() == 0) {
            hasArtifact = false;
        }
    }
    
    /**
     * This method places artifact in the room,
     * @param artifact, is class Artifact instance.
     */
    public void placeArtifact(Artifact artifact)
    {
        artifactList.add(artifact);
    }

    /**
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }
    
    /**
     * Return a description of the room.
     * @return A long description of this room
     */
    public String getLongDescription()
    {
        return  getExitString();
    }
    
    
    /**
     * * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    private String getExitString()
    {
        String returnString = "";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
    
    /**
     * This method gives the artifacts description within the room,
     * @return artifactString, gives the String of artifacts description when called.
     */
    public ArrayList artifactDescriptions()
    {
        ArrayList<String> artifactStrings = new ArrayList<>();
        for (Artifact artifact : artifactList)
        {
            artifactStrings.add(artifact.getDescriptionArtifact());
        }
        return artifactStrings;
    }
    
    
    /**
     * This method gives the artifacts name within the room,
     * @return artifactString returns artifacts name.
     */
    public ArrayList artifactNames()
    {
        ArrayList<String> artifactString = new ArrayList<>();
        for(Artifact artifact : artifactList)
        {
            artifactString.add(artifact.getArtifactName());
        }
        return artifactString;
    }
    
    /**
     * This method is to get artifact list within the room,
     * @return justList, returns the list of artifacts located in the room.
     */
    public ArrayList<Artifact> getArtifactList()
    {
        ArrayList<Artifact> justList = new ArrayList<>();
        for (Artifact artifact : artifactList) {
            justList.add(artifact);
        }
        return justList;
    }
    
    /**
     * This method is boolean to check if teleportation int is 0 or 1,
     * @return true, is true when rooms teleportation number is 1,
     * @return false, is false when rooms teleportation number is 0 or anything else.
     */
    public boolean teleport()
    {
        if(teleportation == 1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
}
