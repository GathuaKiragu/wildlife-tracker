import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;

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
 public void getName_endangeredAnimalInstantiatesWithName_Bison() {
   EndangeredAnimal newEndangeredAnimal = new EndangeredAnimal("Tiger", "okay", 3);
   assertEquals("Tiger", newEndangeredAnimal.getName());
 }
}
