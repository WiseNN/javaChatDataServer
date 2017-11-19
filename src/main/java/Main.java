import java.util.HashMap;
import java.util.*;

import static spark.Spark.*;


public class Main
{

    public static void main(String[] args)
    {
        //do not touch
        port(getHerokuAssignedPort());

        Main obj1 = new Main();

        get("/encodeData", (req, res) -> obj1.encryptionFunction());
        get("/", (req,res) -> "Hello There Heroku for Java, nice for you to have joined us! ;)");
    }




    String encryptionFunction()
    {

        String myStr = "Hello World";

        for(int i=0;i<myStr.length();i++)
        {
            int randomNum = (int)Math.random();

            int intForChar = myStr.charAt(0);

            char newLetter = (char)(intForChar + randomNum);

        }


        return "Some New Data";
    }













    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();

        if (processBuilder.environment().get("PORT") != null) {

            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }

        return 4567;
    }



}
