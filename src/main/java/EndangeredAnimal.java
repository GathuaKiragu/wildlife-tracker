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
}
