import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;

public class AnimalTest {
  @Test
  public void animal_instantiatesCorrectly_true() {
    Animal testAnimal = new Animal("leopard");
    assertEquals(true, testAnimal instanceof Animal);
  }

  @Test
  public void Animal_instantiatesWithName_String() {
    Animal testAnimal = new Animal("leopard");
    assertEquals("leopard", testAnimal.getName());
  }
}
