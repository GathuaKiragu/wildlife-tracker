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
}
