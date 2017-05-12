import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;

public class AnimalTest {
//test to check if animal instantiates correctly
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
}