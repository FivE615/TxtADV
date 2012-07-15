
public class ScoreKeeper {

		  private int health = 100;
		  private int armor = 42;

		  /**
		   * @param i hitpoints to remove
		   * @return true if no health anymore
		   */
		  public boolean hit(int i) {
			if (i>=8) {
				System.out.println("CRITICAL HIT!");
			}
		    System.out.println("You hit: "+i*3);
		    if (armor > 0) {
		      armor = armor - 2;
		    }
		    if (health > 0) {
		      health = health - i*3;
		    }
		    if (health<=0){
		      health = 0;
		      return true;
		    }
		    return false;
		  }

		  public int getArmor() {
		    return armor;
		  }
		  
		  public int getHealth() {
		    return health;
		  }
	}
		  