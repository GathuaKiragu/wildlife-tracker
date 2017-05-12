import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;

public class Animal {
  private String name;
  private int id;

// Constructor
  public Animal(String name) {
    this.name = name;
  }
// method to get name
  public String getName(){
    return name;
  }
//method to get animal id
  public int getId(){
      return id;
  }

//ovarride method
  @Override
public boolean equals(Object otherAnimal){
  if (!(otherAnimal instanceof Animal)) {
    return false;
  } else {
    Animal newAnimal = (Animal) otherAnimal;
    return this.getName().equals(newAnimal.getName());
    }
}
// Save animals to DatabaseRule
public void save() {
  try(Connection con = DB.sql2o.open()) {
    String sql = "INSERT INTO animals (name) VALUES (:name)";
    this.id = (int) con.createQuery(sql, true)
      .addParameter("name", this.name)
      .executeUpdate()
      .getKey();
      }
    }
public static List<Animal> all() {
   String sql = "SELECT * FROM Animals";
   try(Connection con = DB.sql2o.open()) {
     return con.createQuery(sql).executeAndFetch(Animal.class);
   }
 }
}
