package hello;

import static spark.Spark.*;

/**
 * Spark Example Starter app.
 * @see http://sparkjava.com/documentation
 */
public class Spark {
    
    public static void main(String[] args) {
        
        // set port (default is 4567)
        port(8080);
        
        get("/hello", (request, response) -> "Hello World!");

        post("/hello", (request, response) ->
            "Hello World: " + request.body()
        );

        get("/private", (request, response) -> {
            response.status(401);
            return "Go Away!!!";
        });

        get("/users/:name", (request, response) -> "Selected user: " + request.params(":name"));

        get("/news/:section", (request, response) -> {
            response.type("text/xml");
            return "<?xml version=\"1.0\" encoding=\"UTF-8\"?><news>" + request.params("section") + "</news>";
        });

        get("/protected", (request, response) -> {
            halt(403, "I don't think so!!!");
            return null;
        });

        get("/redirect", (request, response) -> {
            response.redirect("/news/world");
            return null;
        });

        get("/", (request, response) -> "Hello from Spark!");
    }
}