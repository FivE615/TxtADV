
public class MyGame {

  private ScoreKeeper scoreKeeper = new ScoreKeeper();
  public boolean gameOver = false;
  
  void doHit(int c) {
    //System.out.println("State BEFORE hit "+c+". Health:"+scoreKeeper.getHealth()+"; Armor:"+scoreKeeper.getArmor());
    if (gameOver) {
      System.err.println("Cannot hit anymore, game over!");
    }
    if (scoreKeeper.hit(c)) {
      gameOver = true;
      System.out.println("You killed the monster!");
    }
    System.out.println("State AFTER hit "+c+". Health:"+scoreKeeper.getHealth()+"; Armor:"+scoreKeeper.getArmor());
  }

  public ScoreKeeper getStats() {
    return scoreKeeper;
  }

}