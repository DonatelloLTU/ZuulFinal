
/**
 * Artiffacts is an object which is located within the rooms and players inventory. Some artifacts have some special abilities.
 *
 * @author Donatas Vasauskas
 * @version 2019.12.11-01
 */
public class Artifact
{
    private String artifactName;
    private String descriptionArtifact;
    private int weight;
    private GUI language;
    
    /**
     * Constructor for Artifact with specified values.
     */
    public Artifact() 
    {
        artifactName = "";
        descriptionArtifact = "";
        weight = 0;
        
    }
    
    /**
     * Constructor for Artifact with user defined values.
     * @param artiffactName is a String which names the artifact.
     * @param descriptionArtifact is a String description of the artifact.
     * @param weight is integer which specifies how heavy is an artifact.
     */
    public Artifact(String artifactName, String descriptionArtifact, int weight)
    {
        this.artifactName = artifactName;
        this.descriptionArtifact = descriptionArtifact;
        this.weight = weight;
    }
   
    
    /*
     * This method gives description of the artifact into a string
     * @return gives specific string for each scenario
     */
    public String getDescriptionArtifact()
    {
        if(language.english())
        {
            return (" Great job, you found " + descriptionArtifact);
        }
        else
        {
            return ("Šanuolis, suradai " + descriptionArtifact);
        }
    }
    
    /*
     * This method gives name of the artifact into the string
     */
    public String getArtifactName()
    {
        return artifactName;
    }
    
    /**
     * This method gets artifacts weight
     * @return weight returns artifacts weight in integer
     */
    public int getWeight()
    {
        return  weight;
    }
    
    /*
     * This method gets artifacts description in the string.
     */
    public String getDescription()
    {
        return descriptionArtifact;
    }
    
    
}

