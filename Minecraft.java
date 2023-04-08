import java.util.ArrayList;

/**
 * this creates a public class to move a character in minecraft
 * @param character which is the character used in the game (Steve or Alex)
 * @param potion the amount of potion a character collects that can be used 
 * @param item the items in the characters posession in an arraylist for all items collected
 * @param heartPoints character's healthlife / hearts / lives, set to 20
 */
public class Minecraft implements Contract {
    private String character; 
    private int potion; 
    private int heartPoints; 
    private ArrayList<String> items;

    public Minecraft(int potion, String character){
        this.potion = potion;
        this.character = character;
        this.heartPoints = 20; // default value of amount of heartPoints set to 20
        this.items = new ArrayList<String>(); //create arralylist for items that the character will grab
        }

    /**
     * acessors of character and potion for later use
     * @return character
     * @return potion
     */
    public String character(){
        return this.character;
       }
    public int potion(){
        return this.potion;
      }
    
    /** 
   *  Choose which character you want to be. Only charcters able to play are Alex and Steve
   *  @param name name of the character you selected
   */
    public void player(String name){
        if(character.equals("Alex") || character.equals("Steve")){
            System.out.println("Welcome " + character + "!!");
        } else{
            System.out.println("Please pick a new character for the game: either Steve or Alex");
        }
    }


    /** 
     * character is able to grab tools for thier own use
     * @param item what the character can grab
     */
    public void grab(String item){
        items.add(item);
        System.out.println(character + " grabbed a " + item + " for his adventures.");
    }

    /** 
   * Whether or not the character needs to drop a tools given how many they have on them
   * @param item what the character drops 
   * @return the item the character is dropping 
   * */
    public String drop(String item){
        items.remove(item);
        System.out.println(character + " removed a " + item + " from his toolbox of tools.");
        return item;
    }

    /** 
   * If the character needs to examine whether they have an enemy in front of them
   * @param item what is the character's enemy
   */
    public void examine(String item) {
     if (item.equals("skeleton")){
            System.out.println("A " + item + " is in front of you. Before you proceed, examine the obstacle.");
     }else{
         System.out.println("Keep going foward but beware of enemies.");
     }
    }

    /** 
   *  What the character can do if they have enough potion
   *  @param item what the character does
   */
    public void use(String item) {
        if (this.potion == 2){
           System.out.println("You have " + potion + " potions, you can now sprint! You have " + item + " left in your backpack.");
        }
        if (this.potion == 4){
            System.out.println("You have " + potion + " potions, you can now sneak! You have " + item + " left in your backpack.");
        }
        if (this.potion == 6){
            System.out.println("You have " + potion + " potions, you can now attack! You have " + item + " left in your backpack.");
        }//else{
            //System.out.println("You need to select either 2, 4 or 6 potions to be able use use a feature."); //this isn't necessary
        //}
    }

    /** 
   * Whether or not the character walks foward or backwards and in what direction do they move
   * @param direction the direction the character walks in
   * @return T/F whether or not the character can walk
   */
    public boolean walk(String direction){
        if(direction.equals("forward") || direction.equals("backward")|| direction.equals("left")|| direction.equals("right")){
            System.out.println("You are now walking " + direction);
            return true;
        } else{
            System.out.println("I don't understand this direction: " + direction + ". Try: forward,backward, left or right");
            return false;
        }
    }

    /** 
   * How many potions required for the character to fly
   * @param x the distance from where started
   * @param y the distance off the ground
   * @return T/F boolean whether or not the character can fly based on coodinates- focus on y if off the ground
   */
    public boolean fly(int x, int y){
        if(y <= 0){
            System.out.println("You are not able to fly yet, increase y to fly.");
            return false;
        } else{
            System.out.println("You are able to fly. You are " + y + " feet off the ground and " + x + " feet away from where you started.");
            return true;
        }
    }

    /** 
   * what's necessary for a character to shrink
   * @return The amount of heartPoints the character has 
   */
    public Number shrink() {
        this.heartPoints -= 10;
        System.out.println("Your hearts has gone down by -10 (the game has starting value of 20 hearts) = " +this.heartPoints);
        return(this.heartPoints);
        }

    /** 
     * What it takes for the character to grow
     * @return the amount of potion
    */
    public Number grow() {
        this.heartPoints += 10;
        System.out.println("Your hearts has gone up by +10 pt (the game has starting value of 20 hearts)= "+ this.heartPoints);
        return(this.heartPoints);
    }

    /** 
     * If the character is dead (given they have used up all their hearts (heartpoints) they are resting. If not they are still on their feet and able to move
     * */
    public void rest() {
        if(this.heartPoints == 0){
            System.out.println("Character is dead due to now hearts. Now resting");
        }else{
            System.out.println("Character still able to move around.");
        }
    }

    /** 
     * Whether or not the character has enough tools they can undo the game and return to their latest checkpoint
   */
    public void undo() {
        System.out.println("Clearing out tools inventory in " + character +"'s adventure...");
        items.clear();
        System.out.println("Inventory cleared! " + character + " now has no tools in their posession.");
    }

    public static void main(String[] args) {
        Minecraft Steve = new Minecraft(6, "Steve");
        Steve.player("Steve");
        Steve.grab("bow and arrow");
        Steve.grab("boxing gloves");
        Steve.drop("bow and arrow");
        Steve.examine("skeleton");
        Steve.examine("ghost");
        Steve.use("20");
        Steve.walk("forward");
        Steve.fly(10,4);
        Steve.fly(6,0);
        Steve.shrink();
        Steve.grow();
        Steve.shrink();
        Steve.shrink();
        Steve.rest();
        Steve.undo();
        
        System.out.println("-----");

        Minecraft Alex = new Minecraft(4, "Alex");
        Alex.player("Alex");
        Alex.grab("candle");
        Alex.grab("bat");
        Alex.drop("bat");
        Alex.examine("squid");
        Alex.use("10");
        Alex.walk("backward");
        Alex.walk("forward");
        Alex.walk("sideways");
        Alex.fly(200,40);
        Alex.fly(0,20);
        Alex.shrink();
        Alex.grow();
        Alex.grow();
        Alex.grow();
        Alex.rest();
        Alex.undo();

        Minecraft Rob = new Minecraft(4, "Rob");
        Rob.player("Rob");
    }
    
}