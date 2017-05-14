import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class SightingTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

//Test to check If sighting instantiates correctly
  @Test
  public void sighting_instantiatesSighting_true() {
    Sighting newSighting = new Sighting(1, "Roadside", "Collins");
    assertEquals(true, newSighting instanceof Sighting);
  }
// Test to check if sighting instatiates with ranger
  @Test
  public void sighting_sightingRanger_String() {
    Sighting newSighting = new Sighting(1, "Roadside", "Collins");
    assertEquals("Collins", newSighting.getRanger());
  }
// Test to check if location instatiates with location
  @Test
  public void sighting_sightingLocation_String() {
    Sighting newSighting = new Sighting(1, "Roadside", "Collins");
    assertEquals("Roadside", newSighting.getLocation());
  }
// Test to check if sighting is saved with an Id
  // @Test
  // public void save_assignsIdToObject() {
  //   Sighting newSighting = new Sighting(1, "Roadside", "Collins");
  //   newSighting.save();
  //   Sighting savedSighting = Sighting.all().get(0);
  //   assertEquals(newSighting.getId(), savedSighting.getId());
  // }
// Test to check if all instances of sighting are instantiated
  // @Test
  // public void all_returnsAllInstancesOfSighting_true() {
  //   Sighting firstSighting = new Sighting(1, "Roadside", "Collins");
  //   firstSighting.save();
  //   Sighting secondSighting = new Sighting(1, "Park", "Alex");
  //   secondSighting.save();
  //   assertEquals(true, Sighting.all().get(0).equals(firstSighting));
  //   assertEquals(true, Sighting.all().get(1).equals(secondSighting));
  }
// Test to find sighting
  // @Test
  // public void find_returnsSightingWithSameId_secondSighting() {
  //   Sighting firstSighting = new Sighting(1, "Roadside", "Collins");
  //   firstSighting.save();
  //   Sighting secondSighting = new Sighting(1, "Park", "Alex");
  //   secondSighting.save();
  //   assertEquals(Sighting.find(secondSighting.getId()), secondSighting);
  // }
// Test to check if sighting can be updated
  // @Test
  // public void update_updatesSighting_true() {
  //   Sighting newSighting = new Sighting(1, "Roadside", "Collins");
  //   newSighting.save();
  //   newSighting.update("Park", "Alex");
  //   assertEquals("Park", Sighting.find(newSighting.getId()).getLocation());
  //   assertEquals("Alex", Sighting.find(newSighting.getId()).getRanger());
  // }
// Delete sighting
  // @Test
  // public void delete_deletesSighting_true() {
  //   Sighting newSighting = new Sighting(1, "Roadside", "Collins");
  //   newSighting.save();
  //   int newSightingId = newSighting.getId();
  //   newSighting.delete();
  //   assertEquals(null, Sighting.find(newSightingId));
