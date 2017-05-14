import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;

public class EndangeredAnimal{
  private String name;
  private String health;
  private int age;
  private int id;
  private String endangered;

  public static final String Good = "good";
  public static final String Poor = "poor";
  public static final String isEndangered = "true";

// Constructor
  public EndangeredAnimal(String name, String health, int age) {
    this.name = name;
    this.health = health;
    this.age = age;
    endangered = isEndangered;
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
// Return id of endangered animal
  public int getId() {
    return id;
  }
// Save endangered animal to the database
  public void save() {
    // Throw error when ranger inputs empty animal
    try(Connection con = DB.sql2o.open()) {
      if(name.equals("")) {
        throw new UnsupportedOperationException("Enter name of Endangered animal");
      }
      String sql = "INSERT INTO animals (name, health, age, endangered) VALUES (:name, :health, :age, :endangered)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .addParameter("health", this.health)
        .addParameter("age", this.age)
        .addParameter("endangered", endangered)
        .executeUpdate()
        .getKey();
    }
  }
  public static List<EndangeredAnimal> all() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM animals WHERE endangered='true'";
      return con.createQuery(sql)
      .throwOnMappingFailure(false)
      .executeAndFetch(EndangeredAnimal.class);
    }
  }
}
