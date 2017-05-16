import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;

public class Sighting {
  private int id;
  private int animal_id;
  private String location;
  private String ranger;

// Constractor
  public Sighting(int animal_id, String location, String ranger) {
    this.animal_id = animal_id;
    this.location = location;
    this.ranger = ranger;
  }
// get sighting id
  public int getId() {
    return id;
  }
// get animal id
  public int getAnimalId() {
    return animal_id;
  }
// get location
  public String getLocation() {
    return location;
  }
// get ranger
  public String getRanger() {
    return ranger;
  }
// Override Method
  @Override
  public boolean equals(Object otherSighting){
    if (!(otherSighting instanceof Sighting)) {
      return false;
    } else {
      Sighting newSighting = (Sighting) otherSighting;
      return this.getLocation().equals(newSighting.getLocation()) &&
             this.getId() == newSighting.getId() &&
             this.getAnimalId() == newSighting.getAnimalId();
    }
  }
  public static List<Sighting> all() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM sightings";
      return con.createQuery(sql)
      .executeAndFetch(Sighting.class);
    }
  }

// Save method
  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO sightings (animal_id, location, ranger) VALUES (:animal_id, :location, :ranger;";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("animal_id", this.animal_id)
        .addParameter("location", this.location)
        .addParameter("ranger", this.ranger)
        .executeUpdate()
        .getKey();
    }
}
// Find method
  public static Sighting find(int id) {
    try(Connection con = DB.sql2o.open()){
      String sql = "SELECT * FROM sightings WHERE id=:id";
      Sighting sighting = con.createQuery(sql)
      .addParameter("id", id)
      .executeAndFetchFirst(Sighting.class);
      return sighting;
    }
  }

// update sigthing method
  public void update(String location, String ranger){
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE sightings SET location = :location , ranger = :ranger WHERE id=:id";
      con.createQuery(sql)
      .addParameter("location", location)
      .addParameter("ranger", ranger)
      .addParameter("id", id)
      .executeUpdate();
    }
  }
// Delete sighting method
  public void delete() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "DELETE FROM sightings WHERE id = :id;";
      con.createQuery(sql)
        .addParameter("id", id)
        .executeUpdate();
    }
  }
}
