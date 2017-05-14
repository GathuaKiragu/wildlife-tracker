import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class SightingTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void sighting_instantiatesSighting_true() {
    Sighting newSighting = new Sighting(1, "Roadside", "Collins");
    assertEquals(true, newSighting instanceof Sighting);
  }
}
