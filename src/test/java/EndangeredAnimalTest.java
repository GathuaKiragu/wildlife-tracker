import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class EndangeredAnimalTest {
//test to check if animal instantiates correctly

@Rule
  public DatabaseRule database = new DatabaseRule();

@Test
 public void EndangeredAnimalInstantiatesCorrectly() {
   EndangeredAnimal myEndangeredAnimal = new EndangeredAnimal("Tiger", "okay", 3);
   assertEquals(true, myEndangeredAnimal instanceof EndangeredAnimal);
 }
// Test to check if endangered animal instantiates with name correctly
@Test
 public void getName_endangeredAnimalInstantiatesWithName_Tiger() {
   EndangeredAnimal newEndangeredAnimal = new EndangeredAnimal("Tiger", "okay", 3);
   assertEquals("Tiger", newEndangeredAnimal.getName());
 }
 // Test to check if endangered animal instantiates with health correctly
 @Test
  public void getName_endangeredAnimalInstantiatesWithHealth() {
    EndangeredAnimal newEndangeredAnimal = new EndangeredAnimal("Tiger", "okay", 3);
    assertEquals("okay", newEndangeredAnimal.getHealth());
  }
  // Test to check if endangered animal instantiates with age correctly
  @Test
   public void getName_endangeredAnimalInstantiatesWithName() {
     EndangeredAnimal newEndangeredAnimal = new EndangeredAnimal("Tiger", "okay", 3);
     assertEquals(3, newEndangeredAnimal.getAge());
   }
  //Save endangered animal to Database
  // @Test
  // public void save_savesEndangeredAnimalIntoDatabase_true() {
  //   EndangeredAnimal newEndangeredAnimal = new EndangeredAnimal("Tiger", "okay", 3);
  //   newEndangeredAnimal.save();
  //   assertTrue(EndangeredAnimal.all().get(0).equals(newEndangeredAnimal));
  // }
}
