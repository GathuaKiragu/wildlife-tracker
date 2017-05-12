import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;

public class AnimalTest {
//test to check if animal instantiates correctly

@Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void animal_instantiatesCorrectly_true() {
    Animal testAnimal = new Animal("leopard");
    assertEquals(true, testAnimal instanceof Animal);
  }

//test to check if animal instantiates correctly eith name
  @Test
  public void Animal_instantiatesWithName_String() {
    Animal testAnimal = new Animal("leopard");
    assertEquals("leopard", testAnimal.getName());
  }
// Test to ovarride equals
  @Test
  public void equals_returnsTrueIfNameAndEmailAreSame_true() {
    Animal firstAnimal = new Animal("leopard");
    Animal anotherAnimal = new Animal("leopard");
    assertTrue(firstAnimal.equals(anotherAnimal));
  }

//Saving Animals
  @Test
 public void save_returnsTrueIfDescriptionsAretheSame() {
   Animal testAnimal = new Animal("leopard");
   testAnimal.save();
   assertTrue(Animal.all().get(0).equals(testAnimal));
 }

//Assigns id to saved animal
 @Test
 public void save_assignsIdToAnimal() {
   Animal testAnimal = new Animal("leopard");
   testAnimal.save();
   Animal savedAnimal = Animal.all().get(0);
   assertEquals(savedAnimal.getId(), testAnimal.getId());
 }
// Find Animals from the database
 @Test
  public void find_returnsAnimalWithSameId_secondAnimal() {
    Animal firstAnimal = new Animal("leopard");
    firstAnimal.save();
    Animal secondAnimal = new Animal("Zebra");
    secondAnimal.save();
    assertEquals(Animal.find(secondAnimal.getId()), secondAnimal);
  }
}
