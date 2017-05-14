import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;

public class EndangeredAnimal{
  private String name;
  private String health;
  private int age;

  public static final String Good = "good";
  public static final String Poor = "poor";

// Constructor
  public EndangeredAnimal(String name, String health, int age) {
    this.name = name;
    this.health = health;
    this.age = age;
  }
  // get name
  public String getName() {
    return name;
  }
// get endangerd animal health
  public String getHealth() {
    return health;
  }
//get endangered animal estimate age
  public int getAge() {
    return age;
  }
}
