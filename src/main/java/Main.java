import static spark.Spark.*;


public class Main
{

    public static void main(String[] args)
    {
        port(getHerokuAssignedPort());

        get("/hello", (req, res) -> "Hello Heroku World");
        get("/", (req,res) -> "Hello There Heroku for Java, nice for you to have joined us! ;)");
    }


    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }

        return 4567;
    }



}
