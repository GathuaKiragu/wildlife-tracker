import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;

public class NormalAnimal{
  private String name;
  private String endangered;

  public static final String isEndangered = "false";

//Constructor
  public NormalAnimal(String name) {
    this.name = name;
    endangered = isEndangered;
  }
}
