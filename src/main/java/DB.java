import org.sql2o.*;
public class DB {
  public static Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker", "kiragu", "brianmbete");
}
// public class DB {
//   public static Sql2o sql2o = new Sql2o("jdbc:postgresql://ec2-54-235-72-121.compute-1.amazonaws.com:5432/dfbu8s5vu803or","etxtwmncebozcg", "b40662e404b447aa55f5cf57d8c86fe88b829fd4a9b87132238828cd9ec0804f");
// }
