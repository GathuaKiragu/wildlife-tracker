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
}
