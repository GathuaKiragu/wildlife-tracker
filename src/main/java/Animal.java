public class Animal {
  private String name;
  private int id;

// Constructor
  public Animal(String name) {
    this.name = name;
  }
// method to get name
  public String getName(){
    return name;
  }
//method to get animal id
  public int getId(){
      return id;
  }

//ovarride method
  @Override
public boolean equals(Object otherAnimal){
  if (!(otherAnimal instanceof Animal)) {
    return false;
  } else {
    Animal newAnimal = (Animal) otherAnimal;
    return this.getName().equals(newAnimal.getName());
    }
}
}
