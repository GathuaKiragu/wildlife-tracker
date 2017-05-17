import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import static spark.Spark.*;
import spark.template.velocity.VelocityTemplateEngine;

public class App {
      static int getHerokuAssignedPort() {
      ProcessBuilder processBuilder = new ProcessBuilder();
      if (processBuilder.environment().get("PORT") != null) {
        return Integer.parseInt(processBuilder.environment().get("PORT"));
      }
      return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
    public static void main(String[] args) {
      port(getHerokuAssignedPort());
      staticFileLocation("/public");
      String layout = "templates/layout.vtl";
// Ger routes
    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      model.put("animal", NormalAnimal.all());
      model.put("endangeredAnimals", EndangeredAnimal.all());
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

   get("/animal/:id", (request, response) -> {
     Map<String, Object> model = new HashMap<String, Object>();
     NormalAnimal animal = NormalAnimal.find(Integer.parseInt(request.params(":id")));
     model.put("sightings", animal.getSightings());
     model.put("animal", animal);
     model.put("template", "templates/animal.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());
// get endangered animal with id
   get("/endangeredanimal/:id", (request, response) -> {
     Map<String, Object> model = new HashMap<String, Object>();
     EndangeredAnimal animal = EndangeredAnimal.find(Integer.parseInt(request.params(":id")));
     model.put("sightings", animal.getSightings());
     model.put("animal", animal);
     model.put("template", "templates/endangeredanimal.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());
// get animal sigthing
   get("/sighting/:id", (request, response) -> {
     Map<String, Object> model = new HashMap<String, Object>();
     Sighting sighting = Sighting.find(Integer.parseInt(request.params(":id")));
     model.put("sighting", sighting);
     model.put("template", "templates/sighting.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());

   // Post Routes

   post("/normalanimal/new", (request, response) -> {
     Map<String, Object> model = new HashMap<String, Object>();
     String name = request.queryParams("animal");
     try{
       NormalAnimal newNormalAnimal = new NormalAnimal(name);
       newNormalAnimal.save();
     }
     catch (UnsupportedOperationException exception)
     { }
     model.put("animals", NormalAnimal.all());
     model.put("endangeredAnimals", EndangeredAnimal.all());
     model.put("template", "templates/index.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());
// route to add new endangered aniimal
   post("/endangeredanimal/new", (request, response) -> {
     Map<String, Object> model = new HashMap<String, Object>();
     String name = request.queryParams("animal");
     int userHealth = Integer.parseInt(request.queryParams("health"));
     int userAge = Integer.parseInt(request.queryParams("age"));
     model.put("animals", NormalAnimal.all());
     model.put("endangeredAnimals", EndangeredAnimal.all());
     model.put("template", "templates/index.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());

   post("/animal/:id", (request, response) -> {
     Map<String, Object> model = new HashMap<String, Object>();
     NormalAnimal animal = NormalAnimal.find(Integer.parseInt(request.params(":id")));
     String location = request.queryParams("location");
     String ranger = request.queryParams("name");
     Sighting newSighting = new Sighting(animal.getId(), location, ranger);
     newSighting.save();
     model.put("sightings", animal.getSightings());
     model.put("animal", animal);
     model.put("template", "templates/animal.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());
// route to normal update animal
   post("/animal/:id/update", (request, response) -> {
     Map<String, Object> model = new HashMap<String, Object>();
     NormalAnimal animal = NormalAnimal.find(Integer.parseInt(request.params(":id")));
     String name = request.queryParams("name");
     try{
       animal.update(name);
     }
     catch (UnsupportedOperationException exception)
     { }
     String url = String.format("/animal/%id", animal.getId());
     response.redirect(url);
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());
// route to view individial endangered animal with id
   post("/endangeredanimal/:id", (request, response) -> {
     Map<String, Object> model = new HashMap<String, Object>();
     EndangeredAnimal animal = EndangeredAnimal.find(Integer.parseInt(request.params(":id")));
     String location = request.queryParams("location");
     String ranger = request.queryParams("name");
     Sighting newSighting = new Sighting(animal.getId(), location, ranger);
     newSighting.save();
     model.put("sightings", animal.getSightings());
     model.put("animal", animal);
     model.put("template", "templates/endangeredanimal.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());
// route to update endangeredanimal
   post("/endangeredanimal/:id/update", (request, response) -> {
     Map<String, Object> model = new HashMap<String, Object>();
     EndangeredAnimal animal = EndangeredAnimal.find(Integer.parseInt(request.params(":id")));
     String name = request.queryParams("name");
     String health = request.queryParams("health");
     int age = Integer.parseInt(request.params("age"));
     try {
       animal.update(name, health, age);
     }
     catch (UnsupportedOperationException exception)
     { }
     String url = String.format("/endangeredanimal/%d", animal.getId());
     response.redirect(url);
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());
// route to delete endangeredanimal
   post("/animal/:id/delete", (request, response) -> {
     Map<String, Object> model = new HashMap<String, Object>();
     NormalAnimal animal = NormalAnimal.find(Integer.parseInt(request.params(":id")));
     animal.delete();
     animal.deleteSightings();
     model.put("animals", NormalAnimal.all());
     model.put("endangeredAnimals", EndangeredAnimal.all());
     model.put("template", "templates/index.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());
// delete endangered animal route
   post("/endangeredanimal/:id/delete", (request, response) -> {
     Map<String, Object> model = new HashMap<String, Object>();
     EndangeredAnimal animal = EndangeredAnimal.find(Integer.parseInt(request.params(":id")));
     animal.delete();
     animal.deleteSightings();
     model.put("animals", NormalAnimal.all());
     model.put("endangeredAnimals", EndangeredAnimal.all());
     model.put("template", "templates/index.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());
// delete sighting rourte
   post("/sighting/:id/delete", (request, response) -> {
     Map<String, Object> model = new HashMap<String, Object>();
     Sighting sighting = Sighting.find(Integer.parseInt(request.params(":id")));
     sighting.delete();
     model.put("animals", NormalAnimal.all());
     model.put("endangeredAnimals", EndangeredAnimal.all());
     model.put("template", "templates/index.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());
// update sighting roure
   post("/sighting/:id/update", (request, response) -> {
     Map<String, Object> model = new HashMap<String, Object>();
     Sighting sighting = Sighting.find(Integer.parseInt(request.params(":id")));
     String location = request.queryParams("location");
     String name = request.queryParams("name");
     sighting.update(location, name);
     String url = String.format("/sighting/%d", sighting.getId());
     response.redirect(url);
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());
  }
 }
