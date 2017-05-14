import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;

public class NormalAnimal{
  private String name;
  private String endangered;
  private int id;

  public static final String isEndangered = "false";

//Constructor
  public NormalAnimal(String name) {
    this.name = name;
    endangered = isEndangered;
  }
  public String getName() {
    return name;
  }

  public int getId() {
    return id;
  }

  // Save Method
  public void save() {
    try(Connection con = DB.sql2o.open()) {
      if (name.equals("")){
        throw new UnsupportedOperationException("Enter name of NormalAnimal");
      }
      String sql = "INSERT INTO animals (name, endangered) VALUES (:name, :endangered)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .addParameter("endangered", this.endangered)
        .executeUpdate()
        .getKey();
    }
  }

  public static List<NormalAnimal> all() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM animals WHERE endangered='false'";
      return con.createQuery(sql)
      .throwOnMappingFailure(false)
      .executeAndFetch(NormalAnimal.class);
    }
  }
// Find method
  public static NormalAnimal find(int id) {
    try(Connection con = DB.sql2o.open()){
      String sql = "SELECT * FROM animals WHERE id=:id";
      return con.createQuery(sql)
      .addParameter("id", id)
      .throwOnMappingFailure(false)
      .executeAndFetchFirst(NormalAnimal.class);
    }
  }
  // Ovarride method
  @Override
public boolean equals(Object otherNormalAnimal){
  if (!(otherNormalAnimal instanceof NormalAnimal)) {
    return false;
  } else {
    NormalAnimal newNormalAnimal = (NormalAnimal) otherNormalAnimal;
    return this.getName().equals(newNormalAnimal.getName());
    }
  }
// Update method
  public void update(String name) {
    try(Connection con = DB.sql2o.open()) {
      if (name.equals("")){
        throw new UnsupportedOperationException("Enter name");
      }
    String sql = "UPDATE animals SET name = :name WHERE id = :id";
    con.createQuery(sql)
      .addParameter("name", name)
      .addParameter("id", id)
      .executeUpdate();
      }
    }
  }
