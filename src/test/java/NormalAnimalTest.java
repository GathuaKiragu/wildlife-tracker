import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class NormalAnimalTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();
//Test to check if normal animal instantiates correctly
  @Test
  public void normalAnimal_instantiatesNewNormalAnimal_true() {
    NormalAnimal newNormalAnimal = new NormalAnimal("Lion");
    assertEquals(true, newNormalAnimal instanceof NormalAnimal);
  }
// Test to check if normalAnimal instantiates with name
  @Test
  public void getName_normalAnimalInstantiatesWithName() {
    NormalAnimal newNormalAnimal = new NormalAnimal("Lion");
    assertEquals("Lion", newNormalAnimal.getName());
  }
// Test if normalAnimal can be saved to Database
  @Test
  public void save_savesIntoDatabase_true() {
    NormalAnimal newNormalAnimal = new NormalAnimal("Lion");
    newNormalAnimal.save();
    assertTrue(NormalAnimal.all().get(0).equals(newNormalAnimal));
  }
//Test To find Normal animal with given Id
  @Test
  public void find_returnsNormalAnimalWithSameId_secondAnimal() {
    NormalAnimal firstNormalAnimal = new NormalAnimal("Lion");
    firstNormalAnimal.save();
    NormalAnimal secondNormalAnimal = new NormalAnimal("Antelope");
    secondNormalAnimal.save();
    assertEquals(NormalAnimal.find(secondNormalAnimal.getId()), secondNormalAnimal);
  }
}
