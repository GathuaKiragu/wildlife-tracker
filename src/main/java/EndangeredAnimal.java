import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;

public class EndangeredAnimal extends Animal{
  private String health;
  private int age;
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
// get endangerd animal health
  public String getHealth() {
    return health;
  }
//get endangered animal estimate age
  public int getAge() {
    return age;
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
// Find endangered animal from database
public static EndangeredAnimal find(int id) {
  try(Connection con = DB.sql2o.open()){
    String sql = "SELECT * FROM animals WHERE id=:id";
    return con.createQuery(sql)
    .addParameter("id", id)
    .throwOnMappingFailure(false)
    .executeAndFetchFirst(EndangeredAnimal.class);
    }
  }
// Update endangered animals
public void update(String name, String health, int age){
  try(Connection con = DB.sql2o.open()) {
    if(name.equals("")) {
      throw new UnsupportedOperationException("Enter name of EndangeredAnimal");
    }
    String sql = "UPDATE animals SET name = :name , health = :health , age = :age WHERE id=:id";
       con.createQuery(sql)
      .addParameter("name", name)
      .addParameter("health", health)
      .addParameter("age", age)
      .addParameter("id", id)
      .executeUpdate();
    }
  }
}
