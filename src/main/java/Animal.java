import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;

public abstract class Animal {
  private String name;
  private int id;
  public String endangered;

// Constructor
  // public Animal(String name) {
  //   this.name = name;
  // }
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
// Assign id to animal
// public static List<Animal> all() {
//    String sql = "SELECT * FROM animals";
//    try(Connection con = DB.sql2o.open()) {
//      return con.createQuery(sql).executeAndFetch(Animal.class);
//    }
//  }
 // find animal from the database
 // public static Animal find(int id) {
 //     try(Connection con = DB.sql2o.open()) {
 //       String sql = "SELECT * FROM animals where id=:id";
 //       Animal Animal = con.createQuery(sql)
 //         .addParameter("id", id)
 //         .executeAndFetchFirst(Animal.class);
 //       return Animal;
 //     }
 //   }
//delete method
     public void delete() {
       try(Connection con = DB.sql2o.open()) {
       String sql = "DELETE FROM animals WHERE id = :id;";
       con.createQuery(sql)
         .addParameter("id", id)
         .executeUpdate();
       }
   }

   public List<Sighting> getSightings() {
     try(Connection con = DB.sql2o.open()) {
       String sql = "SELECT * FROM sightings where animal_id=:id";
       return con.createQuery(sql)
         .addParameter("id", this.id)
         .executeAndFetch(Sighting.class);
     }
   }
 //method to Delete sightings
   public void deleteSightings() {
     try(Connection con = DB.sql2o.open()) {
       String sql = "DELETE FROM sightings where animal_id=:id";
       con.createQuery(sql)
         .addParameter("id", this.id)
         .executeUpdate();
     }
   }
}
