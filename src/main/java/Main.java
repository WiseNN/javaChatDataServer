import java.util.HashMap;
import java.util.*;

import static spark.Spark.*;
import dataProcessing.Encryption;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;





public class Main
{
    static int num = 0;
    public static void main(String[] args)
    {
        //do not touch
        port(getHerokuAssignedPort());
        JSONObject obj = new JSONObject();

        Encryption op1 = new Encryption();



        //I am going to send a String, HashMap<String, String>
        get("/encodeData/:data", (req, res) -> req.params("data"));
        get("/decodeData", (req, res) -> "Decoding Data");
        get("/", (req,res) -> "Hello There Heroku for Java, nice for you to have joined us! ;)");
    }







    static int getHerokuAssignedPort()
    {
        ProcessBuilder processBuilder = new ProcessBuilder();

        if (processBuilder.environment().get("PORT") != null) {

            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }

        return 4567;
    }



}
